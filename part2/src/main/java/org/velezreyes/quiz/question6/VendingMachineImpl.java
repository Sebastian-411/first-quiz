package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

import org.velezreyes.quiz.question6.drinks.*;

public class VendingMachineImpl implements VendingMachine {

  private Map<String, Class<? extends Drink>> availableDrinks = new HashMap<>();
  private int userBalance = 0;

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }

  public VendingMachineImpl() {
    availableDrinks.put("ScottCola", ScottCola.class);
    availableDrinks.put("KarenTea", KarenTea.class);
  }

  @Override
  public void insertQuarter() {
    userBalance += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    Class<? extends Drink> drinkClass = availableDrinks.get(name);

    if (drinkClass == null) {
      throw new UnknownDrinkException();
    }

    Drink drink;
    try {
      drink = drinkClass.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new UnknownDrinkException();
    }

    if (userBalance < drink.getCost()) {
      throw new NotEnoughMoneyException();
    }

    userBalance -= drink.getCost(); 
    return drink;
  }
}

package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {

  private Map<String, Drink> availableDrinks = new HashMap<>();
  private int userBalance = 0;

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }

  public VendingMachineImpl() {
    availableDrinks.put("ScottCola", new DrinkImpl("ScottCola", 75, true));
    availableDrinks.put("KarenTea", new DrinkImpl("KarenTea", 100, false));
  }

  @Override
  public void insertQuarter() {
    userBalance += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    Drink drink = availableDrinks.get(name);

    if (drink == null) {
      throw new UnknownDrinkException();
    }

    if (userBalance < drink.getCost()) {
      throw new NotEnoughMoneyException();
    }

    userBalance -= drink.getCost(); 
    return drink;
  }
}

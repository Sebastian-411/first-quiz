package org.velezreyes.quiz.question6;
public class DrinkImpl implements Drink {
  private String name;
  private boolean fizzy;
  private int cost;

  public DrinkImpl(String name, int cost, boolean fizzy) {
    this.name = name;
    this.fizzy = fizzy;
    this.cost = cost;
  }

  public int getCost(){
    return cost;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isFizzy() {
    return fizzy;
  }
}

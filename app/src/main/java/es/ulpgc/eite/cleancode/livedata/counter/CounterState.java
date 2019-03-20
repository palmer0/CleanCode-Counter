package es.ulpgc.eite.cleancode.livedata.counter;

public class CounterState extends CounterViewModel {

  // put the model state here

  private int clicks;

  public int getClicks() {
    return clicks;
  }

  public void setClicks(int value) {
    clicks = value;
  }
}

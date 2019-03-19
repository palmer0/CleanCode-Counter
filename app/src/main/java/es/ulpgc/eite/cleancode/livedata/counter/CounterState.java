package es.ulpgc.eite.cleancode.livedata.counter;

public class CounterState extends CounterViewModel {

  private int clicks;

  public int getClicks() {
    return clicks;
  }

  public void setClicks(int value) {
    clicks = value;
  }
}

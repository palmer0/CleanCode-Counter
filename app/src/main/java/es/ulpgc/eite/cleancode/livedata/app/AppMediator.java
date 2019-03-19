package es.ulpgc.eite.cleancode.livedata.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.livedata.counter.CounterState;

public class AppMediator extends Application {

  private CounterState state = new CounterState();

  public void setCounterState(CounterState state) {
    this.state = state;
  }

  public CounterState getCounterState() {
    return state;
  }
}

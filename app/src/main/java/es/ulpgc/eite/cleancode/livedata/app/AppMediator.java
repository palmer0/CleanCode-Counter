package es.ulpgc.eite.cleancode.livedata.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.livedata.counter.CounterState;

public class AppMediator extends Application {

  private CounterState counter = new CounterState();


  public CounterState getCounterState() {
    return counter;
  }

}

package es.ulpgc.eite.cleancode.livedata.app;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import es.ulpgc.eite.cleancode.livedata.counter.CounterState;

public class AppMediator extends Application {


  private MutableLiveData<CounterState> state;

  @Override
  public void onCreate() {
    super.onCreate();

    state = new MutableLiveData();
    state.setValue(new CounterState());
  }

  public LiveData<CounterState> fetchState() {
    return state;
  }

  public void setState(CounterState value) {
    state.setValue(value);
  }

}

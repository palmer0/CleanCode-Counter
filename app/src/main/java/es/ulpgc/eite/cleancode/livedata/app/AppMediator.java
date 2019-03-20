package es.ulpgc.eite.cleancode.livedata.app;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import es.ulpgc.eite.cleancode.livedata.counter.CounterState;
import es.ulpgc.eite.cleancode.livedata.reset.ResetState;

public class AppMediator extends Application {

  private MutableLiveData<ResetState> reset;
  private MutableLiveData<CounterState> counter;

  @Override
  public void onCreate() {
    super.onCreate();

    counter = new MutableLiveData();
    counter.setValue(new CounterState());

    reset = new MutableLiveData();
    reset.setValue(new ResetState());
  }

  public LiveData<CounterState> fetchCounterState() {
    return counter;
  }

  public void setCounterState(CounterState value) {
    counter.setValue(value);
  }

  public LiveData<ResetState> fetchResetState() {
    return reset;
  }

  public void setResetState(ResetState value) {
    reset.setValue(value);
  }

}

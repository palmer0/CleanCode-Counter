package es.ulpgc.eite.cleancode.livedata.counter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class CounterModel implements CounterContract.Model {

  public static String TAG = CounterModel.class.getSimpleName();


  private Integer counter;
  private Integer clicks;

  private MutableLiveData<CounterState> state;


  public CounterModel() {
    state = new MutableLiveData();
  }

  @Override
  public LiveData<CounterState> fetchData() {
    return state;
  }


  @Override
  public void setCounter(Integer value) {
    counter = value;
  }

  @Override
  public void setClicks(Integer value) {
    clicks = value;
  }

  @Override
  public void updateData() {
    clicks++;
    counter++;

    if(counter == 10){
      counter = 0;
    }

    CounterState value = new CounterState();
    value.setCounter(counter);
    value.setClicks(clicks);
    state.setValue(value);

  }


}

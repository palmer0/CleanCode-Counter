package es.ulpgc.eite.cleancode.livedata.counter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CounterModel implements CounterContract.Model {

  public static String TAG = CounterModel.class.getSimpleName();


  private int counter;
  private int clicks;

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
  public int getClicks() {
    return clicks;
  }

  @Override
  public void updateData() {

    CounterState value = new CounterState();
    value.setCounter(increment(counter));
    value.setClicks(clicks + 1);
    state.setValue(value);

  }

  public int increment(int counter) {
    counter++;

    if(counter == 10){
      counter = 0;
    }

    return counter;
  }

  /*
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
  */

}

package es.ulpgc.eite.cleancode.livedata.counter;

import android.arch.lifecycle.MutableLiveData;

public class CounterViewModel {

  // put the view state here
  private MutableLiveData<Integer> liveData = new MutableLiveData();

  public CounterViewModel() {
    liveData.setValue(0);
  }

  public MutableLiveData<Integer> getLiveData() {
    return liveData;
  }

  public void setData(Integer counter) {
    liveData.setValue(counter);
  }


  public Integer getData() {
    return liveData.getValue();
  }
}

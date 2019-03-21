package es.ulpgc.eite.cleancode.livedata.reset;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class ResetModel implements ResetContract.Model {

  public static String TAG = ResetModel.class.getSimpleName();

  private int clicks;
  private boolean reset;

  private MutableLiveData<ResetState> state;

  public ResetModel() {
    state = new MutableLiveData();
  }

  @Override
  public LiveData<ResetState> fetchData() {
    return state;
  }


  @Override
  public boolean getReset() {
    return reset;
  }

  @Override
  public void setReset(Boolean value) {
    reset = value;
  }


  @Override
  public void setClicks(Integer value) {
    clicks = value;
  }

  @Override
  public void resetData() {
    //clicks = 0;
    //reset = true;

    ResetState value = new ResetState();
    //value.setReset(reset);
    //value.setClicks(clicks);
    value.setReset(true);
    value.setClicks(0);
    state.setValue(value);

  }


}

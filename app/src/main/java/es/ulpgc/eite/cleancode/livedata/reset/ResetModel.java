package es.ulpgc.eite.cleancode.livedata.reset;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class ResetModel implements ResetContract.Model {

  public static String TAG = ResetModel.class.getSimpleName();

  private int clicks;
  private boolean status;

  private MutableLiveData<ResetState> state;

  public ResetModel() {
    state = new MutableLiveData();
  }

  @Override
  public LiveData<ResetState> fetchData() {
    return state;
  }

  @Override
  public boolean getStatus() {
    return status;
  }

  @Override
  public void setStatus(Boolean value) {
    status = value;
  }

  @Override
  public void setClicks(Integer value) {
    clicks = value;
  }

  @Override
  public void resetData() {
    clicks = 0;
    status = true;

    ResetState value = new ResetState();
    value.setStatus(status);
    value.setClicks(clicks);
    state.setValue(value);

  }
}

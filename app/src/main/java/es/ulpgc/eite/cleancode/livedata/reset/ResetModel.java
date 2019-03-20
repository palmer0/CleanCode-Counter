package es.ulpgc.eite.cleancode.livedata.reset;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.eite.cleancode.livedata.counter.CounterState;

public class ResetModel implements ResetContract.Model {

  public static String TAG = ResetModel.class.getSimpleName();

  private Integer clicks;
  private Boolean status;

  private MutableLiveData<ResetState> state;

  public ResetModel() {
    state = new MutableLiveData();
  }

  @Override
  public LiveData<ResetState> fetchData() {
    return state;
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

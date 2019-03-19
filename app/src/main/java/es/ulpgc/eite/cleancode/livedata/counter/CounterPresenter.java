package es.ulpgc.eite.cleancode.livedata.counter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class CounterPresenter implements CounterContract.Presenter {

  public static String TAG = CounterPresenter.class.getSimpleName();

  private CounterContract.Model model;
  private CounterState state;
  private MutableLiveData<CounterViewModel> viewModel;


  public CounterPresenter(CounterState state) {
    this.state = state;
    viewModel = new MutableLiveData();
    viewModel.setValue(state);
  }

  @Override
  public LiveData<CounterViewModel> fetchData() {

    model.setCounter(state.getCounter());
    model.setClicks(state.getClicks());

    return viewModel;
  }


  @Override
  public void updateData() {

    model.updateCounter();

    state.setCounter(model.getCounter());
    state.setClicks(model.getClicks());
    viewModel.setValue(state);
  }


  @Override
  public void injectModel(CounterContract.Model model) {
    this.model = model;
  }

}

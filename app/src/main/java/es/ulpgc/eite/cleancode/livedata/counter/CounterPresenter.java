package es.ulpgc.eite.cleancode.livedata.counter;

import android.arch.lifecycle.LiveData;

public class CounterPresenter implements CounterContract.Presenter {

  public static String TAG = CounterPresenter.class.getSimpleName();

  //private WeakReference<CounterContract.View> view;
  private CounterViewModel viewModel;
  private CounterContract.Model model;

  public CounterPresenter(CounterState state) {
    viewModel = state;
  }

  @Override
  public LiveData<Integer> fetchData() {

    // call the model
    Integer counter = viewModel.getData();
    model.setData(counter);

    return viewModel.getLiveData();

  }

  @Override
  public void updateData() {

    // call the model
    model.updateData();
    Integer counter = model.getData();

    // set view state
    viewModel.setData(counter);
  }

  /*
  @Override
  public void injectView(WeakReference<CounterContract.View> view) {
    this.view = view;
  }
  */

  @Override
  public void injectModel(CounterContract.Model model) {
    this.model = model;
  }

}

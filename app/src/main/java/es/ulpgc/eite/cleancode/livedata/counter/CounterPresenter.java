package es.ulpgc.eite.cleancode.livedata.counter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.livedata.app.AppMediator;

public class CounterPresenter implements CounterContract.Presenter {

  public static String TAG = CounterPresenter.class.getSimpleName();

  private WeakReference<FragmentActivity> context;
  private AppMediator mediator;
  private CounterContract.Model model;
  private MutableLiveData<CounterViewModel> viewModel;


  public CounterPresenter(WeakReference<FragmentActivity> context) {
    this.context = context;

    mediator = (AppMediator) context.get().getApplication();
    viewModel = new MutableLiveData();
  }


  @Override
  public LiveData<CounterViewModel> fetchData() {

    mediator.fetchState().observe(context.get(), new Observer<CounterState>() {

      @Override
      public void onChanged( CounterState state) {
        model.setCounter(state.getCounter());
        model.setClicks(state.getClicks());
        viewModel.setValue(state);
      }

    });

    model.fetchData().observe(context.get(), new Observer<CounterState>() {

      @Override
      public void onChanged( CounterState state) {
        mediator.setState(state);
      }

    });

    return viewModel;
  }


  @Override
  public void updateData() {
    model.updateCounter();
  }


  @Override
  public void injectModel(CounterContract.Model model) {
    this.model = model;
  }

}

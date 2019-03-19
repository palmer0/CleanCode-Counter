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
  //private CounterState state;
  private MutableLiveData<CounterViewModel> viewModel;

  /*
  public CounterPresenter(CounterState state) {
    this.state = state;

    viewModel = new MutableLiveData();
    viewModel.setValue(state);
  }
  */

  /*
  public CounterPresenter(AppMediator mediator) {
    this.mediator = mediator;

    state = mediator.getState();
    viewModel = new MutableLiveData();
    viewModel.setValue(state);
  }
  */


  public CounterPresenter(WeakReference<FragmentActivity> context) {
    this.context = context;

    //AppMediator mediator = (AppMediator) context.get().getApplication();
    mediator = (AppMediator) context.get().getApplication();
    //state = mediator.getState();


    //CounterState state = mediator.getState();
    viewModel = new MutableLiveData();
    //viewModel.setValue(state);


    //setState(mediator.getState());
  }

  /*
  private void setState(CounterState state) {
    //this.state = state;
    //viewModel = new MutableLiveData();
    viewModel.setValue(state);
  }
  */

  @Override
  public LiveData<CounterViewModel> fetchData() {

    //model.setCounter(state.getCounter());
    //model.setClicks(state.getClicks());


    mediator.fetchState().observe(context.get(), new Observer<CounterState>() {

      @Override
      public void onChanged( CounterState state) {
        model.setCounter(state.getCounter());
        model.setClicks(state.getClicks());
        //Log.e(TAG, "counter1: " + state.getCounter());
        //Log.e(TAG, "clicks1: " + state.getClicks());
        //model.setData(state);
        viewModel.setValue(state);
      }

    });


    //CounterState state = mediator.getState();
    //viewModel = new MutableLiveData();
    //viewModel.setValue(state);

    return viewModel;
  }


  @Override
  public void updateData() {

    model.fetchData().observe(context.get(), new Observer<CounterState>() {

      @Override
      public void onChanged( CounterState state) {
        //viewModel.setValue(state);
        //setState(state);
        //Log.e(TAG, "counter2: " + state.getCounter());
        //Log.e(TAG, "clicks2: " + state.getClicks());
        mediator.setState(state);
      }

    });

    model.updateCounter();

    /*
    state.setCounter(model.getCounter());
    state.setClicks(model.getClicks());
    viewModel.setValue(state);
    */

  }


  @Override
  public void injectModel(CounterContract.Model model) {
    this.model = model;
  }

}

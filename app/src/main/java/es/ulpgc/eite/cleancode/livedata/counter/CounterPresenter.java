package es.ulpgc.eite.cleancode.livedata.counter;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.livedata.app.AppMediator;

public class CounterPresenter implements CounterContract.Presenter {

  public static String TAG = CounterPresenter.class.getSimpleName();

  private WeakReference<FragmentActivity> context;
  private AppMediator mediator;
  private CounterContract.Model model;
  private MutableLiveData<CounterViewModel> viewModel;
  private CounterContract.Router router;

  public CounterPresenter(WeakReference<FragmentActivity> context) {
    this.context = context;

    mediator = (AppMediator) context.get().getApplication();
    viewModel = new MutableLiveData();
  }


  @Override
  public LiveData<CounterViewModel> fetchData() {

    mediator.fetchCounterState()
        .observe(context.get(), new Observer<CounterState>() {

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
        mediator.setCounterState(state);
      }

    });

    return viewModel;
  }

  @Override
  public void updateData() {
    model.updateData();
  }

  @Override
  public void resetData() {
    router.passDataToNextScreen(model.getClicks());
    router.navigateToNextScreen();
  }


  @Override
  public void injectModel(CounterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CounterContract.Router router) {
    this.router = router;
  }
}

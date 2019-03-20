package es.ulpgc.eite.cleancode.livedata.reset;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.livedata.app.AppMediator;

public class ResetPresenter implements ResetContract.Presenter {

  public static String TAG = ResetPresenter.class.getSimpleName();

  private WeakReference<FragmentActivity> context;
  private ResetContract.Model model;
  private ResetContract.Router router;
  private AppMediator mediator;
  private MutableLiveData<ResetViewModel> viewModel;


  public ResetPresenter(WeakReference<FragmentActivity> context) {
    this.context = context;

    mediator = (AppMediator) context.get().getApplication();
    viewModel = new MutableLiveData();
  }


  @Override
  public LiveData<ResetViewModel> fetchData() {

    mediator.fetchResetState()
        .observe(context.get(), new Observer<ResetState>() {

      @Override
      public void onChanged( ResetState state) {
        model.setStatus(state.getStatus());
        model.setClicks(state.getClicks());
        viewModel.setValue(state);
      }

    });

    model.fetchData().observe(context.get(), new Observer<ResetState>() {

      @Override
      public void onChanged( ResetState state) {
        mediator.setResetState(state);
      }

    });

    return viewModel;
  }


  @Override
  public void resetData() {
    model.resetData();

    router.passDataToPreviousScreen(model.getStatus());
    router.navigateToPreviousScreen();
  }


  @Override
  public void injectModel(ResetContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ResetContract.Router router) {
    this.router = router;
  }
}
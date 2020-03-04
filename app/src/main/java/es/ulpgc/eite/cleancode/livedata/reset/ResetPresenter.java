package es.ulpgc.eite.cleancode.livedata.reset;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

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
        model.setReset(state.getReset());
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

    router.passDataToPreviousScreen(model.getReset());
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

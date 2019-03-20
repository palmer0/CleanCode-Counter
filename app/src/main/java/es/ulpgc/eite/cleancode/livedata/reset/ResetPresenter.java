package es.ulpgc.eite.cleancode.livedata.reset;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.lang.ref.WeakReference;

public class ResetPresenter implements ResetContract.Presenter {

  public static String TAG = ResetPresenter.class.getSimpleName();

  private WeakReference<FragmentActivity> context;
  private WeakReference<ResetContract.View> view;
  private ResetViewModel viewModel;
  private ResetContract.Model model;
  private ResetContract.Router router;

  /*
  public ResetPresenter(ResetState state) {
    viewModel = state;
  }
  */

  public ResetPresenter(WeakReference<FragmentActivity> context) {

  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    ResetState state = router.getDataFromPreviousScreen();
    if (state != null) {

      // update view and model state
      viewModel.data = state.data;

      // update the view
      view.get().displayData(viewModel);

      return;
    }

    // call the model
    String data = model.fetchData();

    // set view state
    viewModel.data = data;

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void injectView(WeakReference<ResetContract.View> view) {
    this.view = view;
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

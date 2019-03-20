package es.ulpgc.eite.cleancode.livedata.reset;

import android.arch.lifecycle.LiveData;

import java.lang.ref.WeakReference;

public interface ResetContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ResetViewModel viewModel);
  }

  interface Presenter {
    void injectModel(Model model);
    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {

    LiveData<ResetState> fetchData();
    void setStatus(Boolean value);
    void setClicks(Integer value);
    void resetData();
  }

  interface Router {
    void navigateToNextScreen();
    void passDataToNextScreen(ResetState state);
    ResetState getDataFromPreviousScreen();
  }
}

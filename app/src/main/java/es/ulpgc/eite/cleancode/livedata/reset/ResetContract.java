package es.ulpgc.eite.cleancode.livedata.reset;

import androidx.lifecycle.LiveData;

public interface ResetContract {

  interface View {
    void injectPresenter(Presenter presenter);

  }

  interface Presenter {
    void injectModel(Model model);
    void injectRouter(Router router);

    LiveData<ResetViewModel> fetchData();
    void resetData();
  }

  interface Model {

    boolean getReset();
    void setReset(Boolean value);
    void setClicks(Integer value);

    LiveData<ResetState> fetchData();
    void resetData();
  }

  interface Router {
    void navigateToPreviousScreen();
    void passDataToPreviousScreen(boolean reset);
  }
}

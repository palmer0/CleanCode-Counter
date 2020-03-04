package es.ulpgc.eite.cleancode.livedata.counter;

import androidx.lifecycle.LiveData;

public interface CounterContract {

  interface View {
    void injectPresenter(Presenter presenter);

  }

  interface Presenter {
    void injectModel(Model model);
    void injectRouter(Router router);

    LiveData<CounterViewModel> fetchData();
    void updateData();
    void resetData();
  }

  interface Model {
    int getClicks();
    void setCounter(Integer value);
    void setClicks(Integer value);

    LiveData<CounterState> fetchData();
    void updateData();

  }

  interface Router {
    void navigateToNextScreen();
    void passDataToNextScreen(Integer value);
  }
}

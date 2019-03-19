package es.ulpgc.eite.cleancode.livedata.counter;

import android.arch.lifecycle.LiveData;

public interface CounterContract {

  interface View {
    void injectPresenter(Presenter presenter);

  }

  interface Presenter {
    void injectModel(Model model);

    LiveData<CounterViewModel> fetchData();
    void updateData();
  }

  interface Model {
    void updateData();
    void setCounter(Integer value);
    void setClicks(Integer value);
    LiveData<CounterState> fetchData();

  }

}

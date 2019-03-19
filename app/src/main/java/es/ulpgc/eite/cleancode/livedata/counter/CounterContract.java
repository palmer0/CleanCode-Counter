package es.ulpgc.eite.cleancode.livedata.counter;

import android.arch.lifecycle.LiveData;

import java.lang.ref.WeakReference;

public interface CounterContract {

  interface View {
    void injectPresenter(Presenter presenter);

  }

  interface Presenter {
    //void injectView(WeakReference<View> view);
    void injectModel(Model model);

    LiveData<Integer> fetchData();
    void updateData();
  }

  interface Model {
    Integer fetchData();
    void updateData();
    void setData(Integer counter);
  }

}

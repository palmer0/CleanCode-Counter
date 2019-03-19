package es.ulpgc.eite.cleancode.livedata.counter;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.livedata.app.AppMediator;

public class CounterScreen {

  public static void configure(CounterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    CounterState state = mediator.getCounterState();

    CounterContract.Presenter presenter = new CounterPresenter(state);
    CounterContract.Model model = new CounterModel();
    presenter.injectModel(model);
    //presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}

package es.ulpgc.eite.cleancode.livedata.counter;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

public class CounterScreen {

  public static void configure(CounterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    //AppMediator mediator = (AppMediator) context.get().getApplication();

    //CounterContract.Router router = new CounterRouter(mediator);
    CounterContract.Router router = new CounterRouter(context);
    CounterContract.Presenter presenter = new CounterPresenter(context);
    CounterContract.Model model = new CounterModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);

    view.injectPresenter(presenter);

  }
}

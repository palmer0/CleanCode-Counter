package es.ulpgc.eite.cleancode.livedata.reset;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.eite.cleancode.livedata.app.AppMediator;

public class ResetScreen {

  public static void configure(ResetContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();

    ResetContract.Router router = new ResetRouter(mediator);
    ResetContract.Presenter presenter = new ResetPresenter(context);
    ResetContract.Model model = new ResetModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);

    view.injectPresenter(presenter);

  }
}

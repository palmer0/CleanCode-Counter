package es.ulpgc.eite.cleancode.livedata.reset;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

public class ResetScreen {

  public static void configure(ResetContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    ResetContract.Router router = new ResetRouter(context);
    ResetContract.Presenter presenter = new ResetPresenter(context);
    ResetContract.Model model = new ResetModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);

    view.injectPresenter(presenter);

  }
}

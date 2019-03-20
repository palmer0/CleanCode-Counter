package es.ulpgc.eite.cleancode.livedata.counter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.livedata.app.AppMediator;
import es.ulpgc.eite.cleancode.livedata.reset.ResetActivity;
import es.ulpgc.eite.cleancode.livedata.reset.ResetState;

public class CounterRouter implements CounterContract.Router {

  public static String TAG = CounterRouter.class.getSimpleName();

  //private WeakReference<FragmentActivity> context;
  private AppMediator mediator;

  public CounterRouter(WeakReference<FragmentActivity> context) {
    //this.context = context;
    mediator = (AppMediator) context.get().getApplication();
  }

  /*
  public CounterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }
  */

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ResetActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(Integer value) {
    ResetState state = new ResetState();
    state.setClicks(value);

    mediator.setResetState(state);
  }

}

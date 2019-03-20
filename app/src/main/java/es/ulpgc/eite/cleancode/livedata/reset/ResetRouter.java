package es.ulpgc.eite.cleancode.livedata.reset;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.livedata.app.AppMediator;
import es.ulpgc.eite.cleancode.livedata.counter.CounterState;

public class ResetRouter implements ResetContract.Router {

  public static String TAG = ResetRouter.class.getSimpleName();

  private WeakReference<FragmentActivity> context;
  //private AppMediator mediator;


  public ResetRouter(WeakReference<FragmentActivity> context) {
    this.context = context;
    //mediator = (AppMediator) context.get().getApplication();
  }

  @Override
  public void navigateToPreviousScreen() {
    context.get().finish();
  }

  @Override
  public void passDataToPreviousScreen(boolean reset) {
    if (reset) {
      CounterState state = new CounterState();
      state.setClicks(0);
      state.setCounter(0);

      AppMediator mediator = (AppMediator) context.get().getApplication();
      mediator.setCounterState(state);
    }
  }

}

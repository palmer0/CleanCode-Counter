package es.ulpgc.eite.cleancode.livedata.reset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.eite.cleancode.livedata.R;

public class ResetActivity
    extends AppCompatActivity implements ResetContract.View {

  public static String TAG = ResetActivity.class.getSimpleName();

  private ResetContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reset);

    // do the setup
    ResetScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(ResetViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.txtClicks)).setText(viewModel.data);
  }

  @Override
  public void injectPresenter(ResetContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

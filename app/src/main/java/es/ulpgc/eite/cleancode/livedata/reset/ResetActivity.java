package es.ulpgc.eite.cleancode.livedata.reset;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    getSupportActionBar().setTitle(R.string.reset_screen);

    findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        presenter.resetData();
      }
    });

    ResetScreen.configure(this);

    presenter.fetchData().observe(this, new Observer<ResetViewModel>() {

      @Override
      public void onChanged( ResetViewModel viewModel) {
        String text = String.valueOf(viewModel.getClicks());
        ((TextView) findViewById(R.id.txtClicks)).setText(text);
      }

    });
  }

  @Override
  public void injectPresenter(ResetContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

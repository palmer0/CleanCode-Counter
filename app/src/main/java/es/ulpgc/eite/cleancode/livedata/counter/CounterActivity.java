package es.ulpgc.eite.cleancode.livedata.counter;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.eite.cleancode.livedata.R;

public class CounterActivity
    extends AppCompatActivity implements CounterContract.View {

  public static String TAG = CounterActivity.class.getSimpleName();

  private CounterContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter);

    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        presenter.updateData();
      }
    });

    CounterScreen.configure(this);

    presenter.fetchData().observe(this, new Observer<CounterViewModel>() {

      @Override
      public void onChanged( CounterViewModel viewModel) {
        String text = String.valueOf(viewModel.getCounter());
        ((TextView) findViewById(R.id.text)).setText(text);
      }

    });

  }

  @Override
  public void injectPresenter(CounterContract.Presenter presenter) {
    this.presenter = presenter;
  }
}

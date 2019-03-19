package es.ulpgc.eite.cleancode.livedata.counter;

public class CounterModel implements CounterContract.Model {

  public static String TAG = CounterModel.class.getSimpleName();

  private Integer counter;


  @Override
  public void setData(Integer counter) {
    this.counter = counter;
  }

  @Override
  public Integer fetchData() {
    return counter;
  }


  @Override
  public void updateData() {
    counter++;

    if(counter == 10){
      counter = 0;
    }
  }

}

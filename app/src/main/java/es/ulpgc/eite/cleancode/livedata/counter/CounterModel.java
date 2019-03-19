package es.ulpgc.eite.cleancode.livedata.counter;

public class CounterModel implements CounterContract.Model {

  public static String TAG = CounterModel.class.getSimpleName();

  private Integer counter;
  private Integer clicks;

  @Override
  public void setCounter(Integer value) {
    counter = value;
  }

  @Override
  public void setClicks(Integer value) {
    clicks = value;
  }

  @Override
  public Integer getClicks() {
    return clicks;
  }

  @Override
  public Integer getCounter() {
    return counter;
  }


  @Override
  public void updateCounter() {
    counter++;
    clicks++;

    if(counter == 10){
      counter = 0;
    }
  }

}

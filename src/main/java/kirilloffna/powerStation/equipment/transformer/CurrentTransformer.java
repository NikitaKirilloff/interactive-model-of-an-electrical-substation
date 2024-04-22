package kirilloffna.powerStation.equipment.transformer;

public class CurrentTransformer {
  private int highCurrent;
  private int lowCurrent;

  public CurrentTransformer(int highCurrent, int lowCurrent) {
    this.highCurrent = highCurrent;
    this.lowCurrent = lowCurrent;
  }

//todo rename KTT
  public int getKTT() {
    return highCurrent/lowCurrent;
  }
}

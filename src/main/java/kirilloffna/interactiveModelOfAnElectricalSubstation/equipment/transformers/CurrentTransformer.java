package kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.transformers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentTransformer {
  private int highCurrent;
  private int lowCurrent;

  public CurrentTransformer(int highCurrent, int lowCurrent) {
    this.highCurrent = highCurrent;
    this.lowCurrent = lowCurrent;
  }

  public int getTransformationRatio() {
    return highCurrent / lowCurrent;
  }  //коэффициент трансформации
}

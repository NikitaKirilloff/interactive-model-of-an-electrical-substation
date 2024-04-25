package kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.highVoltageCircuitBreaker;

import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.Breaker;
import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.transformers.CurrentTransformer;
import lombok.Getter;
import lombok.Setter;

@Getter
public class DefaultHighVoltageBreaker extends Breaker {
  @Setter
  private int voltage;
  private CurrentTransformer currentTransformer;

  public DefaultHighVoltageBreaker(String name, int voltage) {
    super("В " + voltage + " " + name);
    this.voltage = voltage;
  }

  public void setCurrentTransformer(int highCurrent, int lowCurrent) {
    this.currentTransformer = new CurrentTransformer(highCurrent, lowCurrent);
  }
}

package kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.highVoltageCircuitBreaker;

import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.HighVoltage;
import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.transformer.CurrentTransformer;

public abstract class HighVoltageBreaker {
  private HighVoltage voltage;
  private CurrentTransformer currentTransformer;

  public HighVoltageBreaker(HighVoltage voltage, CurrentTransformer currentTransformer) {
    this.voltage = voltage;
    this.currentTransformer = currentTransformer;
  }
}

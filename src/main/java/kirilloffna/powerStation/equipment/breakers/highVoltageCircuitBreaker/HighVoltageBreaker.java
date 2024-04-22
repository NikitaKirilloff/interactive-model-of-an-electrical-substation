package kirilloffna.powerStation.equipment.breakers.highVoltageCircuitBreaker;

import kirilloffna.powerStation.equipment.breakers.HighVoltage;
import kirilloffna.powerStation.equipment.transformer.CurrentTransformer;

public abstract class HighVoltageBreaker {
  private HighVoltage voltage;
  private CurrentTransformer currentTransformer;

  public HighVoltageBreaker(HighVoltage voltage, CurrentTransformer currentTransformer) {
    this.voltage = voltage;
    this.currentTransformer = currentTransformer;
  }
}

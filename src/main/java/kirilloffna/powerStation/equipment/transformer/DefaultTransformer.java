package kirilloffna.powerStation.equipment.transformer;

import kirilloffna.powerStation.equipment.breakers.highVoltageCircuitBreaker.DefaultHighVoltageBreaker;
import kirilloffna.powerStation.equipment.breakers.HighVoltage;
import kirilloffna.powerStation.equipment.breakers.LowVoltage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultTransformer { ///////TODO силовой
  private final float delU;// РПН

  private final double power;

  private final double UkVoltage; //percent

  private final HighVoltage highVoltage;

  private final LowVoltage lowVoltage;

  private Map<String, DefaultHighVoltageBreaker> highVoltageBreakers = new ConcurrentHashMap<>();

  public DefaultTransformer(Map<String, DefaultHighVoltageBreaker> highVoltageBreakers, float delU, double power, double UkVoltage, HighVoltage highVoltage, LowVoltage lowVoltage) {
    this.delU = delU;
    this.power = power;
    this.UkVoltage = UkVoltage;
    this.highVoltage = highVoltage;
    this.lowVoltage = lowVoltage;
    this.highVoltageBreakers = highVoltageBreakers;
  }
}

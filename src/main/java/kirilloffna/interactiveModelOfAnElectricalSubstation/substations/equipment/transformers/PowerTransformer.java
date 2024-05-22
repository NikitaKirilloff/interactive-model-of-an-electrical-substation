package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.equipment.transformers;

import kirilloffna.interactiveModelOfAnElectricalSubstation.substations.equipment.breakers.highVoltageCircuitBreaker.DefaultHighVoltageBreaker;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Setter
@Getter
public class PowerTransformer {
  String name;

  String description;

  private float delU;// диапазон регулирования РПН

  private double power;  /// в кВат

  private double UkVoltage; // as a percentage of one

  private int voltageVN;

  private int voltageNN;

  private final Map<String, DefaultHighVoltageBreaker> breakersMap = new ConcurrentHashMap<>();

  public PowerTransformer(String name, float delU, double power, double UkVoltage, int voltageVN, int voltageNN) {
    this.name = name;
    this.delU = delU;
    this.power = power;
    this.UkVoltage = UkVoltage;
    this.voltageVN = voltageVN;
    this.voltageNN = voltageNN;
  }

  public void addHighVoltageBreaker(int voltage, String side) {
    String name = "Выключатель " + voltage + "кВ " + getName();
    breakersMap.put(side, new DefaultHighVoltageBreaker(name, voltage));
  }
}

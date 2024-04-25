package kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.busbarSections;

import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.highVoltageCircuitBreaker.DefaultHighVoltageBreaker;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Setter
@Getter
public abstract class Section {
  private String name;
  private String description;
  private int voltage;
  Map<String, DefaultHighVoltageBreaker> highVoltageBreakers = new ConcurrentHashMap<>();

  public Section(String name, int voltage) {
    this.name = name + " "+ voltage;
    this.voltage = voltage;
  }

  @Override
  public String toString() {
    return name;
  }
}

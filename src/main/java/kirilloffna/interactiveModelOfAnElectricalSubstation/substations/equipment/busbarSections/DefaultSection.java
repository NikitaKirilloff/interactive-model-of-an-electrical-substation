package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.equipment.busbarSections;

import kirilloffna.interactiveModelOfAnElectricalSubstation.substations.equipment.breakers.highVoltageCircuitBreaker.DefaultHighVoltageBreaker;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class DefaultSection extends Section {
  private final Map<String, DefaultHighVoltageBreaker> highVoltageBreaker = new ConcurrentHashMap<>();

  public DefaultSection(String name, int voltage) {
    super(name, voltage);
  }
}

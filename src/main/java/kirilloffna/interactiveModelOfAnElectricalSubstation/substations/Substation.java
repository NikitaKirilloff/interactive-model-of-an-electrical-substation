package kirilloffna.interactiveModelOfAnElectricalSubstation.substations;

import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.highVoltageCircuitBreaker.HighVoltageBreaker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class Substation {


  @Getter
  @Setter
  Map<String, HighVoltageBreaker> highVoltageBreakers = new ConcurrentHashMap<>();

  @Getter
  @Setter
  Map<String, HighVoltageBreaker> lowVoltageBreakers = new ConcurrentHashMap<>();

  public void addHighVoltageBreaker(String name, HighVoltageBreaker highVoltageBreaker) {
    highVoltageBreakers.put(name, highVoltageBreaker);
  }

  public void addLowVoltageBreaker(String name, HighVoltageBreaker highVoltageBreaker) {

  }

}

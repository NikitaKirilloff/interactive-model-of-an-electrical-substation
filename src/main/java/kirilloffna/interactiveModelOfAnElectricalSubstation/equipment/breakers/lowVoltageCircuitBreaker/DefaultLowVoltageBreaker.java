package kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.lowVoltageCircuitBreaker;

import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.Breaker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultLowVoltageBreaker extends Breaker {
  private double voltage;
  private String shutdownTimeInSeconds;
  private String automaticTransfer;

  public DefaultLowVoltageBreaker(String name, double voltage) {
    super("В " + voltage + " " + name);
    this.voltage = voltage;
  }

  @Override
  public String toString() {

    return "Выключатель СН" + super.getName() + '.' +
            " Время срабатывания (в секундах) =" + shutdownTimeInSeconds +
            ", функция АВР=" + automaticTransfer;
  }
}

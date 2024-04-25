package kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Breaker {
  String name;
  String description;

  public Breaker(String name) {
    this.name = name;
  }

  public Breaker(String name, String description) {
    this.name = name;
    this.description = description;
  }
}

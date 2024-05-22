package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.equipment.breakers;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
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

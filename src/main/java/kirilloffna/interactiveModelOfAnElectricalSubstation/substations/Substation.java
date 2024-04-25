package kirilloffna.interactiveModelOfAnElectricalSubstation.substations;

import jakarta.persistence.*;
import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.Breaker;
import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.highVoltageCircuitBreaker.DefaultHighVoltageBreaker;
import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.breakers.lowVoltageCircuitBreaker.DefaultLowVoltageBreaker;
import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.busbarSections.DefaultSection;
import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.busbarSections.Section;
import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.transformers.PowerTransformer;
import kirilloffna.interactiveModelOfAnElectricalSubstation.utils.ConverterHighVoltage;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Table(name = "substation")
@Getter
public class Substation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Setter
  String name;

  @Setter
  String description;

  @Setter
  public static double IKZMax;

  @Setter
  public static double IKZMin;

  @Setter
  private int voltageVN;

  @Setter
  private int voltageNN;

  @Setter
  private double technicalVoltage;

  /*@Setter
  Breaker sectionHighVoltageBreaker;

  Map<String, Breaker> highVoltageBreakers = new ConcurrentHashMap<>();

  Map<String, PowerTransformer> powerTransformers = new ConcurrentHashMap<>();

  Map<String, Section> sectionsNN = new ConcurrentHashMap<>();

  Map<String, Breaker> lowVoltageBreakers = new ConcurrentHashMap<>();*/


  public Substation(String name, String voltageVN, String voltageNN) {
    this.name = name;
    this.voltageVN = ConverterHighVoltage.getVoltage(voltageVN);
    this.voltageNN = ConverterHighVoltage.getVoltage(voltageNN);
  }

  public Substation(String name, String description, String voltageVN, String voltageNN,
                    double IKZMax, double IKZMin, double technicalVoltage) {
    this.name = name;
    this.description = description;
    this.voltageVN = ConverterHighVoltage.getVoltage(voltageVN);
    this.voltageNN = ConverterHighVoltage.getVoltage(voltageNN);
    this.IKZMax = IKZMax;
    this.IKZMin = IKZMin;
    this.technicalVoltage = technicalVoltage;
  }

  public Substation() {

  }

  public void addDescription(String description) {
    if (!description.isEmpty()) {
     this.description += description;
    }
  }

  /*public void addSectionHighVoltageBreaker(String name)  {
    sectionHighVoltageBreaker = new DefaultHighVoltageBreaker(name, voltageNN);
  }

  public void addHighVoltageBreaker(String name, Breaker highVoltageBreaker) {
    highVoltageBreakers.put(name, highVoltageBreaker);
  }
  public void addHighVoltageBreaker(String name) {
    highVoltageBreakers.put(name, new DefaultHighVoltageBreaker(name, voltageVN));
  }

  public void setPowerTransformers(String name, PowerTransformer powerTransformer) {
    powerTransformers.put(name, powerTransformer);
  }
  public void setPowerTransformers(String name, float delU, double power, double UkVoltage) {
    powerTransformers.put(name, new PowerTransformer(name, delU, power, UkVoltage, voltageVN, voltageNN));
  }

  public void addSectionNN(String name) {
    sectionsNN.put(name, new DefaultSection(name, voltageNN));
  }

  public void addLowVoltageBreaker(String name) {
    if (technicalVoltage != 0.0) {
      lowVoltageBreakers.put(name, new DefaultLowVoltageBreaker(name, technicalVoltage));
    }
  }*/
}

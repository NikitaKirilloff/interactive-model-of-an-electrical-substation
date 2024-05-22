package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.entity;

import jakarta.persistence.*;
import kirilloffna.interactiveModelOfAnElectricalSubstation.substations.utils.ConverterHighVoltage;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "substation")
@Data
@NoArgsConstructor
public class Substation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  private String description;

  public double IKZMax;

  public double IKZMin;

  private int voltageVN;

  private int voltageNN;

  private double technicalVoltage;
/*
  @Setter
  @OneToOne(mappedBy = "substation", cascade = CascadeType.ALL)
  private DefaultHighVoltageBreaker sectionHighVoltageBreaker;

  @OneToMany(mappedBy = "substation", cascade = CascadeType.ALL)
  Map<String, Breaker> highVoltageBreakers = new ConcurrentHashMap<>();

  Map<String, PowerTransformer> powerTransformers = new ConcurrentHashMap<>();

  Map<String, Section> sectionsNN = new ConcurrentHashMap<>();

  Map<String, Breaker> lowVoltageBreakers = new ConcurrentHashMap<>();
*/

  public Substation(String name, String voltageVN, String voltageNN) {
    this.name = "ПС " + voltageVN + " кВ" + name;
    this.voltageVN = ConverterHighVoltage.getVoltage(voltageVN);
    this.voltageNN = ConverterHighVoltage.getVoltage(voltageNN);
  }

  public Substation(String name, String description, String voltageVN, String voltageNN,
                    double IKZMax, double IKZMin, double technicalVoltage) {
    this.name = "ПС " + voltageVN + " кВ" + name;
    this.description = description;
    this.voltageVN = ConverterHighVoltage.getVoltage(voltageVN);
    this.voltageNN = ConverterHighVoltage.getVoltage(voltageNN);
    this.IKZMax = IKZMax;
    this.IKZMin = IKZMin;
    this.technicalVoltage = technicalVoltage;
  }

  public void addDescription(String description) {
    if (!description.isEmpty()) {
     this.description += description;
    }
  }
/*
  public void addSectionHighVoltageBreaker(String name)  {
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
  }
  */
}

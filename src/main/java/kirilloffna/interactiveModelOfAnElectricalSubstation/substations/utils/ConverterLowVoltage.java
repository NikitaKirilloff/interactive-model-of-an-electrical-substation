package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.utils;

public class ConverterLowVoltage {
  public static double getVoltage(String voltage) {
    switch (voltage) {
      case "0.2", "0.22","0.2 кВ", "0.22 кВ", "220"  -> {
        return 0.22;
      }
      case "0.38", "0.4","0.38 кВ", "0.4 кВ", "380", "400" -> {
        return 0.4;
      }
    }
    return 0.4;
  }
}

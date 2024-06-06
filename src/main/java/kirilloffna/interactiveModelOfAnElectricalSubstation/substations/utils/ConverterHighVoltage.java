package kirilloffna.interactiveModelOfAnElectricalSubstation.substations.utils;

public class ConverterHighVoltage {
  public static int getVoltage(String voltage) {
    switch (voltage) {
      case "6", "6кВ", "6 кВ" -> {
        return 6;
      }
      case "10", "10кВ", "10 кВ" -> {
        return 10;
      }
      case "35", "35кВ", "35 кВ" -> {
        return 35;
      }
      case "110", "110кВ", "110 кВ" -> {
        return 110;
      }
    }
    return 0;
  }

  public static double getAverageRatedVoltage(int voltage) {
    switch (voltage) {
      case 6 -> {
        return 6.6;
      }
      case 10 -> {
        return 10.5;
      }
      case 35 -> {
        return 37d;
      }
      case 110 -> {
        return 115d;
      }
    }
    return 0;
  }
}

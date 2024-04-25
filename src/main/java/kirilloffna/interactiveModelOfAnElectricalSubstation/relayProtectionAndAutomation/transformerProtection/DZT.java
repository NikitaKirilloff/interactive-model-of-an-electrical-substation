package kirilloffna.interactiveModelOfAnElectricalSubstation.relayProtectionAndAutomation.transformerProtection;

import kirilloffna.interactiveModelOfAnElectricalSubstation.equipment.transformers.PowerTransformer;
import kirilloffna.interactiveModelOfAnElectricalSubstation.substations.Substation;
import kirilloffna.interactiveModelOfAnElectricalSubstation.utils.ConverterHighVoltage;

public class DZT {
  String description = "Дифференциальная защита трансформатора, выполненная на реле РНТ-565";

  private final double KO = 1.3; //коэф отстройки

  private final int KAS = 1; ////коэффициент апериодической состовляющей

  private final int KOd = 1; /// коэффициент однотипности

  private final double PTT = 0.1; //погрешность ТТ

  private final double KCH = 2; // коэф чувствительности

  private double INomVN;  //номинальные токи вн и нн

  private double INomNN;

  private double mainProtectionCurrent;

  private double currentUnbalancePreliminary;

  public double averageRatedVoltageVN;

  public double averageRatedVoltageNN;

  private PowerTransformer powerTransformer;

  private double KTCurrentTransformerVN; //коэф траснформации трансформаторов тока для ВН и НН

  private double KTCurrentTransformerNN;

  private double secondaryCurrentOfOperationMainSide;

  private double secondaryCurrentOfOperationNonMainSide;

  double secondaryCurrentOfRelayOperationVN;

  double secondaryCurrentOfRelayOperationNN;

  private int acceptedNumberTurnsMainSide; // округляем Вниз

  private int numberTurnsEqualizingWinding;   //число витков уравнительной обмотки

  private boolean isMainSideVN;

  public DZT(PowerTransformer powerTransformer) {
    this.powerTransformer = powerTransformer;
    this.KTCurrentTransformerVN = powerTransformer.getBreakersMap().get("ВН")
            .getCurrentTransformer().getTransformationRatio();
    this.KTCurrentTransformerNN = powerTransformer.getBreakersMap().get("НН")
            .getCurrentTransformer().getTransformationRatio();
  }

  public double getINom(int voltage) {
    double averageRatedVoltage = ConverterHighVoltage.getAverageRatedVoltage(voltage);
    return powerTransformer.getPower() / (Math.sqrt(3) * averageRatedVoltage);
  }

  public boolean preliminarySensitivityTest() { /// возвращаем стрингу, где пишем что коэф либо удовлетворяет, либо устанаваливаем более чувствительное реле
    INomVN = getINom(powerTransformer.getVoltageVN());
    currentUnbalancePreliminary = ((KAS * KOd * PTT) + powerTransformer.getDelU() / 100) * Substation.IKZMax;
    double protectionCurrent1 = KO * INomVN;
    double protectionCurrent2 = KO * currentUnbalancePreliminary;

    mainProtectionCurrent = Math.max(protectionCurrent1, protectionCurrent2);
    double preliminarySensitivity = Substation.IKZMin / mainProtectionCurrent;
    return preliminarySensitivity > KCH;
  }

  public void getВторичныйТокСрабатыванияРеле() {
    averageRatedVoltageVN = ConverterHighVoltage.getAverageRatedVoltage(powerTransformer.getVoltageVN());
    averageRatedVoltageNN = ConverterHighVoltage.getAverageRatedVoltage(powerTransformer.getVoltageNN());
    secondaryCurrentOfRelayOperationVN = Math.sqrt(3) * mainProtectionCurrent / KTCurrentTransformerVN;
    secondaryCurrentOfRelayOperationNN = mainProtectionCurrent * (averageRatedVoltageVN / averageRatedVoltageNN)
            / KTCurrentTransformerNN;

    secondaryCurrentOfOperationMainSide = Math.max(secondaryCurrentOfRelayOperationVN, secondaryCurrentOfRelayOperationNN);
    secondaryCurrentOfOperationNonMainSide = Math.min(secondaryCurrentOfRelayOperationVN, secondaryCurrentOfRelayOperationNN);
    isMainSideVN = secondaryCurrentOfRelayOperationVN > secondaryCurrentOfRelayOperationNN;
  }

  public void calcNumberTurnsEqualizingWinding() {  //расчёт витков уравнительной обмотки
    double calculatedNumberTurnsMainSide = 100 / secondaryCurrentOfOperationMainSide;
    acceptedNumberTurnsMainSide = (int) Math.floor(calculatedNumberTurnsMainSide);

    double calculatedNumberTurnsNonMainSide = acceptedNumberTurnsMainSide * secondaryCurrentOfOperationMainSide / secondaryCurrentOfOperationNonMainSide;
    int acceptedNumberTurnsNonMainSide = (int) Math.round(calculatedNumberTurnsNonMainSide);

    numberTurnsEqualizingWinding = acceptedNumberTurnsNonMainSide - acceptedNumberTurnsMainSide;
  }

  public double acceptedCurrentOfOperationRelayBeforeTT() {  // первичный ток
    double acceptedCurrentOfOperationRelayAfterTT = 100.0 / acceptedNumberTurnsMainSide; //вторичный ток
    double KTTMainSide = isMainSideVN ? KTCurrentTransformerVN : KTCurrentTransformerNN;

    if (isMainSideVN) {
      return acceptedCurrentOfOperationRelayAfterTT * KTTMainSide / Math.sqrt(3);
    }
    return acceptedCurrentOfOperationRelayAfterTT * KTTMainSide * (averageRatedVoltageNN / averageRatedVoltageVN);
  }
}

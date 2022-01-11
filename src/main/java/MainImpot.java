import java.math.BigDecimal;
import java.util.Arrays;

public class MainImpot {

    public static BigDecimal computeImpots(BigDecimal revenu) {
        return Arrays.stream(Tranche.values())
                .map(tranche -> tranche.computeTranche(revenu))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public static void main(String[] args) {

        BigDecimal revenu = BigDecimal.valueOf((48840+41200)/2);

        BigDecimal impots = computeImpots(revenu);

        System.out.println("Revenu annuelle %s vous allez paye %s impots".formatted(revenu.intValue()*2,impots.intValue()*2));


    }
}

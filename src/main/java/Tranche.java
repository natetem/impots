import java.math.BigDecimal;

public enum Tranche {

    TRANCHE1(BigDecimal.valueOf(1), BigDecimal.valueOf(0), BigDecimal.valueOf(10084), BigDecimal.valueOf(0)),
    TRANCHE2(BigDecimal.valueOf(2), BigDecimal.valueOf(10085), BigDecimal.valueOf(25710), BigDecimal.valueOf(0.11)),
    TRANCHE3(BigDecimal.valueOf(3), BigDecimal.valueOf(25711), BigDecimal.valueOf(73516), BigDecimal.valueOf(0.30)),
    TRANCHE4(BigDecimal.valueOf(4), BigDecimal.valueOf(73517), BigDecimal.valueOf(158122), BigDecimal.valueOf(0.41)),
    TRANCHE5(BigDecimal.valueOf(5), BigDecimal.valueOf(158122), BigDecimal.valueOf(Long.MAX_VALUE), BigDecimal.valueOf(0.45));
    public final BigDecimal order;
    public final BigDecimal min;
    public final BigDecimal max;
    public final BigDecimal percentage;

    Tranche(BigDecimal order, BigDecimal min, BigDecimal max, BigDecimal percentage) {
        this.order = order;
        this.max = max;
        this.min = min;
        this.percentage = percentage;
    }

    public BigDecimal computeTranche(BigDecimal revenu) {
        BigDecimal impots= BigDecimal.ZERO;
        BigDecimal restRevenu= BigDecimal.ZERO;
        if (min.compareTo(revenu) < 0) {
            if (max.compareTo(revenu) > 0) {
                restRevenu = revenu.subtract(min);
            } else {
                restRevenu = max.subtract(min);
            }
            impots = impots.add(restRevenu.multiply(percentage));
        }
        return impots;
    }

}

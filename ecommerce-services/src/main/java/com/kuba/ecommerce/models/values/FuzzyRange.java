package com.kuba.ecommerce.models.values;

/**
 * 1 dimensional not-discrete range of double precision
 */
public class FuzzyRange {

    //region 1st dimension
    private Double startValue;
    private Double endValue;
    //endregion 1st dimension

    /**
     * Default used fuzzy Universe consists of values from range 0 to 1
     */
    public FuzzyRange() {
        startValue = 0d;
        endValue = 1d;
    }

    @Override
    public String toString() {
        return "startValue="+String.valueOf(startValue)+" | "+
                "endValue="+String.valueOf(endValue);
    }

    public Double getStartValue() {
        return startValue;
    }

    public Double getEndValue() {
        return endValue;
    }
}

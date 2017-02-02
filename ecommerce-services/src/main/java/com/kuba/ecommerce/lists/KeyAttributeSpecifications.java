package com.kuba.ecommerce.lists;

public class KeyAttributeSpecifications {

    private Double maxValue;
    private Double minValue;

    public KeyAttributeSpecifications() {
        minValue = null;
        maxValue = null;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }
}

package com.kuba.ecommerce.models.values;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

public class FuzzyValue extends Value {

    private double low;
    private double medium;
    private double high;

    public FuzzyValue(double low, double medium, double high) {
        super();
        this.low = low;
        this.medium = medium;
        this.high = high;
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public String toString() {
        if(medium >= 0.5) return "MEDIUM";
        if(low >= 0.5) return "LOW";
        if(high >= 0.5) return "HIGH";
        return "?";
    }

    @Override
    public boolean isEqual(Value value) {
        if(!(value instanceof FuzzyValue)) return false;
        FuzzyValue other = (FuzzyValue) value;
        return this.low == other.low
                && this.medium == other.medium
                && this.high == other.high;
    }

    public double getLow() {
        return low;
    }

    public double getMedium() {
        return medium;
    }

    public double getHigh() {
        return high;
    }
}

package com.kuba.ecommerce.models.values;

import com.google.gson.annotations.SerializedName;

/**
 * Value of relation of X(objects) with A(attribute)
 */
public class DiscreteValue extends Value {
    //currently discrete integer value
    @SerializedName("value")
    private double value;

    public DiscreteValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean isEqual(Value value) {
        if(!(value instanceof DiscreteValue)) return false;
        DiscreteValue other = (DiscreteValue) value;
        return this.value == other.value;
    }
}

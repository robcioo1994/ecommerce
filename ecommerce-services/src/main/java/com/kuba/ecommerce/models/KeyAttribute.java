package com.kuba.ecommerce.models;

import com.google.gson.annotations.SerializedName;
import com.kuba.ecommerce.models.values.DiscreteValue;
import com.kuba.ecommerce.models.values.FuzzyValue;
import com.kuba.ecommerce.models.values.Value;

import java.lang.*;

public class KeyAttribute extends Attribute {

    @SerializedName("value")
    private DiscreteValue discreteValue;

    private FuzzyValue fuzyyValue;

    private double cog;

    public KeyAttribute(String name) {
        super(name);
    }

    public boolean equals(KeyAttribute keyAttribute) {
        return keyAttribute.name.equals(this.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public FuzzyValue getFuzyyValue() {
        return fuzyyValue;
    }

    public void setFuzyyValue(FuzzyValue fuzyyValue) {
        this.fuzyyValue = fuzyyValue;
    }

    public DiscreteValue getDiscreteValue() {
        return discreteValue;
    }

    public double getCog() {
        return this.cog;
    }

    public void setCog(double cog) {
        this.cog = cog;
    }
}

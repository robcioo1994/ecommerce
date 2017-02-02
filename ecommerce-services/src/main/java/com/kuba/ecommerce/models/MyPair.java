package com.kuba.ecommerce.models;

import com.google.gson.annotations.SerializedName;
import com.kuba.ecommerce.models.values.DiscreteValue;
import com.kuba.ecommerce.models.values.Value;

public class MyPair <T extends Value> {

    @SerializedName("attribute")
    public Attribute attribute;
    @SerializedName("value")
    public T value;

    public MyPair(Attribute attribute, T value) {
        this.attribute = attribute;
        this.value = value;
    }

    public boolean isDescrete() {
        return value instanceof DiscreteValue;
    }
}

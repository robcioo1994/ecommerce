package com.kuba.ecommerce.models;

import com.google.gson.annotations.SerializedName;

public class Object extends FuzzyRelationElement {

    @SerializedName("id")
    private int id;

    public Object(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "U"+String.valueOf(id);
    }

    public boolean equals(Object other) {
        return this.id == other.id;
    }
}

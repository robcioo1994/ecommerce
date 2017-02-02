package com.kuba.ecommerce.models;

//public enum Attribute {//public class Attribute extends FuzzyRelationElement {
//
//    A,B,C,D,E,F,G
//}

import com.google.gson.annotations.SerializedName;

import java.lang.*;
import java.lang.Object;

public class Attribute {

    @SerializedName("name")
    protected String name;

    public Attribute(String name) {
        this.name = name;
    }

    public boolean equals(Attribute other) {
        return this.name.equals(other.name);
    }

    public String getName() {
        return name;
    }
}

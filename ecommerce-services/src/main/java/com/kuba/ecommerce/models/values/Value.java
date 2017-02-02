package com.kuba.ecommerce.models.values;

public abstract class Value  {

    public abstract double getValue();

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        try {
            throw new Exception(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.equals(obj);
    }

    public abstract boolean isEqual(Value other);
}

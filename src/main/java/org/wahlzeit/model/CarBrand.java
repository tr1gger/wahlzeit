package org.wahlzeit.model;

import org.wahlzeit.utils.EnumValue;

public enum CarBrand implements EnumValue {

    PORSCHE(0), AUDI(1), VW(2), MERCEDES(3);

    private int value = 0;

    CarBrand(int i) {
        this.value = i;
    }

    private static CarBrand[] allValues = {
            PORSCHE, AUDI, VW, MERCEDES
    };

    private static String[] valueNames = {
            "Porsche", "Audi", "Volkswagen", "Mercedes Benz"
    };


    @Override
    public int asInt() {
        return value;
    }

    @Override
    public String asString() {
        return valueNames[value];
    }

    @Override
    public EnumValue[] getAllValues() {
        return allValues;
    }

    @Override
    public String getTypeName() {
        return "CarBrands";
    }
}
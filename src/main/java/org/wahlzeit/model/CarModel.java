package org.wahlzeit.model;

import org.wahlzeit.utils.EnumValue;

public enum CarModel implements EnumValue {

    COUPE(0), VAN(1), SPORTSCAR(2), SUV(3);

    private int value = 0;

    CarModel(int i) {
        this.value = i;
    }

    private static CarModel[] allValues = {
            COUPE, VAN, SPORTSCAR, SUV
    };

    private static String[] valueNames = {
            "Coupe", "Van", "Sports Car", "SUV"
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
        return "CarModel";
    }
}
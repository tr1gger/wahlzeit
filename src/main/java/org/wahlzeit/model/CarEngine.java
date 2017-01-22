package org.wahlzeit.model;

import org.wahlzeit.utils.EnumValue;

public enum CarEngine implements EnumValue {

    ELECTRIC(0), DIESEL(1), OTTO(2), HYBRID(3);

    private int value = 0;

    CarEngine(int i) {
        this.value = i;
    }

    private static CarEngine[] allValues = {
            ELECTRIC, DIESEL, OTTO, HYBRID
    };

    private static String[] valueNames = {
            "Electric", "Diesel", "Otto", "hybrid"
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
        return "CarEngine";
    }
}
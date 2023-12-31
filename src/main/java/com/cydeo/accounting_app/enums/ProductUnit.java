package com.cydeo.accounting_app.enums;

import lombok.Getter;

@Getter
public enum ProductUnit {

    LBS ("Libre"),
    GALLON ("Gallon"),
    PCS ("Pieces"),
    KG ("Kilogram"),
    METER ("Meter"),
    INCH ("Inch"),
    FEET ("Feet");

    private String value;

    ProductUnit(String value) {
        this.value = value;
    }
}

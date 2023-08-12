package com.javarush.island.zonov.entity.animals.characterstics;

import com.javarush.island.zonov.repository.AnimalTypeCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface AnimalCharacteristic {
    double weight();
    int maxCountOnCell();
    int speed();
    double foodWeight();
}

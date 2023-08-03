package com.javarush.island.zonov.animalCharactersticInterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface Characteristic {
    double weight();
    int maxCountOnCell();
    int speed();
    double foodWeight();
    boolean isAlive() default true;
}

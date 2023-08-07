package com.javarush.island.zonov.characterstics;

import com.javarush.island.zonov.animals.headClasses.Animal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashSet;
import java.util.Set;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface AnimalCharacteristic {
    double weight();
    int maxCountOnCell();
    int speed();
    double foodWeight();
    boolean isAlive() default true;
    boolean isHungry() default true;;
}

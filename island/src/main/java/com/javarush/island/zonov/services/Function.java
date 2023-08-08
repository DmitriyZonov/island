package com.javarush.island.zonov.services;

import com.javarush.island.zonov.entity.Result;

public interface Function {
    Result execute() throws InterruptedException;
}

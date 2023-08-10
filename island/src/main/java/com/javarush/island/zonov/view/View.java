package com.javarush.island.zonov.view;

import com.javarush.island.zonov.entity.Result;

import java.io.IOException;

public interface View {
    String getFirstParameter() throws IOException;

    String getRuntimeParameter() throws IOException;

    void printResult(Result result) throws IOException;

    void printStatistics() throws IOException;
}

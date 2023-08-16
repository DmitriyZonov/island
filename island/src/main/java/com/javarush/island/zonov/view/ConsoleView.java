package com.javarush.island.zonov.view;

import com.javarush.island.zonov.entity.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.javarush.island.zonov.constants.ApplicationCompletionConstants.*;
import static com.javarush.island.zonov.constants.ConsoleViewConstants.*;
import static com.javarush.island.zonov.util.counters.IslandPopulationGetter.getIslandInformation;


public class ConsoleView implements View{

    @Override
    public String getFirstParameter() throws IOException{
        System.out.println(GREETING);
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String parameter;
        System.out.println(FIRST_CHOICE);
        System.out.println();
        parameter = reader.readLine();

        return parameter;
    }

    @Override
    public String getRuntimeParameter() throws IOException {
        System.out.println(getIslandInformation());
        System.out.println();
        System.out.println(NEXT_DAY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String parameter;
        System.out.println();
        parameter = reader.readLine();
        return parameter;
    }

    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case GO_TO_NEXT_DAY -> System.out.println();
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION);
        }
    }

    @Override
    public void printStatistics() {
        System.out.println(getIslandInformation());
        System.out.println();
    }
}

package com.javarush.island.zonov;

import com.javarush.island.zonov.app.Application;
import com.javarush.island.zonov.controller.MainController;
import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.view.ConsoleView;
import com.javarush.island.zonov.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.firstRun();
        application.printResult(result);

    }
}
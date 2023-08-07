package com.javarush.island.zonov.app;

import com.javarush.island.zonov.controller.MainController;
import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.repository.FunctionCode;
import com.javarush.island.zonov.services.Function;

import java.io.IOException;

import static com.javarush.island.zonov.constants.FunctionCodeConstants.*;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }
    public Result run() throws IOException {
        firstRun();
        String mode = mainController.getView().getRuntimeParameter();
        Function function = getFunction(mode);
        return function.execute();
    }

    public Result firstRun() throws IOException {
        String parameter = mainController.getView().getFirstParameter();
        Function function = getStartFunction(parameter);

        return function.execute();
    }

    private Function getStartFunction(String mode) {
        return switch (mode) {
            case "" -> FunctionCode.valueOf(FIRST_START).getFunction();
            case "0" -> FunctionCode.valueOf(LOAD_SAVED_FILE).getFunction();
            default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();
        };
    }

    private Function getFunction(String mode) {
        return switch (mode) {
            case "2" -> FunctionCode.valueOf(NEXT_DAY).getFunction();
            case "3" -> FunctionCode.valueOf(SAVE_RESULT).getFunction();
            case "4" -> FunctionCode.valueOf(LOAD_SAVED_FILE).getFunction();
            default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();
        };
    }

    public void printResult(Result result) {
            try {
                mainController.getView().printResult(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}

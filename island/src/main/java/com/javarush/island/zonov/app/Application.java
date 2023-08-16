package com.javarush.island.zonov.app;

import com.javarush.island.zonov.controller.MainController;
import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.repository.FunctionCode;
import com.javarush.island.zonov.repository.ResultCode;
import com.javarush.island.zonov.services.Function;

import java.io.IOException;

import static com.javarush.island.zonov.constants.FunctionCodeConstants.*;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }
    public Result run() throws IOException, InterruptedException {
        firstRun();
        String mode = mainController.getView().getRuntimeParameter();
        Function function = getFunction(mode);
        return function.execute();
    }

    public Result firstRun() throws IOException, InterruptedException {
        String parameter = mainController.getView().getFirstParameter();
        Function function = getStartFunction(parameter);
        return function.execute();
    }
    public Result nextDayRun() throws IOException, InterruptedException {
        String parameter = mainController.getView().getRuntimeParameter();
        Function function = getFunction(parameter);
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
            case "" -> FunctionCode.valueOf(NEXT_DAY).getFunction();
            case "0" -> FunctionCode.valueOf(SAVE_RESULT).getFunction();
            case "1" -> FunctionCode.valueOf(LOAD_SAVED_FILE).getFunction();
            case "exit" -> FunctionCode.valueOf(EXIT).getFunction();
            default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();
        };
    }

    public void printResult(Result result) {
        while (result.getResultCode() == ResultCode.GO_TO_NEXT_DAY) {
            try {
                Result resultOfNextDay = nextDayRun();
                mainController.getView().printResult(resultOfNextDay);
                mainController.getView().printStatistics();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException();
            }
        }
            try {
                mainController.getView().printResult(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}

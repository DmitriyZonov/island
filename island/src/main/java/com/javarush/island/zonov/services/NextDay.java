package com.javarush.island.zonov.services;

import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.island.Island;
import com.javarush.island.zonov.repository.ResultCode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.javarush.island.zonov.constants.ExceptionConstants.EXCEPTION_MESSAGE;
import static com.javarush.island.zonov.constants.IslandConstants.SECTORS_COUNT;

public class NextDay implements Function{
    @Override
    public Result execute() throws InterruptedException {
        try {
            startNewDay();
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException(EXCEPTION_MESSAGE, e));
        }
        return new Result(ResultCode.OK);
    }

    private void startNewDay() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(SECTORS_COUNT);
        List<Callable<ResultCode>> listOfTasks = new ArrayList<>(Island.getSectors());
        service.invokeAll(listOfTasks);
    }
}

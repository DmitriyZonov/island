package com.javarush.island.zonov.services;

import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.island.Island;
import com.javarush.island.zonov.island.Sector;
import com.javarush.island.zonov.repository.ResultCode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


import static com.javarush.island.zonov.constants.ExceptionConstants.NEW_DAY_EXCEPTION_MESSAGE;


public class NextDay implements Function{
    @Override
    public Result execute() throws InterruptedException {
        try {
            startNewDay();
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException(NEW_DAY_EXCEPTION_MESSAGE, e));
        }
        return new Result(ResultCode.OK);
    }

    private void startNewDay() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(8);
        List<Callable<Sector>> listOfTasks = new ArrayList<>(Island.getSectors());
        List<Future<Sector>> future = service.invokeAll(listOfTasks);
        service.shutdown();
        List<Sector> sectors = new ArrayList<>();
        for (int i = 0; i < future.size(); i++) {
            sectors.add(future.get(i).get());
        }
        Island.setSectors(sectors);
    }
}

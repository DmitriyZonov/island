package com.javarush.island.zonov.services;

import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.entity.island.Island;
import com.javarush.island.zonov.entity.island.Sector;
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
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Callable<ResultCode>> listOfTasks = new ArrayList<>(Island.getSectors());
        List<Future<ResultCode>> future = service.invokeAll(listOfTasks);
        service.shutdown();
    }
}

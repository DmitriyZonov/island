package com.javarush.island.zonov.services;

import com.javarush.island.zonov.entity.Result;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.repository.ResultCode;

import static com.javarush.island.zonov.constants.ExceptionConstants.EXCEPTION_MESSAGE;

public class Exit implements Function{
    @Override
    public Result execute() throws InterruptedException {
        try {

        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException(EXCEPTION_MESSAGE, e));
        }
        return new Result(ResultCode.OK);
    }
}

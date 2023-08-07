package com.javarush.island.zonov.entity;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.repository.ResultCode;

public class Result {

    private ResultCode resultCode;

    private ApplicationException applicationException;

    public Result (ResultCode resultcode) {
        this.resultCode = resultcode;
    }
    public Result (ResultCode resultCode, ApplicationException applicationexception) {
        this.resultCode = resultCode;
        this.applicationException = applicationexception;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public ApplicationException getApplicationException() {
        return applicationException;
    }
}

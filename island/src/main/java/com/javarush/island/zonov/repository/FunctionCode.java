package com.javarush.island.zonov.repository;

import com.javarush.island.zonov.services.*;

public enum FunctionCode {
    FIRST_START(new FirstStart()), NEXT_DAY(new NextDay()), SAVE_RESULT(new SaveResult()), LOAD_SAVED_FILE(new LoadSavedFile()), EXIT(new Exit()), UNSUPPORTED_FUNCTION(new UnsupportedFunction());

    private Function function;

    FunctionCode(Function function) {
        this.function = function;
    }
    public Function getFunction() {
        return function;
    }
}

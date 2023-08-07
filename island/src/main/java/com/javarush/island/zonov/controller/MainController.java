package com.javarush.island.zonov.controller;

import com.javarush.island.zonov.view.View;

public class MainController {
    private View view;
    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}

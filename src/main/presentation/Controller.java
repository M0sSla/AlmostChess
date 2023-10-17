package main.presentation;

import main.model.Repository;

import javax.swing.*;

public class Controller {
    private View view;
    private Repository repository;

    public Controller(View view, Repository repository) {
        this.view = view;
        this.repository = repository;
        updateUi();
    }

    public void updateUi() {
    }
}

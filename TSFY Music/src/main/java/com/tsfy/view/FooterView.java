package com.tsfy.view;

import javafx.scene.control.Label;

public class FooterView {

    private final Label root;

    public FooterView() {

        root = new Label(
            "TECNOLOGIA   /   MÚSICA   /   LIBERDADE                         TSFY v1.0"
        );

        root.getStyleClass().add(
            "footer"
        );
    }

    public Label getView() {
        return root;
    }
}
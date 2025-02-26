package com.app.utils;

import javafx.scene.control.TextField;

public class Constraints {

    public static void setTextFieldDouble(TextField txt) {
        txt.textProperty().addListener(
            (_obs, oldValue, newValue) -> {
                if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                    txt.setText(oldValue);
                }
            }
        );
    }

    public static void setTextFieldMaxLength(TextField txt, int max) {
        txt.textProperty().addListener(
            (_obs, oldValue, newValue) -> {
                if (newValue != null && newValue.length() > max) {
                    txt.setText(oldValue);
                }
            }   
        );
    }

    public static void setTextFieldInterger(TextField txt) {
        txt.textProperty().addListener(
            (_obs, oldValue, newValue) -> {
                if (newValue != null && !newValue.matches("\\d*")) {
                    txt.setText(oldValue);
                }
            }
        );
    }

    public static void setTextFieldDataFormater(TextField txt) {
        txt.textProperty().addListener(
            (_obs, oldValue, newValue) -> {
                if (newValue != null && !newValue.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$")) {
                    txt.setText(oldValue);
                }
            }
        );
    }

}

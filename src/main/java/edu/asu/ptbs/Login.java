package edu.asu.ptbs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class Login {
    private Map<String, Map<String,String>> db = new HashMap<String, Map<String,String>>();

    Login(){
        // Initialize the database

    }

    private String username;
    private String password;

    private Person person;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    private boolean isLoggedIn=false;

    public void handleSubmitButtonAction(String username, String password){
        String msg = "";
        // Validate userName and password fields
    }
}

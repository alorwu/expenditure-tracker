package org.az20.expendituretracker.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean emailValidation(String email){

        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)" +
                "*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean userValidation(String username){

        Pattern pattern;
        Matcher matcher;

        final String USERNAME_PATTERN = "^([\\w]{3,})*$";
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean nameValidation(String name){

        Pattern pattern;
        Matcher matcher;

        final String USERNAME_PATTERN = "^([a-zA-Z ]{4,})*$";
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean passwordValidation(String pass){

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!#@$&*_()%])(?=.*[\\d]).{6,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    public static boolean inputValidation(String input){

        Pattern pattern;
        Matcher matcher;

        final String INPUT_PATTERN = "^([a-zA-Z ]{3,})*$";
        pattern = Pattern.compile(INPUT_PATTERN);
        matcher = pattern.matcher(input);
        return matcher.matches();
    }
}

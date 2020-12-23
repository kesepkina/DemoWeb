package com.epam.basics.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataValidator {

    private static final Pattern LOGIN_PATTERN = Pattern.compile("[a-zA-Z0-9._]{5,}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&()])(?=\\S+$).{8,20}$");

    public boolean isLogin(String inputtedData) {
        if (inputtedData == null || inputtedData.isBlank()) return false;
        Matcher matcher = LOGIN_PATTERN.matcher(inputtedData);
        return matcher.matches();
    }

    public boolean isPassword(String inputtedData) {
        if (inputtedData == null || inputtedData.isBlank()) return false;
        Matcher matcher = PASSWORD_PATTERN.matcher(inputtedData);
        return matcher.matches();
    }
}

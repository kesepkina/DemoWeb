package com.epam.basics.command.impl;

import com.epam.basics.command.Command;
import com.epam.basics.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static com.epam.basics.command.PagePath.*;

public class LogInCommand implements Command {

    private static final String PARAM_NAME = "name";
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_USERNAME = "username";
    private static final String PARAM_PASSWORD = "password";

    private final UserServiceImpl service;

    public LogInCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) throws UnsupportedEncodingException {
        String page;
        String nameValue = request.getParameter(PARAM_NAME);
        System.out.println(nameValue);
        String emailValue = request.getParameter(PARAM_EMAIL);
        String usernameValue = request.getParameter(PARAM_USERNAME);
        String passValue = request.getParameter(PARAM_PASSWORD);
        boolean dataAreCorrect = true;
        if (!service.isUsername(usernameValue)) {
            request.setAttribute("errorUsernameMessage", "Username isn't correct. It must include only letters, ciphers, characters \".\", \"_\" and have at least 5 characters.");
            dataAreCorrect = false;
        }
        if (service.checkUsername(usernameValue)) {
            request.setAttribute("errorUserMessage", "User with inputted username already exists.");
            dataAreCorrect = false;
        } else if (!service.isPassword(passValue)) {
            request.setAttribute("errorPasswordMessage", "Password isn't correct. It must include at least one letter in upper and in lower case, at least one cipher, at least one special character (\"@\", \"#\". \"$\", \"%\", \"^\", \"&\", \"(\" or \")\", no spaces and have from 8 to 20 characters.");
            dataAreCorrect = false;
        }
        if (dataAreCorrect) {
            service.addUser(nameValue, emailValue, usernameValue, passValue);
            page = SIGNUP;
        } else {
            request.setAttribute(PARAM_NAME, nameValue);
            page = LOGIN;
        }
        return page;
    }
}

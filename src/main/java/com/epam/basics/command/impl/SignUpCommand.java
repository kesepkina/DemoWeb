package com.epam.basics.command.impl;

import com.epam.basics.command.Command;
import com.epam.basics.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;

import static com.epam.basics.command.PagePath.*;

public class SignUpCommand implements Command {

    private static final String PARAM_NAME = "user";
    private static final String PARAM_USERNAME = "username";
    private static final String PARAM_PASSWORD = "password";

    private final UserServiceImpl service;

    public SignUpCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String username = request.getParameter(PARAM_USERNAME);
        String passValue = request.getParameter(PARAM_PASSWORD);
        boolean dataAreCorrect = true;
        if (!service.isUsername(username)) {
            request.setAttribute("errorUsernameMessage", "Username isn't correct. It must include only letters, ciphers, characters \".\", \"_\" and have at least 5 characters.");
            dataAreCorrect = false;
        }
        if (!service.isPassword(passValue)) {
            request.setAttribute("errorPasswordMessage", "Password isn't correct. It must include at least one letter in upper and in lower case, at least one cipher, at least one special character (\"@\", \"#\". \"$\", \"%\", \"^\", \"&\", \"(\" or \")\", no spaces and have from 8 to 20 characters.");
            dataAreCorrect = false;
        }
        if (service.checkUsername(username)) {
            if (!service.checkUser(username, passValue)) {
                request.setAttribute("errorUserMessage", "Incorrect password");
                dataAreCorrect = false;
            }
        } else {
            request.setAttribute("errorUserMessage", "User with inputted username doesn't exist.");
            dataAreCorrect = false;
        }
        if (dataAreCorrect) {
            try {
                request.setCharacterEncoding("utf8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            request.setAttribute(PARAM_NAME, service.getName(username));
            page = MAIN;
        } else {
            page = SIGNUP;
        }
        return page;
    }
}

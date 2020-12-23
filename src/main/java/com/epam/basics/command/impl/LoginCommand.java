package com.epam.basics.command.impl;

import com.epam.basics.command.Command;
import com.epam.basics.service.impl.UserServiceImpl;
import com.epam.basics.validator.UserDataValidator;

import javax.servlet.http.HttpServletRequest;

import static com.epam.basics.command.PagePath.LOGIN;
import static com.epam.basics.command.PagePath.MAIN;

public class LoginCommand implements Command {

    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";

    private final UserServiceImpl service;

    public LoginCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String loginValue = request.getParameter(PARAM_LOGIN);
        String passValue = request.getParameter(PARAM_PASSWORD);
        UserDataValidator validator = new UserDataValidator();
        if (!validator.isLogin(loginValue)) {
            request.setAttribute("errorLoginMessage", "Login isn't correct. It must include only letters, ciphers, characters \".\", \"_\" and have at least 5 characters.");
            page = LOGIN;
        } else if (!validator.isPassword(passValue)) {
            request.setAttribute("errorPasswordMessage", "Password isn't correct. It must include at least one letter in upper and in lower case, at least one cipher, at least one special character (\"@\", \"#\". \"$\", \"%\", \"^\", \"&\", \"(\" or \")\", no spaces and have from 8 to 20 characters.");
            page = LOGIN;
        } else if (service.checkUser(loginValue, passValue)) {
            request.setAttribute("user", loginValue);
            page = MAIN;
        } else {
            request.setAttribute("errorUserMessage", "There isn't any user with inputted login and password.");
            page = LOGIN;
        }
        return page;
    }
}

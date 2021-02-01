package com.epam.basics.command;

import com.epam.basics.command.impl.*;
import com.epam.basics.service.impl.UserServiceImpl;

public enum CommandType {
    SIGNUP(new SignUpCommand(new UserServiceImpl())),
    LOGIN(new LogInCommand(new UserServiceImpl())),
    LOGOUT(new LogoutCommand()),
    SHOW_INFO(new ShowInfoCommand()),
    MAIN_PAGE(new PageCommand(PagePath.MAIN)),
    LOGIN_PAGE(new PageCommand(PagePath.LOGIN)),
    SIGNUP_PAGE(new PageCommand(PagePath.SIGNUP));

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}

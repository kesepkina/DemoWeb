package com.epam.basics.command;

import com.epam.basics.command.impl.BackToMainPageCommand;
import com.epam.basics.command.impl.LoginCommand;
import com.epam.basics.command.impl.LogoutCommand;
import com.epam.basics.command.impl.ShowInfoCommand;
import com.epam.basics.service.impl.UserServiceImpl;

public enum CommandType {
    LOGIN(new LoginCommand(new UserServiceImpl())),
    LOGOUT(new LogoutCommand()),
    SHOWINFO(new ShowInfoCommand()),
    BACKTOMAIN(new BackToMainPageCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}

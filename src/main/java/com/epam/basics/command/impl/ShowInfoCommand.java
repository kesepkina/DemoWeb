package com.epam.basics.command.impl;

import com.epam.basics.command.Command;
import com.epam.basics.command.PagePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ShowInfoCommand implements Command {

    private static final Logger log = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.INFO;
        log.debug("Info about project showed.");
        return page;
    }
}

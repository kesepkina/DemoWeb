package com.epam.basics.command.impl;

import com.epam.basics.command.Command;
import com.epam.basics.command.PagePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PageCommand implements Command {

    private static final Logger log = LogManager.getLogger();
    private final String page;

    public PageCommand(String page) {
        this.page = page;
    }

    @Override
    public String execute(HttpServletRequest request) {
        log.debug("Forward to {}", page);
        return page;
    }
}

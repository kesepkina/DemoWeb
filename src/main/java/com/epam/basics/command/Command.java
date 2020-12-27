package com.epam.basics.command;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public interface Command {
    String execute(HttpServletRequest request) throws UnsupportedEncodingException;
    default void refresh(){} // return to the same page
}

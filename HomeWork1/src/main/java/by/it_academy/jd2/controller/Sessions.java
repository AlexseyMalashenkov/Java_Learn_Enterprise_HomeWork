package by.it_academy.jd2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * This is a class for work with cookies
 * @author Aleksey Malashenkov
 * @version 0.0.0
 */

public class Sessions {

    /**
     * method load data
     * @param req - param
     * @param key - param
     */

    public static String getValueFromAnyWhere(HttpServletRequest req, String key) {
        String val = req.getParameter(key);

        if (val == null) {
            HttpSession session = req.getSession();

            if (!session.isNew()) {
                val = (String) session.getAttribute(key);
            }
        }

        if (val == null) {
            throw new IllegalArgumentException("Не передан один из обязательных параметров");
        }

        return val;
    }

    /**
     * method save cookie
     * @param req - param
     * @param key - param
     * @param val - param
     */

    public static void saveSessions(HttpServletRequest req, String key, String val) {
        HttpSession session = req.getSession();
        session.setAttribute(key, val);
    }
}

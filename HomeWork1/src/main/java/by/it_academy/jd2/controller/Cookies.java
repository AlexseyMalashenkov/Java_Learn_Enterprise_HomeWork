package by.it_academy.jd2.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * This is a class for work with cookies
 * @author Aleksey Malashenkov
 * @version 0.0.0
 */

public class Cookies {

    /**
     * method load data
     * @param req - param
     * @param key - param
     */

    public static String getValueFromAnyWhere(HttpServletRequest req, String key) {
        String val = req.getParameter(key);

        if (val == null) {
            Cookie[] cookies = req.getCookies();

            if (cookies != null) {
                val = Arrays.stream(cookies)
                        .filter(c -> key.equalsIgnoreCase(c.getName()))
                        .map(Cookie::getValue)
                        .findFirst()
                        .orElse(null);
            }
        }

        if (val == null) {
            throw new IllegalArgumentException("Не передан один из обязательных параметров");
        }

        return val;
    }

    /**
     * method save cookie
     * @param resp - param
     * @param key - param
     * @param val - param
     */

    public static void saveCookies(HttpServletResponse resp, String key, String val) {
        Cookie myCookie = new Cookie(key, URLEncoder.encode(val, StandardCharsets.UTF_8));
        myCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        resp.addCookie(myCookie);
    }
}

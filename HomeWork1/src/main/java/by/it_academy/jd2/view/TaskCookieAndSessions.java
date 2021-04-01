package by.it_academy.jd2.view;

import by.it_academy.jd2.controller.Cookies;
import by.it_academy.jd2.controller.Sessions;
import by.it_academy.jd2.model.LoadType;
import by.it_academy.jd2.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is a class for print info from cookie or session
 * @author Aleksey Malashenkov
 * @version 0.0.0
 */

@WebServlet(name = "TaskCookieAndSessions", urlPatterns = "/cookieAndSessions")
public class TaskCookieAndSessions extends HttpServlet {

    private final String LOAD_TYPE = "loadType";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String AGE = "age";

    /**
     * override method doGet
     * @param req - param
     * @param resp - param
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter(LOAD_TYPE);
        LoadType loadType = LoadType.valueOf(param.toUpperCase());

        if (loadType == LoadType.SESSION) {
            workSessions(req, resp);
        } else if (loadType == LoadType.COOKIE) {
            workCookies(req, resp);
        }
    }

    /**
     * method work with cookie
     * @param req - param
     * @param resp - param
     */

    private void workCookies(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstNameVal = Cookies.getValueFromAnyWhere(req, FIRST_NAME);
        String lastNameVal = Cookies.getValueFromAnyWhere(req, LAST_NAME);
        String ageVal = Cookies.getValueFromAnyWhere(req, AGE);

        Cookies.saveCookies(resp, FIRST_NAME, firstNameVal);
        Cookies.saveCookies(resp, LAST_NAME, lastNameVal);
        Cookies.saveCookies(resp, AGE, ageVal);

        writeWeb(firstNameVal, lastNameVal, ageVal, resp);
    }

    /**
     * method work with cookie
     * @param req - param
     * @param resp - param
     */

    private void workSessions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstNameVal = Sessions.getValueFromAnyWhere(req, FIRST_NAME);
        String lastNameVal = Sessions.getValueFromAnyWhere(req, LAST_NAME);
        String ageVal = Sessions.getValueFromAnyWhere(req, AGE);

        Sessions.saveSessions(req, FIRST_NAME, firstNameVal);
        Sessions.saveSessions(req, LAST_NAME, lastNameVal);
        Sessions.saveSessions(req, AGE, ageVal);

        writeWeb(firstNameVal, lastNameVal, ageVal, resp);
    }

    /**
     * method print info
     * @param firstNameVal - first name
     * @param lastNameVal - last name
     * @param ageVal - age
     * @param resp - param
     */

    private void writeWeb(String firstNameVal, String lastNameVal, String ageVal, HttpServletResponse resp) throws IOException {
        Person person = new Person(firstNameVal, lastNameVal, Integer.parseInt(ageVal));

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: blue;'>Hello, " + person.toString() + " !</span></p>");
    }
}

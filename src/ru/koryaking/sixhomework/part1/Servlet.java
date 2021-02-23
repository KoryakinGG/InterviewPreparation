package ru.koryaking.sixhomework.part1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    private String message;
    private static Logger Logger = LoggerFactory.getLogger(Servlet.class);

    @Override
    public void init() throws ServletException {
        Logger.debug("Log: INIT");
        message = "Hello World";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger.debug("Log: GET");
        response.getWriter().printf("<html><body><h1> Hello from GET request </h1></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger.debug("Log: POST");
        response.getWriter().printf("<html><body><h1> Hello from POST request </h1></body></html>");
    }

    @Override
    public void destroy() {
        Logger.debug("Log: DESTROY");
        // TODO nothing
    }
}

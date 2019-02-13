package io.deep27soft.jwstutorials.servlets;

import io.deep27soft.jwstutorials.templater.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String value = req.getParameter("key");

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("key", value);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(PageGenerator.instance().getPage("simplePage.html", pageVariables));
    }
}

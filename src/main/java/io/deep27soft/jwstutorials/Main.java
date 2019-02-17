package io.deep27soft.jwstutorials;

import io.deep27soft.jwstutorials.accounts.AccountService;
import io.deep27soft.jwstutorials.accounts.UserProfile;
import io.deep27soft.jwstutorials.servlets.SessionsServlet;
import io.deep27soft.jwstutorials.servlets.SignInServlet;
import io.deep27soft.jwstutorials.servlets.SignUpServlet;
import io.deep27soft.jwstutorials.servlets.UsersServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    public static void main(String[] args) throws Exception {

        AccountService accountService = new AccountService();
        accountService.addNewUser(new UserProfile("admin"));
        accountService.addNewUser(new UserProfile("test"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/api/v1/users");
        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/api/v1/sessions");
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/api/v1/signUp");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/api/v1/signIn");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}

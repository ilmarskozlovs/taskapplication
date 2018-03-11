package servlets;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ApplicationContext applicationContext = SpringFactory.get();

        String param = req.getParameter("param");

        HttpSession session = req.getSession();

        session.setAttribute("attr",new Object());
        Object o = session.getAttribute("attr");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "Hello World" + "</h1>");
        out.println("<h2>" + "Hello World" + "</h2>");
        out.println("<h3>" + "Hello World" + "</h3>");
        out.println("<h1>" + "PARAM = " + param + "</h1>");
    }
}

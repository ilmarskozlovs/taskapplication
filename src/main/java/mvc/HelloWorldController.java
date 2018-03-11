package mvc;

import javax.servlet.http.HttpServletRequest;

public class HelloWorldController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        return new MVCModel("helloWorld.jsp", "Hello from MVC!");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }
}

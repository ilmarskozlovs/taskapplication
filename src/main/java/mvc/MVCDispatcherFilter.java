package mvc;

import configs.SpringAppConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MVCDispatcherFilter implements Filter {

    private static Logger logger = Logger.getLogger(MVCDispatcherFilter.class.getName());

    private ApplicationContext applicationContext;

    private Map<String, MVCController> controllerMapping;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            applicationContext =
                    new AnnotationConfigApplicationContext(SpringAppConfig.class);
        }catch (BeansException e){
            logger.log(Level.INFO,"Spring context failed to start",e);
        }

        controllerMapping = new HashMap<>();
        controllerMapping.put("/hello", getBean(HelloWorldController.class));

    }

    private MVCController getBean(Class clazz) {
        return (MVCController) applicationContext.getBean(clazz);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String contextURI = req.getServletPath();

        if (controllerMapping.keySet().contains(contextURI)){
            MVCController controller = controllerMapping.get(contextURI);

            MVCModel model = null;

            String method = req.getMethod();

            if ("GET".equalsIgnoreCase(method)){
                model = controller.processGet(req);
            }
            if ("POST".equalsIgnoreCase(method)){
                model = controller.processPost(req);
            }

            req.setAttribute("model",model.getData());

            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getView());
            requestDispatcher.forward(req,resp);
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

package servlets;

import configs.SpringAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringFactory {

    public static ApplicationContext applicationContext;

    public static ApplicationContext get(){
        if (applicationContext == null){
            applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        }
        return applicationContext;
    }
}

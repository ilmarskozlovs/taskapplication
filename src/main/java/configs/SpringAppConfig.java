package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"businesslogic.impl","businesslogic.database", "businesslogic.userinterface"})
public class SpringAppConfig {






}

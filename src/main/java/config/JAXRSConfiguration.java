package config;


import controller.IncomeExpenseController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/rs")
public class JAXRSConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(CORSConfig.class);
        resources.add(IncomeExpenseController.class);
        return resources;
    }
}


package data.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("/data")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 2.0 JSON provider:
        try {
            Class jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
            // Class jsonProvider = Class.forName("org.glassfish.jersey.moxy.json.MoxyJsonFeature");
            // Class jsonProvider = Class.forName("org.glassfish.jersey.jettison.JettisonFeature");
            resources.add(jsonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(data.ws.AccountFacadeREST.class);
        resources.add(data.ws.AddressFacadeREST.class);
        resources.add(data.ws.ContractFacadeREST.class);
        resources.add(data.ws.EmailFacadeREST.class);
        resources.add(data.ws.EmployeeFacadeREST.class);
        resources.add(data.ws.EnterpriseFacadeREST.class);
        resources.add(data.ws.ManagerFacadeREST.class);
        resources.add(data.ws.ProjectFacadeREST.class);
    }
}

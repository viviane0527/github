package data.persistence.logs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@LogLifeCycleMethod 
@Interceptor
public class LogLifeCycleMethodInterceptor implements java.io.Serializable {

    //protected Logger logger = Logger.getLogger("aixmdb.beans");
    
    @PostConstruct
    public void doAfterConstruct(InvocationContext ctx) {
        System.out.println("DAO " + ctx.getTarget().getClass().getName() + " has been created");
    }
    
    @PreDestroy
    public void doBeforeDestroy(InvocationContext ctx) {
        System.out.println("DAO " + ctx.getTarget().toString() + " will be removed");
    }
    
}

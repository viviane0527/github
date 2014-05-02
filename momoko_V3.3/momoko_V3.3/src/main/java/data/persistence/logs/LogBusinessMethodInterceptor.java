package data.persistence.logs;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@LogBusinessMethod 
@Interceptor
public class LogBusinessMethodInterceptor implements java.io.Serializable {

    //protected Logger logger = Logger.getLogger("aixmdb.beans");

    @AroundInvoke
    public Object doOnBusinessMethod(InvocationContext ctx) throws Exception {
        //logger.entering(ctx.getTarget().getClass().getName(), ctx.getMethod().getName());
        long startTime = System.currentTimeMillis();
        if (ctx.getMethod().getName().startsWith("doTest"))
            System.err.println("Run TEST: " + ctx.getTarget().getClass().getName() + "." + ctx.getMethod().getName());
        else
            System.out.println("Entering " + ctx.getTarget().getClass().getName() + "." + ctx.getMethod().getName());
        try {
            return ctx.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Exiting " + ctx.getTarget().getClass().getName() + "." + ctx.getMethod().getName());
            System.err.println("time: " + (endTime - startTime) + "ms\n");
            //logger.exiting(ctx.getTarget().toString(), ctx.getMethod().getName()); 
        }
    }
}

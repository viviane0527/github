
package data.ws.tools;

import com.thales.momoko.querybuilder.QueryBuilder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class QueryExecutor {
    
    public static List getResultList(QueryBuilder qb, EntityManager em) {
        return em.createQuery(qb.evaluate())
                 .setFirstResult(qb.getOffset())
                 .setMaxResults(qb.getOffset() + qb.getPageSize())
                 .getResultList();
    }

    public static Object getSingleResult(QueryBuilder qb, EntityManager em) {
        return em.createQuery(qb.evaluate()).getSingleResult();
    }

    public static Query getQuery(QueryBuilder qb, EntityManager em) {
        return em.createQuery(qb.evaluate());
    }
}

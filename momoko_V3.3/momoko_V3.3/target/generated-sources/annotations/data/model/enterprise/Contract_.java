package data.model.enterprise;

import data.model.abstracts.AbstractObject_;
import data.model.enterprise.Employee;
import data.model.enterprise.Enterprise;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T15:48:36")
@StaticMetamodel(Contract.class)
public class Contract_ extends AbstractObject_ {

    public static volatile SingularAttribute<Contract, Enterprise> employer;
    public static volatile SingularAttribute<Contract, Integer> salary;
    public static volatile SingularAttribute<Contract, Employee> employees;
    public static volatile SingularAttribute<Contract, Date> startAt;

}
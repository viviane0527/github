package data.model.enterprise;

import data.model.data.enterprise.datatypes.EmployeeTypes;
import data.model.enterprise.Account;
import data.model.enterprise.Contract;
import data.model.enterprise.Manager;
import data.model.enterprise.Project;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T15:48:36")
@StaticMetamodel(Employee.class)
public class Employee_ extends Person_ {

    public static volatile SingularAttribute<Employee, Manager> manager;
    public static volatile ListAttribute<Employee, Contract> employer;
    public static volatile SingularAttribute<Employee, Project> project;
    public static volatile SingularAttribute<Employee, String> language;
    public static volatile SingularAttribute<Employee, Integer> salary;
    public static volatile SingularAttribute<Employee, EmployeeTypes> type;
    public static volatile SingularAttribute<Employee, Account> account;
    public static volatile SingularAttribute<Employee, Date> createAt;
    public static volatile SingularAttribute<Employee, byte[]> picture;
    public static volatile SingularAttribute<Employee, String> diplome;

}
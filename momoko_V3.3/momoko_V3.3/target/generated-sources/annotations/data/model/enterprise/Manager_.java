package data.model.enterprise;

import data.model.enterprise.Employee;
import data.model.enterprise.Project;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T15:48:36")
@StaticMetamodel(Manager.class)
public class Manager_ extends Employee_ {

    public static volatile ListAttribute<Manager, Project> projects;
    public static volatile ListAttribute<Manager, Employee> teams;

}
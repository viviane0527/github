package data.model.enterprise;

import data.model.abstracts.AbstractFeature_;
import data.model.enterprise.Employee;
import data.model.enterprise.Manager;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T13:33:02")
@StaticMetamodel(Project.class)
public class Project_ extends AbstractFeature_ {

    public static volatile ListAttribute<Project, Employee> members;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile SingularAttribute<Project, Manager> lead;

}
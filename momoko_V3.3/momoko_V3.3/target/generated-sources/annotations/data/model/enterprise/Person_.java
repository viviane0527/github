package data.model.enterprise;

import data.model.abstracts.AbstractFeature_;
import data.model.enterprise.Address;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T15:48:36")
@StaticMetamodel(Person.class)
public abstract class Person_ extends AbstractFeature_ {

    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Address> address;
    public static volatile SingularAttribute<Person, Date> birthDate;

}
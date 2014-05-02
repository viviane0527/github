package data.model.enterprise;

import data.model.abstracts.AbstractFeature_;
import data.model.enterprise.Email;
import data.model.enterprise.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T15:48:36")
@StaticMetamodel(Account.class)
public class Account_ extends AbstractFeature_ {

    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> checkNewEmailEvery;
    public static volatile SingularAttribute<Account, String> removedJunkMailAfter;
    public static volatile SingularAttribute<Account, String> language;
    public static volatile SingularAttribute<Account, Employee> employee;
    public static volatile SingularAttribute<Account, String> login;
    public static volatile SingularAttribute<Account, Email> email;

}
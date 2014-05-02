package data.model.enterprise;

import data.model.abstracts.AbstractObject_;
import data.model.data.enterprise.datatypes.EmailType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T15:48:36")
@StaticMetamodel(Email.class)
public class Email_ extends AbstractObject_ {

    public static volatile SingularAttribute<Email, String> password;
    public static volatile SingularAttribute<Email, EmailType> email;

}
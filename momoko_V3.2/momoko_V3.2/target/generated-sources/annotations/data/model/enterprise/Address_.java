package data.model.enterprise;

import data.model.abstracts.AbstractObject_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T13:33:02")
@StaticMetamodel(Address.class)
public class Address_ extends AbstractObject_ {

    public static volatile SingularAttribute<Address, String> country;
    public static volatile SingularAttribute<Address, String> zipCode;
    public static volatile SingularAttribute<Address, String> streetName;
    public static volatile SingularAttribute<Address, String> city;

}
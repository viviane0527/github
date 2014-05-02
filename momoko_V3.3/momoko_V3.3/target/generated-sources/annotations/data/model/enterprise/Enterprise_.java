package data.model.enterprise;

import data.model.abstracts.AbstractFeature_;
import data.model.enterprise.AddressPart;
import data.model.enterprise.Contract;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-20T15:48:36")
@StaticMetamodel(Enterprise.class)
public class Enterprise_ extends AbstractFeature_ {

    public static volatile SingularAttribute<Enterprise, String> name;
    public static volatile SingularAttribute<Enterprise, byte[]> logo;
    public static volatile SingularAttribute<Enterprise, AddressPart> headQuater;
    public static volatile ListAttribute<Enterprise, Contract> employees;

}
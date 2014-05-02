package data.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import javax.inject.Qualifier;

/**
 * This annotation is used to differenciate DAO from other patterns such as
 * Repository (there is also an annotation for that one)
 * DAO traditionnaly doesn't deal with agregate root and are more a single
 * entity concept
 * @author TANG Lei & KONG Hefang
 */
@Qualifier
@Target({
    ElementType.TYPE,
    ElementType.METHOD,
    ElementType.FIELD,
    ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Facade {
	FeatureType value();
}

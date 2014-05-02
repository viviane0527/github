package data.persistence.hubs;

import data.persistence.EmailFacade;
import data.model.enterprise.Email;
import data.annotations.Facade;
import data.annotations.FeatureType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmailHubFacade implements Serializable {

	@Inject 
	private EmailFacade emailFacade;

    public Email create(Email email) {
        return emailFacade.create(email);
    }

    public Email edit(Email email) {
        return emailFacade.edit(email);
    }

    public void remove(Email email) {
        emailFacade.remove(email);
    }

    public Email find(Object id) {
        return emailFacade.find(id);
    }

    public int count(Map<String, String> condition) {
        return emailFacade.count(condition);
    }

    public List<Email> searchRange(int[] range,
            List<String> projection,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return emailFacade.searchRange(range, condition, orderBy);
    }

}

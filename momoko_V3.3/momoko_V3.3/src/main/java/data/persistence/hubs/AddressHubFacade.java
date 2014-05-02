package data.persistence.hubs;

import data.persistence.AddressFacade;
import data.model.enterprise.Address;
import data.annotations.Facade;
import data.annotations.FeatureType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AddressHubFacade implements Serializable {

	@Inject 
	private AddressFacade addressFacade;

    public Address create(Address address) {
        return addressFacade.create(address);
    }

    public Address edit(Address address) {
        return addressFacade.edit(address);
    }

    public void remove(Address address) {
        addressFacade.remove(address);
    }

    public Address find(Object id) {
        return addressFacade.find(id);
    }

    public int count(Map<String, String> condition) {
        return addressFacade.count(condition);
    }

    public List<Address> searchRange(int[] range,
            List<String> projection,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return addressFacade.searchRange(range, condition, orderBy);
    }

}

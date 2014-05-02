package data.persistence.hubs;

import data.persistence.ManagerFacade;
import data.model.enterprise.Manager;
import data.annotations.Facade;
import data.annotations.FeatureType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ManagerHubFacade implements Serializable {

	@Inject @Facade(FeatureType.Manager)
	private ManagerFacade managerFacade;

    public Manager create(Manager manager) {
        return managerFacade.create(manager);
    }

    public Manager edit(Manager manager) {
        return managerFacade.edit(manager);
    }

    public void remove(Manager manager) {
        managerFacade.remove(manager);
    }

    public Manager find(Object id) {
        return managerFacade.find(id);
    }

    public int count(Map<String, String> condition) {
        return managerFacade.count(condition);
    }

    public List<Manager> searchRange(int[] range,
            List<String> projection,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return managerFacade.searchRange(range, condition, orderBy);
    }

}

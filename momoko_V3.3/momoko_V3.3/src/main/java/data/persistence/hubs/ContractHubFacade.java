package data.persistence.hubs;

import data.persistence.ContractFacade;
import data.model.enterprise.Contract;
import data.annotations.Facade;
import data.annotations.FeatureType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ContractHubFacade implements Serializable {

	@Inject 
	private ContractFacade contractFacade;

    public Contract create(Contract contract) {
        return contractFacade.create(contract);
    }

    public Contract edit(Contract contract) {
        return contractFacade.edit(contract);
    }

    public void remove(Contract contract) {
        contractFacade.remove(contract);
    }

    public Contract find(Object id) {
        return contractFacade.find(id);
    }

    public int count(Map<String, String> condition) {
        return contractFacade.count(condition);
    }

    public List<Contract> searchRange(int[] range,
            List<String> projection,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return contractFacade.searchRange(range, condition, orderBy);
    }

}

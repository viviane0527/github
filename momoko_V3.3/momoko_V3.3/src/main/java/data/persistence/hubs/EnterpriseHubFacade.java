package data.persistence.hubs;

import data.persistence.EnterpriseFacade;
import data.persistence.ContractFacade;
import data.model.enterprise.Enterprise;
import data.model.enterprise.Contract;
import data.annotations.Facade;
import data.annotations.FeatureType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EnterpriseHubFacade implements Serializable {

	@Inject @Facade(FeatureType.Enterprise)
	private EnterpriseFacade enterpriseFacade;
	@Inject 
	private ContractFacade contractFacade;

    public Enterprise create(Enterprise enterprise) {
        return enterpriseFacade.create(enterprise);
    }

    public Enterprise edit(Enterprise enterprise) {
        return enterpriseFacade.edit(enterprise);
    }

    public void remove(Enterprise enterprise) {
        enterpriseFacade.remove(enterprise);
    }

    public Enterprise find(Object id) {
        return enterpriseFacade.find(id);
    }

    public int count(Map<String, String> condition) {
        return enterpriseFacade.count(condition);
    }

    public List<Enterprise> searchRange(int[] range,
            List<String> projection,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return enterpriseFacade.searchRange(range, condition, orderBy);
    }

    public List<Contract> searchEnterpriseContractsRange(int[] range,
            Long id,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return contractFacade.searchRangeBySupLevel(range, new String[]{id.toString()}, "enterprise", "id", condition, orderBy);
    }

    public Long countEnterpriseContracts(Long id,
            Map<String, Object> condition) {
        return contractFacade.countBySupLevel(new String[]{id.toString()}, "enterprise", "id", condition);
    }
}

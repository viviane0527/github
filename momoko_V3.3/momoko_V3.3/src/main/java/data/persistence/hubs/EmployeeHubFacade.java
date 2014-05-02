package data.persistence.hubs;

import data.persistence.EmployeeFacade;
import data.persistence.ContractFacade;
import data.model.enterprise.Employee;
import data.model.enterprise.Contract;
import data.annotations.Facade;
import data.annotations.FeatureType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmployeeHubFacade implements Serializable {

	@Inject @Facade(FeatureType.Employee)
	private EmployeeFacade employeeFacade;
	@Inject 
	private ContractFacade contractFacade;

    public Employee create(Employee employee) {
        return employeeFacade.create(employee);
    }

    public Employee edit(Employee employee) {
        return employeeFacade.edit(employee);
    }

    public void remove(Employee employee) {
        employeeFacade.remove(employee);
    }

    public Employee find(Object id) {
        return employeeFacade.find(id);
    }

    public int count(Map<String, String> condition) {
        return employeeFacade.count(condition);
    }

    public List<Employee> searchRange(int[] range,
            List<String> projection,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return employeeFacade.searchRange(range, condition, orderBy);
    }

    public List<Contract> searchEmployeeContractsRange(int[] range,
            Long id,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return contractFacade.searchRangeBySupLevel(range, new String[]{id.toString()}, "employee", "id", condition, orderBy);
    }

    public Long countEmployeeContracts(Long id,
            Map<String, Object> condition) {
        return contractFacade.countBySupLevel(new String[]{id.toString()}, "employee", "id", condition);
    }
}

package data.presentation.util.lazymodels;

import data.model.enterprise.Employee;
import java.util.Map;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import data.annotations.Facade;
import data.annotations.FeatureType;
import data.model.enterprise.Employee;
import data.persistence.EmployeeFacade;
import data.persistence.logs.LogBusinessMethodInterceptor;
import data.persistence.logs.LogLifeCycleMethodInterceptor;


public class LazyEmployeeDataModel extends LazyDataModel<Employee> {

    private EmployeeFacade ejbFacade;

	private EmployeeFacade getFacade() {
    	return ejbFacade;
	}

	public void setFacade(EmployeeFacade ejbFacade) {
    	this.ejbFacade = ejbFacade;
	}

	@Override
    public List<Employee> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
    	int dataSize =  getFacade().count(filters);  
        this.setRowCount(dataSize); 
        return getFacade().load(first, pageSize, sortField,sortOrder,filters);
	}
}

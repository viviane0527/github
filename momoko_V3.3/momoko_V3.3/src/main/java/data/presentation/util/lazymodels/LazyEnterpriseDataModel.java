package data.presentation.util.lazymodels;

import data.model.enterprise.Enterprise;
import java.util.Map;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import data.annotations.Facade;
import data.annotations.FeatureType;
import data.model.enterprise.Enterprise;
import data.persistence.EnterpriseFacade;
import data.persistence.logs.LogBusinessMethodInterceptor;
import data.persistence.logs.LogLifeCycleMethodInterceptor;


public class LazyEnterpriseDataModel extends LazyDataModel<Enterprise> {

    private EnterpriseFacade ejbFacade;

	private EnterpriseFacade getFacade() {
    	return ejbFacade;
	}

	public void setFacade(EnterpriseFacade ejbFacade) {
    	this.ejbFacade = ejbFacade;
	}

	@Override
    public List<Enterprise> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
    	int dataSize =  getFacade().count(filters);  
        this.setRowCount(dataSize); 
        return getFacade().load(first, pageSize, sortField,sortOrder,filters);
	}
}

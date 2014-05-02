package data.presentation.util.lazymodels;

import data.model.enterprise.Project;
import java.util.Map;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import data.annotations.Facade;
import data.annotations.FeatureType;
import data.model.enterprise.Project;
import data.persistence.ProjectFacade;
import data.persistence.logs.LogBusinessMethodInterceptor;
import data.persistence.logs.LogLifeCycleMethodInterceptor;


public class LazyProjectDataModel extends LazyDataModel<Project> {

    private ProjectFacade ejbFacade;

	private ProjectFacade getFacade() {
    	return ejbFacade;
	}

	public void setFacade(ProjectFacade ejbFacade) {
    	this.ejbFacade = ejbFacade;
	}

	@Override
    public List<Project> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
    	int dataSize =  getFacade().count(filters);  
        this.setRowCount(dataSize); 
        return getFacade().load(first, pageSize, sortField,sortOrder,filters);
	}
}

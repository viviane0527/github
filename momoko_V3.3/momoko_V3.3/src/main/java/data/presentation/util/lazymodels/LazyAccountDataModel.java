package data.presentation.util.lazymodels;

import data.model.enterprise.Account;
import java.util.Map;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import data.annotations.Facade;
import data.annotations.FeatureType;
import data.model.enterprise.Account;
import data.persistence.AccountFacade;
import data.persistence.logs.LogBusinessMethodInterceptor;
import data.persistence.logs.LogLifeCycleMethodInterceptor;
import javax.faces.bean.ViewScoped;


public class LazyAccountDataModel extends LazyDataModel<Account> {

    private AccountFacade ejbFacade;

	public AccountFacade getFacade() {
    	return ejbFacade;
	}

	public void setFacade(AccountFacade ejbFacade) {
    	this.ejbFacade = ejbFacade;
	}

	@Override
    public List<Account> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
    	int dataSize =  getFacade().count(filters);  
        this.setRowCount(dataSize); 
        return getFacade().load(first, pageSize, sortField,sortOrder,filters);
	}
}

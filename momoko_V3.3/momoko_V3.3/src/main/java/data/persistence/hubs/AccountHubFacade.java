package data.persistence.hubs;

import data.persistence.AccountFacade;
import data.model.enterprise.Account;
import data.annotations.Facade;
import data.annotations.FeatureType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AccountHubFacade implements Serializable {

	@Inject @Facade(FeatureType.Account)
	private AccountFacade accountFacade;

    public Account create(Account account) {
        return accountFacade.create(account);
    }

    public Account edit(Account account) {
        return accountFacade.edit(account);
    }

    public void remove(Account account) {
        accountFacade.remove(account);
    }

    public Account find(Object id) {
        return accountFacade.find(id);
    }

    public int count(Map<String, String> condition) {
        return accountFacade.count(condition);
    }

    public List<Account> searchRange(int[] range,
            List<String> projection,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return accountFacade.searchRange(range, condition, orderBy);
    }

}

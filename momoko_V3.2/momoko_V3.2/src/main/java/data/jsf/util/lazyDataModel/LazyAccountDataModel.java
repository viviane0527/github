/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.jsf.util.lazyDataModel;

import data.jsf.AccountController;
import data.model.enterprise.Account;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SelectableDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Viviane
 */
public class LazyAccountDataModel extends LazyDataModel<Account> implements SelectableDataModel<Account> {  
      
       private List<Account> datasource;
private int pageSize;
    private int rowIndex;
    private int rowCount;
    private AccountController crudService;

    public LazyAccountDataModel(AccountController crudService) {
        this.crudService = crudService;
    }
	public LazyAccountDataModel(List<Account> datasource) {
    	this.datasource = datasource;
	} 
      
       @Override
   public Account getRowData(String rowKey) {
       List<Account> accounts = (List<Account>) getWrappedData();
       for(Account account : accounts){
           if(account.getLogin().equals(rowKey))
               return account;
       }
       return null;
   }
   
       @Override
   public Object getRowKey(Account account){
       return account.getLogin();
   }

    @Override  
    public List<Account> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {  
        List<Account> data = new ArrayList<>();  

        //filter  
        for(Account account : datasource) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    String filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(account.getClass().getField(filterProperty).get(account));  
  
                    if(filterValue == null || fieldValue.startsWith(filterValue)) {  
                        match = true;  
                    }  
                    else {  
                        match = false;  
                        break;  
                    }  
                } catch(IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {  
                    match = false;  
                }   
            }  
  
            if(match) {  
                data.add(account);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new LazySorter(sortField, sortOrder));  
        }  
  
        //rowCount  
        int dataSize = data.size();  
        this.setRowCount(dataSize);  
  
        //paginate  
        if(dataSize > pageSize) {  
            try {  
                return data.subList(first, first + pageSize);  
            }  
            catch(IndexOutOfBoundsException e) {  
                return data.subList(first, first + (dataSize % pageSize));  
            }  
        }  
        else {  
            return data;  
        }  
    }  
    

} 

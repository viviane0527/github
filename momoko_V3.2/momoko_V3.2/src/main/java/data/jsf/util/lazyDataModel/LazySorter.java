/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.jsf.util.lazyDataModel;

import data.model.enterprise.Account;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Viviane
 */
public class LazySorter implements Comparator<Account>{

    private String sortField;
    
    private SortOrder sortOrder;
    
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(Account account1, Account account2) {
        try {
            Object value1 = Account.class.getField(this.sortField).get(account1);
            Object value2 = Account.class.getField(this.sortField).get(account2);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}

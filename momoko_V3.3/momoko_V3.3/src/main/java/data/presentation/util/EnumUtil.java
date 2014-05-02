package data.presentation.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.faces.model.SelectItem;
import data.model.data.enterprise.datatypes.EmailType;
import data.model.data.enterprise.datatypes.EmployeeTypes;

/**
 * This class is used to diplayed the combobox elements.
 */
@Named("enumUtil")
@ApplicationScoped
public class EnumUtil {
    public SelectItem[] getEmailTypeValues() {
	    SelectItem[] items = new SelectItem[EmailType.values().length];
	    int i = 0;
	    for(EmailType val: EmailType.values()) {
	    	items[i++] = new SelectItem(val, val.name());
	    }
	    return items;
  	}

    public SelectItem[] getEmployeeTypesValues() {
	    SelectItem[] items = new SelectItem[EmployeeTypes.values().length];
	    int i = 0;
	    for(EmployeeTypes val: EmployeeTypes.values()) {
	    	items[i++] = new SelectItem(val, val.name());
	    }
	    return items;
  	}

}


package data.ws.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

	/**
	* @author Christophe de Batz - christophe@debatz.fr
	* @return list of strings
	*/
    public static List<String> stringToList(String text, String separator) {
        if (text == null || text.isEmpty()) {
            return null;
        }

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(text.split(separator)));
        return list;
    }

	/**
	* @author Christophe de Batz - christophe@debatz.fr
	* @return map of string
	*/
    public static Map<String, Object> stringToMap(String text, String separator) {
        if (text == null || text.isEmpty()) {
            return null;
        }

        text = text.replaceAll("\\[", "").replaceAll("\\]", "");

        Map<String, Object> map = new HashMap<>();
        String[] array = text.split(separator);
        for (String couple : array) {
            String[] subArray = couple.split("=");
            map.put(subArray[0], subArray[1]);
        }
        return map;
    }

	    
    public static String getTableAlias (Class entityClass, int size) {
        return entityClass.getSimpleName().substring(0, size).toLowerCase();
    }
}

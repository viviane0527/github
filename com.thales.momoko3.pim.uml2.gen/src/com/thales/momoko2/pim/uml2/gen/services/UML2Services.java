package com.thales.momoko2.pim.uml2.gen.services;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;



public class UML2Services {

	/****************************************************************************
	 * STERETOTYPE OPERATIONS
	 ****************************************************************************/
	/**
	 * get stereotypes'class
	 * 
	 * @param element
	 * @param stereotypeName
	 * @return
	 */
	public static Stereotype getStereotype(Element element,
			String stereotypeName) {
		EList<Stereotype> stereotypes = element.getAppliedStereotypes();
		for (Iterator<Stereotype> i = stereotypes.iterator(); i.hasNext();) {
			Stereotype stereotype = (Stereotype) i.next();
			if (stereotype.getName().equals(stereotypeName)) {
				return stereotype;
			}
		}
		return null;
	}

	/**
	 * check if a class has a specified stereotype
	 * 
	 * @param element
	 * @param stereotypeName
	 * @return
	 */
	public static boolean hasStereotype(Element element, String stereotypeName) {
		Stereotype stereotype = getStereotype(element, stereotypeName);
		return (stereotype != null);
	}
	
	/****************************************************************************
	 * Text processing
	 ****************************************************************************/
	/**
	 * get the table and the column names 
	 * @param s
	 * @return
	 */
	public static String getTableAndColumnName(String s) {
		//	 replace the capital characters to tiny and add '_' 
		int i=0;
		while (i<s.length()) {
	         if (s.charAt(i)>='A' && s.charAt(i)<='Z'){
	        	 if (i>1 && (s.charAt(i-1)<'A' || s.charAt(i-1)>'Z') && s.charAt(i-1)!='_'){
	        	 s= s.substring(0, i).concat("_").concat(s.substring(i, s.length()));
	        	 i++;
	        	 }
	         }
	         i++;
		}
		//	take only the 30 first characters
		if (s.length()>30)	s=s.substring(0, 30);
		return (s.toUpperCase());
	}


	/**
	 * replace the capital characters by tiny and add ' '
	 * 
	 * @param s
	 * @return
	 */
	public static String getNameToDisplay(String s) {
		int i = 0;
		int j = 0;
		String result = "";

		while (i < s.length()) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				if (i > 1 && (s.charAt(i - 1) < 'A' || s.charAt(i - 1) > 'Z')
						&& s.charAt(i - 1) != '_') {
					result = result.concat(s.substring(j, i)).concat(" ");
					j = i;
				}
			}
			if (i == s.length() - 1)
				result = result.concat(s.substring(j, i + 1));
			i++;
		}
		if (result.length() > 1)
			return (result.substring(0, 1).toUpperCase()).concat(result
					.substring(1, result.length()));
		else if (result.length() == 1)
			return result.toUpperCase();
		else if (s.length()>0)
			return (s.substring(0, 1).toUpperCase()).concat(s.substring(1,
					s.length()));
		else
			return "";
	}

}
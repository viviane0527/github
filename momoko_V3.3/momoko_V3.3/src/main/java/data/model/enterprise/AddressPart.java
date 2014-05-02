package data.model.enterprise;

/*
Name : 			AddressPart.java
Comments : 		This part class is created from Address.java which is Object Class containing the associations of composition and aggregation
Stereotype : 	object
*/
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;
import javax.persistence.*;
import javax.validation.constraints.*;	
import data.model.abstracts.AbstractObject;

import java.io.Serializable;


@Embeddable
@XmlRootElement(name="address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressPart extends AbstractObject implements Serializable {	
    
    
    @Column (name="CITY")
    @Basic(fetch=FetchType.EAGER, optional = false)
    @Pattern (regexp="([A-Z]|[a-z]|[0-9])*")
    @Size (min=0, max=56)
    @XmlElement
    private String city;
    
    
    
    @Column (name="COUNTRY")
    @Basic(fetch=FetchType.EAGER, optional = false)
    @Pattern (regexp="([A-Z]|[a-z]|[0-9])*")
    @Size (min=0, max=56)
    @XmlElement
    private String country;
    
    
    
    @Column (name="STREET_NAME")
    @Basic(fetch=FetchType.EAGER, optional = false)
    @Pattern (regexp="([A-Z]|[a-z]|[0-9])*")
    @Size (min=0, max=56)
    @XmlElement
    private String streetName;
    
    
    
    @Column (name="ZIP_CODE")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @XmlElement
    private String zipCode;
    
    
    
    /****************************************************************
    Constructors
    ****************************************************************/
    /**
     * Default constructor 
    */
    public AddressPart(){
    	super();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public AddressPart(AddressPart element) {	
    	super(element);
        if (element != null) {
    		this.city= element.getCity();
    		this.country= element.getCountry();
    		this.streetName= element.getStreetName();
    		this.zipCode= element.getZipCode();
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    /**
     * @return the city
     */
    public String getCity (){
    	return this.city;
    }		
    /**
     * @param city the city to set
     */
    public void setCity (String city){
    	this.city=city;
    }
        
    /**
     * @return the country
     */
    public String getCountry (){
    	return this.country;
    }		
    /**
     * @param country the country to set
     */
    public void setCountry (String country){
    	this.country=country;
    }
        
    /**
     * @return the streetName
     */
    public String getStreetName (){
    	return this.streetName;
    }		
    /**
     * @param streetName the streetName to set
     */
    public void setStreetName (String streetName){
    	this.streetName=streetName;
    }
        
    /**
     * @return the zipCode
     */
    public String getZipCode (){
    	return this.zipCode;
    }		
    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode (String zipCode){
    	this.zipCode=zipCode;
    }
        
    
}	

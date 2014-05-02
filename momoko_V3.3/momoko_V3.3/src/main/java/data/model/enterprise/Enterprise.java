package data.model.enterprise;

/*
Name : 			Enterprise.java
Comments : 		
Stereotype : 	feature
Qualified Name: Data::Enterprise::Enterprise
*/
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;	
import data.model.abstracts.AbstractFeature;

import java.io.Serializable;

@Entity
@Table (name= "ENTERPRISE_F" ,schema="enterprise")

@XmlRootElement(name="enterprise")
@XmlAccessorType(XmlAccessType.FIELD)
public class Enterprise extends AbstractFeature implements Serializable {	
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="ENTERPRISE_JT")
    
    @XmlElementWrapper(name="employees")
    @XmlElement(name="employee")
    private List<Contract> employees;
    
    
    
    
    @Embedded
    
    @XmlElement
    private AddressPart headQuater;
    
    
    
    
    
    @Column (name="LOGO")
    @Basic(fetch=FetchType.LAZY, optional = true)
    @Lob
    @XmlElement
    private byte[] logo;
    
    
    
    @Column (name="NAME")
    @Basic(fetch=FetchType.EAGER, optional = false)
    @Pattern (regexp="([A-Z]|[a-z]|[0-9])*")
    @Size (min=0, max=56)
    @XmlElement
    private String name;
    
    
    
    /****************************************************************
    Constructors
    ****************************************************************/
    /**
     * Default constructor 
    */
    public Enterprise(){
    	super();
    	this.employees = new ArrayList<Contract>();
        this.headQuater = new AddressPart();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public Enterprise(Enterprise element) {	
    	super(element);
        if (element != null) {
    		this.employees = new ArrayList<Contract>();
    		for (Contract c : element.getEmployees()) {
    			this.employees.add(new Contract(c));
    		}
    		
    		this.headQuater= (element.getHeadQuater() !=null)? new AddressPart(element.getHeadQuater()) : null;
    		
    		this.logo= element.getLogo();
    		this.name= element.getName();
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    /**
     * @return the employees
     */
    public List<Contract> getEmployees (){
    	return this.employees;
    }		
    /**
     * @param employees the employees to set
     */
    public void setEmployees (List<Contract> employees){
    	this.employees=employees;
    }
        
    /**
     * @return the headQuater
     */
    public AddressPart getHeadQuater (){
    	return this.headQuater;
    }		
    /**
     * @param headQuater the headQuater to set
     */
    public void setHeadQuater (AddressPart headQuater){
    	this.headQuater=headQuater;
    }
        
    /**
     * @return the logo
     */
    public byte[] getLogo (){
    	return this.logo;
    }		
    /**
     * @param logo the logo to set
     */
    public void setLogo (byte[] logo){
    	this.logo=logo;
    }
        
    /**
     * @return the name
     */
    public String getName (){
    	return this.name;
    }		
    /**
     * @param name the name to set
     */
    public void setName (String name){
    	this.name=name;
    }
        
    
}	

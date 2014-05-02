package data.model.enterprise;

/*
Name : 			Person.java
Comments : 		
Stereotype : 	feature
Qualified Name: Data::Enterprise::Person
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

@MappedSuperclass

public abstract class Person extends AbstractFeature implements Serializable {	
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ADDRESS_O_ID")
    
    @XmlElement
    private Address address;
    
    
    
    
    
    @Column (name="BIRTH_DATE")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @Temporal (TemporalType.DATE)
    @Future
    @XmlElement
    private Date birthDate;
    
    
    
    @Column (name="FIRST_NAME")
    @Basic(fetch=FetchType.EAGER, optional = false)
    @Pattern (regexp="([A-Z]|[a-z]|[0-9])*")
    @Size (min=0, max=56)
    @XmlElement
    private String firstName;
    
    
    
    @Column (name="LAST_NAME")
    @Basic(fetch=FetchType.EAGER, optional = false)
    @Pattern (regexp="([A-Z]|[a-z]|[0-9])*")
    @Size (min=0, max=56)
    @XmlElement
    private String lastName;
    
    
    
    /****************************************************************
    Constructors
    ****************************************************************/
    /**
     * Default constructor 
    */
    public Person(){
    	super();
        this.address = new Address();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public Person(Person element) {	
    	super(element);
        if (element != null) {
    		this.address= (element.getAddress() !=null)? new Address(element.getAddress()) : null;
    		
    		this.birthDate= element.getBirthDate();
    		this.firstName= element.getFirstName();
    		this.lastName= element.getLastName();
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    /**
     * @return the address
     */
    public Address getAddress (){
    	return this.address;
    }		
    /**
     * @param address the address to set
     */
    public void setAddress (Address address){
    	this.address=address;
    }
        
    /**
     * @return the birthDate
     */
    public Date getBirthDate (){
    	return this.birthDate;
    }		
    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate (Date birthDate){
    	this.birthDate=birthDate;
    }
        
    /**
     * @return the firstName
     */
    public String getFirstName (){
    	return this.firstName;
    }		
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName (String firstName){
    	this.firstName=firstName;
    }
        
    /**
     * @return the lastName
     */
    public String getLastName (){
    	return this.lastName;
    }		
    /**
     * @param lastName the lastName to set
     */
    public void setLastName (String lastName){
    	this.lastName=lastName;
    }
        
    
}	

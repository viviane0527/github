package data.model.enterprise;

/*
Name : 			Email.java
Comments : 		
Stereotype : 	object
Qualified Name: Data::Enterprise::Email
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
import data.model.data.enterprise.datatypes.EmailType;

import java.io.Serializable;

@Entity
@Table (name="EMAIL_O"  ,schema="enterprise")

@XmlRootElement(name="email")
@XmlAccessorType(XmlAccessType.FIELD)
public class Email extends AbstractObject implements Serializable {	
    
    
    @Column (name="EMAIL")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @Enumerated(EnumType.ORDINAL)
    @XmlElement
    private EmailType email;
    
    
    
    @Column (name="PASSWORD")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @Pattern (regexp="[a-z]")
    @Size (min=20, max=60)
    @XmlElement
    private String password;
    
    
    
    /****************************************************************
    Constructors
    ****************************************************************/
    /**
     * Default constructor 
    */
    public Email(){
    	super();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public Email(Email element) {	
    	super(element);
        if (element != null) {
    		this.email= element.getEmail();
    		this.password= element.getPassword();
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    /**
     * @return the email
     */
    public EmailType getEmail (){
    	return this.email;
    }		
    /**
     * @param email the email to set
     */
    public void setEmail (EmailType email){
    	this.email=email;
    }
        
    /**
     * @return the password
     */
    public String getPassword (){
    	return this.password;
    }		
    /**
     * @param password the password to set
     */
    public void setPassword (String password){
    	this.password=password;
    }
        
    
}	

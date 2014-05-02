package data.model.enterprise;

/*
Name : 			Account.java
Comments : 		
Stereotype : 	feature
Qualified Name: Data::Enterprise::Account
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
import data.model.abstracts.AbstractFeature;

import java.io.Serializable;

@Entity
@Table (name= "ACCOUNT_F" ,schema="enterprise")
@SecondaryTable(name="PREF")
@XmlRootElement(name="account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account extends AbstractFeature implements Serializable {	
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMAIL_O_ID")
    
    @XmlElement
    private Email email;
    
    
    
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLOYEE_F_ID")
    
    @XmlInverseReference(mappedBy="account")
    @XmlElement(name="employee", type=Employee.class)
    private Employee employee;
    
    
    
    
    
    @Column (name="LOGIN")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @XmlElement
    private String login;
    
    
    
    @Column (name="PASSWORD")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @Pattern (regexp="([a-z]|[0-9])*")
    @Size (min=5, max=60)
    @XmlElement
    private String password;
    
    
    
    @Column (table="PREF")
    @Basic(fetch=FetchType.EAGER, optional = false)
    @Pattern (regexp="([A-Z]|[a-z]|[0-9])*")
    @Size (min=0, max=56)
    @XmlElement
    private String checkNewEmailEvery;
    @Column (table="PREF")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @XmlElement
    private String language;
    @Column (table="PREF")
    @Basic(fetch=FetchType.EAGER, optional = false)
    @Pattern (regexp="([A-Z]|[a-z]|[0-9])*")
    @Size (min=0, max=56)
    @XmlElement
    private String removedJunkMailAfter;
    
    
    
    /****************************************************************
    Constructors
    ****************************************************************/
    /**
     * Default constructor 
    */
    public Account(){
    	super();
        this.email = new Email();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public Account(Account element) {	
    	super(element);
        if (element != null) {
    		this.email= (element.getEmail() !=null)? new Email(element.getEmail()) : null;
    		
    		
    		this.login= element.getLogin();
    		this.password= element.getPassword();
    		
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    /**
     * @return the email
     */
    public Email getEmail (){
    	return this.email;
    }		
    /**
     * @param email the email to set
     */
    public void setEmail (Email email){
    	this.email=email;
    }
        
    /**
     * @return the employee
     */
    public Employee getEmployee (){
    	return this.employee;
    }		
    /**
     * @param employee the employee to set
     */
    public void setEmployee (Employee employee){
    	this.employee=employee;
    }
        
    /**
     * @return the login
     */
    public String getLogin (){
    	return this.login;
    }		
    /**
     * @param login the login to set
     */
    public void setLogin (String login){
    	this.login=login;
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
        
        
    /**
     * @return the checkNewEmailEvery
     */
    public String getCheckNewEmailEvery (){
    	return this.checkNewEmailEvery;
    }		
    /**
     * @param checkNewEmailEvery the checkNewEmailEvery to set
     */
    public void setCheckNewEmailEvery (String checkNewEmailEvery){
    	this.checkNewEmailEvery=checkNewEmailEvery;
    }
    /**
     * @return the language
     */
    public String getLanguage (){
    	return this.language;
    }		
    /**
     * @param language the language to set
     */
    public void setLanguage (String language){
    	this.language=language;
    }
    /**
     * @return the removedJunkMailAfter
     */
    public String getRemovedJunkMailAfter (){
    	return this.removedJunkMailAfter;
    }		
    /**
     * @param removedJunkMailAfter the removedJunkMailAfter to set
     */
    public void setRemovedJunkMailAfter (String removedJunkMailAfter){
    	this.removedJunkMailAfter=removedJunkMailAfter;
    }
    
}	

package data.model.enterprise;

/*
Name : 			Contract.java
Comments : 		
Stereotype : 	object
Qualified Name: Data::Enterprise::Contract
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
import data.model.abstracts.AbstractObject;

import java.io.Serializable;

@Entity
@Table (name="CONTRACT_AC"  ,schema="enterprise")

@XmlRootElement(name="contract")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contract extends AbstractObject implements Serializable {	
    
    
    @Column (name="SALARY")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @Max(value=5000) 
    @Min(value=2000)
    @XmlElement
    private int salary;
    
    
    
    @Column (name="START_AT")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @Temporal (TemporalType.DATE)
    @Future
    @XmlElement
    private Date startAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLOYEES_AC_ID")				
    @XmlElement
    private Employee employees;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLOYER_AC_ID")				
    @XmlElement
    private Enterprise employer;
    
    
    /****************************************************************
    Constructors
    ****************************************************************/
    /**
     * Default constructor 
    */
    public Contract(){
    	super();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public Contract(Contract element) {	
    	super(element);
        if (element != null) {
    		this.salary= element.getSalary();
    		this.startAt= element.getStartAt();
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    /**
     * @return the salary
     */
    public int getSalary (){
    	return this.salary;
    }		
    /**
     * @param salary the salary to set
     */
    public void setSalary (int salary){
    	this.salary=salary;
    }
        
    /**
     * @return the startAt
     */
    public Date getStartAt (){
    	return this.startAt;
    }		
    /**
     * @param startAt the startAt to set
     */
    public void setStartAt (Date startAt){
    	this.startAt=startAt;
    }
        
    /**
     * @return the employees
     */
    public Employee getEmployees (){
    	return this.employees;
    }		
    /**
     * @param employees the employees to set
     */
    public void setEmployees (Employee employees){
    	this.employees=employees;
    }
    /**
     * @return the employer
     */
    public Enterprise getEmployer (){
    	return this.employer;
    }		
    /**
     * @param employer the employer to set
     */
    public void setEmployer (Enterprise employer){
    	this.employer=employer;
    }
    
}	

package data.model.enterprise;

/*
Name : 			Employee.java
Comments : 		
Stereotype : 	feature
Qualified Name: Data::Enterprise::Employee
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
import data.model.data.enterprise.datatypes.EmployeeTypes;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table (name= "EMPLOYEE_F" ,schema="enterprise")
@SecondaryTable(name="CV_FP", schema="enterprise")
@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee extends Person implements Serializable {	
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ACCOUNT_F_ID")
    
    @XmlInverseReference(mappedBy="employee")
    @XmlElement(name="account", type=Account.class)
    private Account account;
    
    
    
    
    
    @Column (table="CV_FP")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @Temporal (TemporalType.DATE)
    @Future
    @XmlElement
    private Date createAt;
    @Column (table="CV_FP")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @XmlElement
    private String diplome;
    @Column (table="CV_FP")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @XmlElement
    private String language;
    
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="EMPLOYEE_JT")
    
    @XmlElementWrapper(name="enterprises")
    @XmlElement(name="enterprise")
    private List<Contract> employer;
    
    
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MANAGER_F_ID")				
    
    @XmlInverseReference(mappedBy="employee")
    @XmlElement(name="manager", type=Manager.class)
    private Manager manager;
    
    
    
    
    
    @Column (name="PICTURE")
    @Basic(fetch=FetchType.LAZY, optional = true)
    @Lob
    @XmlElement
    private byte[] picture;
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PROJECT_F_ID")				
    
    @XmlInverseReference(mappedBy="employee")
    @XmlElement(name="project", type=Project.class)
    private Project project;
    
    
    
    
    
    @Column (name="SALARY")
    @Basic(fetch=FetchType.EAGER, optional = true)
    @Max(value=5000) 
    @Min(value=2000)
    @XmlElement
    private int salary;
    
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TYPE_ID")
    @Enumerated(EnumType.STRING)
    @XmlElement
    private EmployeeTypes type;
    
    
    
    
    
    /****************************************************************
    Constructors
    ****************************************************************/
    /**
     * Default constructor 
    */
    public Employee(){
    	super();
    	this.employer = new ArrayList<Contract>();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public Employee(Employee element) {	
    	super(element);
        if (element != null) {
    		
    		
    		this.employer = new ArrayList<Contract>();
    		for (Contract c : element.getEmployer()) {
    			this.employer.add(new Contract(c));
    		}
    		
    		
    		this.picture= element.getPicture();
    		
    		this.salary= element.getSalary();
    		
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastName() {
        return super.getLastName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFirstName() {
        return super.getFirstName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBirthDate(Date birthDate) {
        super.setBirthDate(birthDate); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getBirthDate() {
        return super.getBirthDate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAddress(Address address) {
        super.setAddress(address); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address getAddress() {
        return super.getAddress(); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the account
     */
    public Account getAccount (){
    	return this.account;
    }		
    /**
     * @param account the account to set
     */
    public void setAccount (Account account){
    	this.account=account;
    }
        
        
    /**
     * @return the createAt
     */
    public Date getCreateAt (){
    	return this.createAt;
    }		
    /**
     * @param createAt the createAt to set
     */
    public void setCreateAt (Date createAt){
    	this.createAt=createAt;
    }
    /**
     * @return the diplome
     */
    public String getDiplome (){
    	return this.diplome;
    }		
    /**
     * @param diplome the diplome to set
     */
    public void setDiplome (String diplome){
    	this.diplome=diplome;
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
     * @return the employer
     */
    public List<Contract> getEmployer (){
    	return this.employer;
    }		
    /**
     * @param employer the employer to set
     */
    public void setEmployer (List<Contract> employer){
    	this.employer=employer;
    }
        
    /**
     * @return the manager
     */
    public Manager getManager (){
    	return this.manager;
    }		
    /**
     * @param manager the manager to set
     */
    public void setManager (Manager manager){
    	this.manager=manager;
    }
        
    /**
     * @return the picture
     */
    public byte[] getPicture (){
    	return this.picture;
    }		
    /**
     * @param picture the picture to set
     */
    public void setPicture (byte[] picture){
    	this.picture=picture;
    }
        
    /**
     * @return the project
     */
    public Project getProject (){
    	return this.project;
    }		
    /**
     * @param project the project to set
     */
    public void setProject (Project project){
    	this.project=project;
    }
        
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
     * @return the type
     */
    public EmployeeTypes getType (){
    	return this.type;
    }		
    /**
     * @param type the type to set
     */
    public void setType (EmployeeTypes type){
    	this.type=type;
    }
        
    
}	

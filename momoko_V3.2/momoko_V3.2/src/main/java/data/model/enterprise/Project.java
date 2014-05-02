package data.model.enterprise;

/*
Name : 			Project.java
Comments : 		
Stereotype : 	feature
Qualified Name: Data::Enterprise::Project
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
@Table (name= "PROJECT_F" ,schema="enterprise")

@XmlRootElement(name="project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project extends AbstractFeature implements Serializable {	
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LEAD_F_ID")				
    
    @XmlInverseReference(mappedBy="project")
    @XmlElement(name="lead", type=Manager.class)
    private Manager lead;
    
    
    
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="PROJECT_JT")
    
    @XmlElementWrapper(name="employees")
    @XmlElement(name="employee")
    private List<Employee> members;
    
    
    
    
    
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
    public Project(){
    	super();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public Project(Project element) {	
    	super(element);
        if (element != null) {
    		
    		
    		this.name= element.getName();
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    /**
     * @return the lead
     */
    public Manager getLead (){
    	return this.lead;
    }		
    /**
     * @param lead the lead to set
     */
    public void setLead (Manager lead){
    	this.lead=lead;
    }
        
    /**
     * @return the members
     */
    public List<Employee> getMembers (){
    	return this.members;
    }		
    /**
     * @param members the members to set
     */
    public void setMembers (List<Employee> members){
    	this.members=members;
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

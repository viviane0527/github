package data.model.enterprise;

/*
Name : 			Manager.java
Comments : 		
Stereotype : 	feature
Qualified Name: Data::Enterprise::Manager
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
@Table (name= "MANAGER_F" ,schema="enterprise")

@XmlRootElement(name="manager")
@XmlAccessorType(XmlAccessType.FIELD)
public class Manager extends Employee implements Serializable {	
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="MANAGER_JT")
    
    @XmlElementWrapper(name="projects")
    @XmlElement(name="project")
    private List<Project> projects;
    
    
    
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="MANAGER_JT")
    
    @XmlElementWrapper(name="employees")
    @XmlElement(name="employee")
    private List<Employee> teams;
    
    
    
    
    
    /****************************************************************
    Constructors
    ****************************************************************/
    /**
     * Default constructor 
    */
    public Manager(){
    	super();
    }
    
    /**
     * Constructor by copy
     * @param element : the element to copy 
    */
    public Manager(Manager element) {	
    	super(element);
        if (element != null) {
    		
    		
     	 }
    }
    
    /****************************************************************
    Getters & Setters
    ****************************************************************/
    /**
     * @return the projects
     */
    public List<Project> getProjects (){
    	return this.projects;
    }		
    /**
     * @param projects the projects to set
     */
    public void setProjects (List<Project> projects){
    	this.projects=projects;
    }
        
    /**
     * @return the teams
     */
    public List<Employee> getTeams (){
    	return this.teams;
    }		
    /**
     * @param teams the teams to set
     */
    public void setTeams (List<Employee> teams){
    	this.teams=teams;
    }
        
    
}	

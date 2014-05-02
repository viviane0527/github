package data.model.abstracts;


/*
Name : 			AbstractFeature.java
Stereotype : 	feature
*/

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractFeature {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ABSTRACT_FEATURE_GEN")
	protected Long id;

    
    /****************************************************************
    Auditable
    ****************************************************************/
    @Column (name="WHENCHANGED") 
    @Basic(fetch=FetchType.LAZY, optional = false) 
    @Temporal(TemporalType.DATE)
    private Date whenchanged;

    @Column (name="WHOCHANGED") 
    @Basic(fetch=FetchType.LAZY, optional = false) 
    private String whochanged;

    @Column (name="WHATCHANGED") 
    @Basic(fetch=FetchType.LAZY, optional = false) 
    private String whatchanged;
    
    /****************************************************************
    History
    ****************************************************************/
    @Column (name="VERSION") 
    @Basic(fetch=FetchType.LAZY, optional = false)  
    private int version;

    @Column (name="LASTCHANGE") 
    @Basic(fetch=FetchType.LAZY, optional = false) 
    private boolean lastChange;

	/**
	 * Default constructor
	 */
	protected AbstractFeature() {
	}

	/**
	 * Copy Constructor
	 * 
	 * @param abstractFeature
	 */
	protected AbstractFeature(AbstractFeature abstractFeature) {
	}

	/**
	 * This method compare this Feature with another AbstractFeature passing in
	 * parameter
	 * 
	 * @param timeSlice
	 * @return timeSlice that contains only the differences
	 */
	//public abstract AbstractFeature diffWith(AbstractFeature abstractFeature);

	@Override
	public boolean equals(Object o) {
		if (id == null || !(o instanceof AbstractFeature))
			return false;
		return id.equals(((AbstractFeature) o).getId());
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}

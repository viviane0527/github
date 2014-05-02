package data.model.abstracts;

/*
Name : 			AbstractObject.java
Stereotype : 	object
*/

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractObject {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ABSTRACT_OBJECT_GEN")
	protected Long id;

	/**
	 * Default Contructor
	 */
	public AbstractObject() {
	}

	/**
	 * Copy Constructor
	 * @param abstractObject
	 */
	public AbstractObject(AbstractObject abstractObject) {
	}

	/**
	 * Check if this object is different from an object passing in parameter
	 * 
	 * @param abstractObject
	 * @return
	 */
	//public abstract Boolean isDiffWith(AbstractObject abstractObject);

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

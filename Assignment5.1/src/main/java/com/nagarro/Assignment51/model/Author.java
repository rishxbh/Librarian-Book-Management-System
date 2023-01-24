package com.nagarro.Assignment51.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	int personID;
	String fullName;
	public Author(int personID, String fullName) {
		super();
		this.personID = personID;
		this.fullName = fullName;
	}
	public Author() {
		super();
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "Author [personID=" + personID + ", fullName=" + fullName + "]";
	}
}

package com.saida.spring.rest.repository;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.springframework.util.StringUtils;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "FST_NAM", unique = true, nullable = false)
	private String firstName;

	@Column(name = "LST_NAM")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CNCT_NO")
	private String contactNo;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "ADDR")
	@Basic(fetch = FetchType.LAZY)
	private String address;

	@Column(name = "STS")
	@Enumerated(EnumType.STRING)
	private Status status;

	public enum Status {
		CREATED, ACTIVE, INACTIVE;
	}

	public User() {
		this.status = User.Status.CREATED;
	}

	public User(String firstName, String lastName, String email, String contactNo, Date dob, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;

		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		} else if (this.id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User id=" + id + "\r\n  firstName=" + firstName + "\r\n  lastName=" + lastName;
	}

	// Create a Builder Pattern

	public static class UserBuilder {

		private String firstName;

		private String lastName;

		private String email;

		private String contactNo;

		private Date dob;

		private String address;

		public UserBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder contactNo(String contactNo) {
			this.contactNo = contactNo;
			return this;
		}

		public UserBuilder dob(Date dob) {
			this.dob = dob;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			User user = new User();
			user.setFirstName(this.firstName);
			user.setLastName(this.lastName);
			user.setContactNo(this.contactNo);
			user.setDob(this.dob);
			user.setEmail(this.email);
			user.setAddress(this.address);

			// Perform necessary validations before returning actual User Object
			user.validate();

			return user;
		}

	}

	public void validate() {
		if (StringUtils.isEmpty(this.firstName)) {
			throw new IllegalArgumentException("first name is a mandatory field");
		}

	}

	public static UserBuilder user() {
		return new User.UserBuilder();
	}

}
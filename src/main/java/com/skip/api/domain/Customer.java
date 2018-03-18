package com.skip.api.domain;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.skip.api.services.validation.CustomerInsert;

@CustomerInsert
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	private String email;

	@NotEmpty
	private String name;

	@NotEmpty
	private String address;

	private Timestamp creation;

	@JsonProperty(access = Access.WRITE_ONLY)
	@NotEmpty
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLES")
    private Set<String> roles = new HashSet<>();
	
	public Customer() {
		roles.add("USER");
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreation() {
		return creation;
	}

	public void setCreation(Timestamp creation) {
		this.creation = creation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addRole(String role) {
		this.roles.add(role);
	}

	public Set<String> getRoles() {
		return Collections.unmodifiableSet(roles);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

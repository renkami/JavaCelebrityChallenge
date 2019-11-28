package com.lenaranjo.celebrity.model;

import java.util.List;

import lombok.Data;

@Data
public class Person {
	
	private Integer id;
	private String name;
	private List<Integer> knowns;

	public Person(Integer id, String name, List<Integer> knowns) {
		super();
		this.id = id;
		this.name = name;
		this.knowns = knowns;
	}
	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Person(int id) {
		super();
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	
}

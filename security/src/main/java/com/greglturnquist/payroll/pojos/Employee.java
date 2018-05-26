/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll.pojos;

import javax.persistence.*;

import com.greglturnquist.payroll.pojos.Manager;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Data
@Entity
//Complex query example
//@NamedQuery(name = "Employee.findByEmailAddress",
//		query = "select u from User u where u.emailAddress = ?1")
//@Table(name = "MyFancyTable")
public class Employee {

	private @Id @GeneratedValue Long id;
	//@Column(name = "first_name1")
    //@Index(name = "myIndex", unique = true)
	private String firstname;
	private String lastName;
	private String description;

	private @Version @JsonIgnore Long version;

	private @ManyToOne
    Manager manager;

//	private @ManyToMany
//    List<Manager> manager;
//
	private Employee() {}

	public Employee(String firstName, String lastName, String description, Manager manager) {
		this.firstname = firstName;
		this.lastName = lastName;
		this.description = description;
		this.manager = manager;
	}
}
// end::code[]
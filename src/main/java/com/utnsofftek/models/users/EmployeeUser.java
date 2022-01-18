package com.utnsofftek.models.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("employee")
@Table(name="user_employee")
public class EmployeeUser extends Usuario{
	
}

package com.utnsofftek.models.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("admin")
@Table(name="user_admin")
public class Admin extends Usuario{
	
}

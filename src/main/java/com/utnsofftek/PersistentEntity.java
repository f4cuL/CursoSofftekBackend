package com.utnsofftek;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class PersistentEntity {
	@GeneratedValue
	@Id
	@Column
	private int id;
}

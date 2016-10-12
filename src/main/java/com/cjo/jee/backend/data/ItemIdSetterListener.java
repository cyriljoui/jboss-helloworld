package com.cjo.jee.backend.data;

import java.util.UUID;

import javax.persistence.PrePersist;

public class ItemIdSetterListener {

	@PrePersist
	public void save(Item item) {
		item.setId(UUID.randomUUID().toString());
	}
	
}

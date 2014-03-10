package net.vl0w.isd.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public abstract class ADocument {
	@Id
	private String _id;

	public String getId() {
		if (_id == null) {
			assignId();
		}
		return _id;
	}

	protected void assignId() {
		_id = getClass().getSimpleName() + "/" + hashCode();
	}
}

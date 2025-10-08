package org.jax.mgi.snpdatamodel.document;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ESEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public String toString() {
		return "ESEntity: ";
	}
}

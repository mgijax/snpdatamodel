package org.jax.mgi.snpdatamodel.document;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseESDocument extends ESEntity implements Serializable {
	
	private String consensussnp_accid;
	
}
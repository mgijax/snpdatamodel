package org.jax.mgi.snpdatamodel.document;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseESDocument implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6501301092865333849L;
	
	private String consensussnp_accid;
	
}

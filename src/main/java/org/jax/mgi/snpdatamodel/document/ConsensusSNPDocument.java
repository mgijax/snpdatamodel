package org.jax.mgi.snpdatamodel.document;

import org.jax.mgi.snpdatamodel.ConsensusSNP;

import lombok.Data;

@Data
public class ConsensusSNPDocument extends BaseESDocument {

	private String consensussnp_accid;
	private ConsensusSNP objectJSONData;
}

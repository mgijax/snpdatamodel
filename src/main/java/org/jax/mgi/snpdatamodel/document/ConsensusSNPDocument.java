package org.jax.mgi.snpdatamodel.document;

import org.jax.mgi.snpdatamodel.ConsensusSNP;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConsensusSNPDocument extends BaseESDocument {

	private String consensussnp_accid;
	private ConsensusSNP objectJSONData;
}

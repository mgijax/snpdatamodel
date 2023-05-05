package org.jax.mgi.snpdatamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ConsensusAlleleSNP extends AlleleSNP {
	
	private boolean conflict;

}

package org.jax.mgi.snpdatamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlleleSNP extends AbstractSNP {

	private String allele;
	private String strain;

}

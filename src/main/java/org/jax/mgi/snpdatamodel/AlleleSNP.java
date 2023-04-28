package org.jax.mgi.snpdatamodel;

import lombok.Data;

@Data
public class AlleleSNP extends AbstractSNP {

	private String allele;
	private String strain;

}

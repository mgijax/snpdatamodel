package org.jax.mgi.snpdatamodel;

import org.jax.mgi.snpdatamodel.visitors.VisitorInterface;

public class AlleleSNP extends AbstractSNP {

	private String allele;
	private String strain;
	
	public String getAllele() {
		return allele;
	}
	public void setAllele(String allele) {
		this.allele = allele;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	@Override
	public void Accept(VisitorInterface pi) {
		pi.Visit(this);
	}
}

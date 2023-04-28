package org.jax.mgi.snpdatamodel;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PopulationSNP extends AbstractSNP {

	private int populationKey;
	private String accid;
	private String subHandleName;
	private String populationName;
	private List<AlleleSNP> alleles;

	public PopulationSNP dup() {
		PopulationSNP p = new PopulationSNP();
		p.setPopulationKey(populationKey);
		p.setAccid(accid);
		p.setPopulationName(populationName);
		p.setSubHandleName(subHandleName);
		p.setAlleles(new ArrayList<AlleleSNP>());
		return p;
	}
}

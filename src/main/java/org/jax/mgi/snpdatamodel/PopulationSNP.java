package org.jax.mgi.snpdatamodel;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PopulationSNP extends AbstractSNP {

	private String populationKey;
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

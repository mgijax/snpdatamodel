package org.jax.mgi.snpdatamodel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SubSNP extends AbstractSNP {
	
	private int subSnpKey;
	private String accid;
	private String variationClass;
	private String alleleSummary;

	private String orientation;
	private String submitterId;
	private boolean exemplar;

	public LinkedHashMap<Integer, PopulationSNP> populations = new LinkedHashMap<Integer, PopulationSNP>();
	
	public List<PopulationSNP> getPopulations() {
		ArrayList<PopulationSNP> pops = new ArrayList<PopulationSNP>();
		for(PopulationSNP p: populations.values()) {
			pops.add(p);
		}
		return pops;
	}
	public void setPopulations(List<PopulationSNP> populations) {
		this.populations.clear();
		for(PopulationSNP p: populations) {
			this.populations.put(p.getPopulationKey(), p);
		}
	}

}

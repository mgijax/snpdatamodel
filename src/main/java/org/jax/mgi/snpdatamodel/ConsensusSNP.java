package org.jax.mgi.snpdatamodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConsensusSNP extends AbstractSNP {

	private String consensusKey;
	private String accid;
	private String variationClass;
	private String alleleSummary;
	private String iupaccode;
	private String buildCreated;
	private String buildUpdated;
	private String flank5Prime;
	private String flank3Prime;

	private List<SubSNP> subSNPs;
	private List<ConsensusCoordinateSNP> consensusCoordinates;
	private List<ConsensusAlleleSNP> consensusAlleles;
	
	@JsonIgnore
	public String getJBrowserLink(String url) {
		return url.replace("<chromosome>", consensusCoordinates.get(0).getChromosome()).replace("<start>", String.valueOf(consensusCoordinates.get(0).getStartCoordinate())).replace("<end>", String.valueOf(consensusCoordinates.get(0).getStartCoordinate()));
	}
	
	@JsonIgnore
	public boolean isMultiCoord() {
		return consensusCoordinates.size() > 1;
	}
	
	@JsonIgnore
	public String getFlank5PrimeFormatted() {
		String flank = new StringBuilder(flank5Prime).reverse().toString();
		int len = flank.length() + (60 - (flank.length() % 60));
		flank = new StringBuilder(String.format("%-" + len +"s", flank)).reverse().toString();
		return splitFlank(flank);
	}
	
	@JsonIgnore
	public String getFlank3PrimeFormatted() {
		String flank = flank3Prime;
		// Get the len for the full line
		int len = flank.length() + (60 - (flank.length() % 60));
		// Pad with white space before chunking
		flank = String.format("%-" + len +"s", flank);
		return splitFlank(flank);
	}
	
	@JsonIgnore
	public String splitFlank(String in) {
		String[] flankArray = in.split("(?<=\\G.{10})");
		StringBuffer ret = new StringBuffer();
		for(int i = 0; i < flankArray.length; i++) {
			ret.append(flankArray[i]);
			if(i > 0 && (i + 1) % 6 == 0) {
				ret.append("\n");
			} else {
				ret.append(" ");
			}
		}
		return ret.toString();
	}

	@JsonIgnore
	public boolean hasVepFunctionClass () {
		for(ConsensusCoordinateSNP cc : getConsensusCoordinates()) {
			for (ConsensusMarkerSNP m : cc.getMarkers()){
				String gc = m.getFunctionClass().toLowerCase();
				if (!gc.contains("within coordinates")
				&&  !gc.contains("within distance")
				&&  !gc.endsWith("proximal")
				&&  !gc.endsWith("distal")
				&&  !gc.endsWith("upstream")
				&&  !gc.endsWith("downstream")
				)
					return true;
			}
		}
		return false;
	}

}

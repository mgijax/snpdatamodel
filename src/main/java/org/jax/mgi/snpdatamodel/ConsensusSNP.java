package org.jax.mgi.snpdatamodel;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.jax.mgi.snpdatamodel.visitors.VisitorInterface;

public class ConsensusSNP extends AbstractSNP {

	private int consensusKey;
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
	private List<AlleleSNP> alleles;
	
	public int getConsensusKey() {
		return consensusKey;
	}
	public void setConsensusKey(int consensusKey) {
		this.consensusKey = consensusKey;
	}
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getVariationClass() {
		return variationClass;
	}
	public void setVariationClass(String variationClass) {
		this.variationClass = variationClass;
	}
	public String getAlleleSummary() {
		return alleleSummary;
	}
	public void setAlleleSummary(String alleleSummary) {
		this.alleleSummary = alleleSummary;
	}
	public String getIupaccode() {
		return iupaccode;
	}
	public void setIupaccode(String iupaccode) {
		this.iupaccode = iupaccode;
	}
	public String getBuildCreated() {
		return buildCreated;
	}
	public void setBuildCreated(String buildCreated) {
		this.buildCreated = buildCreated;
	}
	public String getBuildUpdated() {
		return buildUpdated;
	}
	public void setBuildUpdated(String buildUpdated) {
		this.buildUpdated = buildUpdated;
	}
	public String getFlank5Prime() {
		return flank5Prime;
	}
	public void setFlank5Prime(String flank5Prime) {
		this.flank5Prime = flank5Prime;
	}
	public String getFlank3Prime() {
		return flank3Prime;
	}
	public void setFlank3Prime(String flank3Prime) {
		this.flank3Prime = flank3Prime;
	}
	public List<SubSNP> getSubSNPs() {
		return subSNPs;
	}
	public void setSubSNPs(List<SubSNP> subSNPs) {
		this.subSNPs = subSNPs;
	}
	public List<ConsensusCoordinateSNP> getConsensusCoordinates() {
		return consensusCoordinates;
	}
	public void setConsensusCoordinates(List<ConsensusCoordinateSNP> consensusCoordinates) {
		this.consensusCoordinates = consensusCoordinates;
	}
	public List<AlleleSNP> getAlleles() {
		return alleles;
	}
	public void setAlleles(List<AlleleSNP> alleles) {
		this.alleles = alleles;
	}
	
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
	
	@Override
	public void Accept(VisitorInterface pi) {
		pi.Visit(this);
	}
}

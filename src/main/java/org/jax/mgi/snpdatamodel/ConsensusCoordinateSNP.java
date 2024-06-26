package org.jax.mgi.snpdatamodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConsensusCoordinateSNP extends AbstractSNP {
	
	private String chromosome;
	private long startCoordinate;
	private boolean multiCoord;
	private String strand;

	private String variationClass;
	private String alleleSummary;
	private String iupaccode;

	private List<ConsensusMarkerSNP> markers;
	
	@JsonIgnore
	public String getStrandFormatted() {
		if("f".equals(strand)) return "forward";
		if("r".equals(strand)) return "reverse";
		return "";
	}

}

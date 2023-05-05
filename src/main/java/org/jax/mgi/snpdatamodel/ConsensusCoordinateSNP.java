package org.jax.mgi.snpdatamodel;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConsensusCoordinateSNP extends AbstractSNP {
	
	private String chromosome;
	private int startCoordinate;
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

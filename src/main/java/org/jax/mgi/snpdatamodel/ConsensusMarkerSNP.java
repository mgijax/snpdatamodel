package org.jax.mgi.snpdatamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConsensusMarkerSNP extends AbstractSNP {

	private String accid;
	private String symbol;
	private String name;
	private String functionClass;
	private String transcript;
	private String protein;
	private String contigAllele;
	private String residue;
	private String aaPosition;
	private String readingFrame;
	private int distanceFrom;
	private String distanceDirection;

}

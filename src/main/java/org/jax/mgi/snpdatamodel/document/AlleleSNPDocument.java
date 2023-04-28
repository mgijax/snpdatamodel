package org.jax.mgi.snpdatamodel.document;

import java.util.List;

import lombok.Data;

@Data
public class AlleleSNPDocument extends BaseESDocument {

	private String consensussnp_accid;
	private String chromosome;
	private Double startcoordinate;
	private String varclass;
	private List<String> fxn;
	private List<String> marker_accid;
	private List<String> strains;
	
	private String allele;
	private List<String> samestrains;
	private List<String> diffstrains;
	
	
}

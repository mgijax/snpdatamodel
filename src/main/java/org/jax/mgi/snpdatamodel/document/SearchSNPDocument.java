package org.jax.mgi.snpdatamodel.document;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SearchSNPDocument extends BaseESDocument {

	private String chromosome;
	private Double startcoordinate;
	private String varclass;
	private List<String> fxn;
	private List<String> marker_accid;
	private List<String> strains;
	
}

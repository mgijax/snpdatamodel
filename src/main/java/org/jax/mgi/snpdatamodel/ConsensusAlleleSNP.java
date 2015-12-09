package org.jax.mgi.snpdatamodel;

import org.jax.mgi.snpdatamodel.visitors.VisitorInterface;

public class ConsensusAlleleSNP extends AlleleSNP {
	
	private boolean conflict;
	
	public boolean isConflict() {
		return conflict;
	}
	public void setConflict(boolean conflict) {
		this.conflict = conflict;
	}
	
	@Override
	public void Accept(VisitorInterface pi) {
		pi.Visit(this);
	}
}

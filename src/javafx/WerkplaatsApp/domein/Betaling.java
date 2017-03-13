package javafx.WerkplaatsApp.domein;

import java.io.Serializable;

public class Betaling implements Serializable {
	private int nummer,dagenVoorbij;
	private boolean alBetaald;
	public Betaling(int num,boolean aB){
		nummer = num;
		alBetaald =aB;
	}
	
	public int getNummer() {
		return nummer;
	}

	public int getDagenVoorbij() {
		return dagenVoorbij;
	}

	public void setDagenVoorbij(int dagenVoorbij) {
		this.dagenVoorbij = dagenVoorbij;
	}

	public boolean isAlBetaald() {
		return alBetaald;
	}

	public void setAlBetaald(boolean alBetaald) {
		this.alBetaald = alBetaald;
	}

	public String toString() {
		String betaald = alBetaald ? "wel" : "niet";
		return String.format("Betaling met nummer: %d is %s betaald", nummer, betaald);
	}
}

package com.usthb.modeles;

public class Vehicule extends MoyenTransport {
	private String mtfutil ;//motif d’utilisation
	public Vehicule(TypeMoyen type, long nSerie, long matricul, String model, String entreprise,String mtf) {
		super(type, nSerie, matricul, model, entreprise);
		mtfutil = mtf;
	}
	@Override
	public String toString() {
		return super.toString()+ ", motif d’utilisation :" + mtfutil;
	}

}

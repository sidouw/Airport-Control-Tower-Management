package com.usthb.modeles;

public class Bus extends MoyenTransport {
	
	private int nbrsiege;
	public Bus(int nbsiege, long nSerie, long matricul, String model, String entreprise) {
		super(TypeMoyen.BUS, nSerie, matricul, model, entreprise);
		nbrsiege=nbsiege;
	}
	@Override
	public String toString() {
		return super.toString()+ ", nombre de sièges :" + nbrsiege;
	}

}

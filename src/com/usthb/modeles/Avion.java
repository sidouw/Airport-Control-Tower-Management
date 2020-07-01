package com.usthb.modeles;


public class Avion extends MoyenTransport {

	private AvType avType;
	private int Carburant;
	private int NbVoyageurs;
	
	public Avion(long nSerie, long matricul, String model, String entreprise,AvType Type,int Carburant,int NbVoyageurs ){
		super(TypeMoyen.AVI,nSerie,matricul,model,entreprise);	
		avType=Type;
		this.NbVoyageurs = NbVoyageurs;
		this.Carburant =Carburant;
	}

	
	@Override
	public String toString() {
		
		return super.toString() + ", Type D'avion: " + avType + ", Carburant: " + Carburant + ", Nombre De Voyageurs: " + NbVoyageurs;
	}
	


}


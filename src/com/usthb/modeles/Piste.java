package com.usthb.modeles;


public class Piste extends Couloir {
private static int NS=0;
private orien orientation;
private int longueur;


public Piste(orien orientation,int longueur) {
	super(CouloirType.Piste);
	numero = "p"+(++NS);	
	this.orientation = orientation;
	this.longueur = longueur;
	
}

@Override
public String toString() {
	
	String Temp="\nCette Piste est occupé par :";
	for (int i =0;i<24;i++) {
		for (int y =0;y<60;y++) {
			if(OcupaiedBy[i][y]!= null)
			Temp = Temp+ "\n"+ String.valueOf(OcupaiedBy[i][y])+ " a " + i+"H : "+y+"M" ;
		}
	}
	return "orientation: " + orientation + ", numero: " + numero + ", longueur: " + longueur + Temp;
}

}

package com.usthb.modeles;

import java.util.ArrayList;
import java.util.HashMap;

public class Couloir {
	protected String numero ;
	private boolean occupation[][]= new boolean[24][60];
	protected MoyenTransport OcupaiedBy[][]= new MoyenTransport[24][60];
	private static HashMap<CouloirType,ArrayList<Couloir>> Couloirs = new HashMap<CouloirType, ArrayList<Couloir>>();
	Couloir(CouloirType Type){
		if(Couloirs.get(Type)== null) {
			Couloirs.put(Type, new ArrayList<Couloir>());
		}
		Couloirs.get(Type).add(this);
	}
	
	
	//retour la list des pistes librea une heur donné
	public static ArrayList<Couloir> getFreeHals(CouloirType type,int H , int M) {
		ArrayList<Couloir> temp = new ArrayList<Couloir>();
		for(Couloir Hal : Couloirs.get(type) ) {		
			if(!Hal.getOccupation(H, M))
				temp.add(Hal);
		}	
		return temp;
		
	}
	public void setOccupation(boolean Ocupation,int H,int M) {
		occupation[H][M]=Ocupation;
	}

	public void setOcupaiedby(MoyenTransport Ocupation,int H,int M) {
		OcupaiedBy[H][M]=Ocupation;
	}

	public boolean getOccupation(int H,int M) {
		return occupation[H][M];
	}
	

	//affichier les Couloir creé
	public static void ShowHals(CouloirType type) {
		if (Couloirs.get(type) == null ) {
			System.out.println("La List des " +type+" est vide !!\n\n");
			return ;
		}
		int y=1;
		
		for(Couloir i : Couloirs.get(type)) {
			System.out.println(String.valueOf(y)+". "+i);
			y++;
		}
	}
}

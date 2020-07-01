package com.usthb.modeles;
import java.util.ArrayList;
import java.util.HashMap;


public class MoyenTransport {
	private long NSerie;
	private long matricul;
	private static int v=0,c=0,b=0,a=0;
	private String Model;
	private String Entreprise;
	private String numero;
	private static HashMap<TypeMoyen,ArrayList<MoyenTransport>> TransportMeans = new HashMap<TypeMoyen, ArrayList<MoyenTransport>>();
	
	
	public MoyenTransport(TypeMoyen type,long nSerie, long matricul, String model, String entreprise){
		if(TransportMeans.get(type)== null) {
			TransportMeans.put(type, new ArrayList<MoyenTransport>());
		}
			
		
		switch(type) {
		case VOI:v++; numero=type.toString()+v;
			break;
		case CAM:c++; numero=type.toString()+c;
			break;
		case BUS:b++; numero=type.toString()+b;
			break;
		case AVI:a++; numero=type.toString()+a;
			break;
		}
		
		NSerie = nSerie;
		this.matricul = matricul;
		Model = model;
		Entreprise = entreprise;		
		TransportMeans.get(type).add(this);
	}
	
	public static ArrayList<MoyenTransport> getTransportMeans(TypeMoyen type) {
		return TransportMeans.get(type);
	}

	//affichier les moyen de transport du type donne 
	public static void ShowTrasportmeans(TypeMoyen type) {
		if (TransportMeans.get(type)== null ) {
			System.out.println("La List est vide !!\n\n");
			return ;
		}
		int y=1;
		
		for(MoyenTransport i : TransportMeans.get(type)) {
			System.out.println(String.valueOf(y)+". "+i);
			y++;
		}
	}

	@Override
	public String toString() {
		return  "numero: " + numero + ", matricul: " + matricul + ", Model: " + Model + ", Entreprise: "
				+ Entreprise + ", Numero De Serie: " + NSerie;
	}
	




}

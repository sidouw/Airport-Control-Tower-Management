package com.usthb.controleur;
import java.util.ArrayList;
import java.util.Scanner;
import com.usthb.modeles.*;

public class Application {
	
	private static Scanner Scan = new Scanner (System.in);
	
	
	// La fonction responsable d'ajouter un moyen de transport 
	private static void AjouterMoyenDeTransport() {	

		int Choice=1;
		TypeMoyen type=null;
		// Selection de type de moyen de transport
		while (type == null) {
		System.out.print("vouliez Choisir le type de moyen \n 1. Pour Une Voiture \n 2. Pour un Camion \n3. Pour Un Bus \n ");
		Choice = Scan.nextInt();
		switch(Choice){
		case 1 : type = TypeMoyen.VOI;
			break;
		case 2 : type = TypeMoyen.CAM;
			break;
		case 3 : type = TypeMoyen.BUS;
			break;				
		}	
		}
		
		//Saisie d'information pour le vehicule 
		System.out.println("vouliez entrer un numero de serie");
		int Nserie = Scan.nextInt();
		System.out.println("vouliez entrer Le Matricule ");
		int Mat = Scan.nextInt();
		System.out.println("vouliez entrer Le Model Du Vehicule ");
		String Model = Scan.next();
		System.out.println("vouliez entrer L'entreprise ");
		String Entreprise = Scan.next();
		
		if(type==TypeMoyen.BUS) {
			System.out.println("vouliez entrer le nombre de sièges du bus");
			int nbsg = Scan.nextInt();
			//Creation de Bus	
			new Bus(nbsg,Nserie,Mat, Model,Entreprise);
			return;
		}
		System.out.println("vouliez entrer le motif d’utilisation ");
		String mtf = Scan.next();
		//Creation du vehicule
		new Vehicule(type,Nserie,Mat, Model,Entreprise,mtf);
	}
	
	
	
	// La fonction responsable d'ajouter d'une Avion
	private static void AjouterAvion() {	
		int Choice;
		AvType type=null;
		// Selection de type d'avion
		while (type == null) {
		System.out.print("vouliez Choisir le type d'avion \n 1. Pour AIRBUS \n 2. BOEING \n3. Pour ATR \n ");
		Choice = Scan.nextInt();
		switch(Choice){
		case 1 : type = AvType.AIRBUS;
			break;
		case 2 : type = AvType.BOEING;
			break;
		case 3 : type = AvType.ATR;
			break;				
		}	
		}
		
		//Saisie d'information pour l'avion 
		System.out.println("vouliez entrer un numero de serie");
		int Nserie = Scan.nextInt();
		System.out.println("vouliez entrer Le Matricule ");
		int Mat = Scan.nextInt();
		System.out.println("vouliez entrer Le Model D'avion ");
		String Model = Scan.next();
		System.out.println("vouliez entrer La companigne ");
		String Entreprise = Scan.next();
		System.out.println("vouliez entrer Le Carburant ");
		int Fuel = Scan.nextInt();
		System.out.println("vouliez entrer Le nombre de voyageur ");
		int NbVoy = Scan.nextInt();
		
		//Creation d'avion 
		new Avion(Nserie,Mat, Model,Entreprise,type,Fuel,NbVoy);	
		
	}
	
	// La fonction responsable d'ajouter d'une route
	private static void AjouterRoute() {	
		System.out.println("est ce que cette route est en intersection avec une piste \n Y/N");
		//Creation de route
		new Route(Scan.next().equalsIgnoreCase("Y"));
	}
	
	// La fonction responsable d'ajouter d'une piste
	private static void AjouterPiste() {	
		int Longeur=1,choice=0;
		orien o = null;
		
		//Saisie d'information pour la piste 
		System.out.println("vouliez entrer La Lengeur de la Piste");
		Longeur = Scan.nextInt();
		while(o==null) {
			System.out.println("vouliez choisir l'orientation de la Piste \n 1. Pour EST \n 2. Pour NORD \n 3. Pour OUEST \n 4. pour SUD\n");
			choice = Scan.nextInt();
			switch(choice){
			case 1 : o = orien.EST;
				break;
			case 2 : o = orien.NORD;
				break;
			case 3 : o = orien.OUEST;
				break;	
			case 4: o = orien.SUD;
				break;
			}
		}
		//Creation de piste
		new Piste(o,Longeur);	
	}
	
	// La fonction responsable d'affichier les moyen de trasport
	static void ShowTarnsportmeans() {
		int Choice =0;
		// Selection de type de moyen de transport
		while(Choice<=0 || Choice>3) {
			System.out.print("vouliez Choisir le type de moyen \n 1. Pour Une Voiture \n 2. Pour un Camion \n3. Pour Un Bus \n ");
			Choice = Scan.nextInt();
		}
		//affichage de moyen de transport selectioné 
		switch(Choice){
		case 1 : Vehicule.ShowTrasportmeans(TypeMoyen.VOI);
			break;
		case 2 :  Vehicule.ShowTrasportmeans(TypeMoyen.CAM);
			break;
		case 3 :Bus.ShowTrasportmeans(TypeMoyen.BUS);
			break;				
		}
	}
	
	 
	//La fonction responsable d'autoriser un moyen de transport a une heur donné 
	public static void autoriseruntrasport() {
		int index=0,Mindex=-1;
		// Selection de type de moyen de transport
		while(index<=0 || index>3) {
			System.out.print("vouliez Choisir le type de Moyen de Transport a autoriser \n 1. Pour Une Voiture \n 2. Pour un Camion \n3. Pour Un Bus \n ");
			index = Scan.nextInt();
		}
		ArrayList<MoyenTransport> Transportmeans = null;
		switch(index){
		case 1 :MoyenTransport.ShowTrasportmeans(TypeMoyen.VOI);
				Transportmeans = MoyenTransport.getTransportMeans(TypeMoyen.VOI);	
			break;
		case 2 :MoyenTransport.ShowTrasportmeans(TypeMoyen.CAM);
				Transportmeans = MoyenTransport.getTransportMeans(TypeMoyen.CAM);
			break;
		case 3 :MoyenTransport.ShowTrasportmeans(TypeMoyen.BUS);
				Transportmeans = MoyenTransport.getTransportMeans(TypeMoyen.BUS);
				break;				
		}
		//Selection de moyen apartir de la list 
		if(Transportmeans!=null) {			
			System.out.println("vouliez choisir un Moyen");	
			while(Mindex<=0 || Mindex > Transportmeans.size()) {Mindex = Scan.nextInt();}
			
			
			int H=-1,M=-1;
			while(H<0 || H>23) {
				System.out.println("vouliez entrer L'heur");
				H=Scan.nextInt();
				}
			while(M<0 || M>59) {
				System.out.println("vouliez entrer Les Minute");
				M=Scan.nextInt();
				}
			index = 1;
			ArrayList<Couloir> FreeRoads= Route.getFreeHals(CouloirType.Route,H, M);
		if(FreeRoads.size()>0) {
				
				for (Couloir road :FreeRoads) {
					System.out.println(String.valueOf(index) +". "+ road );
					index++;		
				}
				
			}else {
				System.out.println("Aucune Route est libre a cette horaire !!\n");
				return;
			}
		
			index = -1;		
			System.out.println("vouliez choisir une route");
			
			while(index<=0 || index > FreeRoads.size()) {index = Scan.nextInt();}
			
			FreeRoads.get(index-1).setOccupation(true, H, M);	
			FreeRoads.get(index-1).setOcupaiedby(Transportmeans.get(Mindex-1), H, M);
			
		}else {
			System.out.println("Aucune vehicule de ce type existe pour l'autoriser\n\n");
		}
		
	}
	
	
	//La fonction responsable d'autoriser une avion a une heur donne
	public static void autoriseruneAvion() {
		int index=0,Mindex=-1;

		ArrayList<MoyenTransport> Transportmeans = MoyenTransport.getTransportMeans(TypeMoyen.AVI);
		Avion.ShowTrasportmeans(TypeMoyen.AVI);
		
		if(Transportmeans!= null) {			
			System.out.println("Vouliez choisir une Avion");	
			while(Mindex<=0 || Mindex > Transportmeans.size()) {Mindex = Scan.nextInt();}
			
			
			int H=-1,M=-1;
			while(H<0 || H>23) {
				System.out.println("Vouliez entrer L'heur");
				H=Scan.nextInt();
				}
			while(M<0 || M>59) {
				System.out.println("Vouliez entrer Les Minute");
				M=Scan.nextInt();
				}
			index = 1;
			ArrayList<Couloir> FreeTracks= Piste.getFreeHals(CouloirType.Piste,H, M);
		if(FreeTracks.size()>0) {
				
				for (Couloir Track :FreeTracks) {
					System.out.println(String.valueOf(index) +". "+ Track );
					index++;		
				}
				
			}else {
				System.out.println("Aucune Piste est libre a cette horaire !!\n");
				return;
			}
		
			index = -1;		
			System.out.println("Vouliez choisir une piste");
			
			while(index<=0 || index > FreeTracks.size()) {index = Scan.nextInt();}
			
			FreeTracks.get(index-1).setOccupation(true, H, M);	
			FreeTracks.get(index-1).setOcupaiedby((Avion)Transportmeans.get(Mindex-1), H, M);
			
		}else {
			System.out.println("Aucune avion existe pour l'autoriser\n\n");
		}
		
	}
	
	
	public static void main(String[] args)  {
		
		
		int Choice=1;
		// La boucle principale du programe 
		while(true) {
			System.out.println("\nEntere 1 Pour ajouter Un Moyen De Transport");
			System.out.println("Entere 2 Pour ajouter Une Avion");
			System.out.println("Entere 3 Pour Affichier les Moyen De Transport");
			System.out.println("Entere 4 Pour Affichier les Avion");
			System.out.println("Entere 5 Pour ajouter Une Route");
			System.out.println("Entere 6 Pour ajouter Une Piste");
			System.out.println("Entere 7 Pour Affichier les Route");
			System.out.println("Entere 8 Pour Affichier les Piste");
			System.out.println("Entere 9 Pour autoriser Un Moyen De Transport");
			System.out.println("Entere 10 Pour autorise Une avion");
			System.out.println("Entere 11 Pour Quitter");
			
			Choice= Scan.nextInt();
			
			switch(Choice) {
			case 1:
				AjouterMoyenDeTransport();				
				break;
			case 2:
				AjouterAvion();				
				break;
			case 3:
				ShowTarnsportmeans();			
				break;
			case 4:
				Avion.ShowTrasportmeans(TypeMoyen.AVI);				
				break;
			case 5:
				AjouterRoute();				
				break;
			case 6:
				AjouterPiste();				
				break;
			case 7:
				Route.ShowHals(CouloirType.Route);		
				break;
			case 8:
				Piste.ShowHals(CouloirType.Piste);				
				break;
			case 9:
				autoriseruntrasport();	
				break;
			case 10:
				autoriseruneAvion();		
				break;
			}
			if(Choice ==11)
				break;
			
		}
	}
	
	//
}

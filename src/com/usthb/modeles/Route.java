package com.usthb.modeles;

public class Route extends Couloir {
	
	private static int NS=0;
	private boolean IsIntersecting;
	
	
	
	public Route(boolean inter){
		super(CouloirType.Route);
		numero = "R"+(++NS);
		IsIntersecting = inter;
	
	}
	

	@Override
	public String toString() {
		String Temp="\nCette Route est occupé par :";
		for (int i =0;i<24;i++) {
			for (int y =0;y<60;y++) {
				if(OcupaiedBy[i][y]!= null)
				Temp = Temp+ "\n"+ String.valueOf(OcupaiedBy[i][y])+ " a " + i+"H : "+y+"M" ;
			}
		}
		return "Route: numero: " + numero + ", est en intersection avec une piste =" + IsIntersecting+Temp ;
	}
	
}

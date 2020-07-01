package com.usthb.modeles;
class Position{
	int x,y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	} 
public class PosteStationnement {
private static int NS = 0;
private Position Pos;
public String getNumero() {
	return numero;
}
private String numero;
private boolean IsInContact;
	PosteStationnement(){
		numero = "A" +(++NS); 
}
	public Position getPos() {
		return Pos;
	}
	public void setPos(Position pos) {
		Pos = pos;
	}
	public boolean isIsInContact() {
		return IsInContact;
	}
	public void setIsInContact(boolean isInContact) {
		IsInContact = isInContact;
	}
	
}

package org.arquivo;

import java.io.Serializable;

public class High implements Serializable{

	public String highScore;
	
	public High(String high){
		
		this.highScore = high;
		
	}
	
	public void setH(String score){
		
		highScore = score;
		
		
	}
	
}

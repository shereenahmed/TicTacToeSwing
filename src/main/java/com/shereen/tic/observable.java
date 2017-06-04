package com.shereen.tic;
import java.util.Observable;

import javax.swing.ImageIcon;

public class observable extends Observable{
	
	private String msg;
	
	public observable(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return msg;
	}
	
	public void setMsg(String msg){
		this.msg = msg;
		setChanged();
		notifyObservers();
	}
}


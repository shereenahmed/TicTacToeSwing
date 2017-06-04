package com.shereen.tic;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

public class observer implements Observer {

	private observable msgUpdate ;
    
	@Override
	public void update(Observable observable, Object arg) {
		msgUpdate = (observable) observable;
		JOptionPane.showMessageDialog(null, "Oh wow. bravo" + msgUpdate.getMsg());
		
	}

}

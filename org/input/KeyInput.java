package org.input;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInput implements KeyListener{

	public static int codigo;
	
	@Override
	public void keyPressed(KeyEvent e) {
		codigo = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

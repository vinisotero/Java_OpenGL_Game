package org.graphics;
import org.input.KeyInput;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
public class Renderer {	
	private static GLWindow window = null;
	public static void init(){
		GLProfile.initSingleton();
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps  = new GLCapabilities(profile);
		window = GLWindow.create(caps);
		window.setSize(640, 360);
		window.setResizable(true);
		window.addGLEventListener(new EventListener());
		window.setVisible(true);
		window.addKeyListener(new KeyInput());
		FPSAnimator animator = new FPSAnimator(window,60);
		animator.start();
	}

}

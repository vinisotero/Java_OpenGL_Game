package org.engine;

public class GameLoop {
	
	private static boolean running = false;
	
	public static Thread thread = new Thread(){
		
		public void run(){
			
			running = true;
			
			
		}
	
	};
	
	
	public static void start(){
		
		
		thread.setName("GameLoop");
		thread.start();
		
	}
}

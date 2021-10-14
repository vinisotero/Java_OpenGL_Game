package org.graphics;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.arquivo.Arquivo;
import org.arquivo.High;
import org.input.KeyInput;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.awt.TextRenderer;


public class EventListener implements GLEventListener{
	
	
	
	public static float x,xl,y,yl;
	public static ArrayList<Squares> list = new ArrayList<Squares>();
	public static int c = 0,d=0, a; //d = 0 -> right, d = 1 -> left, d= 2 -> up, d = 3 -> down
	public static int v = 0;
	public static boolean comeu = false;
	public static Random random;
	public static int n1, n2;
	private static int score = 0;
	private static boolean gameover = false;
	public static boolean readed = false;
	private static File file = new File("high_score.txt");
	private static Arquivo arq = new Arquivo();
	private static int high = 0;
	
	
	public void display(GLAutoDrawable drawable) {
		
		
		GL2 gll = drawable.getGL().getGL2();
		gll.glClear(GL2.GL_COLOR_BUFFER_BIT);
	
		TextRenderer textRenderer = new TextRenderer(new Font("Verdana", Font.BOLD, 12));
		textRenderer.beginRendering(900, 700);
		textRenderer.setColor(Color.YELLOW);
		textRenderer.setSmoothing(true);

		if(!file.exists()){
			
			arq.write(0, file);
			
			textRenderer.draw("Score: " + score, 50,10);
			textRenderer.draw("High Score: " + 0, 150, 10);
			
		}else{

			high = Integer.parseInt(arq.read(file));
			
			textRenderer.draw("Score: " + score, 50,10);
			textRenderer.draw("High Score: " + high, 150, 10);
			
		}
		
		
		textRenderer.endRendering();

		if(!gameover){
		
			if(KeyInput.codigo == 151){
				
				d = 0;
				
				
			}else if(KeyInput.codigo == 149){
				
				d = 1;
				
			}else if(KeyInput.codigo == 150){
				
				d = 2;
				
			}else if(KeyInput.codigo == 152){
				
				d = 3;
				
			}
			
	
			
			
			
			if(c==0){
				
				Squares sqr1 = new Squares(-19,-20,1,0);
				Squares sqr2 = new Squares(-18,-19,1,0);
				Squares sqr3 = new Squares(-17,-18,1,0);
				Squares sqr4 = new Squares(-16,-17,1,0);
				Squares sqr5 = new Squares(-15,-16,1,0);
				Squares sqr6 = new Squares(-14,-15,1,0);
				Squares sqr7 = new Squares(-13,-14,1,0);
				Squares sqr8 = new Squares(-12,-13,1,0);
				Squares sqr9 = new Squares(-11,-12,1,0);
				Squares sqr10 = new Squares(-10,-11,1,0);
				Squares sqr11= new Squares(-9,-10,1,0);
				Squares sqr12= new Squares(-8,-9,1,0);
				Squares sqr13= new Squares(-7,-8,1,0);
				Squares sqr14= new Squares(-6,-7,1,0);
				
				list.add(sqr1);
				list.add(sqr2);
				list.add(sqr3);
				list.add(sqr4);
				list.add(sqr5);
				list.add(sqr6);
				list.add(sqr7);
				list.add(sqr8);
				list.add(sqr9);
				list.add(sqr10);
				list.add(sqr11);
				list.add(sqr12);
				list.add(sqr13);
				list.add(sqr14);
	
				
				c++;
			}
			
			if(comeu){
				
				Squares crescimento, crescimento2, crescimento3;
				
				if(d == 0){
					
					crescimento = new Squares(list.get(list.size()-1).getX()+1,list.get(list.size()-1).getXL()+1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					crescimento2 = new Squares(list.get(list.size()-1).getX()+1,list.get(list.size()-1).getXL()+1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					crescimento3 = new Squares(list.get(list.size()-1).getX()+1,list.get(list.size()-1).getXL()+1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					
					list.add(crescimento);
					list.add(crescimento2);
					list.add(crescimento3);
					
					
				}else if(d == 1){
					
					crescimento = new Squares(list.get(list.size()-1).getX()-1,list.get(list.size()-1).getXL()-1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					crescimento2 = new Squares(list.get(list.size()-1).getX()-1,list.get(list.size()-1).getXL()-1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					crescimento3 = new Squares(list.get(list.size()-1).getX()-1,list.get(list.size()-1).getXL()-1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					
					list.add(crescimento);
					list.add(crescimento2);
					list.add(crescimento3);
					
				}else if(d == 2){
					
					crescimento = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()+1,list.get(list.size()-1).getYL()+1);
					crescimento2 = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()+1,list.get(list.size()-1).getYL()+1);
					crescimento3 = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()+1,list.get(list.size()-1).getYL()+1);
					
					list.add(crescimento);
					list.add(crescimento2);
					list.add(crescimento3);
					
				}else if(d == 3){
					
					crescimento = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()-1,list.get(list.size()-1).getYL()-1);
					crescimento2 = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()-1,list.get(list.size()-1).getYL()-1);
					crescimento3 = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()-1,list.get(list.size()-1).getYL()-1);
					
					list.add(crescimento);
					list.add(crescimento2);
					list.add(crescimento3);
					
				}
				
				random = new Random();
				
				int positivo = random.nextInt(2);
				
				if(positivo == 1){
					
					n1 = random.nextInt(90);
					
				}else{
					
					n1 = random.nextInt(90) * -1;
					
				}
				
				positivo = random.nextInt(2);
				
				if(positivo == 1){
					
					n2 = random.nextInt(90);
					
				}else{
					
					n2 = random.nextInt(90) * -1;
					
				}
				
				comeu = false;
				
				
			}else{
				
				if(c==0){
					
					random = new Random();
					int positivo = random.nextInt(2);
					
					if(positivo == 1){
						
						n1 = random.nextInt(90);
						
					}else{
						
						n1 = random.nextInt(90) * -1;
						
					}
					
					
					positivo = random.nextInt(90);
					
					if(positivo == 1){
						
						n2 = random.nextInt(90);
						
					}else{
						
						n2 = random.nextInt(90) * -1;
						
					}
					
				}
			
				
			}
			
			gll.glBegin(GL2.GL_QUADS);
			
				gll.glColor3f(1, 0, 0);
				gll.glVertex2f(n1,n2);
				gll.glVertex2f(n1-3,n2);
				gll.glVertex2f(n1,n2-3);
				gll.glVertex2f(n1-3, n2-3);	
			
			gll.glEnd();
			
			if(list.get(list.size() -1).getX() <= n1 && list.get(list.size() -1).getX() >= (n1-3) && list.get(list.size() -1).getY() <= n2 && list.get(list.size() -1).getY() > (n2-3)){

				comeu = true;
				score++;
				
			}
			
			gll.glColor3f(0,1,0);
			
			if(d == 0){
				if(a!= 1){
				a = 0;
					gll.glBegin(GL2.GL_QUADS);
					for(int i = 0; i < list.size(); i++){
						
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getY());
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getY());			
						
					}
					gll.glEnd();
					
					Squares sqr = new Squares(list.get(list.size()-1).getX() +1,list.get(list.size()-1).getXL()+1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					list.add(sqr);
					list.remove(list.get(0));
				}else{
					
					gll.glBegin(GL2.GL_QUADS);
					for(int i = 0; i < list.size(); i++){
						
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getY());
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getY());			
						
					}
					gll.glEnd();
					
					Squares sqr = new Squares(list.get(list.size()-1).getX() -1 ,list.get(list.size()-1).getXL() - 1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					list.add(sqr);
					list.remove(list.get(0));
					
					
				}
				
			}else if(d == 1){
				
				if(a != 0){
					a = 1;
					
					gll.glBegin(GL2.GL_QUADS);
					for(int i = 0; i < list.size(); i++){
						
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getY());
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getY());			
						
					}
					gll.glEnd();
					
					Squares sqr = new Squares(list.get(list.size()-1).getX() -1 ,list.get(list.size()-1).getXL() - 1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					list.add(sqr);
					list.remove(list.get(0));
					
					
				}else{
					
					gll.glBegin(GL2.GL_QUADS);
					for(int i = 0; i < list.size(); i++){
						
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getY());
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getY());			
						
					}
					gll.glEnd();
					
					Squares sqr = new Squares(list.get(list.size()-1).getX() +1,list.get(list.size()-1).getXL()+1,list.get(list.size()-1).getY(),list.get(list.size()-1).getYL());
					list.add(sqr);
					list.remove(list.get(0));
					
				}
				
			}else
				if(d == 2){
				
					if(a != 3){
						a = 2;
						
						gll.glBegin(GL2.GL_QUADS);
						for(int i = 0; i < list.size(); i++){
							
								gll.glVertex2f(list.get(i).getXL(),list.get(i).getY());
								gll.glVertex2f(list.get(i).getXL(),list.get(i).getYL());
								gll.glVertex2f(list.get(i).getX(),list.get(i).getYL());
								gll.glVertex2f(list.get(i).getX(),list.get(i).getY());			
							
						}
						gll.glEnd();
						
						Squares sqr = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()+1,list.get(list.size()-1).getYL()+1);
						list.add(sqr);
						list.remove(list.get(0));
					
					
				}else{
					
					gll.glBegin(GL2.GL_QUADS);
					for(int i = 0; i < list.size(); i++){
						
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getY());
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getY());			
						
					}
					gll.glEnd();
					
					Squares sqr = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()-1,list.get(list.size()-1).getYL()-1);
					list.add(sqr);
					list.remove(list.get(0));
					
				}
				
			}else if(d == 3){
				
				if(a != 2){
					a = 3;
					
					gll.glBegin(GL2.GL_QUADS);
					for(int i = 0; i < list.size(); i++){
						
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getY());
							gll.glVertex2f(list.get(i).getXL(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getYL());
							gll.glVertex2f(list.get(i).getX(),list.get(i).getY());			
						
				}
					gll.glEnd();
					
					Squares sqr = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()-1,list.get(list.size()-1).getYL()-1);
					list.add(sqr);
					list.remove(list.get(0));
					
					
			}else{
				
				gll.glBegin(GL2.GL_QUADS);
				for(int i = 0; i < list.size(); i++){
					
						gll.glVertex2f(list.get(i).getXL(),list.get(i).getY());
						gll.glVertex2f(list.get(i).getXL(),list.get(i).getYL());
						gll.glVertex2f(list.get(i).getX(),list.get(i).getYL());
						gll.glVertex2f(list.get(i).getX(),list.get(i).getY());			
					
				}
				gll.glEnd();
				
				Squares sqr = new Squares(list.get(list.size()-1).getX(),list.get(list.size()-1).getXL(),list.get(list.size()-1).getY()+1,list.get(list.size()-1).getYL()+1);
				list.add(sqr);
				list.remove(list.get(0));
				
				
			}
				
			
			
			}
			
			if(list.get(list.size()-1).getX() >= 100 || list.get(list.size()-1).getX() <= -100){
				
				gameover = true;
				
			}
			
			if(list.get(list.size()-1).getY() >= 100 || list.get(list.size()-1).getYL() <= -100){
				
				gameover = true;
			}
			
			
			if(!gameover && v != 0){
				this.death(list.get(list.size()-1));
			
				v++;
			}
			
			if(KeyInput.codigo == 32){
				
				KeyInput.codigo = 151;
				gameover = false;
				
			}
		
		}else{
			
			gll.glClear(GL2.GL_COLOR_BUFFER_BIT);
			
			list.clear();
			
			
			if(!readed){
				
				readed = true;

			    int x = high;
				if(score > x){
					arq.write(score,file);
				}

			}else{		
				textRenderer.beginRendering(200, 200);
				textRenderer.setColor(Color.YELLOW);
				textRenderer.setSmoothing(true);

				textRenderer.draw("GAME OVER ",5, 130);
				textRenderer.draw("Your Score: " + score, 5, 100);
				textRenderer.draw("High Score: " + high, 5, 70);
				textRenderer.draw("Press space to play again",5, 40);
				
				textRenderer.endRendering();
				
				
				if(KeyInput.codigo == 32){
					
					
					gameover = false;
					readed = false;
					
					
					
					
					Squares sqr1 = new Squares(-19,-20,1,0);
					Squares sqr2 = new Squares(-18,-19,1,0);
					Squares sqr3 = new Squares(-17,-18,1,0);
					Squares sqr4 = new Squares(-16,-17,1,0);
					Squares sqr5 = new Squares(-15,-16,1,0);
					Squares sqr6 = new Squares(-14,-15,1,0);
					Squares sqr7 = new Squares(-13,-14,1,0);
					Squares sqr8 = new Squares(-12,-13,1,0);
					Squares sqr9 = new Squares(-11,-12,1,0);
					Squares sqr10 = new Squares(-10,-11,1,0);
					Squares sqr11= new Squares(-9,-10,1,0);
					Squares sqr12= new Squares(-8,-9,1,0);
					Squares sqr13= new Squares(-7,-8,1,0);
					Squares sqr14= new Squares(-6,-7,1,0);
					
					list.add(sqr1);
					list.add(sqr2);
					list.add(sqr3);
					list.add(sqr4);
					list.add(sqr5);
					list.add(sqr6);
					list.add(sqr7);
					list.add(sqr8);
					list.add(sqr9);
					list.add(sqr10);
					list.add(sqr11);
					list.add(sqr12);
					list.add(sqr13);
					list.add(sqr14);
					
					KeyInput.codigo = 151;
					
					score = 0;
					v= 0;
					d = 0; 	 	
					
				}
				
			}

		}

		
	}
	
	public boolean searchObject(Squares actualSqr){
		
		for(Squares sqr: list){
			
			if(sqr.equals(actualSqr)){
				continue;
			}
			
			if(actualSqr.getX() == sqr.getX() && actualSqr.getXL() == sqr.getXL() && actualSqr.getY() == sqr.getY() && actualSqr.getYL() == sqr.getYL()){
				return true;
			}
		}
		
		return false;
		
	}
	
	public void death(Squares actualSqr){
	
		if(this.searchObject(actualSqr)){
			
			gameover = true;
			
		}
		
	}
	

	@Override
	public void dispose(GLAutoDrawable drawable) {
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0,0,0,1);
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(-100,100,-100,100,-1,1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		
	}

}

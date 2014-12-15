import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class ZonaRisunka extends Canvas implements Runnable {
	
	private int step = 0;
	private int boxWidth = step;
	private int sec = 0;
	private int sleepSeconds = 1;
	private int secondsInALap = 10;
	private int alarmPeriod = 5;
	private boolean justStarted = true;
	
	// PAINT
	public void paint(Graphics g) {
		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		if(justStarted == false) { 
			for(int i = 0; i < sec + 2; i++) {
				drawFilling(g,	i * step);
			}
		}
		
		if(justStarted == false) { 
			for(int i = 0; i < sec + 2; i++) {
				drawPerimeter(g, i * step);
			}
		}
		
		if(boxWidth >= secondsInALap * step) boxWidth = 0; 
	}
	
	
	// ALL progress bar becomes red at the end of the lap
	public void drawFilling(Graphics g, int tick) {
		//System.out.println("Tick = " + tick);
		
		g.setColor(Color.ORANGE);
		g.fillRect(20, 100, tick, 50);
		
		if (sec > (secondsInALap - alarmPeriod)) {
			g.setColor(Color.RED);
			g.fillRect(20, 100, tick, 50);
			
		}
		
	}
	
	// just the LAST alarming seconds are red
	public void drawFilling2(Graphics g, int tick) {
		//System.out.println("Tick = " + tick);
	
		g.setColor(Color.ORANGE);
		g.fillRect(20, 100, tick, 50);
		
		if (sec > (secondsInALap - alarmPeriod)) {
			g.setColor(Color.RED);
			g.fillRect(20, 100, tick, 50);
			g.setColor(Color.ORANGE);
			g.fillRect(20, 100, (secondsInALap - alarmPeriod) * step , 50);
			
		}
		
	}
	
	// Draw Segment lines
	public void drawPerimeter(Graphics g, int tick) {
		
		g.setColor(Color.BLACK);
		g.drawRect(20, 100, tick, 50);
	
	}
	
	// RUN
	public void run() {
			step = 10;
			
		while(true) {
			repaint();
			
			// Timer
		
			try{
				Thread.currentThread();
				Thread.sleep(sleepSeconds * 1000);
			}catch(Exception e ){
				e.printStackTrace();
			}
			
			justStarted = false;
			
			sec = boxWidth / step ;    // 1 2 3 4 5 6 7 
			System.out.println("Timer check = " + (sec + 1) );
			boxWidth += step;
			}
			
	}
}

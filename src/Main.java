import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/*

THIS IS STARCRAFT 2 MACRO TIMER. 

MAIN QUESTION:
*** Q:  Will it be possible to port Java program into iPhone app? 

TASKS: 
1) Add a button "Synchronize"  to get to the start of the cycle. 
	a) think about adding a message of sound "SCV, Macromechanic, Supply, Production"

2) Add a timer for expansion times (5 min, 10 min, 15 min, 20 min). E.g. Increments once every 5 sec, Flashes RED for 20 sec. 
	a) Add times for when to add production buildings. (e.g. 7 min, 12 min, 17 min, 22 min) 
	b) Add times for when to add upgrade building and start upgrades.

3) Add a timer for key scouting times ( 8 min... 12 min...) 
4) ADD SOUND played from file when Alarm time comes 

GOAL 1: Allow player to see when the macro cycle is about to expire and he needs to 
	- Order SCVs / Drones / Probes
	- Call down Mules / Inject / Chronoboost 
	
	 /  2 supply structures also queued here /  Production queue
	  
	DONE: WITH TURNING PROGRESS BAR TO RED.       
	NEXT STEP IS TO ADD SOUND

GOAL 2: Allow player to see when default expansion time is coming. 
	Expansion times are  _customizable_.   (Button: Settings > opens new JPanel (or paints over Canvas) > 4 Textfields
	For Example the default may be for terran mech: 
	- Fast CC on 3:45
	- 2nd Expo on 8:00
	- Max out by 14 minutes, move out
	- 3rd Expo on 14:30, behind the push


GOAL 3: Customizable upgrade notificator
	Customizable saturation notificator (e.g. 1 minute after CC is started)
	Customizable production increase notificator (e.g. 2 minutes after CC was started

GOAL 4: The timer should be largely build-independent (except for expo timings) and cover all general play over 20-25 minutes 
	with taking all expos, maxing out upgrades and transitioning into late game units (e.g.) BCs in the end. 


Key principles:
1) Alert player in a way that allows him to prepare for action. 
e.g. Order SCVs in 3,2,1 NOW !

2) 45-second macro cycle. 
Means we order 3 SCVs every 45 sec
and call mules every 45 sec.

Or inject and order drones 
Inject has to be SPOT on! 

What happens if player misses or delays a cycle? 
There should be a button to restart a cycle (or move insta-jump to the next cycle)

The timer should be initialize on 2nd SCV.
After you can reset it when u call down first mule (first inject). 
the SCV timer then would be a separate one. 

The timer is primarily visual, shows a progress bar. 5 sec before it is complete, it gives an alert (inject larva in 3 - 2 - 1 - NOW! ) 





 */



public class Main{

	
	public static void main(String[] args) {
			
		// CREATE JFrame
		Window window = new Window(800, 600, "Starcraft 2 Macro Timer");
		
		// CREATE a CANVAS  and specify in its paint() method what to paint
		ZonaRisunka zona = new ZonaRisunka();	
		
		// ADD Canvas to JFrame
		window.add(zona);
		
		// RUN the Canvas which acts as a Thread because it implements Runnable interface
		zona.run();
		
	}
}
	
	
	


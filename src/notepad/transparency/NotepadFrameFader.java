package notepad.transparency;

import notepad.NotepadFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotepadFrameFader {

	//timer utility from jframe
	//
	private NotepadFrame notepadFrame;
	private Timer timer;// keeps track of the time when a component is fading
	private float current;
	private float increment;
	private int interval;
	
	public NotepadFrameFader(NotepadFrame notepadFrame, float increment, int interval) {
		this.notepadFrame = notepadFrame;
		this.increment = increment;
		this.interval = interval;
	}
	
	public void setTargetOpacity(float target0) {
		if (timer != null) timer.stop();
		
		current = notepadFrame.getOpacity();
		float change= 0;
		if (target0 > current) {
			change = 1;
			
			}
		else {
			change = -1;
		}

		increment = Math.abs(increment) * change;

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current = notepadFrame.getOpacity();
				float newOpacity = current + increment;
				newOpacity = Math.min(1f, newOpacity);
				newOpacity = Math.max(0f, newOpacity);
				notepadFrame.setOpacity(newOpacity);
			 
				if(Math.abs(notepadFrame.getOpacity() - target0) <= .05 || notepadFrame.getOpacity() >= 1){
					timer.stop();
				}
			}
		};
		
		timer = new Timer(interval,actionListener);
		
		timer.start();
		
	}
}

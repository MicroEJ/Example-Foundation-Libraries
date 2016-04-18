package ej.examples.foundation.microui.mvc;

import ej.microui.event.controller.DispatchEventHandler;
import ej.microui.event.generator.Command;
import ej.microui.event.generator.Pointer;

public class MVCController extends DispatchEventHandler {

	private static final int MINIMUM_SIZE = 20;
	private static final int TOLERANCE = 10;
	
	private final MVCDisplayable displayable;
	private final PercentageModel percentage;
	
	private boolean pressed;
	
	public MVCController(MVCDisplayable displayable, PercentageModel percentage) {
		this.displayable = displayable;
		this.percentage = percentage;
	}

	@Override
	public boolean onCommand(int command) {
		
		switch(command) {
		case Command.UP:
			//command up -> increment model value
			percentage.incrementValue();
			break;
		case Command.DOWN:
			//command down -> decrement model value
			percentage.decrementValue();
			break;
		case Command.LEFT:
			//command left -> page decrement model value
			percentage.pageDecrementValue();
			break;
		case Command.RIGHT:
			//command right -> page increment model value
			percentage.pageIncrementValue();
			break;
		default:
			//other commands -> random model value
			percentage.random();
		}
		
		return false;
	}
	
	
	@Override
	public boolean onPointerPressed(Pointer pointer, int pointerX,
			int pointerY, int event) {
		//check pointer is over the cross (plus or minus TOLERANCE)
		int px = pointer.getX();
		int py = pointer.getY();
		if(over(px, py, displayable.getCrossX(), displayable.getCrossY())) {
			pressed = true;
		}
		return true;
	}
	
	@Override
	public boolean onPointerReleased(Pointer pointer, int pointerX,
			int pointerY, int event) {
		pressed = false;
		return true;
	}
	
	@Override
	public boolean onPointerDragged(Pointer pointer, int pointerX,
			int pointerY, int event) {

		if (!pressed) {
			return false;
		}
		
		//use locals
		int displayWidth = pointer.getWidth();
		int displayHeight = pointer.getHeight();
		int px = pointer.getX();
		int py = pointer.getY();

		//crop to a minimum size
		if(px < MINIMUM_SIZE) px = MINIMUM_SIZE;
		else if(px > displayWidth - MINIMUM_SIZE) px = displayWidth - MINIMUM_SIZE;
		if(py < MINIMUM_SIZE) py = MINIMUM_SIZE;
		else if(py > displayHeight - MINIMUM_SIZE) py = displayHeight - MINIMUM_SIZE;

		//set cross coordinates
		displayable.updateViews(px, py);
		return true;
	}
	
	private boolean over(int px, int py, int x, int y) {
		return(px >= x - TOLERANCE && px <= x + TOLERANCE
		&& py >= y - TOLERANCE && py <= y + TOLERANCE);
	}
}

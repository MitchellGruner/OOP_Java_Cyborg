package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;

public class Game extends Form {
	
	GameWorld gw;
	boolean flag = false;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	private void play() {
	
		Label myLabel = new Label("Enter a Command:"); 
		this.addComponent(myLabel);
		
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
	
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
	
				if (flag) {
					switch(sCommand.charAt(0)) {
						case 'y':
							System.exit(0);
							break;
							
						default:
							flag = false;
							break;
					}
				} else {
				
				switch (sCommand.charAt(0)){
					case 'a':
						gw.addAsteroid();
						break;
				
					case 'b':
						gw.addBlinkingSpaceStation();
						break;
						
					case 's':
						gw.addShip();
						break;
						
					case 'i':
						gw.increaseSpeedOfShip();
						break;
						
					case 'd':
						gw.decreaseSpeedOfShip();
						break;
						
					case 'l':
						gw.turnShipLeft();
						break;
						
					case 'r':
						gw.turnShipRight();
						break;
						
					case 'f':
						gw.fireShipMissile();
						break;
						
					case 'j':
						gw.jumpHyperSpace();
						break;
						
					case 'n':
						gw.loadNewMissiles();
						break;
						
					case 'k':
						gw.killAsteroid();
						break;
						
					case 'c':
						gw.shipCrashed();
						break;
						
					case 'x':
						gw.exterminate();
						break;
						
					case 't':
						gw.gameClockTicked();
						break;
						
					case 'p':
						gw.printDisplay();
						break;
						
					case 'm':
						gw.printMap();
						break;
						
					case 'q':
						flag = true;
						System.out.println("Are you sure you want to quit? ");
						break;
						
					default:
						System.out.println("Invalid input");
						//add code to handle rest of the commands
				}} //switch
			} //actionPerformed
		} //new ActionListener()
		); //addActionListener
	} //play
}

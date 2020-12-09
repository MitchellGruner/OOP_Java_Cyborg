package com.mycompany.a1;

import java.util.ArrayList;

public class GameWorld {

	// World dimensions
	private final static double sizeX = 1024.0;
	private final static double sizeY = 768.0;
	
	// Starting of game
	private int lives = 3;
	private int score = 0;
	private int time = 0;
	
	// Initially, there will be one (and only one) ship created in the gameWorld
	private Ships ship;
	
	// ArrayList will hold all of our gameObjects
	private ArrayList<GameObject> gameArray = new ArrayList<GameObject>();
	
	int counter = 1;
	
	public double getSizeX() {
		return sizeX;
	}
	
	public double getSizeY() {
		return sizeY;
	}
	
	public int getScore() { return score; }
	public void setScore(int score) { this.score = score; }
	
	public void init() {
		ship = new Ships(sizeX,sizeY);
		gameArray.add(ship);
	}
	
	// Method will add an asteroid to the gameWorld
	public void addAsteroid() {
		gameArray.add(new Asteroids());
		System.out.println("Asteroid has been added to the game world...");
	}
	
	// Method will add a blinking space station to the gameWorld
	public void addBlinkingSpaceStation() {
		gameArray.add(new SpaceStation());
		System.out.println("Blinking station has been added to the game world...");
	}
	
	// Method will check if ship is an instanceof Ships, if not, the gameArray will add a ship to the gameWorld
	public void addShip() {
			
//			for(int i = 0; i < gameArray.size(); i++) {
//				
//				boolean flag = false;
//				if(gameArray.get(i) instanceof Ships) {
//					System.out.println("Already ship in the game world, therefore no ship added...");
//					flag = true;
//					
//					if(flag) {
//						break;
//					}
//				} else {
//					ship = new Ships(sizeX, sizeY);
//					gameArray.add(ship);
//					System.out.println("Ship has been added to the game world...");
//					break;
//				}
//			}
		
		if(counter % 2 == 0) {
			ship = new Ships(sizeX,sizeY);	
			gameArray.add(ship);
			System.out.println("Ship has been added to the game world...");
			counter = 1;
		} else {
			System.out.println("There is already a ship in the game world...");
		}
	}
	
	// Method will add a speed of one to the only ship in the gameWorld
	public void increaseSpeedOfShip() {
		if(ship instanceof Ships) {
			ship.accelerateShip(1);
			System.out.println("Ship has increased speed to: " + ship.getSpeed());
		} else {
			System.out.println("There is no ship");
		}
	}
	
	// Method will subtract a speed of one to the only ship in the gameWorld
	public void decreaseSpeedOfShip() {
		if(ship instanceof Ships) {
			ship.decelerateShip(1);
			System.out.println("Ship has decreased speed to: " + ship.getSpeed());
		} else {
			System.out.println("There is no ship");
		}
	}
	
	// Method will cause the ship to turn left by a small amount
	public void turnShipLeft() {
		if(ship instanceof Ships) {
			ship.turnLeft(5);
			System.out.println("Ship has turned left; new degrees is: " + ship.getDirection());
		} else {
			System.out.println("There is no ship");
		}
	}
	
	// Method will cause the ship to turn right by a small amount
	public void turnShipRight() {
		if(ship instanceof Ships) {
			ship.turnRight(5);
			System.out.println("Ship has turned right; new degrees is " + ship.getDirection());
		} else {
			System.out.println("There is no ship");
		}
	}
	
	// Method will fire a missile (if there is one) out from the front of the ship, and set that missile's properties directly with the ship's.
	public void fireShipMissile() {
		if(ship instanceof Ships) {
			
			int missileCount = ship.getMissileCount();
			
			if(missileCount > 0) {
				Missiles missile = new Missiles(ship.getDirection(),ship.getX(),ship.getY());
				
				missile.setDirection(ship.getDirection());
				missile.setSpeed(ship.getSpeed());
				missile.setX(ship.getX());
				missile.setY(ship.getY());
				
				gameArray.add(missile);
				
				int finalMissileCount = ship.getMissileCount() - 1;
				ship.setMissileCount(finalMissileCount);
				
				System.out.println("Ship has fired missile; ship missile count: " + finalMissileCount);
			} else {
				System.out.println("No more missiles!");
			}
		}
	}
	
	// Method will jump player ship to center of the map (512.0, 384.0)
	public void jumpHyperSpace() {
		if(ship instanceof Ships) {
			ship.setX(512.0);
			ship.setY(384.0);
			System.out.println("Ship is now at coordinates: " + ship.getX() + ", " + ship.getY());
		}
	}
	
	// Method will setMissileCount, regardless of previous number, to the maximum number (10)
	public void loadNewMissiles() {
		if(ship instanceof Ships) {
			ship.setMissileCount(10);
			System.out.println("Ship has new missiles loaded; ship missile count: " + ship.getMissileCount());
		} else {
			System.out.println("There is no ship");
		}
	}
	
	// If both missiles and asteroids exist, it will be removed from the game world
	public void killAsteroid() {
		boolean missile = false;
		boolean asteroid = false;
		int missileIndex = 0;
		int asteroidIndex = 0;
		
		for(int i = 0; i < gameArray.size(); i++) {
			if(gameArray.get(i) instanceof Missiles) {
				missile = true;
				missileIndex = i;
			} else if(gameArray.get(i) instanceof Asteroids) {
				asteroid = true;
				asteroidIndex = i;
			}
			
			if(missile && asteroid) {
				break;
			}
		}
		
		if(missile && asteroid) {
			score += 125;
			System.out.println("Success! Score is now: " + score);

			if(missileIndex < asteroidIndex) {
				gameArray.remove(asteroidIndex);
				gameArray.remove(missileIndex);
			} else if (missileIndex > asteroidIndex) {
				gameArray.remove(missileIndex);
				gameArray.remove(asteroidIndex);
			}
		} else {
			System.out.println("'Kill' not performed.  ERROR.  Must have both an asteroid and a missile in gameWorld");
		}
	}
	
	public void shipCrashed() {
		
		if(ship instanceof Ships) {
			
			boolean ship = false;
			boolean asteroid = false;
			int shipIndex = 0;
			int asteroidIndex = 0;
		
			for(int i = 0; i < gameArray.size(); i++) {
			
				if(gameArray.get(i) instanceof Ships) {
					ship = true;
					shipIndex = i;
				} else if (gameArray.get(i) instanceof Asteroids) {
					asteroid = true;
					asteroidIndex = i;
				}
			
				if(ship && asteroid) {
					break;
				}
			}
		
			if(ship && asteroid) {
			
				if(lives > 0) {
				
					lives -= 1;
					System.out.println("Ship crashed! Lives left: " + lives);
					
					if(shipIndex < asteroidIndex) {
						gameArray.remove(asteroidIndex);
						gameArray.remove(shipIndex);
						counter = 2;
					} else if (shipIndex > asteroidIndex) {
						gameArray.remove(shipIndex);
						gameArray.remove(asteroidIndex);
						counter = 2;
					}
				} else {
					System.out.println("Game over!");
				}
			}
		} else {
			System.out.println("There is no ship in the gameWorld");
		}
	}
	
	public void exterminate() {
		
		int asteroid1Index = 0;
		int asteroid2Index = 0;
		int count = 0;
		
		for(int i = 0; i < gameArray.size(); i++) {
			
			if(gameArray.get(i) instanceof Asteroids) {
				count++;
				
				if(count == 1) {
					asteroid1Index = i;
				} else if (count == 2) {
					asteroid2Index = i;
					break;
				} else {
					break;
				}
			}
		}
		
		if(count == 2) {
			gameArray.remove(asteroid2Index);
			gameArray.remove(asteroid1Index);
			System.out.println("Two asteroids have been exterminated!");
		} else {
			System.out.println("ERROR!  Two asteroids in the gameWorld do not exist");
		}
	}
	
	public void gameClockTicked() {
		time++;
		System.out.println("Game clock has ticked; time is now: " + time);
		// all moveable objects are told to update their positions according to their current direction and speed;
		for(int i = gameArray.size() - 1; i >= 0; i--) {
			if(gameArray.get(i) instanceof IMoveable) {
				IMoveable moveable = (IMoveable) gameArray.get(i);
				moveable.move();
			}
			
        //every missevel is reduced by one and any missiles which are now out of fuel are removed from the game
			if(gameArray.get(i) instanceof Missiles) {
				Missiles missle = (Missiles) gameArray.get(i);
			
				int currentFuelLevel = missle.getFuelLevel();
				if(currentFuelLevel > 0) {
					currentFuelLevel -= 1;
					missle.setFuelLevel(currentFuelLevel);
				} else {
					missle = null;
					gameArray.remove(i);
				}
			}
		
		// each space station toggles its blinking light if the tick count modulo the stlink rate is zero
			if(gameArray.get(i) instanceof SpaceStation) {
				SpaceStation spaceStation = (SpaceStation) gameArray.get(i);
			
				if((time % spaceStation.getBlinkRate()) == 0) {
					if(spaceStation.getLightOn()) {
						spaceStation.setLightOn(false);
					} else {
						spaceStation.setLightOn(true);
					}
				}
			}
		}
	}
	
	public void printDisplay() {
		System.out.println("Score=" + score + "; Missiles=" + ship.getMissileCount() + "; time=" + time);
	}
	
	public void printMap() {
		
		for(int i = 0; i < gameArray.size(); i++) {
			System.out.println(gameArray.get(i));
		}
	}
	
	public void quitGame() {
		
		System.out.println("Are you sure you want to quit game?");
		System.exit(0);
	}
}

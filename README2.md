# Extra Points Power-Up

## Overview
The Tiger Game currently has three power-ups and each one contirbutes uique gameplay.  Invincibility allows players to navigate through obstacles without losing, extra life allows players withstand one obstacle, and double-jump which allows players to jump twice before landing on the ground.  I want to introduce another power-up, one that has a fresh and distinctive power that alters the game dynamic.  I plan on including a power-up to the game that will grant the players extra points while they play.  This new power-up is designed to enhance the competitive aspect of the game by allowing players to accumulate points more rapidly, thereby facilitating the pursuit of higher scores.

## Pseudocode
### PowerUpType.java
``` Java
# Define a new PowerUpType
# Have it return a String of it's name
```
### PowerUp.java
```Java
# Modify randomizePowerUp function to add in the new power-up
# Increasing the number range of the random number generator
# If(randNum equals 4)
  # Then powerImage equals the image for the new power-up
  # Also powerType equals the PowerUpType.(new power-up name)
```
### Player.java
```Java
# Add a new Timer variable for the new power-up
# In Player function
  # Set a the timer of new power up to new Timer(1000, this) 
# In actionPerformed function
  # if(e.getSource() equals timer of new power-up)
    # Stop timer
    # Remove image of power-up
# In isCollided(with power-ups)
  # if(the player collided with new power-up)
    # Add that amount of points to the player's score
    # Show how much points player earned under the current score
```
### PlayerManualPane.java
```Java
#Edit image to show the information on what the new power-up does
```

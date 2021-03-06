/**
 * SYST 17796 Project Winter 2019 Base code.
 * Kiranpreet Kaur, Roopminder Kaur, Nasreen, Gurtej Singh
 * 11 February 2020
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */
public abstract class Player 
{
    private String playerID; //The Player iD gives the Identity to players
    private String GameName; //The name of the game
    /**
     * A constructor that allows you to set the player's unique ID
     */
    public Player(String name)
    {
        playerID= name;
    }
   //getters and setters for the PlayerID

    public String getGameName() {
        return GameName;
    }
    
    public String getPlayerID() 
    {
        return playerID;
    }
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();
    
}


package com.gamingroom;

import java.util.ArrayList;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	//creates array list for teams
	private ArrayList<Team> teams;
	


	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
		
		
	}
	/**
	 * method to add team, which iterates through defined array
	 * to find matches for the submitted name. if no match
	 * is found, a new team is created and added to the array
	 * ensuring only one team of this unique name exists
	 */
	public Team addTeam(String name) {
		 
		Team teamName = null;
	        
	    for (Team t:teams) {
	    	if (t.getName().equals(name)) {
				teamName = t;
				break;
			}
	        
		}
	    
	    if (teamName == null) {
			teamName = new Team(GameService.getInstance().getNextTeamId(), name);
			teams.add(teamName);
		}
	    return teamName;
    }

	//overridden method to return game information
	@Override
	public String toString() {
		
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}

}

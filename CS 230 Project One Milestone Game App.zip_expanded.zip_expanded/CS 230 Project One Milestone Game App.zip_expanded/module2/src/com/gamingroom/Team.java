package com.gamingroom;

import java.util.ArrayList;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	//creates array list for players
	private ArrayList<Player> players;
	
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
		
	}
	
	/**
	 * method to add player to the defined array. Iterates
	 * through the array to find a match for the submitted name
	 * and, if not found, creates a new player and adds the name to the array
	 * ensuring only one player of this name exists
	 */
	public Player addPlayer(String name) {
		
		Player playerName = null;
		
		for (Player p:players) {
			if (p.getName().equals(name)) {
				playerName = p;
				break;
			}
		}
		
		if (playerName == null) {
			Player player = new Player(GameService.getInstance().getNextPlayerId(), name);
			players.add(player);
	
	}

	//overridden method to return team's informtion
	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}

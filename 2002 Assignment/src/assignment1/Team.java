package assignment1;

import java.util.*;

/**
 * A class representing a Team made of a Set of Characters.
 *
 * @author Dr Phil
 * @author Dr-to-be Doug
 * @version (6/9/2017)
 */
public class Team {
	/** The name of the team */
	protected String name;
	/** The set of member of the team */
	protected Set<Character> members;

	/*
	 * Invariants:
	 * 
	 * name != null && !name.isEmpty()
	 * members != null && !members.contains(null) && !members.get(i).isEmpty()
	 */
	
	/**
	 * Creates a new Team with the given name.
	 * <p>
	 * A team is initially created with no members
	 * (empty set of members).
	 * 
	 * @param n Name of the team.
	 */
	public Team(String n) {
		name = n;
		members = new HashSet<Character>();
	}

	/**
	 * @return The name of the team.
	 */
	public String getName() { return name; }
	
	/**
	 * Add a member (Character) to the team.
	 * 
	 * @param c The character member to add.
	 * @see Character
	 */
	public void addMember(Character c) {
		members.add(c); 
	}
	
	/**
	 * Add a member (Character) to the team.
	 * 
	 * @param c The character member to add.
	 * @see Character
	 */
	public void removeMember(Character c) {
		members.remove(c); 
	}

	/**
	 * Returns the sum total of all the team members' individual power
	 * rankings. 
	 * <p>
	 * only super-people contribute to a team's power ranking. Ordinary 
	 * characters count as 0 with regard to the team's ranking.
	 * <p>
	 * If a member of them is either UNRANKABLE or INVALID (i.e. Super-Character's
	 * power ranking not in the range [1..10]), then  the team's power ranking is
	 * also UNRANKABLE or INVALID respectively.
	 * 
	 * @return The team's power ranking.
	 */
	public int powerRanking() {
		int sum = 0;
		for (Character c : members)
			if (c instanceof SuperCharacter) {
				int p = ((SuperCharacter) c).getPowerRanking();
				if (p == SuperCharacter.UNRANKABLE || p == SuperCharacter.INVALID)
					return p;
				else
					sum = sum + p;
			}

		return sum;
	}
		
	@Override
	public String toString() {
		return name + ":" + powerRanking() + "\n" + members;
	}
}

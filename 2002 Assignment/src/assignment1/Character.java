package assignment1;

import java.io.Serializable;
import java.util.*;

/**
 * A class representing a Character with name, 
 * description, and a set of traits.
 *
 * @author Dr Phil
 * @author Dr-to-be Doug
 * @version (6/9/2017)
 */
public class Character implements Serializable{
	/** Character's name */
	protected String name;
	/** Character's description */
	protected String description;
	/** A set of character's traits */
	protected Set<String> traits;

	/*
	 * Invariants:
	 * 
	 * name != null && !name.isEmpty()
	 * description != null
	 * traits != null && !traits.contains(null) && !traits.get(i).isEmpty()
	 */
	
	/**
	 * Creates a new Character with the given name,
	 * and empty description. 
	 * <p>
	 * Characters are initially created with a empty 
	 * set of traits, to add traits to a Character use
	 * the addTrait() method.
	 * 
	 * @param n The character's name.
	 */
	public Character(String n) {
		name = n;
		description = "";
		traits = new HashSet<String>();
	}

	/**
	 * Creates a new Character with the given name
	 * and description.
	 * <p>
	 * Characters are initially created with a empty 
	 * set of traits, to add traits to a Character use
	 * the addTrait() method.
	 * 
	 * @param n The character's name.
	 * @param d The character's description.
	 */
	public Character(String n, String d) {
		this(n);
		description = d;
	}

	/**
	 * @return The Character's name.
	 */
	public String getName() { return name; }
	
	/**
	 * @return The character's description.
	 */
	public String getDescription() { return description; }

	/**
	 * Set the Character's name.
	 * 
	 * @param n Character's name as a String.
	 */
	public void setName(String n) { 
		name = n; 
	}
	
	/**
	 * Set the Character's description.
	 * 
	 * @param d Character's description as a String.
	 */
	public void setDescription(String d) { 
		description = d; 
	}

	/**
	 * Add a trait to the Character's set of traits.
	 * 
	 * @param t The character's trait to add.
	 */
	public void addTrait(String t) {
		traits.add(t); 
	}
	
	/**
	 * Remove a trait from the Character's set of traits.
	 */
	public void removeTrait(String t) {
		traits.remove(t); 
	}

	@Override
    public String toString() {
        String s = name + "\n" + description + "\n\n" + "Traits:\n" + traits;
        return s;
    }

	@Override
	public boolean equals(Object other) {
		try {
			Character c = (Character) other;
			return name.equals(c.getName());
		}
		catch (ClassCastException cce) {
			return false;
		}
	}

	public int hashCode( ) {
		return name.hashCode( );
	}
	
	/**
	 * Check the correctness of this Character object.
	 * Validate the Character's invariants.
	 * 
	 * @return True if this object is a valid Character, that is,
	 * if none of the Character invariants are broken. Return false
	 * otherwise.
	 */
	protected boolean validateCharacter(){
		if (name == null) {
			System.out.println("Character's name must not be null.");
			return false;
		}
		if (name.isEmpty()) {
			System.out.println("Character's name must not be an empty string.");
			return false;
		}
		if (description == null) {
			System.out.println("Character's description must not be null.");
			return false;
		}
		if (traits == null) {
			System.out.println("Character's trait set must not be null.");
			return false;
		}
		// check each trait
		for (String trait : traits) {
			if (trait == null) {
				System.out.println("Character's trait must not be null.");
				return false;
			}
			if (trait.isEmpty()) {
				System.out.println("Character's trait must not be an empty.");
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Check whether this character contains the given set 
	 * of traits, that is, check if the set of traits
	 * of this character and the given set of traits have 
	 * the same elements. 
	 * 
	 * @param expectedTraits The set of traits to check.
	 * @return True if validation passed, false otherwise.
	 */
	protected boolean compareTraits(Set<String> expectedTraits) {
		if (traits.size() != expectedTraits.size())
			return false;
		for (String trait : expectedTraits) {
			if (!traits.contains(trait))
				return false;
		}
		return true;
	}

	/**
	 * @return a deep copy clone
	 */
	public Object clone() {
		Character clone = new Character(name, description);
		// !! Note: the clone() method of the traits object CANNOT be used here
			// traits are added individually to the clone
		for (String t : traits)
			clone.traits.add(t);
		return clone;
	}
}
		

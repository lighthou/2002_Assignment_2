package assignment1;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for the {@link SuperCharacter} class.
 */
public class TestSuperCharacter {
	/** Instances of Super-characters to test */
	private SuperCharacter ironMan;
	private SuperCharacter lowRangeMan;
	private SuperCharacter highPerformanceWoman;
	private SuperCharacter hulk;
	private SuperCharacter invisibleWoman;
	private SuperCharacter invalidMan;
	
	
	/**
     * This method is run by JUnit before each test.
     */
    @Before
    public void setUp() throws IllegalPowerRankingException{
    	// initialize super-characters before each test
    	ironMan = new SuperCharacter("Iron Man", "The Golden Avenger", 8);
    	lowRangeMan = new SuperCharacter("LRM", "", SuperCharacter.MIN_POWER);
    	highPerformanceWoman = new SuperCharacter("HPW", "", SuperCharacter.MAX_POWER);
    	hulk = new SuperCharacter("The Hulk", "Big Green", SuperCharacter.UNRANKABLE);
    	invisibleWoman = new SuperCharacter("", "You can't see me", 5);
    	invalidMan = new SuperCharacter("Invalid Man", "Superman near kryptonite", SuperCharacter.INVALID);
    }
	
    /**
     * Test constructor and equals
     */
	@Test
	public void testSuperCharacter() throws IllegalPowerRankingException {
		System.out.println(ironMan);
		System.out.println(lowRangeMan);
		System.out.println(highPerformanceWoman);
		System.out.println(hulk);
		System.out.println(invisibleWoman);
		System.out.println(invalidMan);
		
		// test valid super-characters
		Assert.assertTrue(ironMan.validateSuperCharacter());
		Assert.assertTrue(lowRangeMan.validateSuperCharacter());
		Assert.assertTrue(highPerformanceWoman.validateSuperCharacter());
		Assert.assertTrue(hulk.validateSuperCharacter());
		
		// test invalid super-characters
		Assert.assertFalse(invalidMan.validateSuperCharacter());
		Assert.assertFalse(invisibleWoman.validateSuperCharacter());
		
		// test equals
		SuperCharacter realIronMan = new SuperCharacter("Iron Man", "The Golden Avenger", 8);
		SuperCharacter fakeIronMan = new SuperCharacter("Iron Girl", "The Golden Avenger", 8);
		SuperCharacter realHulk = new SuperCharacter("The Hulk", "Big Green", SuperCharacter.UNRANKABLE);
		SuperCharacter fakeHulk = new SuperCharacter("The Hulk", "Big Pink", SuperCharacter.UNRANKABLE);
		
		Assert.assertEquals(realIronMan, ironMan);
		Assert.assertEquals(realHulk, hulk);
		Assert.assertNotEquals(fakeIronMan, ironMan);
		Assert.assertNotEquals(fakeHulk, hulk);
		Assert.assertNotEquals(ironMan, hulk);		
	}

	/**
	 * Test the correctness of get name
	 */
	@Test
	public void testGetName() {
		String ironManName = "Iron Man";
		String fakeIronMan = "Aluminiun Man";
		String hulkName	   = "The Hulk";
		String invisibleName = "";
		
		Assert.assertEquals(ironManName, ironMan.getName());
		Assert.assertEquals(hulkName, hulk.getName());
		Assert.assertEquals(invisibleName, invisibleWoman.getName());
		Assert.assertNotEquals(fakeIronMan, ironMan.getName());
		Assert.assertNotEquals(" ", invisibleWoman.getName());
	}

	/**
	 * Test the correctness of get description
	 */
	@Test
	public void testGetDescription() {
		String ironManDescr = "The Golden Avenger";
		String fakeIronMan  = "The Silver Avenger";
		String hulkDescr	= "Big Green";
		String lowManDescr  = "";		
				
		Assert.assertEquals(ironManDescr, ironMan.getDescription());
		Assert.assertEquals(hulkDescr, hulk.getDescription());
		Assert.assertEquals(lowManDescr, lowRangeMan.getDescription());
		Assert.assertNotEquals(fakeIronMan, ironMan.getDescription());
		Assert.assertNotEquals(" ", lowRangeMan.getDescription());
	}
	
	/**
	 * Test the correctness of set name
	 */
	@Test
	public void testSetName() {
		String newIronManName 	= "Tony Stark";
		String newHulkName	  	= null;
		String newInvisibleName = "Invisible Man";
		String newWomanName = "";
		
		ironMan.setName(newIronManName);
		hulk.setName(newHulkName);
		invisibleWoman.setName(newInvisibleName);
		highPerformanceWoman.setName(newWomanName);
		
		Assert.assertEquals(newIronManName, ironMan.getName());
		Assert.assertEquals(newHulkName, hulk.getName());
		Assert.assertEquals(newInvisibleName, invisibleWoman.getName());
		Assert.assertEquals(newWomanName, highPerformanceWoman.getName());
		
		// invariant should now hold
		Assert.assertTrue(invisibleWoman.validateSuperCharacter());
		// invariant should no longer hold
		Assert.assertFalse(highPerformanceWoman.validateSuperCharacter());
		Assert.assertFalse(hulk.validateSuperCharacter());
	}
	
	/**
	 * Test the correctness of set description
	 */
	@Test
	public void testSetDescription() {
		String newIronManDescr = "The CEO of the Stark Corp.";
		String newLowRangeManDescr = "A low range super-character";
		String newHulkDescr = null;		
		String newInvalidManDescr = "";
		
		ironMan.setDescription(newIronManDescr);
		hulk.setDescription(newHulkDescr);
		lowRangeMan.setDescription(newLowRangeManDescr);
		invalidMan.setDescription(newInvalidManDescr);
		
		Assert.assertEquals(newIronManDescr, ironMan.getDescription());
		Assert.assertEquals(newLowRangeManDescr, lowRangeMan.getDescription());
		Assert.assertEquals(newHulkDescr, hulk.getDescription());
		Assert.assertEquals(newInvalidManDescr, invalidMan.getDescription());
		
		// invariant should no longer hold
		Assert.assertFalse(hulk.validateSuperCharacter());
	}
	
	/**
	 * Test the correctness of get power ranking
	 */
	@Test
	public void testGetPowerRanking() {
		int ironManPower = 8;
		int lowRangeManPower = SuperCharacter.MIN_POWER;
		int highPerfWomanPower = SuperCharacter.MAX_POWER;
		int hulkPower = SuperCharacter.UNRANKABLE;
		int invalidManPower = SuperCharacter.INVALID;
		
		Assert.assertEquals(ironManPower, ironMan.getPowerRanking());
		Assert.assertEquals(lowRangeManPower, lowRangeMan.getPowerRanking());
		Assert.assertEquals(highPerfWomanPower, highPerformanceWoman.getPowerRanking());
		Assert.assertEquals(hulkPower, hulk.getPowerRanking());
		Assert.assertEquals(invalidManPower, invalidMan.getPowerRanking());
	}

	/**
	 * Test the correctness of set power ranking
	 */
	@Test
	public void testSetPowerRanking() throws IllegalPowerRankingException{
		int minPower = 1;
		int maxPower = 10;
		int invalidPos = 100;
		int invalidNeg = -100;
		
		ironMan.setPowerRanking(minPower);
		lowRangeMan.setPowerRanking(maxPower);
		highPerformanceWoman.setPowerRanking(invalidPos);
		hulk.setPowerRanking(invalidNeg);
		
		Assert.assertEquals(minPower, ironMan.getPowerRanking());
		Assert.assertEquals(maxPower, lowRangeMan.getPowerRanking());
		Assert.assertEquals(SuperCharacter.INVALID, highPerformanceWoman.getPowerRanking());
		Assert.assertEquals(SuperCharacter.INVALID, hulk.getPowerRanking());

		// invariant should no longer hold
		Assert.assertFalse(highPerformanceWoman.validateSuperCharacter());
		Assert.assertFalse(hulk.validateSuperCharacter());
	}

	/**
	 * Test the correctness of the add traits
	 */
	@Test
	public void testAddTrait() {	
		String trait1 = "Green";
		String trait2 = "Angry";
		String trait3 = "10XL pants";
		String invalid = "A trait not belonging to hulk";
		
		hulk.addTrait(trait1);
		hulk.addTrait(trait2);
		hulk.addTrait(trait3);
		// add same more than once
		hulk.addTrait(trait3);
		hulk.addTrait(trait3);
		hulk.addTrait(trait3);
		
		Set<String> expectedTraits = new HashSet<>();
		expectedTraits.add(trait1);
		expectedTraits.add(trait2);
		expectedTraits.add(trait3);
		Assert.assertTrue(hulk.compareTraits(expectedTraits));
		
		hulk.addTrait(invalid);
		Assert.assertFalse(hulk.compareTraits(expectedTraits));
		
		// cannot be null
		hulk.addTrait(null);
		Assert.assertFalse(hulk.validateSuperCharacter());
		
		// check empty set of traits
		expectedTraits = new HashSet<>();
		Assert.assertTrue(ironMan.compareTraits(expectedTraits));
		
		// cannot be empty
		ironMan.addTrait("");
		Assert.assertFalse(ironMan.validateSuperCharacter());
	}

	/**
	 * Test the correctness of the remove traits
	 */
	@Test
	public void testRemoveTrait() {
		String trait1 = "Green";
		String trait2 = "Angry";
		String trait3 = "10XL pants";
		String invalid = "A trait not belonging to hulk";
		
		hulk.addTrait(trait1);
		hulk.addTrait(trait2);
		hulk.addTrait(trait3);
		
		hulk.removeTrait(trait1);
		hulk.removeTrait(trait3);	
		
		// invariant should still hold
		Assert.assertTrue(hulk.validateSuperCharacter());
		
		Set<String> expectedTraits = new HashSet<>();
		expectedTraits.add(trait2);
		Assert.assertTrue(hulk.compareTraits(expectedTraits));
		
		// try to remove a trait not in the set
		hulk.removeTrait(invalid);
		Assert.assertTrue(hulk.compareTraits(expectedTraits));
		
		// try to remove a null trait
		hulk.removeTrait(null);
		Assert.assertTrue(hulk.compareTraits(expectedTraits));
			
		// try to remove from an empty set
		ironMan.removeTrait(trait1);
		expectedTraits = new HashSet<>();
		Assert.assertTrue(ironMan.compareTraits(expectedTraits));
	}

	/**
	 * Test the correctness of the add power
	 */
	@Test
	public void testAddPower() {		
		String power1 = "Can fly";
		String power2 = "Granade launcher";
		String power3 = "Hand beam";
		String invalid = "A power not possessed by Iron Man";
		
		ironMan.addPower(power1);
		ironMan.addPower(power2);
		ironMan.addPower(power3);
		// add same more than once
		ironMan.addPower(power3);
		ironMan.addPower(power3);
		ironMan.addPower(power3);
		
		Set<String> expectedPowers = new HashSet<>();
		expectedPowers.add(power1);
		expectedPowers.add(power2);
		expectedPowers.add(power3);
		Assert.assertTrue(ironMan.comparePowers(expectedPowers));

		ironMan.addTrait(invalid);
		Assert.assertFalse(ironMan.compareTraits(expectedPowers));
		
		// cannot be null
		ironMan.addTrait(null);
		Assert.assertFalse(ironMan.validateSuperCharacter());
		
		// check empty set of powers
		expectedPowers = new HashSet<>();
		Assert.assertTrue(hulk.comparePowers(expectedPowers));
		
		// cannot be empty
		hulk.addPower("");
		Assert.assertFalse(hulk.validateSuperCharacter());
	}

	/**
	 * Test the correctness of the remove power
	 */
	@Test
	public void testRemovePower() {
		String power1 = "Can fly";
		String power2 = "Granade launcher";
		String power3 = "Hand beam";
		String invalid = "A power not possessed by Iron Man";

		ironMan.addPower(power1);
		ironMan.addPower(power2);
		ironMan.addPower(power3);
		
		ironMan.removePower(power1);
		ironMan.removePower(power3);
		
		// invariant should still hold
		Assert.assertTrue(ironMan.validateSuperCharacter());
				
		Set<String> expectedPowers = new HashSet<>();
		expectedPowers.add(power2);
		Assert.assertTrue(ironMan.comparePowers(expectedPowers));
		
		// try to remove a power not in the set
		ironMan.removePower(invalid);
		Assert.assertTrue(ironMan.comparePowers(expectedPowers));
		
		// try to remove a null power
		ironMan.removePower(null);
		Assert.assertTrue(ironMan.comparePowers(expectedPowers));
			
		// try to remove from super-character with no powers
		hulk.removePower(power1);
		expectedPowers = new HashSet<>();
		Assert.assertTrue(hulk.compareTraits(expectedPowers));
	}
}

package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for the {@link Team} class.
 */
public class TestTeam {
	/** Instances of objects to test */
	private Team avengers;
	private SuperCharacter blackWidow;
	private SuperCharacter hulk;
	private SuperCharacter thor;
	private SuperCharacter invalidMan;
	private Character johnDoe;
	
	/**
     * This method is run by JUnit before each test.
     */
    @Before
    public void setUp() throws IllegalPowerRankingException {
    	// initialize objects before each test
    	blackWidow = new SuperCharacter("Black Widow", "Fury's fury", 3);
    	hulk = new SuperCharacter("The Hulk", "Big Green", SuperCharacter.UNRANKABLE);
    	thor = new SuperCharacter("Thor", "The Son of Odin", 10);
    	invalidMan = new SuperCharacter("Invalid Man", "Superman near kryptonite", SuperCharacter.INVALID);
    	johnDoe = new Character("John Doe", "Just a normal guy");
    	avengers = new Team("The Avengers");
    }
    
	/**
	 * Test the correctness of the team's power ranking.
	 */
	@Test
	public void testPowerRanking() {
		// expected Avengers power ranking
		int apr = 13;

		// test empty team
		Assert.assertEquals(0, avengers.powerRanking());
		
		// add member with power
		avengers.addMember(blackWidow);
		avengers.addMember(thor);
		Assert.assertEquals(apr, avengers.powerRanking());
		
		// add member without power
		avengers.addMember(johnDoe);
		Assert.assertEquals(apr, avengers.powerRanking());
		
		// add unrakable member
		avengers.addMember(hulk);
		Assert.assertEquals(SuperCharacter.UNRANKABLE, avengers.powerRanking());
		
		// remove unrakable member
		avengers.removeMember(hulk);
		Assert.assertEquals(apr, avengers.powerRanking());
		
		// remove member without power
		avengers.removeMember(johnDoe);
		Assert.assertEquals(apr, avengers.powerRanking());
		
		// remove remainder members
		avengers.removeMember(blackWidow);
		avengers.removeMember(thor);
		Assert.assertEquals(0, avengers.powerRanking());
		
		// add invalid member
		avengers.addMember(blackWidow);
		avengers.addMember(invalidMan);
		Assert.assertEquals(SuperCharacter.INVALID, avengers.powerRanking());
		
		// remove invalid member
		avengers.removeMember(invalidMan);
		Assert.assertEquals(blackWidow.getPowerRanking(), avengers.powerRanking());
	}
}

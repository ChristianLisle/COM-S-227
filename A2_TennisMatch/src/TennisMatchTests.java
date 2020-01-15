package hw2;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
/*
This is a JUnit test I made to test my TennisMatch class
*/
public class TennisMatchTests {
	private TennisMatch tm;
	
	@Before
	public void setup()	{
		tm = new TennisMatch("P1", "P2", true, 1, 1); //DO NOT EDIT! (if these values are changed, the test results will be incorrect)
		//Match is initialized before each test is run.
	}
	
	@Test
	public void testInitial()	{
		assertEquals("The ball should not have been served yet.\n", false, tm.getBallServed());
		assertEquals("The game should not be over yet.\n", false, tm.getGameOver());
		assertEquals("The ball should not be in play yet.\n", false, tm.getBallInPlay());
		assertEquals("The bestOfThree value is not correct.\n", true, tm.getBestOfThree());
		assertEquals("The initial server is not correct.\n", tm.getName(1), tm.getServer());
		assertEquals("The receiver is not correct.\n", tm.getName(2), tm.getReceiver());
		assertEquals("The initial game score is not correct.\n", "game score: love-love", tm.getGameScore().toLowerCase());
		assertEquals("The initial set score is not correct.\n", "set score: 0-0",tm.getSetScore().toLowerCase());
		assertEquals("The initial match score is not correct.\n", "match score: 0-0",tm.getMatchScore().toLowerCase());
		
		assertEquals("The initial score is not correct.\n", "game score: love-love\nset score: 0-0\nmatch score: 0-0", tm.getScore().toLowerCase());
		assertEquals("The initial getWinner() value is not correct.\n", "the game is not over", tm.getWinner().toLowerCase());
	}
	@Test
	public void testBooleans()	{
		tm.serve();//Player 1 serves the ball
		assertEquals("The ballFrom value is not correct.\n", tm.getServer(), tm.getBallFrom());
		assertEquals("The ballTo value is not correct.\n", tm.getReceiver(), tm.getBallTo());
		assertEquals("The ball should be in play after being served.\n", true, tm.getBallInPlay());
		assertEquals("The ballServed should be true after being served.\n", true, tm.getBallServed());
		
		tm.returnBall();// Player 2 returns the ball
		assertEquals("The ballFrom value is not correct.\n", tm.getReceiver(), tm.getBallFrom());
		assertEquals("The ballTo value is not correct.\n", tm.getServer(), tm.getBallTo());
		assertEquals("The ball should still be in play after being returned (after being served).\n", true, tm.getBallInPlay());
		assertEquals("The ballServed should be false after being returned.\n", false, tm.getBallServed());
		tm.failedReturn();// Player 1 fails to return the ball. Player 2 scores a point
		assertEquals("The ball should not be in play after a failed return.\n", false, tm.getBallInPlay());
		assertEquals("The ballServed should not be true after a failed return.\n", false, tm.getBallServed());
		
		tm.serve();
		tm.fault();//Player 1 faults while serving
		assertEquals("The serveFault value is not correct.\n", true, tm.getServeFault());
		
		tm.serve();
		tm.fault();//Player 1 faults while serving (again), giving a point to player 2
		assertEquals("The initial game score is not correct.\n", "game score: love-30", tm.getGameScore().toLowerCase());
	}
	@Test
	public void test1()	{
		tm.serve();
		tm.returnBall();
		tm.failedReturn();
		assertEquals("The initial game score is not correct.\n", "game score: love-15", tm.getGameScore().toLowerCase());
		
		tm.serve();//Player 1 serves the ball again
		assertEquals("The server should not have changed.\n", tm.getName(1), tm.getServer());
		assertEquals("The ballTo value is not correct.\n", tm.getReceiver(), tm.getBallTo());
		tm.returnBall();
		assertEquals("The ballTo value is not correct.\n", tm.getServer(), tm.getBallTo());
		assertEquals("The ballFrom value is not correct after a return.\n", tm.getName(2), tm.getBallFrom());
		tm.failedReturn();// Player 2 scores a 2nd point
		
		tm.serve();
		tm.returnBall();
		tm.failedReturn();// Player 2 scores a 3rd point
		assertEquals("The game score is not correct.\n", "game score: love-40", tm.getGameScore().toLowerCase());
		
		tm.serve();
		tm.failedReturn();//Player 1 scores a point
		
		tm.serve();
		tm.failedReturn();//Player 1 scores a 2nd point
		assertEquals("The game score is not correct.\n", "game score: 30-40", tm.getGameScore().toLowerCase());
		
		tm.serve();
		tm.failedReturn();//Player 1 scores a 3rd point, putting the score at deuce
		assertEquals("The game score is not correct.\n", "game score: deuce", tm.getGameScore().toLowerCase());
		
		tm.serve();
		tm.returnBall();
		tm.failedReturn();// Player 2 scores another point, giving him advantage
		assertEquals("The game score is not correct.\n", ("game score: advantage " + tm.getName(2).toLowerCase()), tm.getGameScore().toLowerCase());
		
		tm.serve();
		tm.failedReturn();// Player 1 scores another point, putting the score at deuce again
		assertEquals("The game score is not correct.\n", "game score: deuce", tm.getGameScore().toLowerCase());
		
		tm.serve();
		tm.returnBall();
		tm.failedReturn();// Player 2 scores another point, giving him advantage
		assertEquals("The game score is not correct.\n", ("game score: advantage " + tm.getName(2).toLowerCase()), tm.getGameScore().toLowerCase());
		
		tm.serve();
		tm.returnBall();
		tm.failedReturn();// Player 2 scores another point, winning him the game
		
		//Game 1 ends. Players switch sides (odd-games only), and the server is switched
		
		assertEquals("The Set score is not correct after p2 won a game.\n", "set score: 0-1", tm.getSetScore().toLowerCase());
		assertEquals("The game score is not correct after a game has been one (the gameScore values should be reset when a game is won).\n", "game score: love-love", tm.getGameScore().toLowerCase());
		assertEquals("The server is not correct.\n", tm.getName(2), tm.getServer());
		assertEquals("The receiver is not correct.\n", tm.getName(1), tm.getReceiver());
		assertEquals("The player 1 side is not correct.\n", tm.getP1End(), 2);
		assertEquals("The player 2 side is not correct.\n", tm.getP2End(), 1);
		
		tm.setGameScore(3, 0);
		tm.serve();
		tm.returnBall();
		tm.failedReturn();//Player 1 scores a point and wins game 2
		assertEquals("The Set score is not correct after p1 won a game.\n", "set score: 1-1", tm.getSetScore().toLowerCase());
		assertEquals("The player 1 end.\n", tm.getP1End(), 2);
		assertEquals("The server is not correct.\n", tm.getName(1), tm.getServer());
	}
	@Test
	public void test2()	{
		tm.setScore(3, 3, 6, 5, 1, 1); //Game/set/match scores are set
		assertEquals("The getScore() accessor is not returning the correct values. (possibly an issue with setScore() method)\n", "game score: deuce\nset score: 6-5\nmatch score: 1-1", tm.getScore().toLowerCase());
		
		tm.serve();
		tm.let();
		assertEquals("The ball should not be in play after a let.", false, tm.getBallInPlay());
		assertEquals("The ballServed is value is incorrect after a let.", false, tm.getBallServed());
		assertEquals("The game score should still be the same after a let.", "game score: deuce", tm.getGameScore().toLowerCase());
		
		
		tm.serve();
		tm.failedReturn();//Player 1 scores a point, giving him the advantage
		
		tm.serve();
		tm.failedReturn();//Player 1 scores a point, and wins the match
		assertEquals("The getScore() accessor is not returning the correct values. (possibly an issue with setScore() method)\n", "game score: love-love\nset score: 0-0\nmatch score: 2-1", tm.getScore().toLowerCase());
		assertEquals("The game is over after player 1 has won the match.\n", true, tm.getGameOver());
		assertEquals("The getWinner() accessor is not returning the correct value.\n", ("The winner is: " + tm.getName(1)), tm.getWinner());
	}
	@Test
	public void test3()	{
		tm.changeEnds();
		assertEquals("The player 1 side is not correct.\n", 2, tm.getP1End());
		assertEquals("The player 2 side is not correct.\n", 1, tm.getP2End());
		tm.changeServer();
		assertEquals("The server is not correct (after the changeServer() method is called).\n", tm.getName(2), tm.getServer());
		assertEquals("The receiver is not correct (after the changeServer() method is called).\n", tm.getName(1), tm.getReceiver());
		
		tm.setSetScore(1, 3);
		assertEquals("The set score is not correct (after the setSetScore() method is called).\n", "set score: 1-3", tm.getSetScore().toLowerCase());
	}

}

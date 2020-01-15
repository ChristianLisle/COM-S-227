package hw2;

public class CustomTestTennisMatch {
	public static void main(String[] args) {
		TennisMatch tm = new TennisMatch("p1", "p2", true, 1, 1);
		
		
		tm.setScore(3, 0, 5, 0, 0, 0);
	    System.out.println(tm.getScore());
	    /* Game score: 40-Love
	     * Set score: 5-0
	     * Match score: 0-0
	     */
	    tm.changeServer();
	    tm.serve();
	    tm.failedReturn();
	    tm.serve();
	    tm.failedReturn();
	    System.out.println(tm.getScore());
	    /* Game score: 40-30
	     * Set score: 5-0
	     * Match score: 0-0
	     */
	    tm.serve();
	    tm.failedReturn();
	    System.out.println(tm.getScore());
	    /* Game score: Deuce
	     * Set score: 5-0
	     * Match score: 0-0
	     */
	    tm.serve();
	    tm.failedReturn();
	    System.out.println(tm.getScore());
	    /* Game score: Advantage Monica Seles
	     * Set score: 5-0
	     * Match score: 0-0
	     */
	    tm.serve();
	    tm.failedReturn();
	    System.out.println(tm.getScore());
	    /* Game score: Love-Love
	       Set score: 5-1
	       Match score: 0-0
	    */
	    System.out.println("6-----------------------------------------");

	    tm.setScore(4, 4, 6, 6, 1, 1);
	    System.out.println(tm.getScore());
	    /* Game score: Deuce
	     * Set score: 6-6
	     * Match score: 1-1
	     */
	    System.out.println("7-----------------------------------------");

	    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
	    /* Steffi Graf is on end 2 */
	    System.out.println(tm.getServer() + " is serving");
	    /* Steffi Graf is serving */
	    tm.serve();
	    tm.failedReturn();
	    tm.serve();
	    tm.failedReturn();
	    System.out.println(tm.getScore());
	    /* Game score: Love-Love
	     * Set score: 7-6
	     * Match score: 1-1
	    */
	    System.out.println("8-----------------------------------------");

	    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
	    /* Steffi Graf is on end 1 */
	    System.out.println(tm.getServer() + " is serving");
	    /* Monica Seles is serving */
	    
	    tm.serve();
	    tm.failedReturn();
	    tm.serve();
	    tm.failedReturn();
	    System.out.println(tm.getScore());
	    /* Game score: Love-30
	     * Set score: 7-6
	     * Match score: 1-1
	     */
	    System.out.println("9-----------------------------------------");
	    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
	    /* Steffi Graf is on end 1 */
	    System.out.println(tm.getServer() + " is serving");
	    /* Monica Seles is serving */
	    tm.serve();
	    tm.returnBall();
	    tm.failedReturn();
	    tm.serve();
	    tm.returnBall();
	    tm.failedReturn();
	    tm.serve();
	    tm.returnBall();
	    tm.failedReturn();
	    System.out.println(tm.getScore());
	    /* Game score: 40-30
	       Set score: 7-6
	       Match score: 1-1 */
	    System.out.println("The winner is " + tm.getWinner());
	    /* The winner is Game is not over */
	    tm.serve();
	    tm.returnBall();
	    tm.failedReturn();
	    System.out.println(tm.getScore());
	    /* Match score: 2-1 */
	    System.out.println("The winner is " + tm.getWinner());
	    /* The winner is Steffi Graf */
	    System.out.println("10-----------------------------------------");
		
		
		
		
		
		
		/*tm.serve();
		System.out.println(tm.getBallPos());
		tm.returnBall();
		System.out.println(tm.getBallPos());
		tm.returnBall();
		System.out.println(tm.getBallPos());
		tm.returnBall();
		System.out.println(tm.getBallPos());
		System.out.println(tm.getBallPos());
		tm.returnBall();
		System.out.println(tm.getBallPos());
		tm.returnBall();
		System.out.println(tm.getBallPos());
		tm.failedReturn();
		System.out.println(tm.getBallPos());*/
		
		
		
		
		
		
		
		
		/*System.out.println("Player 1: " + tm.getName(1) + " on end: " + tm.getP1End());
		System.out.println("Player 2: " + tm.getName(2) + " on end: " + tm.getP2End());
		System.out.println(tm.getServer());
		System.out.println(tm.getBallPos());
		tm.serve();
		System.out.println(tm.getBallPos() + " going to 2");
		tm.returnBall();
		System.out.println(tm.getBallPos() + " returning to 1");
		tm.failedReturn(); //15-0 0-0
		System.out.println(tm.getBallPos() + " failed. handed back to 1");
	    System.out.println(tm.getGameScore());
	    tm.serve();
	    System.out.println(tm.getBallPos() + " served to 2 again");
	    tm.failedReturn();//30-0 0-0
	    System.out.println(tm.getGameScore());
	    tm.serve();
	    tm.failedReturn();//40-0 0-0
	    System.out.println(tm.getGameScore());
	    tm.serve();
	    tm.failedReturn();//0-0 1-0
	    System.out.println(tm.getSetScore());
	    System.out.println("Player 1: " + tm.getName(1) + " on end: " + tm.getP1End());
		System.out.println("Player 2: " + tm.getName(2) + " on end: " + tm.getP2End());
		
		System.out.println(tm.getServer());	    */
		
		
		
		
	    
	    
		/*TennisMatch tm = new TennisMatch("P1", "P2", false, 1, 1);
		
		System.out.println(tm.getServer() + " served the ball");
		tm.serve();
		System.out.println(tm.getReceiver() + " returned the ball");
		tm.returnBall();
		System.out.println(tm.getBallTo() + " failed to return the ball");
		tm.failedReturn();
		System.out.println(tm.getGameScore());//love-15
		System.out.println(tm.getServer() + " served the ball");
		tm.serve();
		System.out.println(tm.getBallTo() + " failed to return the ball");
		tm.failedReturn();
		System.out.println(tm.getServer() + " served the ball");
		tm.serve();
		System.out.println(tm.getBallTo() + " failed to return the ball");
		tm.failedReturn();
		System.out.println(tm.getServer() + " served the ball");
		tm.serve();
		System.out.println(tm.getBallTo() + " failed to return the ball");
		tm.failedReturn();
		System.out.println(tm.getServer() + " served the ball");
		tm.serve();
		System.out.println(tm.getBallTo() + " failed to return the ball");
		tm.failedReturn();
		
		System.out.println(tm.getGameScore());
		System.out.println(tm.getScore());
		
		tm.setGameScore(4, 6);
		System.out.println(tm.getScore());
		tm.setScore(5, 4, 5, 3, 2, 2);
		//System.out.println(getP1MatchScore());
		System.out.println(tm.getScore());
		//tm.incrementGamePoints(1, 2);
		System.out.println(tm.getServer() + " serves...\n" + tm.getReceiver() + " failes to return it");
		tm.serve();
		tm.failedReturn();
		
		System.out.println(tm.getScore());	
		System.out.println(tm.getWinner());
		System.out.println("gameOver " + tm.getGameOver());*/
		
	}
}

package hw2;

public class TestTennisMatch {
  public static void main(String [] args)
  {
    TennisMatch tm = new TennisMatch("Steffi Graf", "Monica Seles",true, 1, 1);
    
    /*/* Game 1 */
    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
    /* Steffi Graf is on end 1 */
    System.out.println(tm.getServer() + " is serving");
    System.out.println(tm.getReceiver() + " is receiving");
    /* Steffi Graf is serving */
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.failedReturn(); //15-0 0-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.failedReturn();//30-0 0-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.failedReturn();//40-0 0-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.failedReturn();//0-0 1-0
    System.out.println(tm.getSetScore());
    /* Set score: 1-0 */
    System.out.println("1-----------------------------------------");

    /* Game 2 */
    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
    /* Steffi Graf is on end 2 */
    System.out.println(tm.getServer() + " is serving");
    /* Monica Seles is serving */
    //System.out.println(tm.getGameScore());//0-0 1-0
    tm.serve();
    tm.returnBall();
    tm.failedReturn(); //15-0 1-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.returnBall();
    tm.failedReturn();//30-0 1-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.returnBall();
    tm.failedReturn();//40-0 1-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.returnBall();
    tm.failedReturn();//0-0 2-0
    System.out.println(tm.getGameScore());
    System.out.println(tm.getSetScore());
    /* Set score: 2-0 */
    System.out.println("2-----------------------------------------");
    
    /* Game 3 */
    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
    /* Steffi Graf is on end 2 */
    System.out.println(tm.getServer() + " is serving");
    /* Steffi Graf is serving */
    tm.serve();
    tm.failedReturn();//15-0 2-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.failedReturn();//30-0 2-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.failedReturn();//40-0 2-0
    System.out.println(tm.getGameScore());
    tm.serve();
    tm.failedReturn();
    System.out.println(tm.getGameScore());
    System.out.println(tm.getSetScore());
    /* Set score: 3-0 */
    System.out.println("3-----------------------------------------");

    /* Game 4 */
    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
    /* Steffi Graf is on end 1 */
    System.out.println(tm.getServer() + " is serving");
    /* Monica Seles is serving */
    tm.serve();
    tm.returnBall();
    tm.failedReturn();//15-0 3-0
    tm.serve();
    tm.returnBall();
    tm.failedReturn();//30-0 3-0
    tm.serve();
    tm.returnBall();
    tm.failedReturn();//40-0 3-0
    tm.serve();
    tm.returnBall();
    tm.failedReturn();
    System.out.println(tm.getSetScore());
    /* Set score: 4-0 */
    System.out.println("4-----------------------------------------");

    /* Game 5 */
    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
    /* Steffi Graf is on end 1 */
    System.out.println(tm.getServer() + " is serving");
    /* Steffi Graf is serving */
    tm.serve();
    tm.failedReturn();//15-0 4-0
    tm.serve();
    tm.failedReturn();//30-0 4-0
    tm.serve();
    tm.failedReturn();//40-0 4-0
    tm.serve();
    tm.failedReturn();
    System.out.println(tm.getSetScore());
    /* Set score: 5-0 */
    System.out.println("5-----------------------------------------");

    /* Game 6 */
    System.out.println(tm.getName(1) + " is on end " + tm.getP1End());
    /* Steffi Graf is on end 2 */
    System.out.println(tm.getServer() + " is serving");
    /* Monica Seles is serving */
    tm.serve();
    tm.fault();
    tm.serve();
    tm.fault();

    tm.serve();
    tm.fault();
    tm.serve();
    tm.fault();

    tm.serve();
    tm.fault();
    tm.serve();
    tm.fault();

    tm.serve();
    tm.returnBall();
    tm.returnBall();
    tm.returnBall();
    tm.returnBall();
    tm.returnBall();
    tm.let();
    tm.setScore(3, 0, 5, 0, 0, 0);
    System.out.println(tm.getScore());
    /* Game score: 40-Love
     * Set score: 5-0
     * Match score: 0-0
     */

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
  }
}

package hw2;
/**
 * This class simulates a tennis match.
 * This was created as a Computer Science assignment in my COM S 227 Class at Iowa State University
 * @author Christian Lisle
 */
public class TennisMatch {
/*Instance variables:*/
	
	/**
	 * Tennis player(s)
	 */
	private TennisPlayer p1, p2;
	/**
	 * bestOfThree: Whether or not the game is best of three. True for best of three, false for best of five
	 */
	private boolean bestOfThree;
	/**
	 * Whether or not the game is over
	 */
	private boolean gameOver;
	/**
	 * If the ball is in play, has been served, and if the last serve was a fault
	 */
	private boolean ballInPlay, ballServed, serveFault;
	/**
	 * Who the server is and what end the server is on
	 */
	private int server, serverEnd;
	/**
	 * The position of the ball
	 */
	private int ballPosition;
	/**
	 * The game number. When odd, the players switch ends at the end of the game.
	 */
	private int game;
	/**
	 * The number of serve faults performed by the player currently serving. Two serve faults yield a game point for the receiver
	 */
	private int serveFaultCount;
	
	
	
/*Tennis Match constructor:*/
	
	
	/**
	 * Create a new tennis match.
	 * @param p1Name Player 1 name
	 * @param p2Name Player 2 name
	 * @param playBestOfThree Match is best-of-3-sets if true; else best-of-5
	 * @param initialServer Specifies which player serves first
	 * @param initialServerEnd Specifies which end the initial server starts on
	 */
	public TennisMatch(String p1Name, String p2Name, boolean playBestOfThree, int initialServer, int initialServerEnd)	{
		bestOfThree = playBestOfThree;
		server = initialServer;
		ballPosition = serverEnd = ballPosition = initialServerEnd;
		int p1End, p2End;
		if (server == serverEnd) {
			p1End = 1;
			p2End = 2;
		}
		else {
			p1End = 2;
			p2End = 1;
		}
		game = 1;
		p1 = new TennisPlayer(p1Name, p1End); //Declare the name and end of player 1
		p2 = new TennisPlayer(p2Name, p2End); //Declare the name and end of player 2
	}
	
	
	
/*Basic in-game actions:*/
	
	
	/**
	 * Serves the ball. Does nothing if the game is over.
	 */
	public void serve()	{
		if (!gameOver)	{
			if (server == 1) {
				ballPosition = p1.getEnd();
			}
			else {
				ballPosition = p2.getEnd();
			}
			ballInPlay = ballServed = true;
			if (ballPosition == 1)	{
				ballPosition = 2;
			}
			else {
				ballPosition = 1;
			}
		}
	}
	/**
	 * Registers a serve fault. Does nothing if the ball is not being served. Two serve faults yield a game point for the receiver
	 */
	public void fault()	{
		if (ballServed) {
			serveFault = true;
			serveFaultCount ++;
			if (serveFaultCount == 2) {
				if (getServer() == p1.getName())	{
					incrementGamePoints(p2, p1);
				}
				else {
					incrementGamePoints(p1, p2);
				}
				serveFaultCount = 0;
			}
		}
		ballInPlay = ballServed = false;
	}
	/**
	 * Reverses the direction of the ball. Ball is no longer being served. Does nothing if the ball is not in play
	 */
	public void returnBall()	{
		if (ballInPlay)	{
			if (ballPosition == 1)	{
				ballPosition = 2;
			}
			else {
				ballPosition = 1;
			}
			ballServed = serveFault = false;
		}
	}
	/**
	 * Takes the ball out of play. The player who last served or returned the ball scores a game point
	 */
	public void failedReturn()	{
		if (getP1End() == ballPosition) {
			incrementGamePoints(p2, p1);
		}
		else	{
			incrementGamePoints(p1, p2);
		}
		ballInPlay = ballServed  = serveFault = false;
	}
	/**
	 * Ends the current point early without a point being scored
	 */
	public void let()	{
		ballInPlay = ballServed = serveFault = false;
	}
	/**
	 * Swaps the ends of the two players
	 */
	public void changeEnds()	{
		int storedEnd = p1.getEnd();
		p1.setEnd(p2.getEnd());
		p2.setEnd(storedEnd);
	}
	/**
	 * Swaps the server and receiver
	 */
	public void changeServer()	{
		if (server == 1) {
			server = 2;
		}
		else	{
			server = 1;
		}
	}
	
	
	
/*Game scoring and logic:*/
	
	
	/**
	 * Adds one game point to addTo's game total. Zeros game score and increments set score if game has ended. Removes ball from play. Clears faults
	 * @param addTo The player who has scored a point
	 * @param noAdd The other player
	 */
	public void incrementGamePoints(TennisPlayer addTo, TennisPlayer noAdd) {
			addTo.incrementGamePoints();
			if (addTo.getGamePoints() >= 4 && (addTo.getGamePoints()-2) >= noAdd.getGamePoints()) {
				incrementSetPoints(addTo, noAdd);
				setGameScore(0, 0);
				game++;
			}
			ballInPlay = serveFault = false;
			serveFaultCount = 0;
	}
	/**
	 * Adds one set point to addTo's total. Zeros set score and increments match score if set has ended. Changes server. Changes ends after odd numbered sets
	 * @param addTo The player who has scored a point
	 * @param noAdd The other player
	 */
	public void incrementSetPoints(TennisPlayer addTo, TennisPlayer noAdd)	{
		addTo.incrementSetPoints();
		if (addTo.getSetPoints() >= 6 && (addTo.getSetPoints()-2) >= noAdd.getSetPoints())	{
			incrementMatchPoints(addTo, noAdd);
			setSetScore(0, 0);
		}
		if (!(game % 2 == 0))	{
			changeEnds();
		}
		changeServer();
	}
	/**
	 * Adds one match point to addTo's total. Sets game over if match has ended
	 * @param addTo The player who has scored a point
	 * @param noAdd The other player
	 */
	public void incrementMatchPoints(TennisPlayer addTo, TennisPlayer noAdd)	{
		addTo.incrementMatchPoints();
		//Ends the match in best of three and best of five conditions
		if ((bestOfThree && addTo.getMatchPoints() == 2) || (!bestOfThree && addTo.getMatchPoints() == 3))	{
			gameOver = true;
			server = 0; //If the game is over, the getServer() method will return "no server". Same as getReceiver()
		}
	}
	
	
	
/*Game, set, and match score accessors:*/
	
	
	/**
	 * Returns the game score p1-p2, Advantage name, or Deuce
	 * @return The game score
	 */
	public String getGameScore()	{
		String p1DisplayScore, p2DisplayScore;
		if (p1.getGamePoints() == 0)	{
			p1DisplayScore = "Love";
		}
		else if (p1.getGamePoints() == 1) {
			p1DisplayScore = "15";
		}
		else if (p1.getGamePoints() == 2) {
			p1DisplayScore = "30";
		}
		else {
			p1DisplayScore = "40";
			if (p1.getGamePoints() == p2.getGamePoints())	{
				return "Game score: Deuce";
			}
			if (p1.getGamePoints() > p2.getGamePoints() && p2.getGamePoints() >= 3) {
				return "Game score: Advantage " + p1.getName();
			}
		}
		if (p2.getGamePoints() == 0)	{
			p2DisplayScore = "Love";
		}
		else if (p2.getGamePoints() == 1) {
			p2DisplayScore = "15";
		}
		else if (p2.getGamePoints() == 2) {
			p2DisplayScore = "30";
		}
		else {
			p2DisplayScore = "40";
			if (p2.getGamePoints() > p1.getGamePoints()&& p1.getGamePoints() >= 3) {
				return "Game score: Advantage " + p2.getName();
			}
		}
		return "Game score: " + p1DisplayScore + "-" + p2DisplayScore;
	}
	/**
	 * Returns the set score p1-p2
	 * @return The set score
	 */
	public String getSetScore()	{
		return "Set score: " + p1.getSetPoints() + "-" + p2.getSetPoints();
	}
	/**
	 * Returns the match score p1-p2
	 * @return The match score
	 */
	public String getMatchScore()	{
		return "Match score: " + p1.getMatchPoints() + "-" + p2.getMatchPoints();
	}
	/**
	 * Returns the full game, set, and match score
	 * @return game, set, and match score
	 */
	public String getScore()	{
		return getGameScore() + "\n" + getSetScore() + "\n" + getMatchScore();
	}
	
	
	
/*Game, set, and match score setters:*/
	
	
	/**
	 * Set the game score
	 * @param p1Game Player 1's new game score
	 * @param p2Game Player 2's new game score
	 */
	public void setGameScore(int p1Game, int p2Game) {
		p1.setGamePoints(p1Game);
		p2.setGamePoints(p2Game);
	}
	/**
	 * Sets the set score
	 * @param p1Set Player 1's new set score
	 * @param p2Set Player 2's new set score
	 */
	public void setSetScore(int p1Set, int p2Set) {
		p1.setSetPoints(p1Set);
		p2.setSetPoints(p2Set);
	}
	/**
	 * Sets the match score
	 * @param p1Match Player 1's new match score
	 * @param p2Match Player 2's new match score
	 */
	public void setMatchScore(int p1Match, int p2Match) {
		p1.setMatchPoints(p1Match);
		p2.setMatchPoints(p2Match);
	}
	/**
	 * Set the game, set, and match scores
	 * @param p1Game Player 1's new game score
	 * @param p2Game Player 2's new game score
	 * @param p1Set Player 1's new set score
	 * @param p2Set Player 2's new set score
	 * @param p1Match Player 1's new match score
	 * @param p2Match Player 2's new match score
	 */
	public void setScore(int p1Game, int p2Game, int p1Set, int p2Set, int p1Match, int p2Match) {
		setGameScore(p1Game, p2Game);
		setSetScore(p1Set, p2Set);
		setMatchScore(p1Match, p2Match);
	}
	
	
/*Miscellaneous setters:*/
	
	
	/**
	 * Sets the server
	 * @param player The new Server
	 */
	public void setServe(int player)	{
		server = player;
	}
	/**
	 * Sets the server's end
	 * @param end The server end
	 */
	public void setServerEnd(int end) {
		serverEnd = end;
	}
	/**
	 * Returns the winner's name, or an error message if the game is not over
	 * @return The winner
	 */
	public String getWinner()	{
		if ((bestOfThree && p1.getMatchPoints() == 2) || (!bestOfThree && p1.getMatchPoints() == 3))	{
			return "The winner is: " + p1.getName();
		}
		if ((bestOfThree && p2.getMatchPoints() == 2) || (!bestOfThree && p2.getMatchPoints() == 3))	{
			return "The winner is: " + p2.getName();
		}
		return "The game is not over";
	}
	
	
	
/*Miscellaneous accessors:*/
	
	
	/**
	 * Returns p1's end
	 * @return Player 1's end
	 */
	public int getP1End()	{
		return p1.getEnd();
	}
	/**
	 * Returns p2's end
	 * @return Player 2's end
	 */
	public int getP2End()	{
		return p2.getEnd();
	}
	/**
	 * Returns serve fault status
	 * @return serveFault Whether or not the last serve was a fault
	 */
	public boolean getServeFault()	{
		return serveFault; 
	}
	/**
	 * Returns the server's name or "No server"
	 * @return Server
	 */
	public String getServer()	{
		if (server == 1) {
			return p1.getName();
		}
		else if (server == 2) {
			return p2.getName();
		}
		else {
			return "No server";
		}
	}
	/**
	 * Returns the receiver's name or "No receiver"
	 * @return Receiver
	 */
	public String getReceiver()	{
		if (getServer() == p1.getName()) {
			return p2.getName();
		}
		else if (getServer() == p2.getName()) {
			return p1.getName();
		}
		else {
			return "No receiver";
		}
	}
	/**
	 * Returns the name of the player whom the ball is heading toward or "Ball is not in play"
	 * @return ballTo The name of the player the ball is going to
	 */
	public String getBallTo()	{
		if (ballInPlay) {
			if (getP1End() == ballPosition)	{
				return p1.getName();
			}
			if (getP2End() == ballPosition)	{
				return p2.getName();
			}
		}
		return "Ball is not in play";
	}
	/**
	 * Returns the name of the player who last successfully served or returned the ball or "Ball is not in play"
	 * @return ballFrom the name of the player the ball is coming from
	 */
	public String getBallFrom()	{
		if (ballInPlay) {
			if (ballPosition == getP1End())	{
				return p2.getName();
			}
			else {
				return p1.getName();
			}
		}
		return "Ball is not in play";
	}
	/**
	 * Returns ballInPlay
	 * @return ballInPlay The state of the ball
	 */
	public boolean getBallInPlay()	{
		return ballInPlay;
	}
	/**
	 * Returns ballServed
	 * @return ballServed Whether or not the ball is being served
	 */
	public boolean getBallServed()	{
		return ballServed;
	}
	/**
	 * Returns bestOfThree
	 * @return bestOfThree Whether or not the game is best of three. True for best of three, false for best of five
	 */
	public boolean getBestOfThree()	{
		return bestOfThree;
	}
	/**
	 * Returns gameOver
	 * @return gameOver Whether or not the game is over.
	 */
	public boolean getGameOver()	{
		return gameOver;
	}
	/**
	 * Returns the player's name
	 * @param player The player (1 or 2)
	 * @return Name of the player given the parameter 
	 */
	public String getName(int player) {
		if (player == 1)	{
			return p1.getName();
		}
		else {
			return p2.getName();
		}
	}
}
package hw2;

public class TennisPlayer {
  /**
   * This class simulates a tennis player.  DO NOT MODIFY THIS CLASS!!!
   */

  /**
   * The player's name
   */
  private String name;

  /**
   * The player's current end of the court (1 or 2)
   */
  private int end;

  /**
   * The player's current game points (0, 1, 2...)
   */
  private int gamePoints;

  /**
   * The player's current set points.
   */
  private int setPoints;

  /**
   * The player's current match points.
   */
  private int matchPoints;


  /**
   * Constructs a new tennis player
   *
   * @param playerName the player's name
   * @param startingEnd the player's initial end
   */
  public TennisPlayer(String playerName, int startingEnd)
  {
    name = playerName;
    end = startingEnd;
    gamePoints = setPoints = matchPoints = 0;
  }


  /**
   * Returns the player's name
   *
   * @return the player's name
   */
  public String getName()
  {
    return name;
  }


  /**
   * Returns the player's current end
   *
   * @return the player's end
   */
  public int getEnd()
  {
    return end;
  }


  /**
   * Changes the player's end
   *
   * @param newEnd the new end
   */
  public void setEnd(int newEnd)
  {
    end = newEnd;
  }


  /**
   * Returns the player's game points
   *
   * @return the player's game points
   */
  public int getGamePoints()
  {
    return gamePoints;
  }


  /**
   * Returns the player's set points
   *
   * @return the player's set points
   */
  public int getSetPoints()
  {
    return setPoints;
  }


  /**
   * Returns the player's match points
   *
   * @return the player's match points
   */
  public int getMatchPoints()
  {
    return matchPoints;
  }


  /**
   * Increments the player's game points
   */
  public void incrementGamePoints()
  {
    gamePoints++;
  }


  /**
   * Increments the player's set points
   */
  public void incrementSetPoints()
  {
    setPoints++;
  }


  /**
   * Increments the player's match points
   */
  public void incrementMatchPoints()
  {
    matchPoints++;
  }


  /**
   * Set's the player's game points
   *
   * @param value the player's game points
   */
  public void setGamePoints(int value)
  {
    gamePoints = value;
  }


  /**
   * Set's the player's set points
   *
   * @param value the player's set points
   */
  public void setSetPoints(int value)
  {
    setPoints = value;
  }


  /**
   * Set's the player's match points
   *
   * @param value the player's match points
   */
  public void setMatchPoints(int value)
  {
    matchPoints = value;
  }
}

package hw1;
/**
 * This class represents a wireless printer
 * This was created as a Computer Science assignment in my COM S 227 Class at Iowa State University
 * @author Christian Lisle
 */
public class WirelessPrinter {
	public static final int PAGES_PER_CARTRIDGE = 1000;
	public static final int TRAY_CAPACITY = 500;
	public static final double NEW_CARTRIDGE_INK_LEVEL = 1.0;
	private boolean power = false;
	private boolean connection = false;
	private double ink;
	private int paper, pagesUsed, pagesPrinted;
	/**
	 * Create a new printer. The printer initially has a cartridge that is half full and no paper.
	 */
	public WirelessPrinter()	{
		ink = 0.5;
		paper = 0;
	}
	/**
	 * Creates a new printer with specified amount of ink and paper
	 * @param newInk Initial ink level: must be between 0.0 and 1.0, inclusive.
	 * @param newPaper Initial paper level: must be between 0 and 500, inclusive.
	 */
	public WirelessPrinter(double newInk, int newPaper)	{
		this.paper = newPaper;
		this.ink = newInk;
	}
	/**
	 * This method simulates printing a given (set in the WirelessPrinter class). 
	 * If there is not enough paper in the tray, the printer will stop when the paper runs out, and the remaining job is cancelled.
	 * If ink runs out during the printing processes, the printing will not stop, and the remaining pages printed will be blank.
	 * @param pagesWanted The requested number of pages to be printed.
	 */
	public void print(int pagesWanted)	{
		if (!isConnected())	{
			return;
		}
		pagesPrinted += Math.min(paper, pagesWanted);
		pagesUsed += Math.min(paper, pagesWanted);
		ink = Math.max(ink - Math.min(paper, pagesWanted)/1000.0, 0.0);
		paper = Math.max(paper - pagesWanted, 0);
	}
	/**
	 * load the paper. The number of pages in the tray can not surpass its capacity.
	 * @param pages The number of pages of papers added. Pages must be equal or greater than 0.
	 */
	public void loadPaper(int pages)	{
		paper = Math.min(paper + pages, TRAY_CAPACITY);
	}
	/**
	 * Replace the cartridge. The ink level is reset to NEW_CARTRIDGE_INK_LEVEL.
	 */
	public void replaceCartridge()	{
		ink = NEW_CARTRIDGE_INK_LEVEL;
	}
	/**
	 * Return the current ink level as a double value that is between 0.0 and 1.0.
	 * @return Ink Level
	 */
	public double getInkLevel()	{
		return Math.round(ink*100.0) / 100.0;
	}
	/**
	 * Return how much paper, in percentage, is left, rounded to the nearest percentage.
	 * @return Paper amount left in percentage.
	 */
	public int getPaperLevel()	{
		return Math.round((100 * paper) / TRAY_CAPACITY);
	}
	/**
	 * Return the exact count of the sheets of paper left in the tray.
	 * @return The number of sheets of paper left in the tray.
	 */
	public int getPaperLevelExact()	{
		return paper;
	}
	/**
	 * Return the total number of pages printed with full ink (i.e. blank pages do not count).
	 * @return Total pages used.
	 */
	public int getTotalPaperUsed()	{
		return pagesUsed;
	}
	/**
	 * Return the total number of pages printed with full ink (does not include blank pages).
	 * @return Total pages actually printed.
	 */
	public int getTotalPagesPrinted()	{
		return pagesPrinted;
	}
	/**
	 * Return the power status of the printer.
	 * @return True if the printer is on and false if the printer is off.
	 */
	public boolean isOn()	{
		return power;
	}
	/**
	 * Return the status of current wireless connection.
	 * @return True if connected and false otherwise.
	 */
	public boolean isConnected()	{
		return connection;
	}
	/**
	 * Turn the printer on and connect it to the network.
	 */
	public void turnOn()	{
		power = true;
		connection = true;
	}
	/**
	 * Turn the printer off and disconnect the wireless connection.
	 */
	public void turnOff()	{
		power = false;
		connection = false;
	}
	/**
	 * Connect the printer to the network.
	 */
	public void connect()	{
		connection = true;
	}
	/**
	 * Disconnect the wireless connection.
	 */
	public void disconnect()	{
		connection = false;
	}
}

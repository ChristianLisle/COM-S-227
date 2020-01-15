package hw1;

import java.util.Random;

public class WirelessPrinterTest {
	public static void main(String[] args) {
		//VALUES GIVEN: ---------------------------> (1.0, 500)
		WirelessPrinter printer = new WirelessPrinter(1.0, 500);
		int seed = 0;
		
		// try turn it on and test its wireless connection 
		printer.turnOn();
		System.out.println("true | " + printer.isOn()); // expected true
		System.out.println("true | " + printer.isConnected()); // expected true
		System.out.println("100  | " + printer.getPaperLevel()); // expected 100
		System.out.println("1.0  | " + printer.getInkLevel()); // expected 1.0
		
		// try print
		printer.print(50);
		System.out.println("90   | " + printer.getPaperLevel()); // expected 90
		System.out.println("0.95 | " + printer.getInkLevel()); // expected 0.95
		System.out.println("50   | " + printer.getTotalPagesPrinted()); // expected 50
		System.out.println("50   | " + printer.getTotalPaperUsed()); // expected 50
		
		// try print more pages than what is left in the tray
		printer.print(500); // out of paper
		System.out.println("0    | " + printer.getPaperLevel()); // expected 0
		System.out.println("0.5  | " + printer.getInkLevel());   // expected 0.5
		System.out.println("500  | " + printer.getTotalPagesPrinted()); // expected 500
		System.out.println("500  | " + printer.getTotalPaperUsed());  // expected 500
		
		// try loadPaper method
		printer.loadPaper(1000);
		System.out.println("500  | " + printer.getPaperLevelExact()); // expected 500
		
		
		// try replace the cartridge
		printer.replaceCartridge();
		System.out.println("1.0  | " + printer.getInkLevel());   // expected 1.0
		
		// try disconnect method
		printer.disconnect(); // network goes off
	    printer.print(50);
		System.out.println("500  | " + printer.getPaperLevelExact()); // expected 500
		System.out.println("1.0  | " + printer.getInkLevel());   // expected 1.0
	}
}

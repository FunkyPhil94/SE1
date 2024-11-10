package org.hbrs.se1.ws24.exercises.uebung1.control;

public class GermanTranslator implements Translator {

	public String date = "Okt/2024"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */

	private String[] zahlen = { "eins", "zwei", "drei", "vier" , "fünf",
			"sechs" , "sieben" , "acht" , "neun" , "zehn" };

	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]

		String result = " ";

		try {
			result = zahlen[number - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			result = "Übersetzung der Zahl " + number + " nicht möglich (Version: " + version + ")";
		}

		return result;
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2024"))
	 * Das Datum sollte system-intern durch eine Factory-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate(String date) {
		this.date = date;
	}

}

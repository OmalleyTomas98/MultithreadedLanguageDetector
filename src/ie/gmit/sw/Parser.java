package ie.gmit.sw;

import java.io.*;

/**
 * 
 * @author Tomas O'Malley
 * @version 2.0
 * @since 1.8
 * 
 *        Public class <b>parser</b> class is the brains of the application that
 *        parses the users input and determines the language.
 */

public class Parser implements Runnable {

	/**
	 * Variable Declaration
	 */
	private Database db = null;
	private String file;
	private int k;

	/**
	 * 
	 * @param file
	 * @param k
	 * 
	 */
	public Parser(String file, int k) {
		this.file = file;
		this.k = k;
	}

	/**
	 * 
	 * @param db Sets value of DB used
	 */
	public void setDb(Database db) {
		this.db = db;

	}

	/**
	 * Run method parses the file entered by the user
	 * 
	 */
	@Override
	public void run() {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] record = line.trim().split("@");
				if (record.length != 2)
					continue;
				parse(record[0], record[1]);

			}
			// close buffer reader
			br.close();
			// Debug catch An exception
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * 
	 * @param text
	 * @param lang
	 * @param ks
	 */
	private void parse(String text, String lang, int... ks) {
		Language language = Language.valueOf(lang);

		/**
		 * Loops over the Language
		 * 
		 */
		for (int i = 0; i <= text.length() - k; i++) {
			CharSequence kmer = text.substring(i, i + k);
			/**
			 * Adds the the database
			 */
			db.add(kmer, language);

		}
	}

	/**
	 * 
	 * 
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {

		Parser p = new Parser("wili-2018-Small-11750-Edited.txt", 1);

		/**
		 * Instantiate database object
		 */
		Database db = new Database();
		p.setDb(db);

		/**
		 * Creates Thread in database holding parser object
		 */
		Thread t = new Thread(p);
		t.start();
		t.join();

		db.resize(300);
		String s = "The Scene was a bare stark , unanimous done of a school room";


		System.out.println(db);

	}

	/**1
	 * 
	 * @param s Method analyses the file
	 */
	static void analyseQuery(String s) {

			System.out.println(" Parsing your  File" );
	}
}
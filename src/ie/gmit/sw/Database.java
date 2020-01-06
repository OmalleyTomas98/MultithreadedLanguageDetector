package ie.gmit.sw;

import java.util.*;

/**
 * 
 * @author Tomas O'malley
 * @version 2.0
 * @since 1.8
 * 
 *        Public Class <b>Database<b/>Holds existing and adds new languages in
 *        the project and stores and acts as a database for languages to be
 *        detected.
 *
 */

public class Database {

	/**
	 * 
	 */
	private Map<Language, Map<Integer, LanguageEntry>> db = new TreeMap<>();

	/**
	 * 
	 * @param s
	 * @param lang Adds a substring to n elements to the database
	 */

	public void add(CharSequence s, Language lang) {
		int kmer = s.hashCode();
		Map<Integer, LanguageEntry> langDb = getLanguageEntries(lang);

		/**
		 * 
		 */
		int frequency = 1;
		if (langDb.containsKey(kmer)) {
			frequency += langDb.get(kmer).getFrequency();
		}
		langDb.put(kmer, new LanguageEntry(kmer, frequency));

	}

	/**
	 * 
	 * @param lang
	 * @return
	 */
	private Map<Integer, LanguageEntry> getLanguageEntries(Language lang) {
		Map<Integer, LanguageEntry> langDb = null;
		if (db.containsKey(lang)) {
			langDb = db.get(lang);
		} else {
			langDb = new TreeMap<Integer, LanguageEntry>();
			db.put(lang, langDb);
		}
		return langDb;
	}

	/**
	 * 
	 * @param max Void method resizes the number of n-grams used in the parser
	 */

	public void resize(int max) {
		Set<Language> keys = db.keySet();
		for (Language lang : keys) {
			Map<Integer, LanguageEntry> top = getTop(max, lang);
			db.put(lang, top);
		}
	}

	/**
	 * 
	 * @param max
	 * @param lang
	 * @return
	 */
	public Map<Integer, LanguageEntry> getTop(int max, Language lang) {
		Map<Integer, LanguageEntry> temp = new TreeMap<>();
		List<LanguageEntry> les = new ArrayList<>(db.get(lang).values());
		Collections.sort(les);

		int rank = 1;
		for (LanguageEntry le : les) {
			le.setRank(rank);
			temp.put(le.getKmer(), le);
			if (rank == max)
				break;
			rank++;
		}

		return temp;
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	public Language getLanguage(Map<Integer, LanguageEntry> query) {
		TreeSet<OutOfPlaceMetric> oopm = new TreeSet<>();

		Set<Language> langs = db.keySet();
		for (Language lang : langs) {
			oopm.add(new OutOfPlaceMetric(lang, getOutOfPlaceDistance(query, db.get(lang))));
		}
		return oopm.first().getLanguage();
	}

	/**
	 * 
	 * @param query
	 * @param subject
	 * @return
	 */
	private int getOutOfPlaceDistance(Map<Integer, LanguageEntry> query, Map<Integer, LanguageEntry> subject) {

		int distance = 0;

		/**
		 * 
		 */
		Set<LanguageEntry> les = new TreeSet<>(query.values());
		for (LanguageEntry q : les) {
			LanguageEntry s = subject.get(q.getKmer());
			if (s == null) {
				distance += subject.size() + 1;
			} else {
				distance += s.getRank() - q.getRank();
			}
		}
		return distance;
	}

	/**
	 * 
	 * Compares The distance between strings
	 *
	 */
	private class OutOfPlaceMetric implements Comparable<OutOfPlaceMetric> {

		/**
		 * Instance Variables
		 * 
		 */
		private Language lang;
		private int distance;

		/**
		 * 
		 * @param lang
		 * @param distance
		 * 
		 *                 Method which calculates the distance between next substring
		 */
		public OutOfPlaceMetric(Language lang, int distance) {
			super();
			this.lang = lang;
			this.distance = distance;
		}

		/**
		 * 
		 * @return lang
		 */
		public Language getLanguage() {
			return lang;
		}

		/**
		 * 
		 * @return distance
		 */
		public int getAbsoluteDistance() {
			return Math.abs(distance);
		}

		/**
		 * 
		 * @return the difference between the two kmers
		 */
		@Override
		public int compareTo(OutOfPlaceMetric o) {
			return Integer.compare(this.getAbsoluteDistance(), o.getAbsoluteDistance());
		}

		/**
		 * @return lang , Distance in form of string
		 */
		@Override
		public String toString() {
			return "[lang=" + lang + ", distance=" + getAbsoluteDistance() + "]";
		}

	}

	/**
	 * @return sb 
	 */
	@Override
	public String toString() {

		/**
		 * 
		 */
		StringBuilder sb = new StringBuilder();

		int langCount = 0;
		int kmerCount = 0;
		Set<Language> keys = db.keySet();
		/**
		 * 
		 */
		for (Language lang : keys) {
			langCount++;
			sb.append(lang.name() + "->\n");

			/**
			 * Creates a collection of type languages
			 */
			Collection<LanguageEntry> m = new TreeSet<>(db.get(lang).values());
			kmerCount += m.size();
			for (LanguageEntry le : m) {
				sb.append("\t" + le + "\n");
			}
		}

		sb.append(kmerCount + " total k-mers in " + langCount + " languages");
		return sb.toString();
	}
}
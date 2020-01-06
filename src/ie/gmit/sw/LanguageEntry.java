package ie.gmit.sw;

/**
 * 
 * @author Tomas O'Malley
 * @version 2.0
 * @since 1.8
 * 
 *        Public class <b>LanguageEntry</b> Used to hold the frequencies and 
 *        compare the results to the file entered by the user  
 *
 */
public class LanguageEntry implements Comparable<LanguageEntry> {

	/**
	 * Variable Declaration
	 */
	private int kmer;
	private int frequency;
	private int rank;

	/**
	 * 
	 * @param kmer
	 * @param frequency
	 */
	public LanguageEntry(int kmer, int frequency) {
		super();
		this.kmer = kmer;
		this.frequency = frequency;
	}

	/**
	 * 
	 * @return kmer
	 */
	public int getKmer() {
		return kmer;
	}

	/**
	 * 
	 * @param kmer
	 *  method sets the Kmer
	 */
	public void setKmer(int kmer) {
		this.kmer = kmer;
	}

	/**
	 * 
	 * @return frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * 
	 * @param frequency
	 * Retrieves and sets the frequency
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * 
	 * @return rank
	 * 
	 * Method returns the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * 
	 * @param rank
	 * 
	 *  Sets the rank 
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * 
	 *  Method override to return integer value of next 
	 *  
	 *  @return frequency
	 */
	@Override
	public int compareTo(LanguageEntry next) {
		return -Integer.compare(frequency, next.getFrequency());
	}

	/**
	 * 
	 *@return Displays all the languages kmer, frequency and rank
	 */
	@Override
	public String toString() {
		return "[" + kmer + "/" + frequency + "/" + rank + "]";
	}
}
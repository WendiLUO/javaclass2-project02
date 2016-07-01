import java.util.HashMap;

/**
 *  
 *
 *  @author Foothill College, Wendi Luo
 */
public class CellularData {
	private double[][] table;
	// For quickly searching the index of a given country.
	private HashMap<String, Integer> countryToIndexMap;
	// For printing purpose.
	private String[] countryList;
	private int nextModifyingIndex;
	private int startingYear;
	
	private static final double NUM_FOR_PERIOD_ERROR_RESULT = -1f;
	
	/**
	 * 
	 * @param numRows
	 * @param numColumns
	 * @param startingYear
	 */
	public CellularData(int numRows, int numColumns, int startingYear) {
		this.table = new double[numRows][numColumns];
		this.nextModifyingIndex = 0;
		this.startingYear = startingYear;
		this.countryToIndexMap = new HashMap<>();
		this.countryList = new String[numRows];
	}
	
	/**
	 * 
	 * @param country
	 * @param countryData
	 * @return
	 */
	public boolean addCountry(String country, double[] countryData) {
		// If country is null or the inserting row is null, or the inserting row's column number doesn't
		// equals to the table's column, we return false, indicating invalid data.
		if (country == null
				|| countryData == null
				|| table.length == 0
				|| countryData.length != table[0].length) {
			return false;
		}
		
		// Since we are not using ArrayList, and the assignment doesn't require us to rewrite or delete
		// the table when it's full, we return false here, indicating that the table is full.
		if (nextModifyingIndex >= table.length) {
			return false;
		}
		
		// This implementation doesn't allow two countries having the same name in the table, we can't
		// calculate its corresponding number during period.
		if (countryToIndexMap.containsKey(country)) {
			return false;
		}
		
		// Copy the row into the stored table;
		for (int i=0; i < countryData.length; ++i) {
			table[nextModifyingIndex][i] = countryData[i];
		}
		// Record the country's corresponding index.
		countryToIndexMap.put(country, nextModifyingIndex);
		countryList[nextModifyingIndex] = country;
		++nextModifyingIndex;
		return true;
	}
	
	/**
	 * 
	 * @param country
	 * @param startingYear
	 * @param endingYear
	 * @return
	 */
	public double getNumSubscriptionsInCountryForPeriod(String country, int startingYear, int endingYear) {
		if (country == null || !countryToIndexMap.containsKey(country)) {
			System.out.println("ERROR : the requested country is not in the table.");
			return NUM_FOR_PERIOD_ERROR_RESULT;
		}
		
		if (endingYear < startingYear) {
			System.out.printf("ERROR : requested ending year %d is less than requested starting year %d\n",
					endingYear, startingYear);
			return NUM_FOR_PERIOD_ERROR_RESULT;
		}
		
		if (startingYear < this.startingYear) {
			System.out.printf("ERROR : requested starting year %d is less than the starting year of the table %d\n",
					startingYear, this.startingYear);
			return NUM_FOR_PERIOD_ERROR_RESULT;
		}
		
		int tableEndingYear = this.startingYear + this.table[0].length - 1;
		if (endingYear > tableEndingYear) {
			System.out.printf("ERROR : requested ending year %d is greater than the ending year of the table %d\n",
					endingYear, tableEndingYear);
			return NUM_FOR_PERIOD_ERROR_RESULT;
		}
		
		double sum = 0;
		// Inclusive
		int startIndex = startingYear - this.startingYear;
		// Inclusive
		int endIndex = endingYear - startingYear + startIndex;
		int countryIndex = countryToIndexMap.get(country);
		for (int i = startIndex; i <= endIndex; ++i) {
			sum += table[countryIndex][i];
		}
		
		System.out.printf("country is \"%s\", subscriptions from %d to %d\n",
				country, startingYear, endingYear);
		
		return sum;
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < table.length; ++i) {
			sb.append(countryList[i]);
			sb.append(' ');
			for (int j = 0; j < table[0].length; ++j) {
				sb.append(String.format("%.2f", table[i][j]));
				sb.append(' ');
				// We don't want to add enter when this is the last data.
				if ((j + 1) % 10 == 0 && j != table[0].length - 1) {
					sb.append('\n');
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}

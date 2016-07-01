/**
 *  Tests the CellularData class by reading in one dimensional arrays of countries.
 *  Given a country name and a range of years, computes the total number of subscriptions
 *  during that period.
 *
 *  @author Foothill College, Wendi Luo
 */
public class TestCellularData {

	public static void main(String[] args) 
	{
        // Part 1: Testing with partial data for a country --------------------------------------------
		System.out.println("Testing with Partial Data:");
        final double[] canadaPartial = {0,0,0.046433382,0.229211886,0.370663166,0.752880479,1.264765577};
        final double[] mexicoPartial = {0,0,0,0,0,0.001815204,0.010079818};
        final double[] usaPartial = {0,0.038253436,0.140659444,0.279060364,0.498659917,0.829863407,1.39281703};
		
		int startingYear = 1983;
		
		CellularData datatable;
		int numRows = 3;
		int numColumns = canadaPartial.length;
		
		datatable = new CellularData(numRows, numColumns, startingYear);
		
		datatable.addCountry("canada", canadaPartial);
		datatable.addCountry("mexico", mexicoPartial);
		datatable.addCountry("usa", usaPartial);
        
        System.out.println(datatable);
        // the output is:
        /*
        canada   0.00   0.00   0.05   0.23   0.37   0.75   1.26
        mexico   0.00   0.00   0.00   0.00   0.00   0.00   0.01
        usa      0.00   0.04   0.14   0.28   0.50   0.83   1.39
        */
        // Note: As long as your output is easily readable,
        //       then the alignment (i.e. tabs and white-space) of your output need not match mine.

		double totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("usa",1983,1989);
		System.out.printf("usa (1983 to 1989): %.2f \n", totalSubscriptions);
		// country is "usa", subscriptions from 1983 to 1989
		// the output is: 
		// usa (1983 to 1989): 3.18
		
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("mexico",1983,1989);
		System.out.printf("mexico (1983 to 1989): %.2f \n", totalSubscriptions);
		// country is "mexico", subscriptions from 1983 to 1989
		// the output is:
		// mexico (1983 to 1989): 0.01
		
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("canada",1890, 2000);
		System.out.printf("canada (1890 to 2000): %.2f \n", totalSubscriptions);
		// testing out-of-bounds data
		// ERROR : requested year 1890  is less than 1983
		// canada (1890 to 2000): -1.00
		
		
		// Part 2: Testing with all data for a country --------------------------------------------
		System.out.println("\n\nTesting with All Data:");
		final double[] canada = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.046433382,0.229211886,0.370663166,0.752880479,1.264765577,2.110674786,2.769888481,3.621301434,4.648371087,6.435664704,8.840378661,11.82226558,14.04583637,17.73689555,22.72196984,28.42909462,34.36625958,37.94941948,42.07126881,47.06386648,52.75959279,57.49320536,61.47310755,66.20487722,70.54830532,75.676078,79.41215888,80.05046389};
		final double[] mexico = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.001815204,0.010079818,0.074266061,0.183067275,0.348322481,0.421293924,0.608553991,0.721767371,1.051320868,1.758956617,3.326889843,7.556565917,13.55289414,20.65462731,24.29476815,27.85371761,35.15321825,42.56115672,49.40875353,58.62729509,65.49948112,71.45817512,77.51826326,79.24118294,83.35070827};
		final double[] usa = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.038253436,0.140659444,0.279060364,0.498659917,0.829863407,1.39281703,2.075802366,2.939643902,4.249049037,6.103716586,9.104921407,12.6047249,16.23815248,20.14238484,24.89063952,30.57610298,38.46809105,44.69057874,48.85103822,54.84681409,62.54719598,68.31769507,76.29353842,82.06414479,85.20916517,88.62364611,91.31165202,94.71891668,95.44786574};
		
        
        // NOTE: Your program should be able to handle a variety of start year and end year. So, do not assume that the data will always start from 1960 or end in on a particular year.
		startingYear = 1960;
		
		numRows = 3;
		numColumns = canada.length;
		
		datatable = new CellularData(numRows, numColumns, startingYear);
		
		datatable.addCountry("canada", canada);
		datatable.addCountry("mexico", mexico);
		datatable.addCountry("usa", usa);
		
        System.out.println(datatable);
        // the output is:
        /*
         canada   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00
         0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00
         0.00   0.00   0.00   0.00   0.00   0.05   0.23   0.37   0.75   1.26
         2.11   2.77   3.62   4.65   6.44   8.84  11.82  14.05  17.74  22.72
         28.43  34.37  37.95  42.07  47.06  52.76  57.49  61.47  66.20  70.55
         75.68  79.41  80.05
         mexico   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00
         0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00
         0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.01
         0.07   0.18   0.35   0.42   0.61   0.72   1.05   1.76   3.33   7.56
         13.55  20.65  24.29  27.85  35.15  42.56  49.41  58.63  65.50  71.46
         77.52  79.24  83.35
         usa      0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00
         0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00   0.00
         0.00   0.00   0.00   0.00   0.04   0.14   0.28   0.50   0.83   1.39
         2.08   2.94   4.25   6.10   9.10  12.60  16.24  20.14  24.89  30.58
         38.47  44.69  48.85  54.85  62.55  68.32  76.29  82.06  85.21  88.62
         91.31  94.72  95.45
         */
        // Note: As long as your output is easily readable,
        //       then the alignment (i.e. tabs and white-space) of your output need not match mine.

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("usa",1983,1989);
		System.out.printf("usa (1983 to 1989): %.2f \n", totalSubscriptions);
		// country is "usa", subscriptions from 1983 to 1989
		// the output is:
		// usa (1983 to 1989): 3.18

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("mexico",1960,2000);
		System.out.printf("mexico (1960 to 2000): %.2f \n", totalSubscriptions);
		// country is "mexico", subscriptions from 1960 to 2000
		// the output is:
		// mexico (1960 to 2000): 29.62
		
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("canada",1890, 2000);
		System.out.printf("canada (1890 to 2000): %.2f \n", totalSubscriptions);
        // Invalid input range:
        // The requested year of 1890 is less than the starting year of 1960.
        
        
        // TO COMPLETE: For full credit, include test cases in addition to those provided.
		System.out.println("\n\nTesting with My 5 Row Table With All Data:");
		final double[] aruba = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.029310471,0,0,2.138784453,3.605985937,3.98141538,6.16435217,13.48254011,16.50927821,57.05427692,65.05605558,72.10431377,99.64250268,103.3849507,108.1325002,112.2180618,119.2038996,126.2103374,129.72824,0,131.8565401};
		final double[] andorra = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1.307211734,1.278625641,1.250259142,4.424155104,8.538444783,13.44671556,22.12730607,32.14530928,35.99902139,43.27794118,45.77115817,68.60251444,73.82494308,79.48487497,84.27763597,78.1171579,80.2836099,82.06181111,84.06818386,83.53432222,81.50204186};
		final double[] afghanistan = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.112598381,0.865196277,2.498055472,4.826865367,9.833164022,17.71624331,29.22037376,37.89493697,45.77817474,60.32631999,60.35299258};
		final double[] angola = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.009672748,0.015532086,0.016472597,0.026485822,0.055130843,0.07474762,0.177638088,0.185322296,0.521366177,0.940444726,2.269621281,4.63174063,9.738161173,17.83989624,28.01098233,36.98368954,42.84657348,45.57339756,47.0305726,47.07374094};
		final double[] albania = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.068840778,0.099059921,0.168397958,0.331772024,0.901406013,11.94887288,26.07553141,33.95706284,39.16395669,47.87802749,60.06734238,73.35038415,58.91235149,78.1845877,85.468247,98.29153459,110.6865316};

		startingYear = 1960;
		
		numRows = 5;
		numColumns = aruba.length;
		
		datatable = new CellularData(numRows, numColumns, startingYear);
		
		datatable.addCountry("aruba", aruba);
		datatable.addCountry("andorra", andorra);
		datatable.addCountry("afghanistan", afghanistan);
		datatable.addCountry("angola", angola);
		datatable.addCountry("albania", albania);
		
        System.out.println(datatable);

        totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("andorra",1975,1995);
		System.out.printf("andorra (1975 to 1995): %.2f \n", totalSubscriptions);

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("angola",1960,2000);
		System.out.printf("angola (1960 to 2000): %.2f \n", totalSubscriptions);
		
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("albania",1997, 1997);
		System.out.printf("albania (1997 to 1997): %.2f \n", totalSubscriptions);
		

        // TO COMPLETE: Also, make sure to test for other invalid requests.
		System.out.println("\n\nTesting with My 5 Row Table With Invalid Data:");
		
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("make up country",1987, 1999);
		System.out.printf("make up country (1987 to 1999): %.2f \n", totalSubscriptions);
		
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("andorra",1999,1998);
		System.out.printf("andorra (1999 to 1998): %.2f \n", totalSubscriptions);

		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("angola",1800,1990);
		System.out.printf("angola (1800 to 1990): %.2f \n", totalSubscriptions);
		
		totalSubscriptions = datatable.getNumSubscriptionsInCountryForPeriod("albania",1997, 2997);
		System.out.printf("albania (1997 to 2997): %.2f \n", totalSubscriptions);
	}
}

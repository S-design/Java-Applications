public class Quarterly_Report {

    public static void main(String[] args) {
    	 // Data representing sales for each category in different months
        int[][] data = {
        		 // Sales data for each month and category
                // [Kitchen, Electrical, Bathroom, Soft Furnishing, Accessories]
                {67, 65, 63, 18, 16},  // April
                {63, 67, 63, 24, 23},  // May
                {78, 56, 65, 22, 21},  // June
                {78, 45, 71, 19, 19},  // July
                {104, 56, 73, 17, 20},  // August
                {103, 72, 69, 16, 19}   // September
        };
        
        // Calculate and print totals for different categories and months
        printTotalForCategory(data, "Accessories", 3, 4);  // Accessories category
        printTotalForSecondCategory(data, "Accessories", 3, 3, 4);  // Second Accessories category
        printTotalForCategory(data, "Soft Furnishing", 3, 3);  // Soft Furnishing category
        printTotalForSecondCategory(data, "Soft Furnishing", 3, 3, 3);  // Second Soft Furnishing category
        printTotalForCategory(data, "Bathroom", 3, 2);  // Bathroom category
        printTotalForSecondCategory(data, "Bathroom", 3, 3 , 2);  // Second Bathroom category
        printTotalForCategory(data, "Electrical", 3, 0);  // Electrical category
        printTotalForSecondCategory(data, "Electrical", 3, 3, 0);  // Second Electrical category
        printTotalForCategory(data, "Kitchen", 3, 1);  // Kitchen category
        printTotalForSecondCategory(data, "Kitchen", 3, 3, 1);  // Kitchen category
        
     // Calculate the highest of highest totals for the second quarter
        int[] highestInfo = calculateHighestOfHighestTotal(data, 3);
        int highestOfHighestTotal = highestInfo[0];
        String highestOfHighestTotalCategory =  highestInfo[1] == 0 ? "Electrical" : "Category " + highestInfo[1];

        // Print the highest of highest totals and corresponding category for the second quarter
        System.out.println("*****************");
        System.out.println("Highest of highest totals for the 2nd quater: " + highestOfHighestTotal + ",000");
        System.out.println("Category with the highest total: " + highestOfHighestTotalCategory);
        System.out.println("*****************");
        System.out.println("Totals Per Month");
        System.out.println("April: " + data[0][highestInfo[1]] + ",000");
        System.out.println("May: " + data[1][highestInfo[1]] + ",000");
        System.out.println("June: " + data[2][highestInfo[1]] + ",000");
        
     // Calculate the highest of highest totals for the third quarter
        int[] highestSecondInfo = calculateHighestOfHighestSecondTotal(data, 3, 3);
        int highestOfHighestSecondTotal = highestSecondInfo[0];
        String highestOfHighestSecondTotalCategory = highestInfo[1] == 0 ? "Electrical" : "Category " + highestInfo[1];
        
     // Print the highest of highest totals and corresponding category for the third quarter
        System.out.println("*****************");
        System.out.println("Highest of highest totals for the 3rd quater: " + highestOfHighestSecondTotal + ",000");
        System.out.println("Category with the highest total: " + highestOfHighestSecondTotalCategory);
        System.out.println("*****************");
        System.out.println("Totals Per Month");
        System.out.println("July: " + data[3][highestInfo[1]] + ",000");
        System.out.println("August: " + data[4][highestInfo[1]] + ",000");
        System.out.println("September: " + data[5][highestInfo[1]] + ",000");
        
     // Calculate the lowest of lowest totals for the second quarter
        int[] lowestInfo = calculateLowestOfLowestTotal(data, 3);
        int lowestOfLowestTotal = lowestInfo[0];
        String lowestCategory = lowestInfo[1] == 4 ? "Accessories" : "Category " + lowestInfo[1];

        // Print the lowest of lowest totals and corresponding category for the second quarter
        System.out.println("*****************");
        System.out.println("Lowest of lowest totals for the 2nd quarter: " + lowestOfLowestTotal + ",000");
        System.out.println("Category with the lowest total: " + lowestCategory);
        System.out.println("*****************");
        System.out.println("Totals Per Month");
        System.out.println("April: " + data[0][lowestInfo[1]] + ",000");
        System.out.println("May: " + data[1][lowestInfo[1]] + ",000");
        System.out.println("June: " + data[2][lowestInfo[1]] + ",000");
        
        // Calculate the lowest of lowest totals for the third quarter
        int[] lowestSecondInfo = calculateLowestOfLowestSecondTotal(data, 3, 3);
        int lowestOfLowestSecondTotal = lowestSecondInfo[0];
        String lowestOfLowestSecondTotalIndex = lowestSecondInfo[1] == 3 ? "Soft Furnishing" : "Category " + lowestSecondInfo[1];
       
     // Print the lowest of lowest totals and corresponding category for the third quarter
        System.out.println("*****************");
        System.out.println("Lowest of lowest totals for the 3rd quater: " + lowestOfLowestSecondTotal + ",000");
        System.out.println("Category with the lowest total: " + lowestOfLowestSecondTotalIndex);
        System.out.println("*****************");
        System.out.println("Totals Per Month");
        System.out.println("July: " + data[3][lowestSecondInfo[1]] + ",000");
        System.out.println("August: " + data[4][lowestSecondInfo[1]] + ",000");
        System.out.println("September: " + data[5][lowestSecondInfo[1]] + ",000");
        
     // Names of different categories
        String[] categoryNames = {"Electrical", "Kitchen", "Bathroom", "Soft Furnishing", "Accessories"};

        // Consider the first 3 months
        System.out.println("**** Second Quater ****");
        for (int categoryIndex = 0; categoryIndex < data[0].length; categoryIndex++) {
            int highestTotal = Integer.MIN_VALUE;
            String highestTotalMonth = "";

            for (int month = 0; month < 3; month++) {
                int total = calculateTotalCategoryAgain(data, month, categoryIndex);

                if (total > highestTotal) {
                    highestTotal = total;
                    highestTotalMonth = getMonthName(month);
                }
            }
            // Print the highest total for each category in the second quarter
            System.out.println("Highest total for " + categoryNames[categoryIndex] + ": " + highestTotal + ",000" + " in month " + highestTotalMonth);
        }

        System.out.println();  // Add a blank line between outputs

        // Consider the next 3 months for each category and print the highest total
        System.out.println("**** Third Quater ****");
        for (int categoryIndex = 0; categoryIndex < data[0].length; categoryIndex++) {
            int highestTotal = Integer.MIN_VALUE;
            String highestTotalMonth = "";

            for (int month = 3; month < 6; month++) {
                int total = calculateTotalCategoryAgain(data, month, categoryIndex);

                if (total > highestTotal) {
                    highestTotal = total;
                    highestTotalMonth = getMonthName(month);
                }
            }
         // Print the highest total for each category in the third quarter
            System.out.println("Highest total for " + categoryNames[categoryIndex] + ": " + highestTotal + ",000" + " in month " + highestTotalMonth);
        }
        
    }
    
    public static int calculateTotalCategoryAgain(int[][] data, int month, int categoryIndex) {
        return data[month][categoryIndex];
    }
    
    // This method calculates the total for a specific category and month.
    public static String getMonthName(int month) {
        String[] monthNames = {"April", "May", "June", "July", "August", "September"};
        return monthNames[month];
    }
    
    // This method returns the month name based on the provided month index.
    public static int[] calculateLowestOfLowestTotal(int[][] data, int months) {
        int lowestTotal = Integer.MAX_VALUE;
        int lowestTotalIndex = -1;

        // Iterate over each category and find the lowest total for that category
        for (int categoryIndex = 0; categoryIndex < data[0].length; categoryIndex++) {
            int total = calculateLowestTotalForCategory(data, months, categoryIndex);
            if (total < lowestTotal) {
                lowestTotal = total;
                lowestTotalIndex = categoryIndex;
            }
        }

        return new int[]{lowestTotal, lowestTotalIndex};
    }
    
    // This method calculates the lowest total and the corresponding category for the given months.
    public static int calculateLowestTotalForCategory(int[][] data, int months, int categoryIndex) {
        int lowestTotal = Integer.MAX_VALUE;

        // Iterate over each month and calculate the total for the specified category
        for (int i = 0; i < data.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < months; j++) {
                currentTotal += data[j][categoryIndex];
            }
            if (currentTotal < lowestTotal) {
                lowestTotal = currentTotal;
            }
        }

        return lowestTotal;
    }
    
    // This method calculates the lowest total and the corresponding category for the given months in a specific quarter.
    public static int[] calculateLowestOfLowestSecondTotal(int[][] data, int startMonthIndex, int months) {
        int lowestSecondTotal = Integer.MAX_VALUE;
        int lowestSecondTotalIndex = -1;

        // Iterate over the specified months and calculate the total for the specified category.
        for (int categoryIndex = 0; categoryIndex < data[startMonthIndex].length; categoryIndex++) {
            int totalSecond = calculateLowestTotalSecondForCategory(data, startMonthIndex, months, categoryIndex);
            if (totalSecond < lowestSecondTotal) {
                lowestSecondTotal = totalSecond;
                lowestSecondTotalIndex = categoryIndex;
            }
        }

        return new int[]{lowestSecondTotal, lowestSecondTotalIndex};
    }

    public static int calculateLowestTotalSecondForCategory(int[][] data, int startMonthIndex, int months, int categoryIndex) {
    	// Initialise the lowest total to the maximum possible value
        int lowestSecondTotal = Integer.MAX_VALUE;

        // Iterate over the specified months and calculate the total for the specified category
        for (int i = startMonthIndex; i < startMonthIndex + months; i++) {
            int currentSecondTotal = 0;
            // Sum up the values for the specified category for the specified months
            for (int j = startMonthIndex; j < startMonthIndex + months; j++) {
                currentSecondTotal += data[j][categoryIndex];
            }
            // Update the lowest total if the current total is lower
            if (currentSecondTotal < lowestSecondTotal) {
                lowestSecondTotal = currentSecondTotal;
            }
        }

        return lowestSecondTotal;
    }


    // Calculates the highest total and its corresponding index of a specific category for a given range of months
    public static int[] calculateHighestOfHighestSecondTotal(int[][] data, int startMonthIndex, int months) {
        int highestSecondTotal = Integer.MIN_VALUE; // Initialise the highest second total to the lowest possible value
        int highestSecondTotalIndex = -1; // Initialise the index of the highest second total

        // Iterate through each category for the specified range of months
        for (int categoryIndex = 0; categoryIndex < data[startMonthIndex].length; categoryIndex++) {
            int totalSecond = calculateHighestTotalSecondForCategory(data, startMonthIndex, months, categoryIndex);
            // Update the highest second total and its index if the current total is higher
            if (totalSecond > highestSecondTotal) {
                highestSecondTotal = totalSecond;
                highestSecondTotalIndex = categoryIndex;
            }
        }
        // Return an array containing the highest second total and its index
        return new int[]{highestSecondTotal, highestSecondTotalIndex};
    }

    // Calculates the highest total for a specific category over a range of months
    public static int calculateHighestTotalSecondForCategory(int[][] data,int startMonthIndex, int months, int categoryIndex) {
        int highestSecondTotal = Integer.MIN_VALUE; // Initialise the highest second total to the lowest possible value
        
        // Iterate through each month in the specified range
        for (int i = 0; i < data.length; i++) {
            int currentSecondTotal = 0;
            // Sum the values for the specified category within the range of months
            for (int j = startMonthIndex; j < startMonthIndex + months; j++) {
                currentSecondTotal += data[j][categoryIndex];
            }
            // Update the highest second total if the current total is higher
            if (currentSecondTotal > highestSecondTotal) {
                highestSecondTotal = currentSecondTotal;
            }
        }

        return highestSecondTotal; // Return the highest second total
    }

    // Calculates the highest total and its corresponding index of a specific category for the entire data-set
    public static int[] calculateHighestOfHighestTotal(int[][] data, int months) {
        int highestTotal = Integer.MIN_VALUE; // Initialise the highest total to the lowest possible value
        int highestTotalIndex = -1; // Initialise the index of the highest total

        // Iterate through each category for the specified range of months
        for (int categoryIndex = 0; categoryIndex < data[0].length; categoryIndex++) {
            int total = calculateHighestTotalForCategory(data, months, categoryIndex);
            // Update the highest total and its index if the current total is higher
            if (total > highestTotal) {
                highestTotal = total;
                highestTotalIndex = categoryIndex;
            }
        }

        // Return an array containing the highest total and its index
        return new int[]{highestTotal, highestTotalIndex};
    }

    // Calculates the highest total for a specific category over a range of months
    public static int calculateHighestTotalForCategory(int[][] data, int months, int categoryIndex) {
        int highestTotal = Integer.MIN_VALUE; // Initialise the highest total to the lowest possible value

        // Iterate through each month in the specified range
        for (int i = 0; i < data.length; i++) {
            int currentTotal = 0;
            // Sum the values for the specified category within the range of months
            for (int j = 0; j < months; j++) {
                currentTotal += data[j][categoryIndex];
            }
            // Update the highest total if the current total is higher
            if (currentTotal > highestTotal) {
                highestTotal = currentTotal;
            }
        }

        return highestTotal; // Return the highest total
    }
    
    
    // Calculates the total for a specific category over a range of months
    public static int calculateTotalCategory(int[][] data, int months, int categoryIndex) {
        int total = 0; // Initialise the total
        
        // Iterate through each month in the specified range and sum the values for the specified category
        for (int i = 0; i < months; i++) {
            total += data[i][categoryIndex];
        }
        return total; // Return the total
    }
    // Calculates the total for a specific category over a specified range of months
    public static int calculateTotalSecondCategory(int[][] data, int startMonthIndex, int monthsToConsider, int categoryIndex) {
        int total = 0;// Initialise the total
        
        // Iterate through each month in the specified range and sum the values for the specified category
        for (int i = startMonthIndex; i < startMonthIndex + monthsToConsider; i++) {
            total += data[i][categoryIndex];
        }
        return total; // Return the total
    }

    // Prints the total for a specific category for the second quarter
    public static void printTotalForCategory(int[][] data, String categoryName, int months, int categoryIndex) {
        int total = calculateTotalCategory(data, months, categoryIndex);
        // Print the total for the specified category in the second quarter
        System.out.println("Total " + categoryName + " for the 2nd quater: " + total + ",000");
    }
    
    // Prints the total for a specific category for the third quarter
    public static void printTotalForSecondCategory(int[][] data, String categoryName, int startMonthIndex, int monthsToConsider, int categoryIndex) {
        int total = calculateTotalSecondCategory(data, startMonthIndex , monthsToConsider, categoryIndex);
        // Print the total for the specified category in the third quarter
        System.out.println("Total " + categoryName + " for the 3rd quater: " + total + ",000");
    }
    
    
  
}

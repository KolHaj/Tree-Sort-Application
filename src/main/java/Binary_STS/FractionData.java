package Binary_STS;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
* File: FractionData.java
* Author: Kolger Hajati
* Date: February 22, 2019
* Purpose:This file handles fraction evaluation.
*/

public class FractionData implements Comparable <FractionData> {
	
	//Variables
    private double numbValue;
    private double denomValue;
    private double value;
    
    /**
    * Converts string fraction into integer of numerator
    * and denominator and checks for incorrect fraction.
    */
	FractionData (String fracInput) throws NumberFormatException {
		String[] fracStore;
		fracStore = fracInput.split("/");
		
		if (fracStore.length == 2) {
			numbValue = Integer.parseInt(fracStore[0]); 
			denomValue = Integer.parseInt(fracStore[1]); 
			value = numbValue / denomValue; 
		}
        else {
        	throw new NumberFormatException();
        }
    }

	//Getter of fraction value
    private Double getValue() {
        return this.value;
    }

    //Returns toString fraction
    public String toString() {
    	NumberFormat formatter = new DecimalFormat("0");
        return formatter.format(numbValue) + "/" + formatter.format(denomValue);
    }

    //Handles comparing the fractions
    public int compareTo(FractionData frac) {
        if (this.value == frac.getValue()) {
            return 0;
        }
        return this.value > frac.value ? 1 : -1;
    }
}
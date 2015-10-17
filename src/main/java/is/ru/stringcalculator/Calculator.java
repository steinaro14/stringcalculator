package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("-")){
			String[] numbers = splitNumbers(text); 
			getNegatives(numbers);
		}
		else if(text.contains(",") || text.contains("//")){
			return sum(splitNumbers(text));
		}
		else
			return 1;

	return 0;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    String delimiters = ",|/n";
	    if(numbers.startsWith("//")){
	    	delimiters += "|" + numbers.substring(2,3);
	    	numbers = numbers.substring(4);
	    }

	    return numbers.split(delimiters);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) > 1000){
        		continue;
        	}
		    total += toInt(number);
		}
		return total;
    }

    private static void getNegatives(String[] numbers){
	    String negatives = "";
	    for (String number : numbers){
	    	if(number.contains("-"))
	    		negatives += "," + number;
	    }

	    throw new RuntimeException("Negatives not allowed: " + negatives.substring(1));
		
	}



}
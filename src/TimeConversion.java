	import java.io.*;
	import java.math.*;
	import java.text.*;
	import java.util.*;
	import java.util.regex.*;


public class TimeConversion {

	    /*
	     * Complete the timeConversion function below.
	     */
	    static String timeConversion(String s) {
	        /*
	         * Write your code here.
	         */
	        char ch = s.charAt(8);
	    switch(ch){
	        case 'P':
	            s = Integer.toString((Integer.parseInt(s.substring(0,2)))+12)  + s.substring(2, s.length()-2);
	        break;
	        case 'A':
	            s= s.substring(0, s.length()-2);
	    }
	        return s;
	    }

	    private static final Scanner scan = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String s = scan.nextLine();

	        String result = timeConversion(s);

	        bw.write(result);
	        bw.newLine();

	        bw.close();
	    }
	}


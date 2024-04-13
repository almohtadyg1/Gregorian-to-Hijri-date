package gth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GregorianToHijri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
	        try {
	            System.out.print("Enter a date (dd/mm/yyyy): ");
	            String dateStr = sc.next();
	
	            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	            Date date = sdf.parse(dateStr);
	
	            Calendar cl = Calendar.getInstance();
	            cl.setTime(date);
	
	            HijrahChronology hijrahChronology = HijrahChronology.INSTANCE;
	            HijrahDate islamyDate = hijrahChronology.date(LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DATE)));
	
	            System.out.println(date.toString());
	            System.out.println(islamyDate.toString());
	        } catch (ParseException e) {
	            System.out.println("Invalid date format. Please enter the date in the format 'dd/mm/yyyy'.");
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid date.");
	        }
	        System.out.println("\nAgain? (Y/n): ");
	        String choice = sc.next().toLowerCase().replace("yes", "y");
	        
	        if (!choice.equals("y")) {
	        	break;
	        }
	        System.out.println("");	        
        }
    }
}
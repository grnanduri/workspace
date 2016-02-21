package com.selenium;

public class CompareString {
	public static void main(String[] args) {
        //Create two string objects
        String string1 = "knowledge is power" ;
        String string2 = "KNOWLEDGE IS POWER" ;
         
        System.out.println("Compare String with different case : "+string1.compareTo(string2) );
        System.out.println("Compare String ignoring case : "+string1.compareToIgnoreCase(string2) );
         
    }
}

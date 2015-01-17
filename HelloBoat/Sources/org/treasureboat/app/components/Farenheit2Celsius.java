package org.treasureboat.app.components;

public class Farenheit2Celsius {

    
            /**
             * Rechnet einen Temperaturwert gegeben in Grad,Fahrenheit Celsius in
             * den entsprechenden Wert Grad Fahrenheit um.
             */

	public void celsius2fahrenheit(double celsius) {
                    double fahrenheit = 0.0;
                    
                    fahrenheit = 9.0 / 5.0 * celsius + 32.0;
                    
                    System.out.println(celsius + " Grad Celsius sind " + fahrenheit  + " Grad Fahrenheit");
            }

            public void fahrenheit2celsius(double fahrenheit) {
                double celsius = 0.0;
                
                celsius = (fahrenheit - 32) * 5 / 9;
                
                System.out.println(fahrenheit + " Grad Fahrenheit sind " + celsius + " Grad Celsius");
        }
    
    }


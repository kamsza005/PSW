package danestatystyczne;

import java.util.Random;
import java.util.Scanner;

public class cwiczenie1 {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dlugosc tablicy:");
        int liczba = scanner.nextInt();
        
        double[] tablica = {2,3,3.5,4,4.5,5};
        double[] tablica2 = new double[liczba];
        double srednia=0;
        double wynik=0;
        
        for(int i=0;i<liczba;i++) {
        	Random rand = new Random();
        	int a = rand.nextInt(6);
        	tablica2[i]=tablica[a];
        	
        	System.out.println(tablica2[i]);
        	
        	srednia+=tablica2[i];
        	
        }
        
        System.out.println("Srednia "+srednia/liczba);
        
        
        double minimalna = tablica2[0];
        for (int i=1; i<liczba; i++) {
        	if (minimalna > tablica2[i]) {
        		minimalna = tablica2[i];
        	}
        }
        
        System.out.println("Minimalna: "+minimalna);
        
        double maksymalna = tablica2[0];
        for (int i=1; i<liczba; i++) {
        	if (maksymalna < tablica2[i]) {
        		maksymalna = tablica2[i];
        	}
        }
        
        System.out.println("Maksymalna: "+maksymalna);

        for(int i=0;i<liczba;i++) {
        	if((srednia/liczba)>tablica2[i]) {
        		System.out.println("Liczba "+tablica2[i]+" jest mniejsza od sredniej");

        	}
        	else if((srednia/liczba)<tablica2[i]) {
        		System.out.println("Liczba "+tablica2[i]+" jest wieksza od sredniej");

        	}
        }
        
        for(int i=0;i<liczba;i++) {
        	
        	wynik=wynik+((tablica2[i]-(srednia/liczba))*(tablica2[i]-(srednia/liczba)));
        }
        
		System.out.println("Odchylenie standardowe wynosi: "+wynik/(srednia/liczba));

        

	}

}

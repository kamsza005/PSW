package operacjenamacierzach;

import java.util.Random;
import java.util.Scanner;

public class cwiczenie2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        Random r = new Random();
 
        System.out.println("Podaj wielkosc macierzy kwadratowej");
        int wielkosc = in.nextInt();
     
        // Tworzenie tablicy dwuwymiarowej:
        int [][] tab = new int[wielkosc][wielkosc]; 
        int [][] tab2 = new int[wielkosc][wielkosc]; 
 
        //Przypisanie losoych wartosci
        
        for(int i=0; i<tab.length; i++){ // "Przejœcie" przez wiersze
            for(int j=0; j<tab[i].length; j++) {// "Przejœcie" przez kolumny
            	Random rand = new Random();
        		int a = rand.nextInt(21)-10;
            	tab[i][j]=a;
            }
        }
        
        
        //Wyswietlenie
        
        System.out.println("Macierz nr.1");
        for(int i=0; i<tab2.length; i++){ // "Przejœcie" przez wiersze
            for(int j=0; j<tab2[i].length; j++) {// "Przejœcie" przez kolumny
            	Random rand = new Random();
        		int a = rand.nextInt(21)-10;
            	tab2[i][j]=a;
            }
        }
        
        for(int i=0; i<tab2.length; i++){ // "Przejœcie" przez wiersze
            for(int j=0; j<tab2[i].length; j++)
            	System.out.print(tab2[i][j]+" ");
             	System.out.println(); 
        }
        
     	System.out.println(); 

     	System.out.println("Macierz nr.2");
        for(int i=0; i<tab.length; i++){ // "Przejœcie" przez wiersze
            for(int j=0; j<tab[i].length; j++)
            	System.out.print(tab[i][j]+" ");
             	System.out.println(); 
        }
        
        System.out.println(); 
        
        
        
        int [][] tab3 = new int[wielkosc][wielkosc]; 
        
        System.out.println("Macierz nr.3 po dodawaniu dwoch macierzy");
        for(int i=0; i<tab3.length; i++){ 
            for(int j=0; j<tab3[i].length; j++)
            	tab3[i][j]=tab[i][j]+tab2[i][j];
        }
        
        for(int i=0; i<tab3.length; i++){ // "Przejœcie" przez wiersze
            for(int j=0; j<tab3[i].length; j++)
            	System.out.print(tab3[i][j]+" ");
             	System.out.println(); 
        }
        
        System.out.println(); 
        
        int [][] tab4 = new int[wielkosc][wielkosc]; 
        
        System.out.println("Macierz nr.4 po odejmowaniu dwoch macierzy");
        for(int i=0; i<tab4.length; i++){ 
            for(int j=0; j<tab4[i].length; j++) {
            	tab4[i][j]=tab[i][j]-tab2[i][j];
            	tab4[i][j]*=-1;
            }
        }
        
        for(int i=0; i<tab4.length; i++){ // "Przejœcie" przez wiersze
            for(int j=0; j<tab4[i].length; j++)
            	System.out.print(tab4[i][j]+" ");
             	System.out.println(); 
        }
        
        
        
       
        


	}

}

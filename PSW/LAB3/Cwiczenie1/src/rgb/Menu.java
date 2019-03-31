package rgb;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean x = true;
        RGBController opcja = new RGBController();
        
        RGB kolor1 = new RGB();
        RGB kolor2 = new RGB();

        while (x) {
            System.out.println("1 - Inicjacja kolorów");
            System.out.println("2 - Wyœwietlenie kolorow");
            System.out.println("3 - Mieszanie kolorow");
            System.out.println("4 - Koniec");
          
            int wybor=input.nextInt();
          
            if(wybor==1) {
            	opcja.inicjacja(kolor1, kolor2);
            }
            else if(wybor==2) {
            	opcja.wyswietlenie(kolor1, kolor2);
            }
            else if(wybor==3) {
            	opcja.mieszanie(kolor1, kolor2);
            }
            else if(wybor==4) {
            	x=false;
            }
            else {
                System.out.println("Nie ma takiej opcji");
            }
            
        }


    }


}
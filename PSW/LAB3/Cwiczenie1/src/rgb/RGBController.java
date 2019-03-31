package rgb;

import java.util.Scanner;

public class RGBController {

    Scanner input = new Scanner(System.in);

    RGB kolor3 = new RGB();

    void inicjacja(RGB kolor1, RGB kolor2) {
    	
    	//KOLOR 1
        System.out.println("kolor1(R):");
        kolor1.setR_value(input.nextInt());
        if(kolor1.getR_value() > 255) kolor1.setR_value(255);
        else if(kolor1.getR_value() < 0)  kolor1.setR_value(0);
        
        System.out.println("kolor1(G):");
        kolor1.setG_value(input.nextInt());
        if(kolor1.getG_value() > 255) kolor1.setG_value(255);
        else if(kolor1.getG_value() < 0)  kolor1.setG_value(0);
        
        System.out.println("kolor1(B):");
        kolor1.setB_value(input.nextInt());
        if(kolor1.getB_value() > 255) kolor1.setB_value(255);
        else if(kolor1.getB_value() < 0)  kolor1.setB_value(0);
        
        
        //KOLOR 2
        System.out.println("kolor2(R):");
        kolor2.setR_value(input.nextInt());
        if(kolor2.getR_value() > 255) kolor2.setR_value(255);
        else if(kolor2.getR_value() < 0)  kolor2.setR_value(0);
        
        System.out.println("kolor2(G):");
        kolor2.setG_value(input.nextInt());
        if(kolor2.getG_value() > 255) kolor2.setG_value(255);
        else if(kolor2.getG_value() < 0)  kolor2.setG_value(0);
       
        System.out.println("kolor2(B):");
        kolor2.setB_value(input.nextInt());
        if(kolor2.getB_value() > 255) kolor2.setB_value(255);
        else if(kolor2.getB_value() < 0)  kolor2.setB_value(0);
    }

    void wyswietlenie(RGB kolor1, RGB kolor2){
        System.out.println("Kolor1: ");
        System.out.println("R:" + kolor1.getR_value()+" G:" + kolor1.getG_value()+" B:" + kolor1.getB_value());
        
        System.out.println("Kolor2: ");
        System.out.println("R:" + kolor2.getR_value()+" G:" + kolor2.getG_value()+" B:" + kolor2.getB_value());
      
    }

    void mieszanie(RGB kolor1, RGB kolor2) {
        kolor3.setR_value(kolor1.getR_value()+kolor2.getR_value());
        if(kolor3.getR_value() > 255) kolor3.setR_value(255);
        else if(kolor3.getR_value() < 0)  kolor3.setR_value(0);
           
        kolor3.setG_value(kolor1.getG_value()+kolor2.getG_value());
        if(kolor3.getG_value() > 255) kolor3.setG_value(255);
        else if(kolor3.getG_value() < 0) kolor3.setG_value(0);
            
        kolor3.setB_value(kolor1.getB_value()+kolor2.getB_value());
        if(kolor3.getB_value() > 255) kolor3.setB_value(255);
        else if(kolor3.getB_value() < 0) kolor3.setB_value(0);
            
        System.out.println("Wymieszany kolor: ");
        System.out.println("R:" + kolor3.getR_value()+" G:" + kolor3.getG_value()+" B:" + kolor3.getB_value());
       
    }

}
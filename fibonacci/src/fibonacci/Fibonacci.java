/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author kuupie
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*bilangan fibonacci
        
        */
        int a=0, b=1,c=1,i;                         //inisialisasi objeknya a merupakan deret ke-3, b deret ke-2 dan c merupakan deret ke-2 atau b
        System.out.println("Deret Fibonacci : ");   
        for (i=0;i<=10; i++) {                      //membuat deret angka, dari angka 1 - 10
            a=b;                                    //inisialisasi bahwa deret pertama adalah a dan a = b atau deret ke-1 = ke-2 berulang
            b=c;                                    //inisialisasi bahwa deret ke-2 adalah b dan b = c atau deret ke-2 = ke-3 berulang
            System.out.print(c+ " ");               //print hasil dari deret
            c=a+b;                                  //inisialisasi deret ke-3 adalah hasil penjumlahan dari deret ke-1 dan ke-2 berulang
        }
        
        /*bilangan prima
        
        */
        System.out.println("");
        System.out.println("");
        System.out.println("Bilang Prima :  ");
        
        int j,h,l,k;
        boolean prima;
        for(j=0;j<10;j++){
            prima = false;
            if(j==2){
              prima = true;
            } else {
                for(k=2;k<j;k++){
                    if(j%k==0){
                        prima = false;
                        break;
                    } else {
                        prima = true;
                    }
                }
            }
            if (prima){
                System.out.print(j+" ");
            }
        }
        
        /*bilangan deret
        
        */
        System.out.println("");
        System.out.println("");
        System.out.println("Bilang Deret :  ");
        
        for (h=1;h<=5;h++){
            System.out.println("");
            for (l=1;l<=h;l++){
                if(l==2){
                    System.out.print("hf, ");
                } else {
                    System.out.print(l+", ");
                }
            }
        }
        
        
        /*bilangan prima dengan syarat dan kondisi
        
        */
        System.out.println("");
        System.out.println("");
        System.out.println("Bilang Prima dengan Kondisi :  ");
        int y,z;
        boolean priima = false;
        
        for (y=0;y<=100;y++){
            priima = false;
            if (y==2){
                priima = true; 
            } else {
                for (z=2;z<y;z++){
                    if (y%z==0){
                        priima = false;
                        break;
                    } else {
                        priima=true;
                    }
                }
               
            }
             if(priima){
                 if(y%3==0 || y%5==0){
                     if(y%3==0){
                        System.out.print(" i, ");   
                     }
                     if(y%5==0){
                         System.out.print(" t, ");
                         
                     }
                         
                 } else {
                     System.out.print(y+" ,");
                 }
                  
                }
            
        }


    }
    
}

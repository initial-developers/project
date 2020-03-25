/**
 * SYST 17796 Project Winter 2019 Base code.
 * Kiranpreet Kaur, Roopminder Kaur, Nasreen, Gurtej Singh
 * 11 February 2020
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    
    private static int cash;
    private static int bet;
    
    private ArrayList <Player> players;
   
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    public void setPlayers(ArrayList <Player> players) 
    {
        players = players;
    }
    
    public static int Bet(int cash){
        Scanner sc=new Scanner(System.in);
        int bet=sc.nextInt();
        while(bet>cash)
        {
        System.out.println("You cannot bet more cash than you have!");
        System.out.println("How much would you like to bet?");
        bet=sc.nextInt();
        }
        return bet;
            }

        public static void declareWin(){
            System.out.println("Congratulations, you win!");
            cash=cash+bet;
            System.out.println("Cash: "+cash);
                }

        public static void declareLose(){
            System.out.println("Sorry, you lose!");
            cash=cash-bet;
            System.out.println("Cash: "+cash);
                }

        public static void Push(){
            System.out.println("It's a push!");
            System.out.println("You get your money back.");
            System.out.println("Cash: "+cash);
                }
        
        public static boolean checkBust(int handvalue){
              if(handvalue>21) {
              System.out.println("You have busted!");
              return true;
            }
        return false;
        }

        public static boolean isyesorno(String answer){
         if(answer.equals("yes") || answer.equals("no")) {
             return true;
         }
            return false;
    }

        public static void fivecardtrick(){
             System.out.println("You have achieved a five card trick!");
             declareWin();
        }  
}


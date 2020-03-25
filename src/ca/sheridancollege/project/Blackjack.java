/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
         
private static int cash;
private static int bet;
private static int AceCounter;
private static ArrayList<Card> hand;
private static int handvalue;
private static String name;

public static void main(String[] args){
    
    Game game=new Game();
    System.out.println("Welcome to BlackJack Game!");
    System.out.println("What is your name?");
    Scanner scan = new Scanner(System.in);
    name = scan.nextLine();
    
    System.out.println(name+", lets play BlackJack!");
    System.out.println("How much cash do you want to start with?");
    Scanner money = new Scanner(System.in);
    cash = money.nextInt();
    
    System.out.println("You start with cash: "+cash);
    
    while(cash>0){
        GroupOfCards showCard= new GroupOfCards();
        showCard.shuffle();
        AceCounter=0;
        Dealer dealer = new Dealer(showCard);
        List<Card> hand = new ArrayList<>();
        hand.add(showCard.drawCard());
        hand.add(showCard.drawCard());
        System.out.println("How much would you like to bet?");
        bet=game.Bet(cash);
        System.out.println("Cash:"+(cash-bet));
        System.out.println("Money on the table:"+bet);
        System.out.println("Here is your hand: ");
        System.out.println(hand);
        int handvalue = calcHandValue(hand);
        System.out.println("The dealer is showing: ");
        dealer.showCard();
        if(hasBlackJack(handvalue) && dealer.hasGame())
        {
            game.Blow();
        }
        else if(hasBlackJack(handvalue))
        {
            System.out.println("You have BlackJack!");
            System.out.println("You win 2x your money back!");
            cash=cash+bet;
            game.declareWin();
        }
        else if(dealer.hasGame())
        {
            System.out.println("Here is the dealer's hand:");
            dealer.showHandler();
            game.declareLose();
        }
        else
        {
            if(2*bet<cash)
            {
                System.out.println("Would you like to double down?");
                Scanner doubledown = new Scanner(System.in);
                String doubled = doubledown.nextLine();
                while(!game.Choice(doubled))
                {
                    System.out.println("Please enter yes or no.");
                    doubled = doubledown.nextLine();
                }
                if(doubled.equals("yes"))
                {
                    System.out.println("You have opted to double down!");
                    bet=2*bet;
                    System.out.println("Cash:"+(cash-bet));
                    System.out.println("Money on the table:"+bet);
                }
            }
            System.out.println("Would you like to hit or stand?");
            Scanner hitorstand = new Scanner(System.in);
            String hitter = hitorstand.nextLine();
            while(!isHitorStand(hitter))
            {
                System.out.println("Please enter 'hit' or 'stand'.");
                hitter = hitorstand.nextLine();
            }
            while(hitter.equals("hit"))
            {
                Hit(showCard, hand);
                System.out.println("Your hand is now:");
                System.out.println(hand);
                handvalue = calcHandValue(hand);
                if(game.Busted(handvalue))
                {
                    game.declareLose();
                    break;
                }
                if(handvalue<=21 && hand.size()==5)
                {
                    game.fivecardtrick();
                    break;
                }
                System.out.println("Would you like to hit or stand?");
                hitter = hitorstand.nextLine();
            }
            if(hitter.equals("stand"))
            {
                int dealerhand = dealer.yourTurn(showCard);
                System.out.println("");
                System.out.println("Here is the dealer's hand cards:");
                dealer.showHandler();
                if(dealerhand>21)
                {
                    game.declareWin();
                }
                else
                {
                    int you = 21-handvalue;
                    int deal = 21-dealerhand;
                    if(you==deal)
                    {
                        game.Blow();
                    }
                    if(you<deal)
                    {
                        game.declareWin();
                    }
                    if(deal<you)
                    {
                        game.declareLose();
                    }
                }
            }
        }
    System.out.println("Would you like to play again?");
    Scanner yesorno = new Scanner(System.in);
    String answer = yesorno.nextLine();
    while(!game.Choice(answer))
            {
                System.out.println("Please answer yes or no.");
                answer = yesorno.nextLine();
            }
    if(answer.equals("no"))
    {
        break;
    }
}
    System.out.println("Your cash is: "+cash);
    if(cash==0)
    {
        System.out.println("You ran out of cash!");
    }
    else
    {
        System.out.println("Enjoy your winnings, "+name+"!");
    }
}

public static boolean hasBlackJack(int handValue)
{
    if(handValue==21)
    {
        return true;
    }
    return false;
}

public static int calcHandValue(List<Card> hand)
{
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    int handvalue=0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && handvalue>21)
        {
            handvalue-=10;
            AceCounter--;
        }
    }
    return handvalue;
}

public static void Hit(GroupOfCards showCard, List<Card> hand)
{
    hand.add(showCard.drawCard());
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    handvalue = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && handvalue>21)
        {
            handvalue-=10;
            AceCounter--;
        }
    }
}

public static boolean isHitorStand(String hitter)
{
    if(hitter.equals("hit") || hitter.equals("stand"))
    {
        return true;
    }
    return false;
    }   
}

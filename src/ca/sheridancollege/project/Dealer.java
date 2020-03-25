/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

public class Dealer {
ArrayList<Card> hand;
private int valueSc=0;
private Card[] aHand;
private int AceCounter;

public Dealer(GroupOfCards showCards)
{
    hand = new ArrayList<>();
    aHand = new Card[]{};
    int AceCounter=0;
    for(int i=0; i<2; i++)
    {
        hand.add(showCards.drawCard());
    }
    aHand = hand.toArray(aHand);
    for(int i=0; i<aHand.length; i++)
    {
        valueSc += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && valueSc>21)
        {
            valueSc-=10;
            AceCounter--;
        }
    }
}

public void showCard()
{
    Card[] firstCard = new Card[]{};
    firstCard = hand.toArray(firstCard);
    System.out.println("["+firstCard[0]+"]");
}

public void dealerHit(GroupOfCards showCards)
{
    hand.add(showCards.drawCard());
    aHand = hand.toArray(aHand);
    valueSc = 0;
    for(int i=0; i<aHand.length; i++)
    {
        valueSc += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            AceCounter++;
        }
        while(AceCounter>0 && valueSc>21)
        {
            valueSc-=10;
            AceCounter--;
        }
    }
}

public boolean tryHit()
{
    if(valueSc<17)
    {
        return true;
    }
    return false;
}

public boolean hasGame()
{
    if(hand.size()==2 && valueSc==21)
    {
        System.out.println("The dealer has blackjack!");
        return true;
    }
    return false;
}

public void showHandler()
{
    System.out.println(hand);
}

public int getHandValue()
{
    return valueSc;
}

public boolean boosted(int handvalue)
{
    if(handvalue>21)
    {
        System.out.println("The dealer busted!");
        return true;
    }
    return false;
}

public int yourTurn(GroupOfCards showCards)
{
    while(tryHit())
    {
        System.out.println("The dealer hits");
        dealerHit(showCards);
        if(boosted(valueSc))
        {
            break;
        }
    }
    if(valueSc<=21)
    {
        System.out.print("The dealer stands.");
    }
    return valueSc;
}
    
}

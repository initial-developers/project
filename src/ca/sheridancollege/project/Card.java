/**
 * SYST 17796 Project Winter 2019 Base code.
 * Kiranpreet Kaur, Roopminder Kaur, Nasreen, Gurtej
 * 11 February 2020
 */
package ca.sheridancollege.project;

public class Card {
    
private int rank;    //represents the rank of a card
private int suit;   //represents the suit of a card
private int value;  //represents the value of a card
private static String[] ranks = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

public Card (int suit, int values)
{
    rank=values;
    suit=suit;
}

@Override
    public String toString(){
        return ranks[rank]+" of "+suits[suit];
    }

public int getRank(){
    return rank;
    }
public int getSuit(){
    return suit;
    }

public int getValue(){
    if(rank>10)
    {
        value=10;
    }
    else if(rank==1)
    {
        value=11;
    }
    else
    {
        value=rank;
    }
    return value;
    }

public void setValue(int set){
    value = set;
    }  
}

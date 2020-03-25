/**
 * SYST 17796 Project Winter 2019 Base code.
 * Kiranpreet Kaur, Roopminder Kaur, Nasreen, Gurtej
 * 11 February 2020
 */
package ca.sheridancollege.project;

public class Card {
    
private int position;    
private int sets;  
private int value;  
private static String[] positions = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

public Card (int suit, int values)
{
    position=values;
    suit=suit;
}

@Override
    public String toString(){
        return positions[position]+" of "+suits[sets];
    }

public int getPosition(){
    return position;
    }
public int getSet(){
    return sets;
    }

public int getValue(){
    if(position>10)
    {
        value=10;
    }
    else if(position==1)
    {
        value=11;
    }
    else
    {
        value=position;
    }
    return value;
    }

public void setValue(int set){
    value = set;
    }  
}

/**
 * SYST 17796 Project Winter 2019 Base code.
 * Kiranpreet Kaur, Roopminder Kaur, Nasreen, Gurtej Singh
 * 11 February 2020
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

public class GroupOfCards 
{
 private final ArrayList<Card> showCards;     //represents a deck of cards
public GroupOfCards()
{
    showCards = new ArrayList<>();
    for(int i=0; i<4; i++)
    {
        for(int j=1; j<=13; j++)
        {
            showCards.add(new Card (i,j));
        }
    }
}
/*
 * Shuffles the deck by changing the indexes of 200 random pairs of cards in the deck.
 */
public void shuffle()
{
    Random random = new Random();
    Card temp;
    for(int i=0; i<200; i++)
    {
        int index1 = random.nextInt(showCards.size()-1);
        int index2 = random.nextInt(showCards.size()-1);
        temp = showCards.get(index2);
        showCards.set(index2, showCards.get(index1));
        showCards.set(index1, temp);
    }
}

public Card drawCard()
{
    return showCards.remove(0);
}  
    
    
}


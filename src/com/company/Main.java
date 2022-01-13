package com.company;
public class Main{


    public static void main(String[] args)
    {
        Game game = new Game();

        game.GUI();
        game.ButtonNumListener();
        game.ButtonLetterListener();
        game.ButtonPlayListener();
    }

}

package com.company;

public class Enemy{

    int str= 0;
    int def = 0;
    char type = 'F';
    int health = 0;

    public void knight()
    {
        str = 100;
        def = 80;
        type = 'C';
        health = 100000;
    }

    public void archer()
    {
        str = 75;
        def = 50;
        type = 'L';
        health = 80000;
    }

    public void mainVillain()
    {
        str = 200;
        def = 150;
        type = 'C';
        health = 250000;
    }


}

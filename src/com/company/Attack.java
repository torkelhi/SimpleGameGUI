package com.company;

public class Attack{
    public int attackPower;
    public char attackType;

    public void fastAttack()
    {
        attackPower = 100000;
        attackType = 'C';
    }

    public void longAttack()
    {
        attackPower = 75000;
        attackType = 'L';
    }
}

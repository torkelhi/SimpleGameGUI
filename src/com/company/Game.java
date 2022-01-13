package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class Game {

    // x = enemyType; 1 = knight; 2 = archer; 3 = main villain;
    // y = attackType; 1 = fastattack; 2 = longAttack

    // a = enemy health
    // b = attack power
    // c = remaining health


    public int x;
    public int y;
    public Enemy enemy = new Enemy();
    public Attack attack = new Attack();

    JButton btn1 = new JButton("knight");
    JButton btn2 = new JButton("archer");
    JButton btn3 = new JButton("main villain");


    JButton btnA = new JButton("fast attack");
    JButton btnB= new JButton("long attack");

    JButton btnPlay= new JButton("Fight");

    JFrame frame = new JFrame();
    JPanel panelMain = new JPanel();

    JPanel panelEnemy = new JPanel();
    JPanel panelAttack = new JPanel();
    JPanel panelFight = new JPanel();
    JPanel panelOutput = new JPanel();
    JPanel panelInput = new JPanel();

    JTextArea output = new JTextArea(5,50);

    public void GUI() {

        panelEnemy.add(btn1);
        panelEnemy.add(btn2);
        panelEnemy.add(btn3);
        panelEnemy.setBackground(Color.RED);

        panelAttack.add(btnA);
        panelAttack.add(btnB);
        panelAttack.setBackground(Color.green);

        panelFight.add(btnPlay);
        panelFight.setBackground(Color.YELLOW);

        panelInput.add(panelEnemy);
        panelInput.add(panelAttack);
        panelInput.add(panelFight);

        panelOutput.add(output);

        panelMain.add(panelInput);
        panelMain.add(panelOutput);
        panelMain.setLayout(new GridLayout(2,1));

        frame.setTitle("Cmd Attack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panelMain);
        frame.pack();
        frame.setVisible(true);
    }

    public void ButtonNumListener()
    {
        ActionListener btnNumListener = e -> {
            if(e.getSource() == btn1)
            {x = 1;}
            else if(e.getSource() == btn2)
            {x = 2;}
            else if (e.getSource() == btn3)
            {x = 3;}
        };
        btn1.addActionListener(btnNumListener);
        btn2.addActionListener(btnNumListener);
        btn3.addActionListener(btnNumListener);
    }

    public void ButtonLetterListener()
    {
        ActionListener btnLetterListener = ae -> {
            if (ae.getSource() == btnA)
            {y=1;}
            else if (ae.getSource() == btnB)
            {y=2;}
        };
        btnA.addActionListener(btnLetterListener);
        btnB.addActionListener(btnLetterListener);
    }

    public void ButtonPlayListener()
    {
        ActionListener btnPlayListener = be ->{
            gamePlay();
        };
    btnPlay.addActionListener(btnPlayListener);
    }


    public void gamePlay()
    {
        if (x == 1 && y == 1)
        {
            enemy.knight();
            int a = enemy.health;

            attack.fastAttack();
            int b = attack.attackPower;

            output.setText("Knight VS FastAttack -> Super effective - EnemyHealth: " + (a - b));
        }

        else if (x == 1 && y ==2)
        {
            enemy.knight();
            int a = enemy.health;

            attack.longAttack();
            int b = attack.attackPower;

            output.setText("Knight VS LongAttack -> Good shot - EnemyHealth: " + (a - b));
        }
        else if (x == 2 && y == 1)
        {
            output.setText("Archer vs FastAttack -> You Attack a clone. Archer Would never be that close, try LongAttack");
        }

        else if (x == 2 && y == 2 )
        {
            enemy.archer();
            int a = enemy.health;

            attack.longAttack();
            int b = attack.attackPower;

            output.setText("Archer VS LongAttack -> Super effective - EnemyHealth: " + (a - b));

        }

        else if (x == 3 && y == 1 )
        {
            enemy.mainVillain();
            int a = enemy.health;

            attack.fastAttack();
            int b = attack.attackPower;

            output.setText("Main Villain vs Fast Attack -> You got the jump on the Main Villain, but he is strong- EnemyHealth: " + (a - b));
        }
        else if (x == 3 && y == 2 )
        {
            enemy.mainVillain();
            int a = enemy.health;

            attack.longAttack();
            int b = attack.attackPower;

            output.setText("Main Villain vs Long Attack -> Main Villains armor is strong -  EnemyHealth: " + (a - b));
        }
        else{
            output.setText("You must pick a enemy and attack");
        }

    }

}

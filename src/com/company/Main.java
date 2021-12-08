package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.imageio.*;


public class Main extends Frame {
    int playerWins = 0;
    int pcWins = 0;
    int afterTile  = 200;
    int playerPixelWidth = 90;
    int PlayerPixelHeight = 350;
    int pcPixelWidth = 500;
    int pcPixelHeight = 350;
    Random rad = new Random();
    int pc;
    int player;
    BufferedImage i;
    Button rock = new Button("Rock");
    Button paper = new Button("Paper");
    Button scissor = new Button("Scissor");
    public Main(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        add(rock);
        add(paper);
        add(scissor);
        setLayout(null);
        rock.setBounds(200 , afterTile , 100 , 50);
        paper.setBounds(310 , afterTile , 100 , 50);
        scissor.setBounds(420 , afterTile , 100 , 50);
        rock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = 1;
                pc = rad.nextInt(3)+1;
                repaint();
                record(player , pc);
            }
        });
        scissor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pc = rad.nextInt(3)+1;
                player = 2;
                repaint();
                record(player , pc);
            }
        });
        paper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pc = rad.nextInt(3)+1;
                player = 3;
                repaint();
                record(player , pc);
            }
        });

    }

    public void paint(Graphics g ){
        if(playerWins == 3 || pcWins == 3){
            WinnerMsg(g);
        }
        else{
            setBackground(Color.white);
            g.setFont(new Font("Ariel" , Font.PLAIN , 50));
            g.drawString("The Rock Paper Scissors" , 100 , 100);
            g.setFont(new Font("Monospaced" , Font.BOLD , 20));
            g.drawString("FIRST TO 3 WINS" , 300 , 150);
            g.setFont(new Font("SansSerif" , Font.PLAIN , 50));
            g.drawString("YOU" , 100 , 300);
            g.drawString("PC" , 520 , 300);
            playerScore(g);
            pcScore(g);
            //PLAYER
            if(player == 1){
                rock(g);
            }
            else if (player == 2){
                scissor(g);
            }
            else {
                paper(g);
            }
            //PC
            if(pc == 1){
                PCrock(g);
            }
            else if(pc == 2){
                PCscissors(g);
            }
            else{
                PCpaper(g);
            }
        }
    }
    public void playerScore(Graphics g){
        g.setFont(new Font("Ariel" , Font.PLAIN , 50));
        g.drawString(String.valueOf(playerWins), 250 , 300);
    }
    public void pcScore(Graphics g){
        g.setFont(new Font("Ariel" , Font.PLAIN , 50));
        g.drawString(String.valueOf(pcWins), 600 , 300);
    }
    public void record(int player ,int pc){
        if(player == 1){
            if(pc == 2){
                playerWins+=1;
            }
            else if(pc == 3){
                pcWins+=1;
            }
        }
        else if(player == 2){
            if(pc == 3){
                playerWins+=1;
            }
            else if(pc == 1){
                pcWins+=1;
            }
        }
        else if(player == 3){
            if (pc == 1){
                playerWins+=1;
            }
            else if(pc == 2){
                pcWins+=1;
            }
        }
    }
    public void WinnerMsg(Graphics g ){
        if(playerWins == 3){
            Color win = new Color(95, 221, 65);
            setBackground(win);
            g.setFont(new Font("Ariel" , Font.PLAIN , 50));
            g.drawString("YOU WON" , 245 , 450);
        }
        else if(pcWins == 3){
            Color lose = new Color(219, 61, 61);
            setBackground(lose);
            g.setFont(new Font("Ariel" , Font.PLAIN , 50));
            g.drawString("YOU LOST" , 245 , 450);
        }
        remove(rock);
        remove(paper);
        remove(scissor);
    }
    //PLAYER GRAPHICS
    public void rock(Graphics g){
        try {
            i = ImageIO.read(new File("C:\\Users\\Chinmay\\Desktop\\javaProject\\gem.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Insets insets = getInsets();
        g.drawImage(i,playerPixelWidth,PlayerPixelHeight,null);
    }
    public void paper(Graphics g){
        try {
            i = ImageIO.read(new File("C:\\Users\\Chinmay\\Desktop\\javaProject\\paper.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Insets insets = getInsets();
        g.drawImage(i,playerPixelWidth,PlayerPixelHeight,null);
    }
    public void scissor(Graphics g){
        try {
            i = ImageIO.read(new File("C:\\Users\\Chinmay\\Desktop\\javaProject\\scissors.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Insets insets = getInsets();
        g.drawImage(i,playerPixelWidth,PlayerPixelHeight,null);
    }

    //PC GRAPHHICS
    public void PCrock(Graphics g){
        try {
            i = ImageIO.read(new File("C:\\Users\\Chinmay\\IdeaProjects\\Just_Simple_Java_Stuff\\gem.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Insets insets = getInsets();
        g.drawImage(i,pcPixelWidth,pcPixelHeight,null);
    }
    public void PCpaper(Graphics g){
        try {
            i = ImageIO.read(new File("C:\\Users\\Chinmay\\IdeaProjects\\Just_Simple_Java_Stuff\\paper.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Insets insets = getInsets();
        g.drawImage(i,pcPixelWidth,pcPixelHeight,null);
    }
    public void PCscissors(Graphics g){
        try {
            i = ImageIO.read(new File("C:\\Users\\Chinmay\\IdeaProjects\\Just_Simple_Java_Stuff\\scissors.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Insets insets = getInsets();
        g.drawImage(i,pcPixelWidth,pcPixelHeight,null);
    }


    public static void main(String[] args) {
	// write your code here
        Main jvm = new Main();
        jvm.setSize(750 , 800);
        jvm.setVisible(true);
        jvm.setBackground(Color.white);
        jvm.setTitle("The Classic, Rock Paper And Scissor");

    }
}

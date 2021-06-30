package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame implements ActionListener {

    JButton[][] buttons = new JButton[3][3];
    int tor = 0;
    boolean faound = false;
    JLabel label = new JLabel();
    ImageIcon XIcon = new ImageIcon("src/XGame.png");
    ImageIcon OIcon = new ImageIcon("src/OGame.png");

    public Board(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setLayout(new GridLayout(3,3,5,5));
        label.setFont(new Font("MV Boli",Font.PLAIN,20));

        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.GRAY);
                this.add(buttons[i][j]);
                buttons[i][j].addActionListener(this);
            }
        }
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            for(int k =0;k<3;k++){
                for(int j=0;j<3;j++){
                    if(e.getSource()==buttons[k][j]&& tor ==0 && faound == false&&buttons[k][j].getIcon()==null){
                        buttons[k][j].setEnabled(false);
                        tor =1;
                        buttons[k][j].setIcon(XIcon);
                        buttons[k][j].setDisabledIcon(XIcon);
                        faound =ChackBoard(buttons,faound);
                    }
                    else if(e.getSource()==buttons[k][j]&& tor ==1 && faound == false&&buttons[k][j].getIcon()==null){
                        buttons[k][j].setEnabled(false);
                        tor =0;
                        buttons[k][j].setIcon(OIcon);
                        buttons[k][j].setDisabledIcon(OIcon);
                        faound=ChackBoard(buttons,faound);
                    }
                }
            }
            if(faound == true){
                if(tor == 1 ){
                    label.setText("X is the winner");
                }
                else if(tor == 0 ){
                    label.setText("O is the winner");
                }
                EndGame endGame = new EndGame();
                endGame.add(label);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setHorizontalAlignment(JLabel.CENTER);
            }
    }
    public static boolean ChackBoard(JButton[][] a,boolean b){
        for(int i = 0; i < 3; i++)
        {
            if (a[i][0].getIcon() == a[i][1].getIcon() && a[i][0].getIcon() == a[i][2].getIcon() && a[i][0].getIcon() != null) b = true;
        }
        if(b == false)
        {
            for (int i = 0; i < 3; i++)
            {
                if (a[0][i].getIcon() == a[1][i].getIcon() && a[0][i].getIcon() == a[2][i].getIcon() && a[0][i].getIcon() != null) b = true;
            }
        }
        if (b == false)
        {
            if (a[0][0].getIcon() == a[1][1].getIcon() && a[1][1].getIcon() == a[2][2].getIcon() && a[0][0].getIcon() != null) b = true;
        }
        if (b == false)
        {
            if (a[0][2].getIcon() == a[1][1].getIcon() && a[0][2].getIcon() == a[2][0].getIcon() && a[0][2].getIcon() != null) b = true;
        }
        return b;
    }

}

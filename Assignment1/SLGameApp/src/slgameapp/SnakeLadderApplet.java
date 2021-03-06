/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slgameapp;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ankit
 */
public class SnakeLadderApplet extends javax.swing.JApplet {

    /**
     * Initializes the applet SnakeLadderApplet
     */
    ArrayList<SLNumbers> snakes, ladders;
    int numberofPlayers, boardsize = 8;
    int playerpos[];
    int playerturns[];
    int lowestplayerturn;
    int currplayer = 0;
    GameBoardPanel p1;
    Random randomNumber = new Random();

    @Override
    public void init()
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(SnakeLadderApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SnakeLadderApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SnakeLadderApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SnakeLadderApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try
        {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run()
                {
                    initComponents();
                    getContentPane().removeAll();
                    getContentPane().setLayout(new GridLayout(1, 1));
                    snakes = new ArrayList<SLNumbers>();
                    ladders = new ArrayList<SLNumbers>();
                }
            });
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void start()
    {
        int design = JOptionPane.showOptionDialog(this, "DO u wish to design?", null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (design == 0)
        {
            designGame();


        }
        else
        {
            startDefaultGame();
        }
    }

    private void designGame()
    {
        getContentPane().add(jPanelDesign);
        setSize(jPanelDesign.getPreferredSize());
        jPanelDesign.setVisible(true);
    }

    private void restartGame()
    {
        jLabelPlayer3.setVisible(true);
        numberofPlayers = JOptionPane.showOptionDialog(this, "Select number of Players", "Player Number", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]
                {
                    "2 Players", "3 Players"
                }, "2 Players");
        numberofPlayers += 2;
        if (numberofPlayers == 2)
        {
            jLabelPlayer3.setVisible(false);
        }
        playerpos[0] = playerpos[1] = playerpos[2] = 0;
        playerturns[0] = playerturns[1] = playerturns[2] = 0;
        p1.drawCurrBoard(playerpos[0], playerpos[1], playerpos[2]);
        jButtonRoll.setText("Player 1\n Roll Dice!");
        p1.repaint();
        jButtonNewGame.setVisible(false);
        jButtonRoll.setVisible(true);
    }

    private void startDefaultGame()
    {
        snakes.add(new SLNumbers(45, 25));
        snakes.add(new SLNumbers(34, 17));
        ladders.add(new SLNumbers(5, 22));
        ladders.add(new SLNumbers(13, 48));
        boardsize = 8;
        startGame();
    }

    private void startGame()
    {
        getContentPane().removeAll();
        getContentPane().add(jPanelPlayGame);
        jPanelBoard.setSize(61 * boardsize, 61 * boardsize);
        setSize(61 * boardsize + jPanelOther.getPreferredSize().width + 50, 61 * boardsize + 70);
        // jPanelBoard.setSize(60*boardsize+jPanelOther.getWidth()+50,60*boardsize+70);


        p1 = new GameBoardPanel(snakes.size(), ladders.size(), boardsize, snakes, ladders);


        jLabelPlayer1.setOpaque(true);
        jLabelPlayer1.setBackground(new Color(0, 0, 255, 125));
        jLabelPlayer2.setOpaque(true);
        jLabelPlayer2.setBackground(new Color(0, 255, 0, 125));
        jLabelPlayer3.setOpaque(true);
        jLabelPlayer3.setBackground(new Color(255, 0, 0, 125));

        playerpos = new int[3];

        jPanelBoard.setLayout(new GridLayout(1, 1));
        jPanelBoard.add(p1);



        playerturns = new int[3];
        lowestplayerturn = 10000;
        restartGame();

    }

    private void checkSL()
    {
        for (int i = 0; i < snakes.size(); i++)
        {
            if (playerpos[currplayer] == snakes.get(i).initial)
            {
                JOptionPane.showMessageDialog(this, "Snake at board position " + snakes.get(i).initial + " got you!");
                playerpos[currplayer] = snakes.get(i).finl;
                return;
            }
        }
        for (int i = 0; i < ladders.size(); i++)
        {
            if (playerpos[currplayer] == ladders.get(i).initial)
            {
                JOptionPane.showMessageDialog(this, "You are up through ladder at position " + ladders.get(i).initial + "!");
                playerpos[currplayer] = ladders.get(i).finl;
                return;
            }
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanelPlayGame = new javax.swing.JPanel();
        jPanelBoard = new javax.swing.JPanel();
        jPanelOther = new javax.swing.JPanel();
        jPanelPlayerInfo = new javax.swing.JPanel();
        jLabelPlayer1 = new javax.swing.JLabel();
        jLabelPlayer2 = new javax.swing.JLabel();
        jLabelPlayer3 = new javax.swing.JLabel();
        jPanelCurrent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDiceVal = new javax.swing.JTextField();
        jButtonRoll = new javax.swing.JButton();
        jButtonNewGame = new javax.swing.JButton();
        jPanelDesign = new javax.swing.JPanel();
        jComboBoxBoardSize = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSnakeHead = new javax.swing.JComboBox();
        jComboBoxSnakeTail = new javax.swing.JComboBox();
        jComboBoxLadBottom = new javax.swing.JComboBox();
        jComboBoxLadTop = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonFinish = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(200, 200));
        getContentPane().setLayout(new java.awt.CardLayout(10, 10));

        javax.swing.GroupLayout jPanelBoardLayout = new javax.swing.GroupLayout(jPanelBoard);
        jPanelBoard.setLayout(jPanelBoardLayout);
        jPanelBoardLayout.setHorizontalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelBoardLayout.setVerticalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelOther.setMaximumSize(new java.awt.Dimension(300, 400));

        jPanelPlayerInfo.setLayout(new java.awt.GridLayout(3, 1));

        jLabelPlayer1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlayer1.setText("Player 1 Colour");
        jPanelPlayerInfo.add(jLabelPlayer1);

        jLabelPlayer2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlayer2.setText("Player 2 Colour");
        jPanelPlayerInfo.add(jLabelPlayer2);

        jLabelPlayer3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPlayer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlayer3.setText("Player 3 Colour");
        jPanelPlayerInfo.add(jLabelPlayer3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Dice Number");

        jTextFieldDiceVal.setEditable(false);
        jTextFieldDiceVal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldDiceVal.setText("0");

        jButtonRoll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonRoll.setText("Player 1  Roll Dice!");
        jButtonRoll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonRollActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCurrentLayout = new javax.swing.GroupLayout(jPanelCurrent);
        jPanelCurrent.setLayout(jPanelCurrentLayout);
        jPanelCurrentLayout.setHorizontalGroup(
            jPanelCurrentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCurrentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCurrentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRoll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCurrentLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDiceVal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCurrentLayout.setVerticalGroup(
            jPanelCurrentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCurrentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCurrentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDiceVal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonNewGame.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonNewGame.setText("New Game");
        jButtonNewGame.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonNewGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOtherLayout = new javax.swing.GroupLayout(jPanelOther);
        jPanelOther.setLayout(jPanelOtherLayout);
        jPanelOtherLayout.setHorizontalGroup(
            jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPlayerInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelOtherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelOtherLayout.setVerticalGroup(
            jPanelOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOtherLayout.createSequentialGroup()
                .addComponent(jPanelPlayerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelPlayGameLayout = new javax.swing.GroupLayout(jPanelPlayGame);
        jPanelPlayGame.setLayout(jPanelPlayGameLayout);
        jPanelPlayGameLayout.setHorizontalGroup(
            jPanelPlayGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPlayGameLayout.createSequentialGroup()
                .addComponent(jPanelBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelOther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPlayGameLayout.setVerticalGroup(
            jPanelPlayGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPlayGameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlayGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanelPlayGame, "card2");

        jComboBoxBoardSize.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxBoardSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "6", "7", "8", "9", "10", "11", "12" }));
        jComboBoxBoardSize.setSelectedIndex(3);
        jComboBoxBoardSize.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBoxBoardSizeItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Board Size");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Snake Head Position");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Snake Tail Position");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Ladder Top Position");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Ladder Bottom Position");

        jComboBoxSnakeHead.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBoxSnakeTail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBoxLadBottom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBoxLadTop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Add Snake");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Add Ladder");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSnakeTail, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBoxSnakeHead, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBoxLadTop, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxLadBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxSnakeHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxSnakeTail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBoxLadBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxLadTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonFinish.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonFinish.setText("Finish");
        jButtonFinish.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDesignLayout = new javax.swing.GroupLayout(jPanelDesign);
        jPanelDesign.setLayout(jPanelDesignLayout);
        jPanelDesignLayout.setHorizontalGroup(
            jPanelDesignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDesignLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDesignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDesignLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxBoardSize, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDesignLayout.setVerticalGroup(
            jPanelDesignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDesignLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDesignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBoardSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFinish))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelDesign, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRollActionPerformed
        int dice = randomNumber.nextInt(6) + 1;
        int temp = currplayer;
        jTextFieldDiceVal.setText("" + dice);
        playerpos[currplayer] += dice;
        playerturns[currplayer]++;
        checkSL();
        p1.drawCurrBoard(playerpos[0], playerpos[1], playerpos[2]);
        currplayer++;
        currplayer %= numberofPlayers;
        //  if(currplayer==0) currplayer++;
        jButtonRoll.setText("Player " + (currplayer + 1) + "\n Roll DIce!");
        p1.drawCurrBoard(playerpos[0], playerpos[1], playerpos[2]);
        if (playerpos[temp] >= boardsize * boardsize)
        {
            int k = JOptionPane.showOptionDialog(this, "Congralutions!! Player " + (temp + 1) + "Wins in " + playerturns[temp] + "steps", "Congrats", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]
                    {
                        "OK"
                    }, "OK");
            if (playerturns[temp] < lowestplayerturn)
            {

                JOptionPane.showMessageDialog(this, "Congralutions!! You beat past Score.\nPast highest Score: " + lowestplayerturn);
                lowestplayerturn = playerturns[temp];
            }
            jButtonRoll.setVisible(false);
            jButtonNewGame.setVisible(true);
        }

    }//GEN-LAST:event_jButtonRollActionPerformed

    private void jButtonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewGameActionPerformed
        restartGame();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewGameActionPerformed

    private void jComboBoxBoardSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxBoardSizeItemStateChanged
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel) jComboBoxSnakeHead.getModel();
        model.removeAllElements();
        boardsize = Integer.parseInt((String) jComboBoxBoardSize.getSelectedItem());
        snakes.clear();
        ladders.clear();
        for (int i = boardsize + 1; i <= boardsize * boardsize; i++)
        {
            model.addElement("" + i);
        }
        jComboBoxSnakeHead.setModel(model);
        jComboBoxLadTop.setModel(model);

        model = (DefaultComboBoxModel) jComboBoxSnakeTail.getModel();
        model.removeAllElements();
        for (int i = 1; i <= boardsize * (boardsize - 1); i++)
        {
            model.addElement("" + i);
        }
        jComboBoxLadBottom.setModel(model);
        jComboBoxSnakeTail.setModel(model);
    }//GEN-LAST:event_jComboBoxBoardSizeItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int head = Integer.parseInt((String) jComboBoxSnakeHead.getSelectedItem());
        int tail = Integer.parseInt((String) jComboBoxSnakeTail.getSelectedItem());
        if (head < tail)
        {
            JOptionPane.showMessageDialog(this, "Snake's head index mush be grater than tail index");
            return;
        }
        if ((head - 1) / boardsize == (tail - 1) / boardsize)
        {
            JOptionPane.showMessageDialog(this, "Snake's head and tail must not belong to same row");
            return;
        }
        for (int i = 0; i < snakes.size(); i++)
        {
            if (head == snakes.get(i).finl || tail == snakes.get(i).finl || head == snakes.get(i).initial || tail == snakes.get(i).initial)
            {
                JOptionPane.showMessageDialog(this, "A snake already exist it given position");
                return;
            }
        }
        for (int i = 0; i < ladders.size(); i++)
        {
            if (head == ladders.get(i).finl || tail == ladders.get(i).finl || head == ladders.get(i).initial || tail == ladders.get(i).initial)
            {
                JOptionPane.showMessageDialog(this, "A Ladder already exist it given position");
                return;
            }
        }
        snakes.add(new SLNumbers(head, tail));
        JOptionPane.showMessageDialog(this, "A snake sucessfully added");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int head = Integer.parseInt((String) jComboBoxLadTop.getSelectedItem());
        int tail = Integer.parseInt((String) jComboBoxLadBottom.getSelectedItem());
        if (head < tail)
        {
            JOptionPane.showMessageDialog(this, "Ladder's top index mush be grater than bottom index");
            return;
        }
        if ((head - 1) / boardsize == (tail - 1) / boardsize)
        {
            JOptionPane.showMessageDialog(this, "Ladder's top and buttom must not belong to same row");
            return;
        }
        for (int i = 0; i < snakes.size(); i++)
        {
            if (head == snakes.get(i).finl || tail == snakes.get(i).finl || head == snakes.get(i).initial || tail == snakes.get(i).initial)
            {
                JOptionPane.showMessageDialog(this, "A snake already exist it given position");
                return;
            }
        }
        for (int i = 0; i < ladders.size(); i++)
        {
            if (head == ladders.get(i).finl || tail == ladders.get(i).finl || head == ladders.get(i).initial || tail == ladders.get(i).initial)
            {
                JOptionPane.showMessageDialog(this, "A Ladder already exist it given position");
                return;
            }
        }
        ladders.add(new SLNumbers(tail, head));
        JOptionPane.showMessageDialog(this, "A Ladder sucessfully added");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinishActionPerformed
        startGame();                // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFinishActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonFinish;
    private javax.swing.JButton jButtonNewGame;
    private javax.swing.JButton jButtonRoll;
    private javax.swing.JComboBox jComboBoxBoardSize;
    private javax.swing.JComboBox jComboBoxLadBottom;
    private javax.swing.JComboBox jComboBoxLadTop;
    private javax.swing.JComboBox jComboBoxSnakeHead;
    private javax.swing.JComboBox jComboBoxSnakeTail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelPlayer1;
    private javax.swing.JLabel jLabelPlayer2;
    private javax.swing.JLabel jLabelPlayer3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBoard;
    private javax.swing.JPanel jPanelCurrent;
    private javax.swing.JPanel jPanelDesign;
    private javax.swing.JPanel jPanelOther;
    private javax.swing.JPanel jPanelPlayGame;
    private javax.swing.JPanel jPanelPlayerInfo;
    private javax.swing.JTextField jTextFieldDiceVal;
    // End of variables declaration//GEN-END:variables
}

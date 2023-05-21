package ShotTheDuck;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class FrameWithGameEasy extends JFrame {

    JFrame jFrame = new JFrame("Shot The Duck");
    JPanel jPanel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon icon = new ImageIcon("Images/backGroung.png");

            g.drawImage(icon.getImage(), 0,0,this);
            g.drawImage(icon.getImage(), 0, 0, this);
            g.drawImage(icon.getImage(), 0, 0, this);
            g.drawImage(icon.getImage(), 0, 0, this);
        }
    };
    JLabel pointsLabel1 = new JLabel();
    JLabel timeLabel1 = new JLabel();
    JLabel nameLabel1 = new JLabel();
    JFrame endOfTheGame = new JFrame();
    JPanel endOfTheGamePAnel = new JPanel(new BorderLayout());
    JLabel pointsLabel = new JLabel();
    JLabel lifeLabel = new JLabel();
    JLabel timeS = new JLabel();
    JLabel timeM = new JLabel();

    int lifes = 10;

    public FrameWithGameEasy() {

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK);
        jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "closeHotkey");
        jPanel.getActionMap().put("closeHotkey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        timeM.setFont(new Font("Serif", Font.ITALIC, 18));
        timeS.setFont(new Font("Serif", Font.ITALIC, 18));
        timeM.setBounds(400,20,70,20);
        timeS.setBounds(475,20,30,20);

        jPanel.add(timeM);
        jPanel.add(timeS);

        jPanel.setLayout(null);
        jFrame.getContentPane();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jPanel.setVisible(true);
        jPanel.setBackground(Color.CYAN);
        jFrame.setSize(1420, 810);
        jFrame.add(jPanel);
        createDuck();
        Duck.makeGameHarder();

        Thread createDuck = new Thread(() -> {
            try {

                do {
                    sleep(3000);
                    createDuck();
                }while(lifes > 0);
            } catch (Exception e){

            }
        });

        createDuck.start();
        Thread thread = new Thread(() -> {
            try {
                do {
                    sleep(1000);


                    setTime();
                    lifeLabel.setBounds(860, 20,100, 20);
                    lifeLabel.setFont(new Font("Serif", Font.ITALIC, 18));
                    lifeLabel.setText("Lifes : " + lifes);
                    jPanel.add(lifeLabel);
                    pointsLabel.setBounds(20,20,100,20);
                    pointsLabel.setText("Points : " + totalGamePoints);
                    pointsLabel.setFont(new Font("Serif", Font.ITALIC, 18));
                    jPanel.add(pointsLabel);
                    if(totalGamePoints > 100){
                        weaphonUpgrade();
                    }
                    if(lifes == 0 || lifes == -1){

                        NickName n = new NickName(true);

                        jFrame.dispose();


                        endOfTheGamePAnel.setLayout(null);
                        endOfTheGame.setVisible(true);
                        endOfTheGamePAnel.setVisible(true);
                        endOfTheGame.add(endOfTheGamePAnel);
                        endOfTheGamePAnel.setBackground(Color.orange);
                        pointsLabel1.setBounds(100,20,340,20);
                        pointsLabel1.setText("Points : " + totalGamePoints);
                        pointsLabel1.setFont(new Font("Serif", Font.ITALIC, 18));
                        endOfTheGamePAnel.add(pointsLabel1);

                        timeLabel1.setBounds(660, 20,340, 20);
                        timeLabel1.setFont(new Font("Serif", Font.ITALIC, 18));
                        timeLabel1.setText("Total time : " + minutes + ":" + seconds);
                        endOfTheGamePAnel.add(timeLabel1);

                        nameLabel1.setBounds(1150, 20,340, 20);
                        nameLabel1.setFont(new Font("Serif", Font.ITALIC, 18));

                        nameLabel1.setText("Nickname : " + n.nick);
                        endOfTheGamePAnel.add(nameLabel1);



                        Icon icon1 = new ImageIcon("Images/srart.jpeg");
                        JButton jButton1 = new JButton(icon1);
                        jButton1.setSize(new Dimension(553,156));
                        endOfTheGamePAnel.add(jButton1);
                        jButton1.setBounds(50,150 , 553, 156);
                        jButton1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Duck.step[0] = 1;
                                new DifficultyFrame();
                                endOfTheGame.dispose();
                            }
                        });

                        Icon icon2 = new ImageIcon("Images/score.jpeg");
                        JButton jButton2 = new JButton(icon2);
                        jButton2.setSize(new Dimension(553,156));
                        jButton2.setBounds(837,150 , 553, 156);
                        endOfTheGamePAnel.add(jButton2);

                        jButton2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                endOfTheGame.dispose();

                                JFrame highScoreFrame = new JFrame();

                                Object[][] namesAndPoints;


                                namesAndPoints = new Object[][]{
                                        {n.nick, totalGamePoints}
                                };
                                String[] columns = {"Nickname", "Points"};

                                JTable jTable = new JTable(namesAndPoints, columns);

                                JScrollPane jScrollPane = new JScrollPane(jTable);

                                highScoreFrame.add(jScrollPane);


                                JButton getBack = new JButton("Return back");

                                JPanel jPanel = new JPanel(new GridLayout());
                                jPanel.add(getBack);

                                highScoreFrame.setLayout(new BorderLayout());
                                highScoreFrame.add(jTable, BorderLayout.CENTER);
                                highScoreFrame.add(jPanel, BorderLayout.PAGE_END);


                                highScoreFrame.setLocationRelativeTo(null);
                                highScoreFrame.setSize(400, 600);
                                highScoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                highScoreFrame.setVisible(true);

                                getBack.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        highScoreFrame.dispose();
                                        Duck.step[0] = 1;
                                        SwingUtilities.invokeLater(Frame::new);

                                    }
                                });

                            }
                        });


                        Icon icon3 = new ImageIcon("Images/exit.jpeg");
                        JButton jButton3 = new JButton(icon3);
                        jButton3.setSize(new Dimension(553,156));
                        jButton3.setBounds(444,350 , 553, 156);
                        endOfTheGamePAnel.add(jButton3);
                        endOfTheGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        jButton3.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });

                        endOfTheGame.setSize(1440,700);
                    }
                } while (lifes > 0);
            } catch (Exception e){

            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            try {
                int n = 0;
                do {
                    sleep(5000);
                    addObstacle();
                    n++;
                }while(lifes > 0);
            } catch (Exception e){

            }
        });
        thread2.start();
        if(lifes == 0){
            jFrame.dispose();
        }
//       endTheGAme(comp);
    }
    Icon upgradeButtonPNG = new ImageIcon("Images/upgradeButtonForGame.png");
    Icon yellowDuck = new ImageIcon("Images/yellowduck.png");
    Icon greenDuck = new ImageIcon("Images/greenduck.png");
    Icon purrpleDuck = new ImageIcon("Images/purrpleduck.png");
    Icon redDuck = new ImageIcon("Images/redduck.png");
    Icon yellowDuckMirrored = new ImageIcon("Images/yellowduckmirrored.png");
    Icon greenDuckMirrored = new ImageIcon("Images/greenduckmirrored.png");
    Icon purrpleDuckMirrored = new ImageIcon("Images/purrpleduckmirrored.png");
    Icon redDuckMirrored = new ImageIcon("Images/redduckmirrored.png");
    int weaphonLevev = 1;
    int minWidth = 100;
    int maxWidth = 700;
    public void HighScoreFrame(){

    }
    public void createDuck() {
        final boolean[] isKilled = {false};
        int[] heightStartPoint = {1, 1319};
        Random r1 = new Random();
        int heightLocation = r1.nextInt(2);
        Random r = new Random();
        int widthLocation = r.nextInt((maxWidth - minWidth) + 1) + minWidth;

        Duck duck = new Duck(heightStartPoint[heightLocation], widthLocation, false);
        duck.setBounds(heightStartPoint[heightLocation], widthLocation, 100, 100);


        if (heightStartPoint[heightLocation] == 1319) {
            duck.left = true;

            Random r3 = new Random();
            int duckType = r3.nextInt(20);
            if (duckType < 10) {
                duck.setIcon(yellowDuck);
            } else if (duckType >= 10 && duckType < 15) {
                duck.setIcon(greenDuck);
            } else if (duckType >= 15 && duckType < 18) {
                duck.setIcon(purrpleDuck);
            } else {
                duck.setIcon(redDuck);
            }
            duck.setHealthPoint();
            duck.setOpaque(false);
            duck.setContentAreaFilled(false);
            duck.setBorderPainted(false);



        } else {

            Random r3 = new Random();
            int duckType = r3.nextInt(20);
            if (duckType < 10) {
                duck.setIcon(yellowDuckMirrored);
            } else if (duckType >= 10 && duckType < 15) {
                duck.setIcon(greenDuckMirrored);
            } else if (duckType >= 15 && duckType < 18) {
                duck.setIcon(purrpleDuckMirrored);
            } else {
                duck.setIcon(redDuckMirrored);
            }

            duck.setHealthPoint();
            duck.setOpaque(false);
            duck.setContentAreaFilled(false);
            duck.setBorderPainted(false);

        }
        if (duck.getIcon().equals(yellowDuck) || duck.getIcon().equals(yellowDuckMirrored)) {
            duck.addActionListener(new ActionListener() {
                int clicks = 1;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (clicks == 1) {
                        duck.setVisible(false);
                        jPanel.remove(duck);
                        isKilled[0] = true;
                        totalGamePoints = totalGamePoints + 10;
                    }

                    clicks++;
                }

            });
        } else if(duck.getIcon().equals(greenDuck) || duck.getIcon().equals(greenDuckMirrored)){
            if(weaphonLevev == 1) {
                duck.addActionListener(new ActionListener() {
                    int clicks = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clicks == 3) {
                            duck.setVisible(false);
                            jPanel.remove(duck);
                            isKilled[0] = true;
                            totalGamePoints = totalGamePoints + 30;
                        }
                        clicks++;

                    }

                });

            } else if(weaphonLevev == 2){
                duck.addActionListener(new ActionListener() {
                    int clicks = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clicks == 2) {
                            duck.setVisible(false);
                            jPanel.remove(duck);
                            isKilled[0] = true;
                            totalGamePoints = totalGamePoints + 30;
                        }
                        clicks++;

                    }

                });
            } else {
                duck.addActionListener(new ActionListener() {
                    int clicks = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clicks == 1) {
                            duck.setVisible(false);
                            jPanel.remove(duck);
                            isKilled[0] = true;
                            totalGamePoints = totalGamePoints + 30;
                        }
                        clicks++;

                    }

                });
            }
        } else if(duck.getIcon().equals(purrpleDuck) || duck.getIcon().equals(purrpleDuckMirrored)){
            if(weaphonLevev == 1){
            duck.addActionListener(new ActionListener() {
                int clicks = 1;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (clicks == 5) {
                        duck.setVisible(false);
                        jPanel.remove(duck);
                        isKilled[0] = true;
                        totalGamePoints = totalGamePoints + 50;
                    }
                    clicks++;

                }

            });
            } else if(weaphonLevev == 2) {
                duck.addActionListener(new ActionListener() {
                    int clicks = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clicks == 3) {
                            duck.setVisible(false);
                            jPanel.remove(duck);
                            isKilled[0] = true;
                            totalGamePoints = totalGamePoints + 50;
                        }
                        clicks++;

                    }

                });
            } else {
                duck.addActionListener(new ActionListener() {
                    int clicks = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clicks == 2) {
                            duck.setVisible(false);
                            jPanel.remove(duck);
                            isKilled[0] = true;
                            totalGamePoints = totalGamePoints + 50;
                        }
                        clicks++;

                    }

                });
            }
        } else {
            if(weaphonLevev == 1) {
                duck.addActionListener(new ActionListener() {

                    int clicks = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clicks == 10) {
                            duck.setVisible(false);
                            jPanel.remove(duck);
                            isKilled[0] = true;
                            totalGamePoints = totalGamePoints + 100;
                        }

                        clicks++;

                    }

                });
            } else if(weaphonLevev == 2) {
                duck.addActionListener(new ActionListener() {

                    int clicks = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clicks == 5) {
                            duck.setVisible(false);
                            jPanel.remove(duck);
                            isKilled[0] = true;
                            totalGamePoints = totalGamePoints + 100;
                        }

                        clicks++;

                    }

                });
            } else {
                duck.addActionListener(new ActionListener() {

                    int clicks = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clicks == 4) {
                            duck.setVisible(false);
                            jPanel.remove(duck);
                            isKilled[0] = true;
                            totalGamePoints = totalGamePoints + 100;
                        }

                        clicks++;

                    }

                });
            }
        }
        jPanel.add(duck);
        Thread thread = new Thread(() -> {
            try {

                do {
                    sleep( 1000/60);
                    if(duck.getX() > -100 || duck.getX() < 1470)
                        duck.move();
                } while (isKilled[0] == false);
            } catch (Exception e){

            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            try {
                boolean ifWasInterrupted = true;
                do {
                    sleep( 1000/60);
                    if(duck.getX() <= -100 || duck.getX() >= 1470){
                        jPanel.remove(duck);
                        System.out.println("Before : " + lifes);
                        lifes = lifes - 1;
                        System.out.println("After : "+lifes);


                        ifWasInterrupted = false;
                    }
                } while (ifWasInterrupted);
            } catch (Exception e){

            }
        });
        thread1.start();



    }
    Icon cloud = new ImageIcon("Images/cloud.png");
    Icon trunk = new ImageIcon("Images/treeTrunk.png");
    Icon nut = new ImageIcon("Images/nut.png");
    public void addObstacle(){

        int[] heightStartPoint = {-100, 1400};
        Random r1 = new Random();
        int heightLocation = r1.nextInt(2);
        Random r = new Random();
        int widthLocation = r.nextInt((maxWidth - minWidth) + 1) + minWidth;

        Obstacles obstacles = new Obstacles(heightStartPoint[heightLocation], widthLocation, false);
        if (heightStartPoint[heightLocation] == 1400) {
            obstacles.left = true;

            Random rand = new Random();
            int type = rand.nextInt(20);

            if(type < 10){
                obstacles.setIcon(cloud);
                obstacles.setSize(156, 100);
            } else if(type >= 10 && type < 15) {
                obstacles.setIcon(trunk);
                obstacles.setSize(225, 100);
            } else {
                obstacles.setIcon(nut);
                obstacles.setSize(100, 95);
            }


            obstacles.setOpaque(false);
            obstacles.setContentAreaFilled(false);
            obstacles.setBorderPainted(false);
            jPanel.add(obstacles);


        } else {

            Random rand = new Random();
            int type = rand.nextInt(3);
            Icon[] typeChoise = {cloud, trunk, nut};

            if(typeChoise[type].equals(cloud)){
                obstacles.setIcon(cloud);
            } else if(typeChoise[type].equals(trunk)) {
                obstacles.setIcon(trunk);
            } else {
                obstacles.setIcon(nut);
            }

            obstacles.setOpaque(false);
            obstacles.setContentAreaFilled(false);
            obstacles.setBorderPainted(false);
            jPanel.add(obstacles);

        }
        Thread thread = new Thread(() -> {
            try {
                do {
                    sleep(1000/60);
                    obstacles.move();
                } while(heightStartPoint[heightLocation] >= 0 || heightStartPoint[heightLocation] <= 1320);
            } catch (Exception e){

            }
        });
        thread.start();
    }
    int totalGamePoints;

    public void weaphonUpgrade(){
        JButton weaphonUpgradeButton = new JButton();
        weaphonUpgradeButton.setIcon(upgradeButtonPNG);
        weaphonUpgradeButton.setOpaque(false);
        weaphonUpgradeButton.setContentAreaFilled(false);
        weaphonUpgradeButton.setBorderPainted(false);

        weaphonUpgradeButton.setBounds(1250,10,162,41);

            jPanel.add(weaphonUpgradeButton);
        weaphonUpgradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaphonLevev++;
                totalGamePoints -= 100;
                weaphonUpgradeButton.setVisible(false);
                jPanel.remove(weaphonUpgradeButton);

            }
        });

    }
    int seconds = 0;
    int minutes = 0;
    public void setTime(){
        if (seconds + 1 == 60) {

            minutes += 1;
            seconds = 0;

            timeS.setText(":" + seconds);


        }
        if (minutes < 10)
            timeM.setText("Time: 0" + minutes);
        else
            timeM.setText("Time: " + minutes);

        if (seconds < 10)
            timeS.setText(": 0" + seconds);
        else
            timeS.setText(": " + seconds);

        seconds++;
    }




}





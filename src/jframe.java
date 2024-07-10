import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jframe extends JFrame implements ActionListener {

    JButton[][] buttons;
    private int x_axis;
    private int y_axis = 100;
    private int counter = 0;
    private double evenOrOdd = 0;
    JLabel labelPanel;
    JLabel label;
    JLabel label1;
    private String player1;
    private String player2;
    JButton submit;
    JButton tryAgain;
    private JTextField text1;
    private JTextField text2;
    private ImageIcon Background;
    private JLabel BackgroundLabel;

    jframe() {

        Background=new ImageIcon("background1.png");

        BackgroundLabel=new JLabel();
        BackgroundLabel.setIcon(Background);
        BackgroundLabel.setSize(this.getSize());
        BackgroundLabel.setLayout(new BorderLayout());

        buttons = new JButton[3][3];



        label1=new JLabel("Register to paly");
        label1.setLayout(null);
        label1.setBounds(670,250,300,50);
        label1.setBackground(Color.black);
        label1.setOpaque(true);
        label1.setVisible(true);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("MV boli",Font.ITALIC,30));
        this.setContentPane(BackgroundLabel);


        for (int i = 0; i < 3; i++) {
            x_axis = 670;
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setVisible(false);
                this.add(buttons[i][j]);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBounds(x_axis, y_axis, 100, 100);
                buttons[i][j].setFocusable(false);
                x_axis += 100;
            }
            y_axis += 100;
        }

        labelPanel = new JLabel();
        labelPanel.setIcon(Background);
        labelPanel.setLayout(new GridLayout(5, 0));
        labelPanel.setBounds(670, 350, 300, 300);
        labelPanel.setVisible(true);
        labelPanel.setFont(new Font("MV boli", Font.ITALIC, 20));
        labelPanel.setForeground(Color.WHITE);
        labelPanel.setBackground(Color.black);
        labelPanel.setOpaque(true);

        text1 = new JTextField(20);
        text1.setBackground(Color.white);
        text1.setSize(100, 50);
        text1.setFont(new Font("arial", Font.PLAIN, 30));
        text1.setVisible(true);
        text1.setOpaque(true);
        text2 = new JTextField(20);
        text2.setFont(new Font("arial", Font.PLAIN, 30));

        submit = new JButton("submit");
        submit.setSize(100, 50);
        submit.addActionListener(this);
        submit.setFocusable(false);
        label = new JLabel();
        label.setLayout(null);
        label.setBounds(760, 450, 120, 50);
        label.setBackground(Color.GRAY);
        label.setVisible(false);
        label.setOpaque(true);

        tryAgain = new JButton(" Restart");
        tryAgain.setBounds(0, 0, 120, 50);
        tryAgain.addActionListener(this);
        tryAgain.setBackground(Color.YELLOW);
        tryAgain.setForeground(Color.green);
        tryAgain.setFont(new Font("Mv boli", Font.PLAIN, 20));
        tryAgain.setFocusable(false);
        label.add(tryAgain);


        labelPanel.add(new Label("Name of Player1: "));
        labelPanel.add(text1);
        labelPanel.add(new Label("Name of Player2: "));
        labelPanel.add(text2);
        labelPanel.add(submit);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);

        this.setTitle("Tic_Tac_Toe");
        this.setLayout(null);
        this.setLocationRelativeTo(null);

      //  this.getContentPane().setBackground(new Color(10, 100, 80));
        this.add(label1);
        this.add(labelPanel);
        this.add(label);

        this.setVisible(true);

        this.pack();

    }
    private boolean gameEnded=false;


@Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == buttons[i][j]) {
                    counter++;
                    evenOrOdd = counter % 2;
                    if (evenOrOdd == 0) {
                        buttons[i][j].setText("X");
                        buttons[i][j].setFont(new Font("MV boli", Font.PLAIN, 45));
                    } else {
                        buttons[i][j].setText("O");
                        buttons[i][j].setFont(new Font("MV boli", Font.PLAIN, 45));
                    }

                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 1; b++) {

                            if (buttons[a][b].getText().equals(buttons[a][b + 1].getText()) && buttons[a][b + 1].getText().equals(buttons[a][b + 2].getText())) {
                                if (buttons[a][b].getText().equals("X")) {
                                    JOptionPane.showMessageDialog(null, player2, "*** winner ***", JOptionPane.PLAIN_MESSAGE);
                                    gameEnded = true;
                                    break;
                                } else if (buttons[a][b].getText().equals("O")) {
                                    JOptionPane.showMessageDialog(null, player1, "*** winner ***", JOptionPane.PLAIN_MESSAGE);
                                    gameEnded = true;
                                    break;
                                }
                            } else if (buttons[b][a].getText().equals(buttons[b + 1][a].getText()) && buttons[b + 1][a].getText().equals(buttons[b + 2][a].getText())) {
                                if (buttons[b][a].getText().equals("X")) {
                                    JOptionPane.showMessageDialog(null, player2, "*** winner ***", JOptionPane.PLAIN_MESSAGE);
                                    gameEnded = true;
                                    break;
                                } else if (buttons[b][a].getText().equals("O")) {
                                    JOptionPane.showMessageDialog(null, player1, "*** winner ***", JOptionPane.PLAIN_MESSAGE);
                                    gameEnded = true;
                                    break;
                                }
                            }
                        }
                        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText())) {
                            if (buttons[0][0].getText().equals("X")) {
                                JOptionPane.showMessageDialog(null, player2, "*** winner ***", JOptionPane.PLAIN_MESSAGE);
                                gameEnded = true;
                                break;
                            } else if (buttons[0][0].getText().equals("O")) {
                                JOptionPane.showMessageDialog(null, player1, "*** winner ***", JOptionPane.PLAIN_MESSAGE);
                                gameEnded = true;
                                break;
                            }
                        } else if ((buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()))) {
                            if (buttons[0][2].getText().equals("X")) {
                                JOptionPane.showMessageDialog(null, player2, "*** winner ***", JOptionPane.PLAIN_MESSAGE);
                                gameEnded = true;
                                break;
                            } else if (buttons[0][2].getText().equals("O")) {
                                JOptionPane.showMessageDialog(null, player1, "*** winner ***", JOptionPane.PLAIN_MESSAGE);
                                gameEnded = true;
                                break;
                            }
                        }
                    }
                    buttons[i][j].setEnabled(false);
                    boolean checkTryAgain=false;
                    int num=0;


for(i=0;i<3;i++)
                    {
                        for (j=0;j<3;j++)
                        {
                            if(!buttons[i][j].isEnabled())
                            {
                                num++;
                            }
                        }
                    }
                    if(num==9)
                    {
                        checkTryAgain=true;
                    }
                    if (gameEnded) {
                        for (i = 0; i < 3; i++) {
                            for (j = 0; j < 3; j++) {
                                buttons[i][j].setEnabled(false);
                            }
                        }
                    } else if (!gameEnded && (checkTryAgain)) {
                        JOptionPane.showMessageDialog(null, "Try Again", "Game Status", JOptionPane.WARNING_MESSAGE);

                    }


                }


            }
        }
        if (e.getSource() == submit) {
            player1 = text1.getText();
            player2 = text2.getText();
            submit.setEnabled(false);
            labelPanel.setVisible(false);
            label.setVisible(true);

            label1.setText("Play-Tic_Tac_Toe");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setVisible(true);
                }
            }


        }
        if (e.getSource() == tryAgain) {
            gameEnded=false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("");
                    buttons[i][j].setEnabled(true);
                }

            }


        }
    }
}
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

  private Random rand = new Random();
  private JFrame fram = new JFrame();
  private JPanel panl_title = new JPanel();
  private JPanel button = new JPanel();
  private JLabel textf = new JLabel();
  private JButton[] buttons = new JButton[9];
  private boolean player1_turn;

  public TicTacToe() throws InterruptedException {
    fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fram.setSize(600, 600);
    fram.getContentPane().setBackground(Color.GRAY);
    fram.setLayout(new BorderLayout());
    fram.setLocationRelativeTo(null);
		
    fram.setVisible(true);
    fram.setTitle("X-O Game");

    textf.setBackground(Color.CYAN);
    textf.setForeground(Color.blue);
    textf.setHorizontalAlignment(JLabel.CENTER);
    textf.setFont(new Font(null, 0, 65));
    textf.setText(" X - O ");

    panl_title.setLayout(new BorderLayout());
    panl_title.setBounds(0, 0, 600, 100);

    button.setLayout(new GridLayout(3, 3));
    button.setBackground(Color.GRAY);

    for (int i = 0; i < 9; i++) {
      buttons[i] = new JButton();
      button.add(buttons[i]);
      buttons[i].setFocusable(false);
      buttons[i].addActionListener(this);
      buttons[i].setFont(new Font(null, 0, 65));
    }

    panl_title.add(textf);
    fram.add(panl_title, BorderLayout.NORTH);
    fram.add(button);

    firstTurn();
  }

  public void firstTurn() throws InterruptedException {

    Thread.sleep(2000);

    if (rand.nextInt(2) == 0) {
      player1_turn = true;
      textf.setText("X turn");
    } else {
      player1_turn = false;
      textf.setText("O turn");

    }

  }

  public void check() {

    // Check X

    if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
      xWins(0, 1, 2);
    }
    if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
      xWins(3, 4, 5);
    }
    if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
      xWins(6, 7, 8);
    }
    if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
      xWins(0, 3, 6);
    }
    if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
      xWins(1, 4, 7);
    }
    if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
      xWins(2, 5, 8);
    }
    if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
      xWins(0, 4, 8);
    }
    if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
      xWins(2, 4, 6);
    }

    // Check O

    if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
      oWins(0, 1, 2);
    }
    if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
      oWins(3, 4, 5);
    }
    if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
      oWins(6, 7, 8);
    }
    if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
      oWins(0, 3, 6);
    }
    if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
      oWins(1, 4, 7);
    }
    if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
      oWins(2, 5, 8);
    }
    if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
      oWins(0, 4, 8);
    }
    if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
      oWins(2, 4, 6);
    }

    int j = 0;
    for (int i = 0; i < 9; i++) {
      if (buttons[i].getText() != "")
        j++;
    }
    if (j == 9) {
      for (int i = 0; i < 9; i++)
        buttons[i].setEnabled(false);
      textf.setText("Equals");  
    }
  }

  public void xWins(int a, int b, int c) {

    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);

    for (int i = 0; i < 9; i++)
      buttons[i].setEnabled(false);

    textf.setText("X wins");

  }

  public void oWins(int a, int b, int c) {

    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);

    for (int i = 0; i < 9; i++)
      buttons[i].setEnabled(false);

    textf.setText("O wins");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {

    for (int i = 0; i < 9; i++) {
      if (arg0.getSource() == buttons[i]) {
        if (player1_turn) {
          if (buttons[i].getText() == "") {
            buttons[i].setForeground(Color.red);
            buttons[i].setText("X");
            player1_turn = false;
            textf.setText("O turn");
            check();
          }
        } else {
          if (buttons[i].getText() == "") {
            buttons[i].setForeground(Color.blue);
            buttons[i].setText("O");
            player1_turn = true;
            textf.setText("X turn");
            check();
          }
        }
      }
    }

  }

}
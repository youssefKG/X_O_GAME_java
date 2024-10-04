package Board;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

enum Player { x, o }

class Button extends JButton {
  Player currentPlayer;
  public boolean isClicked = false;
  int index;

  public Button(Player currentPlayer) {
    this.currentPlayer = currentPlayer;
    String player = (this.currentPlayer == Player.x) ? "X" : "O";
    setText(player);

    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (Button.this.isClicked)
          return;
      }
    });
  }
}

public class Board extends JPanel {

  Dimension paneDimension = new Dimension(1000, 1000);

  public Board() {
    GridLayout buttonsGridLayout = new GridLayout(3, 3, 2, 2);

    setPreferredSize(new Dimension(1000, 1000));
    setBackground(Color.GRAY);

    for (int i = 0; i < 9; i++) {
      Button b = new Button(Player.x);
      add(b);
    }

    setLayout(buttonsGridLayout);
  }
}

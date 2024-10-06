package src;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel {
  Controller controller = new Controller();
  GridLayout buttonsGridLayout = new GridLayout(3, 3, 2, 2);
  public Board() {

    setPreferredSize(new Dimension(1000, 1000));
    setBackground(Color.GRAY);

    for (int i = 0; i < 9; i++) {
      final int index = i;
      JButton b = new JButton();
      b.setText(controller.board[1] + "");

      b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          System.out.println("the number of action performed : " + index);
          controller.play(index);

          b.setText(controller.board[index] + "");
          Board.this.printBoard();
        }
      });

      add(b);
    }

    setLayout(this.buttonsGridLayout);
    setVisible(true);
  }

  public void printBoard() {
    for (int i = 0; i < 9; i++) {
      if (i % 3 == 0)
        System.out.print("\n");
      System.out.print(this.controller.board[i]);
    }
  }
}

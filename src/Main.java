import javax.swing.*;
import src.*;

public class Main {
  public static void main(String[] args) {
   JFrame frame = new JFrame();
   Board bord = new Board();
    frame.setSize(1000, 1000);
    frame.add(bord);
    frame.setVisible(true);
  }
}

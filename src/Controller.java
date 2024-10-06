package src;
public class Controller {

  public char[] board = {'_', '_', '_', '_', '_', '_', '_', '_', '_'};
  private int winningCases[][] = {
      {0, 1, 2}, {0, 3, 6}, {0, 4, 8}, {2, 3, 6}, {2, 5, 8}};
  char currentPlayer = 'X';

  char winner = '_';

  public void play(int posistionIndex) {
    if (board[posistionIndex] != '_') {
      System.out.println("this case is not empty");
      return;
    }
    if (this.winner != '_') {
      System.out.println("the game is end and the winner is " + this.winner);
      return;
    }

    this.switchPlayer();
    this.board[posistionIndex] = this.currentPlayer;
    this.checkTheWinner();

    if (checkIfGameIsOver()) {
      System.out.println("the game is over");
    }
  }

  private void checkTheWinner() {
    int i;
    for (int[] winneCase : winningCases) {
      for (i = 0; i < 3; i++) {
        if (board[winneCase[i]] != this.currentPlayer)
          break;
      }
      if (i == 3) {
        this.winner = this.board[winneCase[0]];
        break;
      }
    }
  }

  private boolean checkIfGameIsOver() {
    for (int i = 0; i < 9; i++) {
      if (board[i] == '_')
        return false;
    }
    return true;
  }

  private void switchPlayer() {
    if (this.currentPlayer == 'X')
      this.currentPlayer = 'O';
    else
      this.currentPlayer = 'X';
  }
}

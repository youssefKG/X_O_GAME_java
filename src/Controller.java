package controller;

enum Player { x, o }

public class Controller {

  public Player[] board = {null, null, null, null, null, null, null, null};
  private int winningCases[][] = {
      {0, 1, 2}, {0, 3, 6}, {0, 4, 8}, {2, 3, 6}, {2, 5, 8}};
  Player currentPlayer = Player.x;
  Player winner = null;

  public void play(int posistionIndex) {
    if (board[posistionIndex] != null) {
      System.out.println("this case is not empty");
      return;
    }

    this.switchPlayer();
    this.board[posistionIndex] = this.currentPlayer;
    this.checkTheWinner();

    if (this.winner != null) {
      System.out.println("the winner is " + this.currentPlayer);
      return;
    }

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
      if (board[i] == null)
        return false;
    }
    return true;
  }

  private void switchPlayer() {
    if (this.currentPlayer == Player.x)
      this.currentPlayer = Player.o;
    else
      this.currentPlayer = Player.x;
  }
}

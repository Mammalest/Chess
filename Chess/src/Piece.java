public abstract class Piece {
    boolean isWhite;            //made it boolean instead of int to make it more efficent canMove method (true for white, false for black)

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract String toString();  // will return intial letter, uppercase for white and lowercase for black (except N for Knight)
    public abstract boolean canMove(int sx,int sy,int ex, int ey, ChessBoard board);  // checks if move is doable
}

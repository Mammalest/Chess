public class Pawn extends Piece{
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    public String toString(){
        if(isWhite()){
            return "P";
        }
        else{
            return "p";
        }
    }
    public boolean canMove(int sx, int sy, int ex, int ey, ChessBoard board) {
        int direction = isWhite() ? 1 : -1;
        // Pawn moves forward one square
        if (sx == ex && sy + direction == ey && !board.getSquare(ex, ey).check_if_has_piece()) {
            if((isWhite() && ey == 7) || !isWhite() && ey == 0){
                board.getSquare(sx, sy);
            }
            return true;
        }

        // Pawn's initial two-square move
        if (sy == 1 && sy + (2 * direction) == ey && sx == ex && !board.getSquare(ex, ey).check_if_has_piece()) {
            if (!board.getSquare(sx, sy + direction).check_if_has_piece()) {
                return true;
            }
        }

        // Pawn captures diagonally
        if (Math.abs(ex - sx) == 1 && sy + direction == ey && board.getSquare(ex, ey).check_if_has_piece()) {
            Piece capturedPiece = board.getSquare(ex, ey).getPiece();
            if (capturedPiece.isWhite() != isWhite()) {
                return true;
            }
        }

        return false;
    }
}

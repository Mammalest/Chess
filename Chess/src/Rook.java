public class Rook extends Piece{
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    public String toString(){
        if(isWhite()){
            return "R";
        }
        else{
            return "r";
        }
    }


    public boolean canMove(int sx,int sy,int ex, int ey, ChessBoard board){
        if (sx == ex || sy == ey) {
            if (sy == ey) {                    // Checks for obstruction along the row
                int min = Math.min(sx, ex);
                int max = Math.max(sx, ex);
                for (int x = min + 1; x < max; x++) { 
                    if (board.getSquare(x, sy).check_if_has_piece()) {
                        return false;  // Obstruction found
                    }
                }
            }
            else {                             // Checks for obstruction along the column
                int min = Math.min(sy, ey);
                int max = Math.max(sy, ey);
                for (int x = min + 1; x < max; x++) { 
                    if (board.getSquare(x, sy).check_if_has_piece()) {
                        return false;  // Obstruction found
                    }
                }
            }
        } 
        else if(board.getSquare(ex, ey).piece == null || (board.getSquare(ex,ey).piece.isWhite != this.isWhite())) {
            return true;           // Invalid move
        }
        return false;
    }
}

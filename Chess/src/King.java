public class King extends Piece{
    public King(boolean isWhite) {
        super(isWhite);
    }

    public String toString(){
        if(isWhite()){
            return "K";
        }
        else{
            return "k";
        }
    }

    public boolean canMove(int sx, int sy, int ex, int ey, ChessBoard board) {
        if (Math.abs(ex - sx) <= 1 && Math.abs(ey - sy) <= 1) {         // Check if the move is within one square in any direction
            return true;
        }
        return false;
    }
}  
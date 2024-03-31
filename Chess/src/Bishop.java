public class Bishop extends Piece{
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    public String toString(){
        if(isWhite()){
            return "B";
        }
        else{
            return "b";
        }
    }

    public boolean canMove(int sx, int sy, int ex, int ey, ChessBoard board){
        if (Math.abs(ex - sx) == Math.abs(ey - sy)) {           //checks if diagonal
            if (ex >= 0 && ex < 8 && ey >= 0 && ey < 8) {                    // checks if there are any pieces in between
                int dx = Integer.compare(ex, sx);           // Direction of x movement (1 or -1)
                int dy = Integer.compare(ey, sy);           // Direction of y movement (1 or -1)
    
                int currentX = sx + dx;
                int currentY = sy + dy;
    
                while (currentX != ex && currentY != ey) {                                      // Check if there is a piece at the current position
                    if (board.getSquare(currentX,currentY).check_if_has_piece()) {                               // If there is, the move is invalid
                        return false;
                    }
                    currentX += dx;
                    currentY += dy;
                }
                return true;
            } 
            else{
                return false;
            }
        }
        return false;
    }
}
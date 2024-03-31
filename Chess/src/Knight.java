public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    }
    
    public String toString(){
        if(isWhite()){
            return "N";
        }
        else{
            return "n";
        }
    }

    public boolean canMove(int sx,int sy,int ex, int ey, ChessBoard board){
        if(((Math.abs(sx-ex) == 2) && (Math.abs(sy-ey)==1))||((Math.abs(sy-ey) == 2) && (Math.abs(sx-ex)==1))){
            return true; 
        }
        return false;
    }
}

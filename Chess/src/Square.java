public class Square{
    int row;
    int col;
    Piece piece;

    public Square(int row, int col){        //empty square constructor
        this.row = row;
        this.col = col;
    }

    public Square(int row, int col, Piece piece){       //filled square constructor
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public Piece empty_and_return(){       //empties the square and returns the piece inside it
        Piece temp = this.piece;
        this.piece = null;
        return temp;
    }

    public void fill_or_change_piece(Piece newPiece){
        this.piece = newPiece;
    }

    public boolean check_if_has_piece(){
        if(this.piece == null){
            return false;
        }
        else{
            return true;
        }
    }


    public String toString(){
        if(piece == null){
            return " ";
        }
        return piece.toString();
    }

    public Piece getPiece() {
        return this.piece;
    }
}
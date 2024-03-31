public class ChessBoard{
    Square[][] squares = new Square[8][8];   //2d array for board
    

    public ChessBoard(){
        make_board();
    }

    public void movemaker(int sx, int sy, int ex, int ey){
        squares[ey][ex].fill_or_change_piece(getSquare(sx, sy).empty_and_return());   
    }


    public Square getSquare(int row, int col) {
        return squares[col][row];
    }

    public boolean check_if_move_doable(int sx, int sy, int ex, int ey){
        if(getSquare(sx, sy).piece != null){
            return getSquare(sx, sy).getPiece().canMove(sx, sy, ex, ey, this);
        }
        return false;
    }

    public void display_board(){
        System.out.print("    ");
        for(char i = 'A'; i <= 'H'; i++){
            System.out.print(i + "   ");
        }
        System.out.println();
        for(int x = 7; x >= 0; x--){
            System.out.println("   ---------------------------------");
            System.out.print(x+1);
            for(int y = 0; y <=7; y++){
                System.out.print(" | " + squares[x][y].toString());
            }
            System.out.println(" | " + (x+1));
        }         
        System.out.println("   ---------------------------------");
        System.out.print("    ");
        for(char i = 'A'; i <= 'H'; i++){
            System.out.print(i + "   ");
        }
    }


    public boolean isGameEnded(){
        if(isGameEndedforBlack() || isGameEndedforWhite()){
            return true;
        }
        return false;    
    }

    public boolean isGameEndedforWhite(){
        for(int x = 7; x >= 0; x--){
            for(int y = 0; y <=7; y++){
                if(getSquare(x, y).piece != null){
                    if(getSquare(x, y).piece.isWhite()){
                        return false;
                    }
                }
            }
        }
    return true;
    }
    
    public boolean isGameEndedforBlack(){
        for(int x = 7; x >= 0; x--){
            for(int y = 0; y <=7; y++){
                if(getSquare(x, y).piece != null){
                    if(getSquare(x, y).piece.isWhite()){
                    return false;
                    }
                }
            }
        }
    return true;
}

    public void make_board(){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                squares[x][y] = new Square(x, y, null);
            }
        }
        squares[0][0].piece = new Rook(true);
        squares[0][1].piece = new Knight(true);
        squares[0][2].piece = new Bishop(true);
        squares[0][3].piece = new Queen(true);
        squares[0][4].piece = new King(true);
        squares[0][5].piece = new Bishop(true);
        squares[0][6].piece = new Knight(true);
        squares[0][7].piece = new Rook(true);

        for (int i = 0; i < 8; i++) {
            squares[1][i].piece = new Pawn(true);
        }

        squares[7][0].piece = new Rook(false);
        squares[7][1].piece = new Knight(false);
        squares[7][2].piece = new Bishop(false);
        squares[7][3].piece = new Queen(false);
        squares[7][4].piece = new King(false);
        squares[7][5].piece = new Bishop(false);
        squares[7][6].piece = new Knight(false);
        squares[7][7].piece = new Rook(false);

        for (int i = 0; i < 8; i++) {
            squares[6][i].piece = new Pawn(false);
        }
    }
}

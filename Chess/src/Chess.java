import java.util.Scanner;

public class Chess{
    public static void main(String[] args) {
        boolean isWhitePlaying = true;
        Scanner scanner = new Scanner(System.in);
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.display_board();
        String input1;
        String input2;
        while(!chessBoard1.isGameEnded()){
            if(isWhitePlaying){
                System.out.println();
                System.out.println("It's White's turn");
                System.out.print("Enter the location of the piece: ");
                input1 = scanner.nextLine();
                System.out.println("Enter the new location of the piece: ");
                input2 = scanner.nextLine();
                if (is_input_readable(input1) && is_input_readable(input2)) {
                    if (chessBoard1.check_if_move_doable(first_char_to_int(input1), second_char_to_int(input1), first_char_to_int(input2), second_char_to_int(input2))) {
                        chessBoard1.movemaker(first_char_to_int(input1), second_char_to_int(input1), first_char_to_int(input2), second_char_to_int(input2));
                        isWhitePlaying = false;
                    } 
                    else {
                        System.out.println("Invalid move");
                    }
                }
                else{
                    System.out.println("Invalid input");
                }
            }
            else if(!isWhitePlaying){
                System.out.println();
                System.out.println("It's Black's turn");
                System.out.print("Enter the location of the piece: ");
                input1 = scanner.nextLine();
                System.out.println("Enter the new location of the piece: ");
                input2 = scanner.nextLine();
                if(!is_input_readable(input1)||is_input_readable(input2)){
                    if(chessBoard1.check_if_move_doable(first_char_to_int(input1),second_char_to_int(input1),first_char_to_int(input2),second_char_to_int(input2))){
                        chessBoard1.movemaker(first_char_to_int(input1),second_char_to_int(input1),first_char_to_int(input2),second_char_to_int(input2));
                        isWhitePlaying = true;
                    }
                    else{
                        System.out.println("Invalid move");
                    }  
                }
                else{
                    System.out.println("Invalid input");
                }
            }
            chessBoard1.display_board();
        }
    }

    
    public static boolean is_input_readable(String input){          //checks if input is readable by
        if(input.length() != 2){                                   //checking the length first
            return false;
        }
        for(char x = 'a'; x<= 'h'; x++){                           //then first char
            if(input.charAt(0) == x){
                for(int i = 1; i <9; i++){                         //and if first char is readable checks second right away
                    if(Character.getNumericValue(input.charAt(1)) == i){
                        return true;                               //if both are readable returns true
                    }
                }
            }
        }
        return false;                                              //if not false
    }

   
   
    public static int first_char_to_int(String input){                          //returns the row equivalent of the input
        int row = 0;
        for(char x = 'a'; x <= 'h'; x++){
            if(input.charAt(0)==x){
                return row;
            }
            row++;
        }
        return row;
    }


    public static int second_char_to_int(String input){
        return Character.getNumericValue(input.charAt(1))-1;        //returns the column equivalent of the input
    }

}    
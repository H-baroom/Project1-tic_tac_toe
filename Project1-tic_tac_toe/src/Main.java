import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[][] tic_tac_toe = new char[3][3];

        System.out.println("please enter the number of round (1) or (3) :");
        int num_round = input.nextInt();
        do {
            if (num_round == 1) {
                getWinner(tic_tac_toe,num_round);
                break;
            } else if (num_round == 3 ) {
                getWinner(tic_tac_toe,num_round);
                break;
            }else{
                System.out.println("please enter number (1) or (3) ");
                num_round = input.nextInt();
                continue;
            }

        }while(true);

    }
    public static void getWinner(char[][] tic_tac_toe,int num_round){
        int count_win_computer =0;
        int count_win_user = 0;
        for (int i = 1; i < num_round+1; i++) {
            tic_tac_toe = defaultValues(tic_tac_toe);

            if (num_round !=1) {
                if (i == 1) {
                    System.out.println("The first game     ");
                } else if (i == 2) {
                    System.out.println("The Second game     ");
                } else {
                    System.out.println("The third game      ");
                }
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            }
            board(tic_tac_toe);
            do {
                if(isFull(tic_tac_toe)){
                    tic_tac_toe = check_available(tic_tac_toe);
                    board(tic_tac_toe);
                    if (win(tic_tac_toe,'x') && num_round !=1){
                        System.out.println("The user wins this round!");
                        System.out.println("------------------------------------");
                        count_win_user++;
                        break;
                    }else if (win(tic_tac_toe,'o') && num_round !=1){
                        System.out.println("The computer wins this round! ");
                        System.out.println("------------------------------------");
                        count_win_computer++;
                        break;
                    } else if (win(tic_tac_toe,'x') && num_round == 1) {
                        count_win_user++;
                        break;
                    } else if (win(tic_tac_toe,'o') && num_round ==1) {
                        count_win_computer++;
                        break;
                    }
                }else{
                    System.out.println("No winner this round, again!");
                    System.out.println("****************************************");
                    i--;
                    break;
                }
            }while(true);
        }
        if (count_win_computer >= 2){
            System.out.println("The computer finally wins the game!");
        }else if (count_win_user >= 2){
            System.out.println("The user finally wins the game!");
        }else if (count_win_computer == 1){
            System.out.println("The computer wins this game!");
        }else{
            System.out.println("The user wins this game!");
        }

    }

    public static char[][] defaultValues(char[][] tic_tac_toe){
        for (int z = 1; z <= tic_tac_toe.length*tic_tac_toe.length; z++) {
            int row = (z - 1) / 3;
            int column = (z - 1) % 3;
            char w = (char)(z+'0');
            tic_tac_toe[row][column] = w;
        }
        return tic_tac_toe;
    }
    public static boolean win(char [][] tic_tac_toe ,char c){
        for (int row = 0; row < tic_tac_toe.length; row++) {
            if (tic_tac_toe[0][row] == c && tic_tac_toe[1][row] == c && tic_tac_toe[2][row] == c){
                return true;
            }
            for (int col = 0; col < tic_tac_toe.length; col++) {
                if (tic_tac_toe[col][0] == c && tic_tac_toe[col][1] == c && tic_tac_toe[col][2] == c) {
                    return true;
                }
            }
        }
        if (tic_tac_toe[0][0] == c && tic_tac_toe[1][1] == c && tic_tac_toe[2][2] == c){
            return true;
        } else if (tic_tac_toe[0][2] == c && tic_tac_toe[1][1] == c && tic_tac_toe[2][0] == c) {
            return true;
        }
        return false;
    } 
    public static char[][] computer(char[][] tic_tac_toe){

        do {
            int number = (int)(Math.random()*9)+1;
            int row_rand = (number -1) / 3;
            int column_rand = (number -1) % 3;
            if (Character.isDigit(tic_tac_toe[row_rand][column_rand])) {
                tic_tac_toe[row_rand][column_rand] = 'o';
                break;
            } else {
                continue;
            }
        }while(true);
        return tic_tac_toe;

    }
    
    
    public static char [][] check_available(char [][] tic_tac_toe ){
        boolean isEmpty = true;
        Scanner input = new Scanner(System.in);
        do {
            try {
                if (isFull(tic_tac_toe)) {
                    System.out.println("please enter the number of position you want 1 - 9: ");
                    int number = input.nextInt();
                    int row = (number -1) / 3;
                    int column = (number -1) % 3;
                    if ( Character.isDigit(tic_tac_toe[row][column])) {
                        tic_tac_toe[row][column] = 'x';
                        if(!isFull(tic_tac_toe)) {
                            break;
                        }else{
                            tic_tac_toe = computer(tic_tac_toe);
                            break;
                        }
                    } else {
                        System.out.println("this position is not empty \n");
                        board(tic_tac_toe);
                        continue;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("the number out of index ");
                continue;
            }
        } while (isEmpty);
        return tic_tac_toe;
    }

    public static boolean isFull(char [][] tic_tac_toe) {
        boolean full = false;
        for (int i = 0; i < tic_tac_toe.length; i++) {
            for (int j = 0; j < tic_tac_toe.length; j++) {
                if (Character.isDigit(tic_tac_toe[i][j])) {
                    full = true;
                    return full;
                }
            }
        }
        return full;
    }

    public static void board(char [][] tic_tac_toe ){
        System.out.println("      *<<Tic Tac Toe>>*     ");
        System.out.println("+--------+--------+--------+");
        for (int i = 0; i < tic_tac_toe.length; i++) {
            for (int j = 0; j < tic_tac_toe.length; j++) {
                System.out.print("|   "+tic_tac_toe[i][j]+"    ");
            }
            System.out.println("|");
            System.out.println("+--------+--------+--------+");
        }
    }
}



import java.util.Random;
import java.util.Scanner;

public class MineSweeper{
    int row;
    int col;
    int mineNumber;
    int winNumber;
    String[][] field;
    boolean[][] mines;
   


    MineSweeper(int row,int col){
        this.row=row;
        this.col=col;
        this.mineNumber = this.row*this.col/4;
        this.winNumber = this.row*this.col-this.mineNumber;
        field = new String[row][col];
        mines = new boolean[row][col];
        initField();
        putMine();

    }

    void gameStart(){
        Scanner scan = new Scanner(System.in);
        System.out.println("==================");
        while(true){

            printField(field);

            if(winNumber==0){
                System.out.println("Oyun Bitti! Oyunu Kazandınız!");
                break;
            }
            System.out.print("Satır Sayısı : ");
            int row = scan.nextInt();
            System.out.print("Sütun Sayısı : ");
            int col = scan.nextInt();
            System.out.println("==================");

            if(row < 0 || row >= this.row || col < 0 || col >= this.col){
                System.out.println("Girdiğiniz Değer Tarla İçinde Bulunmuyor.");
                continue;
            }
            
            if(mines[row][col]){
                System.out.println("Oyun Bitti! Mayına Bastınız!");
                mineField();
                printField(field);
                break;
            }else{
                if(field[row][col] != "-"){
                    System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin");
                    continue;
                }else{
                    findMine(row, col);
                    winNumber--;
                }
            
            }
    }
    scan.close();
}

    void putMine(){
        Random rand = new Random();
        while(0 < mineNumber){
            int row = rand.nextInt(this.row);
            int col = rand.nextInt(this.col);
            if(!mines[row][col]){
                mines[row][col]=true;
                mineNumber--;
            }
        }
    }

    void findMine(int row,int col){
        
        int minesNumber=0;
        for(int k=row-1;k<=row+1;k++){
            for(int l=col-1;l<=col+1;l++){
                if( k>=0 && k < this.row && l >=0 && l < this.col && mines[k][l] ==true){
                                minesNumber++;
                }
            }
        }
        field[row][col] = String.valueOf(minesNumber);
        
    }


    void printField(String[][] str){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(str[i][j]+" "); 
            }
            System.out.println();
        }
    }

    void initField(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                field[i][j] = "-";
            }
        }
    }

    void mineField(){
        for (int i = 0; i <this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if(!mines[i][j]){
                    int minesNumber=0;
                    for(int k=i-1;k<=i+1;k++){
                        for(int l=j-1;l<=j+1;l++){
                            if( k>=0 && k < this.row && l >=0 && l < this.col && mines[k][l] ==true){
                                minesNumber++;
                            }
                        }
                    }
                    field[i][j] = (String)(minesNumber+" ");
                }else{
                    field[i][j] ="* ";
                }
            }
        }
    }   
} 

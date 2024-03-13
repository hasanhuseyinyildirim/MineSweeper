import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int row,col;
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz ! ");

        while(true){
                System.out.print("Tarlanın Boyutunu Giriniz\nSatır Sayısı : ");
                row = scan.nextInt();
                System.out.print("Sütun Sayısını Giriniz : ");
                col = scan.nextInt();
                
                if(row >= 2 && col >= 2){
                    break;
                }else{
                    System.out.print("Tarla Boyutu 2x2 den küçük olamaz.Tekrar ");
                }
        }
            MineSweeper game = new MineSweeper(row, col);
            game.gameStart();
      scan.close();
    }
}


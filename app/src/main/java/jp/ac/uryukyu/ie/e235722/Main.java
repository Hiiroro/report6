package jp.ac.uryukyu.ie.e235722;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String def_mas_display = "○";
    public static void main(String[] args){
        Board board = new Board(15);

        // すごろくのイベント回数を設定
        int event_num = 5;
        for(int i=0; i<event_num; i++){
            board.createEvent();
        }
        Player player = new Player("太郎", "⭐️", false);



        System.out.println("ゲーム紹介");
        System.out.println("");
        System.out.println("コース紹介");
        // 盤面の表示
        System.out.println(board.display_boad(board.coas_state));    

        int time = 1;

        System.out.println("ゲーム開始！！");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        while(player.now_mas < board.goal){
        
            System.out.println(time +"ターン目"); 
            System.out.println("エンターキーを押してサイコロを振ってください。");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            
            Random random = new Random();
            int number = random.nextInt(6) + 1;
            player.now_mas += number;
            
            if(player.now_mas >= board.goal){
                System.out.println( "サイコロの目は" + number + "でした。" + number + "マス進みます。現在ゴール地点です。" );
                System.out.println("おめでとうございます！" + time + "ターン目でゴールしました！");

            }else{
                System.out.println( "サイコロの目は" + number + "でした。" + number + "マス進みます。現在"+ player.now_mas + "マス目です。" );
            
            
            int step = board.coas_state[player.now_mas];
            if (step != 0){
                int event_after_me = player.now_mas + step;
                System.out.println("イベント発生！" + board.display_mas(step,player.now_mas,board.goal, false)+ "。現在" + event_after_me + "マス目です。");
                player.now_mas = event_after_me;

            }
            // 盤面の表示
            System.out.println(board.display_boad(board.coas_state));
            System.out.println(board.display_boad_player(player.now_mas, player.koma, board.coas_state));

            }
            time += 1;
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        }
    

    }
    
}
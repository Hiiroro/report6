package jp.ac.uryukyu.ie.e235722;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Board board = new Board(15);

        // すごろくのイベント回数を設定
        int event_num = 5;
        for(int i=0; i<event_num; i++){
            board.createEvent();
        }
        // ゲームプレイヤーリスト
        ArrayList<Player> player_List = new ArrayList<>();

        // プレイヤー作成
        Player player_a = new Player("太郎","⭐︎", false);
        player_List.add(player_a);
        // NPC作成
        Player npc_a = new Player("鬼", "👹", true);
        player_List.add(npc_a);

        System.out.println("(ゲーム紹介)");
        System.out.println("あなたにはNPCと、すごろくゲームをしてもらいます。どちらかの勝敗がつくまでゲームは続きます。");
        System.out.println("");
        System.out.println("(コース紹介)");

        // 盤面の表示
        System.out.println(board.display_boad(board.coas_state));  
        System.out.println("");  

        
        int time = 1;

        System.out.println("ゲーム開始！！");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        
        
        LABEL_END:{
            while(true){
            
                System.out.println(time +"ターン目"); 

                for (Player player : player_List){

                    if (!player.enemy_flg){
                        System.out.println(player.name +"さんのターン！エンターキーを押してサイコロを振ってください。");
                    
                        scanner.nextLine();
                    } else{
                        System.out.println("NPC:"+ player.name +"のターン！");
                    }
                    Random random = new Random();
                    int number = random.nextInt(6) + 1;
                    player.now_mas += number;
                    
                    if(player.now_mas >= board.goal){
                        if (!player.enemy_flg){
                            System.out.println( "サイコロの目は" + number + "でした。" + number + "マス進みます。現在ゴール地点です。" );
                            System.out.println("おめでとうございます！" + time + "ターン目でゴールしました！あなたの勝ちです！！");
                        }else{
                            System.out.println("サイコロの目は" + number + "でした。" + number + "マス進みます。現在ゴール地点です。");
                            System.out.println("NPC:" + player.name + "がゴールしました！あなたの負けです。。。");
                        }
                        break LABEL_END;

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
                        System.out.println(board.display_boad_player(player.now_mas,player.koma, board.coas_state));
                        System.out.println("------------------------------------");
                    }

                }
                time += 1;
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        scanner.close();
    }
    
}
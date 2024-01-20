package jp.ac.uryukyu.ie.e235722;

import java.util.Random;

public class Board {
    int goal;
    int[] coas_state;
    int now_mas;

    public Board(int _goal){
        this.goal = _goal;
        this.coas_state = new int[goal+1];

        for (int i=0; i<coas_state.length; i++){
            coas_state[i] = 0;
        }
        this.now_mas = 0;
    }

    public String display_mas(int step, int now_mas, int goal, boolean num_flg){
        String mas_display = "";
        String num_dis = "";
        if (num_flg){
            num_dis = Integer.valueOf(now_mas).toString() + ":" ;
        }
        if(now_mas==0){
                mas_display = num_dis + "スタート地点";
            }else if (now_mas==goal-1){
                mas_display = num_dis + "ゴール地点";
            }else if (step==0){
                mas_display = num_dis + "○";
            } else if(step>0){
                mas_display = num_dis + step + "マス進む";
            } else if((step < 0) && (now_mas + step <= 0)){
                mas_display = num_dis + "スタート地点に戻る";
            } else {
                mas_display = num_dis + Math.abs(step) + "マス戻る";
            }
        return mas_display;
    }

    /**
     * 盤面表示メソッド
     * @param coas_state 盤面リスト
     */
    public String display_boad(int[] coas_state){
        String str_boad = "";
        for (int i=0; i<coas_state.length; i++){    
            str_boad = str_boad + (display_mas(coas_state[i], i, coas_state.length, true)+ "|");
        }
        return str_boad;
    }

    /**
     * プレイヤー表示メソッド
     * @param me 現在の位置
     * @param koma コマ
     * @param coas_state 盤面リスト
     */
    public String display_boad_player(int me, String koma, int[] coas_state){
        String str_boad_player = "";
        for (int i=0; i<coas_state.length; i++){
            if (i == me){
                str_boad_player = str_boad_player + (koma + "|");
            } else {
                str_boad_player = str_boad_player + display_mas(coas_state[i], i, coas_state.length, true)+ "|";
            }
        }
        return str_boad_player;
    }

    public void createEvent(){
        int[] event_coas = this.coas_state;
        Random rand = new Random();
        // イベントを発生させるマスをスタート地点、ゴール地点を除いてランダムで取得
        int event_mas_num;
        while (true){
            event_mas_num = rand.nextInt(this.goal - 2) + 1;
            // イベントのないマスだった場合、イベントを作成
            if (event_coas[event_mas_num]==0){
                break;
            }
        }

        // イベント発生マスの最大で進めるマスを取得
        int event_max_step = (goal - event_mas_num) - 1;

        // イベントの内容をランダムで取得し、イベントをコースに反映
        int event_contents;
        while (true){
            event_contents = event_max_step - rand.nextInt(this.goal);
            if(event_contents != 0){
                break;
            }
        }
        event_coas[event_mas_num] = event_contents;
        this.coas_state = event_coas;
    }
}

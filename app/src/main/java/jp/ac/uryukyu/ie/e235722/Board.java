package jp.ac.uryukyu.ie.e235722;


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
}

package com.wilson.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int color = 0;// 0 = red , 1 = blue
    int turns = 0;
    int[] board = {-1,-1,-1,-1,-1,-1,-1,-1,-1};


    public void displayToken(View view){
        ImageView counter = (ImageView) view;

        if(board[Integer.parseInt(counter.getTag().toString())]==-1) {
            int ok = winner();

            if(ok==-1) {
                if (color == 0) {
                    counter.setAlpha(0f);
                    counter.setImageResource(R.drawable.redtoken);
                    color = 1;
                    board[Integer.parseInt(counter.getTag().toString())] = 0;
                } else {
                    counter.setAlpha(0f);
                    counter.setImageResource(R.drawable.bluetoken);
                    color = 0;
                    board[Integer.parseInt(counter.getTag().toString())] = 1;
                }
                counter.animate().alpha(1f).setDuration(200);
                ok = winner();
                turns++;

            }
            if (ok==0){
                Toast.makeText(this, "RED WINS", Toast.LENGTH_SHORT).show();
                LinearLayout x = (LinearLayout)findViewById(R.id.resetlayout);
                x.setVisibility(View.VISIBLE);
                x.animate().alpha(1f).setDuration(200);
                TextView y = (TextView)findViewById(R.id.textView2);
                y.setText("RED WINS THE GAME");
            }
            else if(ok==1){
                Toast.makeText(this, "BLUE WINS", Toast.LENGTH_SHORT).show();
                LinearLayout x = (LinearLayout)findViewById(R.id.resetlayout);
                x.setVisibility(View.VISIBLE);
                x.animate().alpha(1f).setDuration(200);
                TextView y = (TextView)findViewById(R.id.textView2);
                y.setText("BLUE WINS THE GAME");
            }
            else if(turns==9){
                Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
                LinearLayout x = (LinearLayout)findViewById(R.id.resetlayout);
                x.setVisibility(View.VISIBLE);
                x.animate().alpha(1f).setDuration(200);
                TextView y = (TextView)findViewById(R.id.textView2);
                y.setText("ITS A DRAW");


            }
        }

    }
    public int winner(){                          //  Checks Winning Condition at every start of move
        if(board[0]==board[1]&&board[1]==board[2]&&board[0]!=-1){
            return board[0];
        }
        else if(board[3]==board[4]&&board[4]==board[5]&&board[3]!=-1){
            return board[3];
        }
        else if(board[6]==board[7]&&board[7]==board[8]&&board[6]!=-1){
            return board[6];
        }
        else if(board[0]==board[3]&&board[3]==board[6]&&board[0]!=-1){
            return board[0];
        }
        else if(board[1]==board[4]&&board[4]==board[7]&&board[1]!=-1){
            return board[1];
        }
        else if(board[2]==board[5]&&board[5]==board[8]&&board[2]!=-1){
            return board[2];
        }
        else if(board[0]==board[4]&&board[4]==board[8]&&board[0]!=-1){
            return board[0];
        }
        else if(board[2]==board[4]&&board[4]==board[6]&&board[2]!=-1){
            return board[2];
        }


        return -1;
    }

    public void restart(View view){
       ImageView n1 = (ImageView)findViewById(R.id.imageView1);     n1.setImageDrawable(null);
        ImageView n2 = (ImageView)findViewById(R.id.imageView2);     n2.setImageDrawable(null);
        ImageView n3 = (ImageView)findViewById(R.id.imageView3);     n3.setImageDrawable(null);
        ImageView n4 = (ImageView)findViewById(R.id.imageView4);     n4.setImageDrawable(null);
        ImageView n5 = (ImageView)findViewById(R.id.imageView5);     n5.setImageDrawable(null);
        ImageView n6 = (ImageView)findViewById(R.id.imageView6);     n6.setImageDrawable(null);
        ImageView n7 = (ImageView)findViewById(R.id.imageView7);     n7.setImageDrawable(null);
        ImageView n8 = (ImageView)findViewById(R.id.imageView8);     n8.setImageDrawable(null);
        ImageView n9 = (ImageView)findViewById(R.id.imageView9);     n9.setImageDrawable(null);
        for(int a=0;a<9;a++){
            board[a]=-1;
        }
        color=0;
        LinearLayout x = (LinearLayout)findViewById(R.id.resetlayout);
        x.animate().alpha(0f).setDuration(200);
        x.setVisibility(View.INVISIBLE);
        turns=0;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package com.example.kingj.reversi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layout;
    MyButton button;
    int size;
    int newi,newj;

    int ia[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int ja[] = {-1, 0, 1, 1, -1, -1, 0, 1};

    MyButton board[][];
    ArrayList<LinearLayout> rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.root);
        size=8;
        setUpBoard();
    }

    public void setUpBoard()
    {
        board=new MyButton[size][size];
        rows=new ArrayList<>();
        layout.removeAllViews();

        for(int i=0;i<size;i++)
        {
            LinearLayout linearLayout=new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams layoutParams=
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,1);
            linearLayout.setLayoutParams(layoutParams);
            layout.addView(linearLayout);
            rows.add(linearLayout);
            layout.setBackgroundColor(Color.RED);
        }

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                button=new MyButton(this);
                LinearLayout.LayoutParams layoutParams=
                        new  LinearLayout.LayoutParams(1,LinearLayout.LayoutParams.MATCH_PARENT,1);
                button.setLayoutParams(layoutParams);
                button.setOnClickListener(this);
                LinearLayout row=rows.get(i);
                button.bi=i;
                button.bj=j;
                button.setBackgroundResource(R.drawable.button_bg);
                row.addView(button);
                board[i][j]=button;

                if((i==(size/2)-1)&&(j==(size/2)-1))
                {
                    board[i][j].setBackgroundResource(R.drawable.white);
//                    board[i][j].playerWhite=true;
//                    checkPlace(i,j,board[i][j].playerWhite);
                }
                if((i==(size/2)-1)&&(j==(size/2)))
                {
                    board[i][j].setBackgroundResource(R.drawable.reversi);
//                    board[i][j].playerBlack=true;
//                    checkPlace(i,j,board[i][j].playerBlack);
                }
                if((i==(size/2))&&(j==(size/2)))
                {
                    board[i][j].setBackgroundResource(R.drawable.white);

//                    checkPlace(i,j,board[i][j].playerWhite);
                }
                 if((i==(size/2))&&(j==((size/2)-1)))
                {
                    board[i][j].setBackgroundResource(R.drawable.reversi);

//                    checkPlace(i,j,button.playerBlack);
                }
            }
        }


    }

    public void checkPlace(int x,int y,int player)
    {
        for(int i=0;i<8;i++)
        {
            newi=x+ia[i];
            newj=y+ja[i];

            if(newi<size && newi>=0 && newj>=0 && newj<size)
            {
                if(player==0)
                {
                    board[newi][newj].playerBlack=1;
                }
            }
        }
    }

    @Override
    public void onClick(View view) {

    }
}

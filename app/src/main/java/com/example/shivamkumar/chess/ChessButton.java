package com.example.shivamkumar.chess;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

public class ChessButton extends AppCompatButton{

    private int piece=0;
    public  int x,y;
    public boolean isShowing = false;
    public int getPiece() {
        return piece;
    }
    public void setPiece(int piece) {
        this.piece = piece;
        if(piece==0) {
            setText(" ");
            if((x+y)%2!=0){
                setBackgroundColor(getResources().getColor(R.color.black,null));
            }else{
                setBackgroundColor(getResources().getColor(R.color.white,null));
            }
        }else if((x+y)%2==0) {
            MainActivity.toggleTurnMove();
            if (piece == 6) {
                setwwp();
            } else if (piece == 12) {
                setbwp();
            } else if (piece == 1) {
                setwwK();
            } else if (piece == 7)
                setbwK();
            else if (piece == 2)
                setwwq();
            else if (piece == 8)
                setbwq();
            else if (piece == 3)
                setwwr();
            else if (piece == 9)
                setbwr();
            else if (piece == 4)
                setwwb();
            else if (piece == 10)
                setbwb();
            else if (piece == 5)
                setwwk();
            else if (piece == 11)
                setbwk();
        }else{
            if (piece == 6) {
                setwbp();
            } else if (piece == 12) {
                setbbp();
            } else if (piece == 1) {
                setwbK();
            } else if (piece == 7)
                setbbK();
            else if (piece == 2)
                setwbq();
            else if (piece == 8)
                setbbq();
            else if (piece == 3)
                setwbr();
            else if (piece == 9)
                setbbr();
            else if (piece == 4)
                setwbb();
            else if (piece == 10)
                setbbb();
            else if (piece == 5)
                setwbk();
            else if (piece == 11)
                setbbk();
        }

    }

    public ChessButton(Context context) {
        super(context);
    }
    public void setCoordinate(int i, int j) {
        x=i;y=j;
        if((i+j)%2!=0){
            setBackgroundColor(getResources().getColor(R.color.black,null));
        }else{
            setBackgroundColor(getResources().getColor(R.color.white,null));
        }
    }
    //black pieces
    public void setbbr(){
        setText("br");
        piece=9;
    }
    public void setbwr(){
        setText("br");piece=9;
    }
    public void setbbb(){
        setText("bb");piece=10;
    }
    public void setbbk(){
        setText("bk");piece=11;
    }
    public void setbwk(){
        setText("bk");piece=11;
    }
    public void setbwb(){
        setText("bb");piece=10;
    }
    public void setbbK(){
        setText("bkk");
        piece=7;
    }
    public void setbwK(){
        setText("bkk");
        piece=7;
    }
    public void setbbq(){
        setText("bq");
        piece=8;
    }
    public void setbwq(){
        setText("bq");piece=8;
    }
    public void setbbp(){
        setText("bp");piece=12;
    }
    public void setbwp(){
        setText("bp");piece=12;
    }
    //white pieces
    public void setwbr(){
        setText("wr");
        piece=3;
    }
    public void setwwr(){
        setText("wr");piece=3;
    }
    public void setwbb(){
        setText("wb");piece=4;
    }
    public void setwbk(){
        setText("wk");piece=5;
    }
    public void setwwk(){
        setText("wk");piece=5;
    }
    public void setwwb(){
        setText("wb");piece=4;
    }
    public void setwbK(){
        setText("wKk");
        piece=1;
    }
    public void setwwK(){
        setText("wKk");
        piece=1;
    }
    public void setwbq(){
        setText("wq");
        piece=2;
    }
    public void setwwq(){
        setText("wq");piece=2;
    }
    public void setwbp(){
        setText("wp");piece=6;
    }
    public void setwwp(){
        setText("wp");piece=6;
    }


    public void showMovable(int a) {
        if(a==1){
            if(piece<7&&piece!=0)
                return;
        }else{
            if(piece>6)
                return;
        }
        isShowing=true;
        if(piece==0) {
            if ((x + y) % 2 == 0)
                setBackgroundDrawable(getResources().getDrawable(R.drawable.moves_available_white, null));
            else
                setBackgroundDrawable(getResources().getDrawable(R.drawable.moves_available_black, null));
        }else{

            //show attacking move
        }
    }
    public void unShow(){
        if(isShowing){
            isShowing=false;
            if((x+y)%2!=0){
                setBackgroundColor(getResources().getColor(R.color.black,null));
            }else{
                setBackgroundColor(getResources().getColor(R.color.white,null));
            }
        }
    }
}


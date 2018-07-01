package com.example.shivamkumar.chess;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.widget.Toast;

public class ChessButton extends AppCompatButton{

    private int piece=0;
    public  int x,y;
    public boolean isShowing = false;
    public boolean checkFlag=false;
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
            if (piece == 6) {
               // setBackgroundDrawable(getResources().getDrawable(R.drawable.wbp,null));
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
       // setText("br");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bbr,null));
        piece=9;
    }
    public void setbwr(){
       // setText("br");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bwr,null));
        piece=9;
    }
    public void setbbb(){
        //setText("bb");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bbb,null));
        piece=10;
    }
    public void setbbk(){
        //setText("bk");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bbk,null));
        piece=11;
    }
    public void setbwk(){
        //setText("bk");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bwk,null));
        piece=11;
    }
    public void setbwb(){
//        setText("bb");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bwb,null));
        piece=10;
    }
    public void setbbK(){
//        setText("bkk");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bbkk,null));
        piece=7;
    }
    public void setbwK(){
//        setText("bkk");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bwkk,null));
        piece=7;
    }
    public void setbbq(){
//        setText("bq");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bbq,null));
        piece=8;
    }
    public void setbwq(){
//        setText("bq");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bwq,null));
        piece=8;
    }
    public void setbbp(){
//        setText("bp");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bbp,null));
        piece=12;
    }
    public void setbwp(){
//        setText("bp");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bwp,null));
        piece=12;
    }
    //white pieces
    public void setwbr(){
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wbr,null));
        piece=3;
    }
    public void setwwr(){
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wwr,null));piece=3;
    }
    public void setwbb(){
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wbb,null));piece=4;
    }
    public void setwbk(){
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wbk,null));piece=5;
    }
    public void setwwk(){
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wwk,null));piece=5;
    }
    public void setwwb(){
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wwb,null));piece=4;
    }
    public void setwbK(){
       // setText("wKk");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wbkk,null));
        piece=1;
    }
    public void setwwK(){
        //setText("wKk");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wwkk,null));
        piece=1;
    }
    public void setwbq(){
//        setText("wq");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wbq,null));
        piece=2;
    }
    public void setwwq(){
        //setText("wq");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wwq,null));
        piece=2;
    }
    public void setwbp(){
       // setText("wp");
        piece=6;
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wbp,null));
    }
    public void setwwp(){
       // setText("wp");
        setBackgroundDrawable(getResources().getDrawable(R.drawable.wwp,null));
        piece=6;
    }


    public void showMovable(int a) {
        if(piece==1)
            Log.d("king","is movable");
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
                if(piece==1||piece==7){
                    Log.d("king","checkFlag enabled for"+ piece+ " "+ x+" "+y);
                    checkFlag = true;
                }
            //show attacking move
        }
    }
    public void unShow(){
        if(isShowing){
            isShowing=false;
            if(piece==0) {
                if ((x + y) % 2 != 0) {
                    setBackgroundDrawable(getResources().getDrawable(R.drawable.black_background, null));
                   // setBackgroundColor(getResources().getColor(R.color.black, null));
                } else {
                    setBackgroundColor(getResources().getColor(R.color.white, null));
                }
            }
        }
    }
}


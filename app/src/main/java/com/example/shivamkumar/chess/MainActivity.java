package com.example.shivamkumar.chess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout rootLayout;
    LinearLayout rows[]= new LinearLayout[8];
    ChessButton[][] board;
    int previousPiece;
    int turn;
    int px,py;
    public boolean turnMove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBoard();
    }

    private void setBoard() {

        rootLayout= (LinearLayout)findViewById(R.id.rootLayout);
        rootLayout.removeAllViews();
        board= new ChessButton[8][8];
        turn =1;
        previousPiece=0;
        px=-1;py=-1;
        turnMove=false;

        for(int i=0;i<8;i++){
            LinearLayout linearLayout= new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1);
            linearLayout.setLayoutParams(layoutParams);
            rows[i]=linearLayout;
            rootLayout.addView(linearLayout);
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessButton chessButton = new ChessButton(this);
                chessButton.setOnClickListener(this);
                chessButton.setCoordinate(i,j);
                LinearLayout linearLayout = new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1);
                layoutParams.setMargins(2,2,2,2);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.addView(chessButton);
                rows[i].addView(linearLayout);
                board[i][j]=chessButton;
            }
        }

        setInitialPieces();

    }

    private void setInitialPieces() {
        board[0][0].setwwr();
        board[0][1].setwbk();
        board[0][2].setwwb();
        board[0][3].setwbK();
        board[0][4].setwwq();
        board[0][5].setwbb();
        board[0][6].setwwk();
        board[0][7].setwbr();
        board[1][0].setwbp();
        board[1][1].setwwp();
        board[1][2].setwbp();
        board[1][3].setwwp();
        board[1][4].setwbp();
        board[1][5].setwwp();
        board[1][6].setwbp();
        board[1][7].setwwp();

        board[7][0].setbbr();
        board[7][1].setbwk();
        board[7][2].setbbb();
        board[7][3].setbwK();
        board[7][4].setbbq();
        board[7][5].setbwb();
        board[7][6].setbbk();
        board[7][7].setbwr();
        board[6][0].setbwp();
        board[6][1].setbbp();
        board[6][2].setbwp();
        board[6][3].setbbp();
        board[6][4].setbwp();
        board[6][5].setbbp();
        board[6][6].setbwp();
        board[6][7].setbbp();
    }

    @Override
    public void onClick(View view) {
        ChessButton button=(ChessButton)view;

            if (button.isShowing) {
                board[px][py].setPiece(0);
                button.setPiece(previousPiece);
                unShowMoves();
                turnMove=false;
                toggleTurn();
                return;
            }

        if((button.getPiece()>6&&turn==1)||button.getPiece()<7&&turn==2){
            Toast.makeText(this,"Invalid Move",Toast.LENGTH_SHORT).show();
            return;
        }
        unShowMoves();
        int piece=button.getPiece();
        showMoves(piece,button.x,button.y);
        previousPiece=piece;


    }

    public void showMoves(int piece,int x,int y) {
        turnMove=true;
        px=x;
        py=y;
        if(piece==6){
            moveWhitePawn(x,y);
        }else if(piece==12){
            moveBlackPawn(x,y);
        }else if(piece==1){
            moveWhiteKing(x,y);
        }else if(piece==7)
            moveBlackKing(x,y);
        else if(piece==2)
            moveWhiteQueen(x,y);
        else if(piece==8)
            moveBlackQueen(x,y);
        else if(piece==3)
            moveWhiteRook(x,y);
        else if(piece==9)
            moveBlackRook(x,y);
        else if(piece==4)
            moveWhiteBishop(x,y);
        else if(piece==10)
            moveBlackBishop(x,y);
        else if(piece==5)
            moveWhiteKnight(x,y);
        else if(piece==11)
            moveBlackKnight(x,y);
    }

    private void moveBlackKnight(int x, int y) {
        if(checkPosition(x+2,y+1)){
            board[x+2][y+1].showMovable(2);
        }
        if(checkPosition(x+1,y+2)){
            board[x+1][y+2].showMovable(2);
        }
        if(checkPosition(x-1,y+2)){
            board[x-1][y+2].showMovable(2);
        }
        if(checkPosition(x-2,y+1)){
            board[x-2][y+1].showMovable(2);
        }
        if(checkPosition(x-2,y-1)){
            board[x-2][y-1].showMovable(2);
        }
        if(checkPosition(x-1,y-2)){
            board[x-1][y-2].showMovable(2);
        }
        if(checkPosition(x+1,y-2)){
            board[x+1][y-2].showMovable(2);
        }
        if(checkPosition(x+2,y-1)){
            board[x+2][y+1].showMovable(2);
        }
    }
    private void moveWhiteKnight(int x, int y) {
        if(checkPosition(x+2,y+1)){
            board[x+2][y+1].showMovable(1);
        }
        if(checkPosition(x+1,y+2)){
            board[x+1][y+2].showMovable(1);
        }
        if(checkPosition(x-1,y+2)){
            board[x-1][y+2].showMovable(1);
        }
        if(checkPosition(x-2,y+1)){
            board[x-2][y+1].showMovable(1);
        }
        if(checkPosition(x-2,y-1)){
            board[x-2][y-1].showMovable(1);
        }
        if(checkPosition(x-1,y-2)){
            board[x-1][y-2].showMovable(1);
        }
        if(checkPosition(x+1,y-2)){
            board[x+1][y-2].showMovable(1);
        }
        if(checkPosition(x+2,y-1)){
            board[x+2][y-1].showMovable(1);
        }
    }
    private void moveBlackBishop(int x, int y) {
        if(checkPosition(x-1,y-1)){
            int a=x-1;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a--;b--;
            }

        }if(checkPosition(x-1,y+1)){
            int a=x-1;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a--;b++;
            }
        }if(checkPosition(x+1,y-1)){
            int a=x+1;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a++;b--;
            }
        }if(checkPosition(x+1,y+1)){
            int a=x+1;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a++;b++;
            }
        }
    }
    private void moveWhiteBishop(int x, int y) {
        if(checkPosition(x-1,y-1)){
            int a=x-1;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a--;b--;
            }

        }if(checkPosition(x-1,y+1)){
            int a=x-1;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a--;b++;
            }
        }if(checkPosition(x+1,y-1)){
            int a=x+1;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a++;b--;
            }
        }if(checkPosition(x+1,y+1)){
            int a=x+1;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a++;b++;
            }
        }
    }
    private void moveBlackRook(int x, int y) {
        if (checkPosition(x - 1, y)) {
            int a = x - 1;
            int b = y;
            while (checkPosition(a, b)) {
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a--;
            }
        }
        if (checkPosition(x, y - 1)) {
            int a = x;
            int b = y - 1;
            while (checkPosition(a, b)) {
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                b--;
            }
        }
        if (checkPosition(x, y + 1)) {
            int a = x;
            int b = y + 1;
            while (checkPosition(a, b)) {
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                b++;
            }
        }
        if (checkPosition(x + 1, y)) {
            int a = x + 1;
            int b = y;
            while (checkPosition(a, b)) {
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a++;
            }
        }
    }
    private void moveWhiteRook(int x, int y) {



        if(checkPosition(x-1,y)){
            int a=x-1;
            int b=y;

            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a--;
            }
        }if(checkPosition(x,y-1)){
            int a=x;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                b--;
            }
        }if(checkPosition(x,y+1)){
            int a=x;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                b++;
            }
        }if(checkPosition(x+1,y)){
            int a=x+1;
            int b=y;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a++;
            }
        }
    }
    private void moveBlackQueen(int x, int y) {
        if(checkPosition(x-1,y-1)){
            int a=x-1;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(1);
                a--;b--;
            }

        }if(checkPosition(x-1,y+1)){
            int a=x-1;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(1);
                a--;b++;
            }
        }if(checkPosition(x-1,y)){
            int a=x-1;
            int b=y;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a--;
            }
        }if(checkPosition(x,y-1)){
            int a=x;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                b--;
            }
        }if(checkPosition(x,y+1)){
            int a=x;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                b++;
            }
        }if(checkPosition(x+1,y-1)){
            int a=x+1;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a++;b--;
            }
        }if(checkPosition(x+1,y)){
            int a=x+1;
            int b=y;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a++;
            }
        }if(checkPosition(x+1,y+1)){
            int a=x+1;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(2);
                    break;
                }
                board[a][b].showMovable(2);
                a++;b++;
            }
        }
    }
    private void moveWhiteQueen(int x, int y) {
        if(checkPosition(x-1,y-1)){
            int a=x-1;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a--;b--;
            }

        }if(checkPosition(x-1,y+1)){
            int a=x-1;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a--;b++;
            }
        }if(checkPosition(x-1,y)){
            int a=x-1;
            int b=y;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a--;
            }
        }if(checkPosition(x,y-1)){
            int a=x;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                b--;
            }
        }if(checkPosition(x,y+1)){
            int a=x;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                b++;
            }
        }if(checkPosition(x+1,y-1)){
            int a=x+1;
            int b=y-1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a++;b--;
            }
        }if(checkPosition(x+1,y)){
            int a=x+1;
            int b=y;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a++;
            }
        }if(checkPosition(x+1,y+1)){
            int a=x+1;
            int b=y+1;
            while(checkPosition(a,b)){
                if(board[a][b].getPiece()>0)
                {
                    board[a][b].showMovable(1);
                    break;
                }
                board[a][b].showMovable(1);
                a++;b++;
            }
        }
    }
    private void moveBlackKing(int x, int y) {
        if(checkPosition(x-1,y-1)){
            board[x-1][y-1].showMovable(2);
        }if(checkPosition(x-1,y+1)){
            board[x-1][y+1].showMovable(2);
        }if(checkPosition(x-1,y)){
            board[x-1][y].showMovable(2);
        }if(checkPosition(x,y-1)){
            board[x][y-1].showMovable(2);
        }if(checkPosition(x,y+1)){
            board[x][y+1].showMovable(2);
        }if(checkPosition(x+1,y-1)){
            board[x+1][y-1].showMovable(2);
        }if(checkPosition(x+1,y)){
            board[x+1][y].showMovable(2);
        }if(checkPosition(x+1,y+2)){
            board[x+1][y+1].showMovable(2);
        }
    }
    private void moveWhiteKing(int x, int y) {
        if(checkPosition(x-1,y-1)){
            board[x-1][y-1].showMovable(1);
        }if(checkPosition(x-1,y+1)){
            board[x-1][y+1].showMovable(1);
        }if(checkPosition(x-1,y)){
            board[x-1][y].showMovable(1);
        }if(checkPosition(x,y-1)){
            board[x][y-1].showMovable(1);
        }if(checkPosition(x,y+1)){
            board[x][y+1].showMovable(1);
        }if(checkPosition(x+1,y-1)){
            board[x+1][y-1].showMovable(1);
        }if(checkPosition(x+1,y)){
            board[x+1][y].showMovable(1);
        }if(checkPosition(x+1,y+1)){
            board[x+1][y+1].showMovable(1);
        }
    }
    public void unShowMoves(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j].unShow();
            }
        }
    }
    private void moveBlackPawn(int x, int y) {
        if(checkPosition(x-1,y)){
            if(board[x-1][y].getPiece()==0)
                board[x-1][y].showMovable(2);
        }
        if(x==6){
            if(checkPosition(x-2,y)){
                if(board[x-2][y].getPiece()==0)
                    board[x-2][y].showMovable(2);
            }
        }
        if(checkPosition(x-1,y+1)){
            if(board[x-1][y+1].getPiece()<7&&board[x-1][y+1].getPiece()!=0)
                board[x-1][y+1].showMovable(2);
        }
        if(checkPosition(x-1,y-1)) {
            if (board[x - 1][y - 1].getPiece() <7&&board[x - 1][y - 1].getPiece()!=0)
                board[x - 1][y - 1].showMovable(2);
        }
    }
    private void moveWhitePawn(int x, int y) {

        if(checkPosition(x+1,y)){
            if(board[x+1][y].getPiece()==0)
                board[x+1][y].showMovable(1);
        }
        if(x==1){
            if(checkPosition(x+2,y)){
                if(board[x+2][y].getPiece()==0)
                    board[x+2][y].showMovable(1);
            }
        }
        if(checkPosition(x+1,y+1)){
            if(board[x+1][y+1].getPiece()>6)
                board[x+1][y+1].showMovable(1);
        }
        if(checkPosition(x+1,y-1)) {
            if (board[x + 1][y - 1].getPiece() > 6)
                board[x + 1][y - 1].showMovable(1);
        }
        //Implementing Imposent moves

    }

    private boolean checkPosition(int i, int j) {
        if(i>=0&&i<8&&j>=0&&j<8)
            return true;
        else
            return false;
    }
    public void toggleTurn(){
        if(turn==1)
            turn=2;
        else
            turn=1;
    }

    public static void toggleTurnMove() {

    }
}

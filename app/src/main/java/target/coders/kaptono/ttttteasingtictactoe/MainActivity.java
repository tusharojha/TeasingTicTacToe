package target.coders.kaptono.ttttteasingtictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Defining our ui buttons
    Button[][] buttons = new Button[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting all UI buttons & Creating on Click Listener for our buttons
        for(int i=0; i<3 ; i++){
            for(int j=0; j<3; j++){
                String button_id= "button_" + (i+1) + (j+1);
                int resid= getResources().getIdentifier(button_id, "id", getPackageName());
                buttons[i][j] = (Button) findViewById(resid);
                buttons[i][j].setOnClickListener(this);
            }
        }

    }
    public String getWinner(){
        //This method checks up the results for the match
        //Setting Boolean to check whether device wins first
        Boolean device_check=true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                //Checking for hoizontal line
                int horizontal_win=0;
                for(int k=0; k<3; k++){
                    if(buttons[i][k].getText().toString().equals("O")){
                        horizontal_win++;
                    }
                }
                if(horizontal_win==3){
                    return "device";
                }
                //Checking for vertical line
                int vertical_win=0;
                for(int k=0; k<3; k++){
                    if(buttons[k][j].getText().toString().equals("O")){
                        vertical_win++;
                    }
                }
                if(vertical_win==3) {
                    return "device";
                }

            }
        }
        //Checking for diagonal line
        if(buttons[0][0].getText().toString().equals("O") && buttons[1][1].getText().toString().equals("O") && buttons[2][2].getText().toString().equals("O")){
            return "device";
        }
        if(buttons[0][2].getText().toString().equals("O") && buttons[1][1].getText().toString().equals("O") && buttons[2][0].getText().toString().equals("O")){
            return "device";
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                //Checking for hoizontal line
                int horizontal_win=0;
                for(int k=0; k<3; k++){
                    if(buttons[i][k].getText().toString().equals("X")){
                        horizontal_win++;
                    }
                }
                if(horizontal_win==3){
                    return "User";
                }
                //Checking for vertical line
                int vertical_win=0;
                for(int k=0; k<3; k++){
                    if(buttons[k][j].getText().toString().equals("X")){
                        vertical_win++;
                    }
                }
                if(vertical_win==3) {
                    return "User";
                }

            }
        }
        //Checking for diagonal line
        if(buttons[0][0].getText().toString().equals("X") && buttons[1][1].getText().toString().equals("X") && buttons[2][2].getText().toString().equals("X")){
            return "User";
        }
        if(buttons[0][2].getText().toString().equals("X") && buttons[1][1].getText().toString().equals("X") && buttons[2][0].getText().toString().equals("X")){
            return "User";
        }
        int draw_score=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
            if(!(buttons[i][j].getText().equals("-"))){
                draw_score++;
            }
            }}
            if(draw_score==9){
            return "Draw";
            }
                return "none";
    }
    public Boolean blockandwin(Boolean who){
if(who==true) {
    //Check if user wins in horizontal line for blocking user
    int horizontal_score = 0;
    int xcordinate = 5;
    int ycordinate = 5;
    for (int i = 0; i < 3; i++) {
        for (int k = 0; k < 3; k++) {
            if (buttons[i][k].getText().toString().equals("X")) {
                horizontal_score++;
            } else if (buttons[i][k].getText().toString().equals("-")) {
                xcordinate = i;
                ycordinate = k;
            }
            if (horizontal_score == 2 && xcordinate != 5 && ycordinate != 5) {
                break;
            }
        }
        if (horizontal_score == 2 && xcordinate != 5 && ycordinate != 5) {
            break;
        } else {
            horizontal_score = 0;
            xcordinate = 5;
            ycordinate = 5;
        }
    }
    //Check if user wins in vertical line for blocking user
    int vertical_score = 0;
    int xcordinate_vertical = 5;
    int ycordinate_vertical = 5;
    for (int i = 0; i < 3; i++) {
        for (int k = 0; k < 3; k++) {
            if (buttons[k][i].getText().toString().equals("X")) {
                vertical_score++;
            } else if (buttons[k][i].getText().toString().equals("-")) {
                xcordinate_vertical = k;
                ycordinate_vertical = i;
            }
            if (vertical_score == 2 && xcordinate_vertical != 5 && ycordinate_vertical != 5) {
                break;
            }
        }
        if (vertical_score == 2 && xcordinate_vertical != 5 && ycordinate_vertical != 5) {
            break;
        } else {
            vertical_score = 0;
            xcordinate_vertical = 5;
            ycordinate_vertical = 5;
        }
    }
    //Check if user wins in right diagonal way for blocking user
    int right_diagonal_score = 0;
    int xcordinate_right_diagonal = 5;
    int ycordinate_right_diagonal = 5;
    if (buttons[0][2].getText().toString().equals("X")) {
        right_diagonal_score++;
    } else if(buttons[0][2].getText().toString().equals("-")) {
        xcordinate_right_diagonal = 0;
        ycordinate_right_diagonal = 2;
    }
    if (buttons[1][1].getText().toString().equals("X")) {
        right_diagonal_score++;
    } else if(buttons[1][1].getText().toString().equals("-")){
        xcordinate_right_diagonal = 1;
        ycordinate_right_diagonal = 1;
    }
    if (buttons[2][0].getText().toString().equals("X")) {
        right_diagonal_score++;
    } else if(buttons[2][0].getText().toString().equals("-")) {
        xcordinate_right_diagonal = 2;
        ycordinate_right_diagonal = 0;
    }

    if (right_diagonal_score == 2 && xcordinate_right_diagonal != 5 && ycordinate_right_diagonal != 5) {

    } else {
        right_diagonal_score = 0;
        xcordinate_right_diagonal = 5;
        ycordinate_right_diagonal = 5;
    }
    //Check if user wins in left diagonal way for blocking user
    int left_diagonal_score = 0;
    int xcordinate_left_diagonal = 5;
    int ycordinate_left_diagonal = 5;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == j) {
                if (buttons[i][j].getText().toString().equals("X")) { // or buttons[j][j], buttons[i][i] means the same because i=j in this particular condition
                    left_diagonal_score++;
                } else if (buttons[i][j].getText().toString().equals("-")) {
                    xcordinate_left_diagonal = i;
                    ycordinate_left_diagonal = j;
                }

                if (left_diagonal_score == 2 && xcordinate_left_diagonal != 5 && ycordinate_left_diagonal != 5) {
                    break;
                }
            }
        }


        if (left_diagonal_score == 2 && xcordinate_left_diagonal != 5 && ycordinate_left_diagonal != 5) {
            break;
        } else {
            left_diagonal_score = 0;
            xcordinate_left_diagonal = 5;
            ycordinate_left_diagonal = 5;
        }
    }

    if (right_diagonal_score == 2 && xcordinate_right_diagonal != 5 && ycordinate_right_diagonal != 5) { // Block user in right diagonal line rule: 2
        buttons[xcordinate_right_diagonal][ycordinate_right_diagonal].setText("O");
        xcordinate_right_diagonal = 5;
        ycordinate_right_diagonal = 5;
        return true;
    } else if (left_diagonal_score == 2 && xcordinate_left_diagonal != 5 && ycordinate_left_diagonal != 5) { // Block user in left diagonal line rule: 2
        buttons[xcordinate_left_diagonal][ycordinate_left_diagonal].setText("O");
        xcordinate_left_diagonal = 5;
        ycordinate_left_diagonal = 5;
        return true;
    } else if (vertical_score == 2 && xcordinate_vertical != 5 && ycordinate_vertical != 5) { // Block user in vertical line rule: 2
        buttons[xcordinate_vertical][ycordinate_vertical].setText("O");
        xcordinate_vertical = 5;
        ycordinate_vertical = 5;
        return true;
    } else if (horizontal_score == 2 && xcordinate != 5 && ycordinate != 5) { // Block user in horizontal line rule: 2
        buttons[xcordinate][ycordinate].setText("O");
        xcordinate = 5;
        ycordinate = 5;
    return true;
    }
}else{
    //Check if user wins in horizontal line for blocking user
    int horizontal_score = 0;
    int xcordinate = 5;
    int ycordinate = 5;
    for (int i = 0; i < 3; i++) {
        for (int k = 0; k < 3; k++) {
            if (buttons[i][k].getText().toString().equals("O")) {
                horizontal_score++;
            } else if (buttons[i][k].getText().toString().equals("-")) {
                xcordinate = i;
                ycordinate = k;
            }
            if (horizontal_score == 2 && xcordinate != 5 && ycordinate != 5) {
                break;
            }
        }
        if (horizontal_score == 2 && xcordinate != 5 && ycordinate != 5) {
            break;
        } else {
            horizontal_score = 0;
            xcordinate = 5;
            ycordinate = 5;
        }
    }
    //Check if user wins in vertical line for blocking user
    int vertical_score = 0;
    int xcordinate_vertical = 5;
    int ycordinate_vertical = 5;
    for (int i = 0; i < 3; i++) {
        for (int k = 0; k < 3; k++) {
            if (buttons[k][i].getText().toString().equals("O")) {
                vertical_score++;
            } else if (buttons[k][i].getText().toString().equals("-")) {
                xcordinate_vertical = k;
                ycordinate_vertical = i;
            }
            if (vertical_score == 2 && xcordinate_vertical != 5 && ycordinate_vertical != 5) {
                break;
            }
        }
        if (vertical_score == 2 && xcordinate_vertical != 5 && ycordinate_vertical != 5) {
            break;
        } else {
            vertical_score = 0;
            xcordinate_vertical = 5;
            ycordinate_vertical = 5;
        }
    }
    //Check if user wins in right diagonal way for blocking user
    int right_diagonal_score = 0;
    int xcordinate_right_diagonal = 5;
    int ycordinate_right_diagonal = 5;
    if (buttons[0][2].getText().toString().equals("O")) {
        right_diagonal_score++;
    } else if(buttons[0][2].getText().toString().equals("-")){
        xcordinate_right_diagonal = 0;
        ycordinate_right_diagonal = 2;
    }
    if (buttons[1][1].getText().toString().equals("O")) {
        right_diagonal_score++;
    } else if(buttons[1][1].getText().toString().equals("-")){
        xcordinate_right_diagonal = 1;
        ycordinate_right_diagonal = 1;
    }
    if (buttons[2][0].getText().toString().equals("O")) {
        right_diagonal_score++;
    } else if(buttons[2][0].getText().toString().equals("-")){
        xcordinate_right_diagonal = 2;
        ycordinate_right_diagonal = 0;
    }

    if (right_diagonal_score == 2 && xcordinate_right_diagonal != 5 && ycordinate_right_diagonal != 5) {

    } else {
        right_diagonal_score = 0;
        xcordinate_right_diagonal = 5;
        ycordinate_right_diagonal = 5;
    }
    //Check if user wins in left diagonal way for blocking user
    int left_diagonal_score = 0;
    int xcordinate_left_diagonal = 5;
    int ycordinate_left_diagonal = 5;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == j) {
                if (buttons[i][j].getText().toString().equals("O")) { // or buttons[j][j], buttons[i][i] means the same because i=j in this particular condition
                    left_diagonal_score++;
                } else if (buttons[i][j].getText().toString().equals("-")) {
                    xcordinate_left_diagonal = i;
                    ycordinate_left_diagonal = j;
                }

                if (left_diagonal_score == 2 && xcordinate_left_diagonal != 5 && ycordinate_left_diagonal != 5) {
                    break;
                }
            }
        }


        if (left_diagonal_score == 2 && xcordinate_left_diagonal != 5 && ycordinate_left_diagonal != 5) {
            break;
        }
    }

    if (right_diagonal_score == 2 && xcordinate_right_diagonal != 5 && ycordinate_right_diagonal != 5) { // Block user in right diagonal line rule: 2
        buttons[xcordinate_right_diagonal][ycordinate_right_diagonal].setText("O");
        xcordinate_right_diagonal = 5;
        ycordinate_right_diagonal = 5;
        return true;
    } else if (left_diagonal_score == 2 && xcordinate_left_diagonal != 5 && ycordinate_left_diagonal != 5) { // Block user in left diagonal line rule: 2
        buttons[xcordinate_left_diagonal][ycordinate_left_diagonal].setText("O");
        xcordinate_left_diagonal = 5;
        ycordinate_left_diagonal = 5;
        left_diagonal_score=0;
        return true;
    } else if (vertical_score == 2 && xcordinate_vertical != 5 && ycordinate_vertical != 5) { // Block user in vertical line rule: 2
        buttons[xcordinate_vertical][ycordinate_vertical].setText("O");
        xcordinate_vertical = 5;
        ycordinate_vertical = 5;
        return true;
    } else if (horizontal_score == 2 && xcordinate != 5 && ycordinate != 5) { // Block user in horizontal line rule: 2
        buttons[xcordinate][ycordinate].setText("O");
        xcordinate = 5;
        ycordinate = 5;
        return true;
    }
}
return false;
    }
    public String device_turn(){
    //Main Algorithm Starts...
        //Check for results if user wins
        String winner_d = getWinner();
        if(winner_d=="User"){
            return "User";
        }else if(winner_d.equals("Draw")){
            return "Draw";
        }
        //If you can win, do it! : Rule 1
        Boolean state_win_action=blockandwin(false);
        //If your opponent win, Block it! : Rule 2
        if(state_win_action==true){
        return "device";
        }
        Boolean state_block_action = blockandwin(true);

        if(state_block_action==true){

        }
        else if(buttons[1][2].getText().toString().equals("X") && buttons[2][1].getText().toString().equals("X") && buttons[2][2].getText().toString().equals("-")){
//Check for right bottom fork if yes then block it rule: 3
            buttons[2][2].setText("O");
            }
        else if(buttons[1][2].getText().toString().equals("O") && buttons[2][1].getText().toString().equals("O") && buttons[2][2].getText().toString().equals("-")){
            //fork if possible
            buttons[2][2].setText("O");
        }
        else if(buttons[1][0].getText().toString().equals("O") && buttons[2][1].getText().toString().equals("O") && buttons[2][0].getText().toString().equals("-")){
            //fork if possible
            buttons[2][0].setText("O");
        }
        else if(buttons[1][0].getText().toString().equals("O") && buttons[0][1].getText().toString().equals("O") && buttons[0][0].getText().toString().equals("-")){
            //fork if possible
            buttons[0][0].setText("O");
        }
        else if(buttons[0][1].getText().toString().equals("O") && buttons[1][2].getText().toString().equals("O") && buttons[0][2].getText().toString().equals("-")){
            //fork if possible
            buttons[0][2].setText("O");
        }
        //generate Random Number and put it!..... if not possible then take up the corners
        else{
            n();
        }

        //Check for results if device wins
        String winner = getWinner();
        if(winner.equals("device")){
            return "device";
        }else if(winner.equals("User")){
            return "User";
        }else if(winner.equals("Draw")){
            return "Draw";
        }
        return "none";
    }
    public void n(){
        int r = new Random().nextInt(2);
        int c = new Random().nextInt(2);
        if(buttons[1][1].getText().toString().equals("-")){
            buttons[r][c].setText("O");
        }else{
            n();
        }

    }
    @Override
    public void onClick(View view) {
    if(((Button) view).getText().toString().equals("-")){
        ((Button) view).setText("X");
        String winner_name= device_turn();

            if(winner_name!="none" && winner_name!="Draw"){
                if(winner_name=="device") {
                    final AlertDialog mDialog = new AlertDialog.Builder(this)
                            .setTitle("You Loose")
                            .setMessage("Yet Another Proof! I Won!")
                            .setPositiveButton("Try Again",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            for (int i = 0; i < 3; i++) {
                                                for (int j = 0; j < 3; j++) {

                                                    buttons[i][j].setText("-");

                                                }
                                            }
                                        }
                                    })
                            .setNegativeButton("See How?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .create();

                    mDialog.show();
                }else if(winner_name=="User"){

                    final AlertDialog mDialog = new AlertDialog.Builder(this)
                            .setTitle("Congratulations")
                            .setMessage("You Have Won this Round... Well Played!")
                            .setPositiveButton("Play Again",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            for (int i = 0; i < 3; i++) {
                                                for (int j = 0; j < 3; j++) {

                                                    buttons[i][j].setText("-");

                                                }
                                            }
                                        }
                                    })
                            .setNegativeButton("See How?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .create();

                    mDialog.show();
                }
                    }else if(winner_name=="Draw"){
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++) {

                        buttons[i][j].setText("-");

                    }}
                AlertDialog mDialog = new AlertDialog.Builder(this)
                        .setTitle("Ohhh..")
                        .setMessage("It's a draw!")
                        .setPositiveButton("Try Again",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.i("MyTag" , "Click YES");
                                    }
                                })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .create();
                mDialog.show();

            }
    }
    }
    public void refresh(View view) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {

                buttons[i][j].setText("-");

            }}

    }
}

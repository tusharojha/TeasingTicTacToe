package target.coders.kaptono.ttttteasingtictactoe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tushar Ojha on 3/21/2018.
 */

public class FriendPlay extends AppCompatActivity implements View.OnClickListener{
    //Defining our ui buttons
    Button[][] buttons = new Button[3][3];
    TextView title;
    Boolean xturn=true;
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
        title= (TextView) findViewById(R.id.textView);
        title.setText("X Turn");
        title.setTextSize(35);
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
    public String device_turn() {
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
    @Override
    public void onClick(View view) {
        if(((Button) view).getText().toString().equals("-")){
            if(xturn==true) {

                ((Button) view).setText("X");
                xturn=false;
                title.setText("O Turn");

            }else if(xturn==false){
                ((Button) view).setText("O");
                xturn=true;
                title.setText("X Turn");

            }
            String winner_name= device_turn();

            if(winner_name!="none" && winner_name!="Draw"){
                if(winner_name=="device") {
                    final AlertDialog mDialog = new AlertDialog.Builder(this)
                            .setTitle("Congratulations")
                            .setMessage("O has won this Round!")
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
                            .setMessage("X have won this Round!")
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
            //Refreshing the boolean variable
        xturn=true;
        //refreshing title as well
        title.setText("X Turn");
    }
}


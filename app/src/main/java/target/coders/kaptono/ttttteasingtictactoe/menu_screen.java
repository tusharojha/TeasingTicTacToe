package target.coders.kaptono.ttttteasingtictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Tushar Ojha on 3/21/2018.
 */

public class menu_screen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);
    }
    public void playwithfriend(View view){
        Intent intent = new Intent(getApplicationContext(), FriendPlay.class);
        startActivity(intent);
    }
    public void playwithme(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void exit(View view){
finish();
    }
}

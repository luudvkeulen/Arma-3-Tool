package nl.luudvankeulen.arma3tool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void onButtonMapsClick(View view) {
        Intent intent = new Intent(this, MapScreenActivity.class);
        startActivity(intent);
    }

    public void onButtonWeaponsClick(View view) {
        Intent intent = new Intent(this, WeaponScreenActivity.class);
        startActivity(intent);
    }
}

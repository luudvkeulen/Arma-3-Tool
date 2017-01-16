package nl.luudvankeulen.arma3tool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class HomeScreenActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mAdView.bringToFront();
            }
        });
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

package nl.luudvankeulen.arma3tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import nl.luudvankeulen.arma3tool.adapters.WeaponsAdapter;
import nl.luudvankeulen.arma3tool.enums.WeaponType;

public class WeaponScreenActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private AdView mAdView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_screen);
        setUpActionBar();

        listView = (ListView)findViewById(R.id.weapon_list);
        listView.setAdapter(new WeaponsAdapter(getApplicationContext()));
        listView.setOnItemClickListener(this);

        spinner = (Spinner)findViewById(R.id.spinnerweapontype);
        spinner.setAdapter(new ArrayAdapter<>(this, R.layout.weapon_spinner_item, WeaponType.values()));
        spinner.setOnItemSelectedListener(this);

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

    private void setUpActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Weapons");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        listView.setAdapter(new WeaponsAdapter((WeaponType)spinner.getSelectedItem()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mAdView != null) {
            mAdView.destroy();
        }
    }
}

package nl.luudvankeulen.arma3tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import nl.luudvankeulen.arma3tool.adapters.MapsAdapter;

public class MapScreenActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Maps");
        list = (ListView)findViewById(R.id.maps_list);
        list.setAdapter(new MapsAdapter(getApplicationContext()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}

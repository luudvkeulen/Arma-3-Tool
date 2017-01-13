package nl.luudvankeulen.arma3tool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import nl.luudvankeulen.arma3tool.adapters.MapsAdapter;
import nl.luudvankeulen.arma3tool.models.MapItem;

public class MapScreenActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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
        list.setOnItemClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, MapDetailsActivity.class);
        intent.putExtra("name", ((MapItem)list.getItemAtPosition(i)).getName());
        startActivity(intent);
    }
}

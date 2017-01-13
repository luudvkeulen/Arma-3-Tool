package nl.luudvankeulen.arma3tool;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class MapDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        String name = getIntent().getStringExtra("name");
        int pictureId = getIntent().getIntExtra("id", R.drawable.altis);
        getSupportActionBar().setTitle(name);

        //Zoomable image
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView)findViewById(R.id.subsamplingScaleImageView);
        subsamplingScaleImageView.setImage(ImageSource.resource(pictureId));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}

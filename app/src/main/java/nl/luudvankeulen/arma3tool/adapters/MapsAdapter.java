package nl.luudvankeulen.arma3tool.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import nl.luudvankeulen.arma3tool.R;
import nl.luudvankeulen.arma3tool.models.MapItem;

public class MapsAdapter extends BaseAdapter{
    ArrayList<MapItem> maps;

    public MapsAdapter(Context context) {
        maps = new ArrayList<>();
        maps.add(new MapItem(R.drawable.altis, "Altis"));
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}

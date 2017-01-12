package nl.luudvankeulen.arma3tool.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nl.luudvankeulen.arma3tool.R;
import nl.luudvankeulen.arma3tool.models.MapItem;

public class MapsAdapter extends BaseAdapter{
    ArrayList<MapItem> maps;
    private static LayoutInflater inflater;

    public MapsAdapter(Context context) {
        maps = new ArrayList<>();
        maps.add(new MapItem(R.drawable.altis_icon, "Altis"));
        maps.add(new MapItem(R.drawable.stratis_icon, "Stratis"));
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return maps.size();
    }

    @Override
    public Object getItem(int i) {
        return maps.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if (vi == null)
            vi = inflater.inflate(R.layout.map_row, null);
        TextView text = (TextView) vi.findViewById(R.id.text);
        text.setText(maps.get(i).getName());
        ImageView image = (ImageView) vi.findViewById(R.id.image);
        image.setImageResource(maps.get(i).getPictureId());
        return vi;
    }
}

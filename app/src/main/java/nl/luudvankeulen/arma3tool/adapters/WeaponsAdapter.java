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
import nl.luudvankeulen.arma3tool.WeaponType;
import nl.luudvankeulen.arma3tool.models.WeaponItem;

public class WeaponsAdapter extends BaseAdapter {
    ArrayList<WeaponItem> weapons;
    private static LayoutInflater inflater;

    public WeaponsAdapter(Context context) {
        weapons = new ArrayList<>();
        weapons.add(new WeaponItem("p07", R.drawable.poseven, WeaponType.HANDGUN));
        weapons.add(new WeaponItem("4-five", R.drawable.fourfive, WeaponType.HANDGUN));
        weapons.add(new WeaponItem("ACP-C2", R.drawable.acp, WeaponType.HANDGUN));
        weapons.add(new WeaponItem("Rook-40", R.drawable.rook, WeaponType.HANDGUN));
        weapons.add(new WeaponItem("Zubr", R.drawable.zubr, WeaponType.HANDGUN));
        weapons.add(new WeaponItem("PM", R.drawable.pm, WeaponType.HANDGUN));
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return weapons.size();
    }

    @Override
    public Object getItem(int i) {
        return weapons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if (vi == null)
            vi = inflater.inflate(R.layout.weapon_row, null);
        TextView text = (TextView) vi.findViewById(R.id.text);
        text.setText(weapons.get(i).getName());
        ImageView image = (ImageView) vi.findViewById(R.id.image);
        image.setImageResource(weapons.get(i).getPictureId());
        return vi;
    }
}

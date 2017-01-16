package nl.luudvankeulen.arma3tool.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import nl.luudvankeulen.arma3tool.R;
import nl.luudvankeulen.arma3tool.enums.DLCType;
import nl.luudvankeulen.arma3tool.enums.WeaponType;
import nl.luudvankeulen.arma3tool.models.WeaponItem;

public class WeaponsAdapter extends BaseAdapter {
    ArrayList<WeaponItem> weapons;
    private static LayoutInflater inflater;

    public WeaponsAdapter(Context context) {
        weapons = getAllWeapons();
        //DMR
        weapons.add(new WeaponItem("ASP-1 Kir", R.drawable.pm, WeaponType.DMR, DLCType.MARKSMEN));
        weapons.add(new WeaponItem("CMR-76", R.drawable.pm, WeaponType.DMR, DLCType.APEX));
        weapons.add(new WeaponItem("Cyrus", R.drawable.pm, WeaponType.DMR, DLCType.MARKSMEN));
        weapons.add(new WeaponItem("MAR-10", R.drawable.pm, WeaponType.DMR, DLCType.MARKSMEN));
        weapons.add(new WeaponItem("Mk-I EMR", R.drawable.pm, WeaponType.DMR, DLCType.MARKSMEN));
        weapons.add(new WeaponItem("Mk14", R.drawable.pm, WeaponType.DMR, DLCType.MARKSMEN));
        weapons.add(new WeaponItem("Mk18 ABR", R.drawable.pm, WeaponType.DMR));
        weapons.add(new WeaponItem("MXM", R.drawable.pm, WeaponType.DMR));
        weapons.add(new WeaponItem("Rahim", R.drawable.pm, WeaponType.DMR));
        weapons.add(new WeaponItem("SPAR-17", R.drawable.pm, WeaponType.DMR, DLCType.APEX));
        //Sniper
        weapons.add(new WeaponItem("M320 LRR", R.drawable.pm, WeaponType.SNIPER));
        weapons.add(new WeaponItem("GM6 Lynx", R.drawable.pm, WeaponType.SNIPER));
        //LMG
        weapons.add(new WeaponItem("LIM-85", R.drawable.pm, WeaponType.MACHINEGUN, DLCType.APEX));
        weapons.add(new WeaponItem("Mk200", R.drawable.pm, WeaponType.MACHINEGUN));
        weapons.add(new WeaponItem("MX SW", R.drawable.pm, WeaponType.MACHINEGUN));
        weapons.add(new WeaponItem("NAVID", R.drawable.pm, WeaponType.MACHINEGUN, DLCType.MARKSMEN));
        weapons.add(new WeaponItem("SPMG", R.drawable.pm, WeaponType.MACHINEGUN, DLCType.MARKSMEN));
        weapons.add(new WeaponItem("Zafir", R.drawable.pm, WeaponType.MACHINEGUN));
        //Launcher
        weapons.add(new WeaponItem("PCML", R.drawable.pm, WeaponType.LAUNCHER));
        weapons.add(new WeaponItem("Titan MPRL", R.drawable.pm, WeaponType.LAUNCHER));
        weapons.add(new WeaponItem("Titan MPRL Compact", R.drawable.pm, WeaponType.LAUNCHER));
        weapons.add(new WeaponItem("RPG-7", R.drawable.pm, WeaponType.LAUNCHER, DLCType.APEX));
        weapons.add(new WeaponItem("RPG-42", R.drawable.pm, WeaponType.LAUNCHER));

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public WeaponsAdapter(Context context, WeaponType weaponType) {
        switch (weaponType) {
            case NONE:
                weapons = getAllWeapons();
                break;
            case HANDGUN:
                weapons = getAllHandguns();
                break;
            case SMG:
                weapons = getAllSmgs();
                break;
            default:
                weapons = new ArrayList<>();
                break;
        }
    }

    public ArrayList<WeaponItem> getAllWeapons() {
        ArrayList<WeaponItem> allWeapons = new ArrayList<>();
        allWeapons.addAll(getAllHandguns());
        allWeapons.addAll(getAllSmgs());
        allWeapons.addAll(getAllRifles());
        return allWeapons;
    }

    public ArrayList<WeaponItem> getAllHandguns() {
        ArrayList<WeaponItem> handguns = new ArrayList<>();
        handguns.add(new WeaponItem("p07", R.drawable.poseven, WeaponType.HANDGUN));
        handguns.add(new WeaponItem("4-five", R.drawable.fourfive, WeaponType.HANDGUN));
        handguns.add(new WeaponItem("ACP-C2", R.drawable.acp, WeaponType.HANDGUN));
        handguns.add(new WeaponItem("Rook-40", R.drawable.rook, WeaponType.HANDGUN));
        handguns.add(new WeaponItem("Zubr", R.drawable.zubr, WeaponType.HANDGUN));
        handguns.add(new WeaponItem("PM", R.drawable.pm, WeaponType.HANDGUN, DLCType.APEX));
        return handguns;
    }

    public ArrayList<WeaponItem> getAllSmgs() {
        ArrayList<WeaponItem> smgs = new ArrayList<>();
        smgs.add(new WeaponItem("PDW2000", R.drawable.pdw, WeaponType.SMG));
        smgs.add(new WeaponItem("Protector", R.drawable.protector, WeaponType.SMG, DLCType.APEX));
        smgs.add(new WeaponItem("Sting", R.drawable.sting, WeaponType.SMG));
        smgs.add(new WeaponItem("Vermin", R.drawable.vermin, WeaponType.SMG));
        return smgs;
    }

    public ArrayList<WeaponItem> getAllRifles() {
        ArrayList<WeaponItem> rifles = new ArrayList<>();
        rifles.add(new WeaponItem("AK-12", R.drawable.aktwelve, WeaponType.RIFLE, DLCType.APEX));
        rifles.add(new WeaponItem("AK-74", R.drawable.akfourtyseven, WeaponType.RIFLE, DLCType.APEX));
        rifles.add(new WeaponItem("AKM", R.drawable.akfourtyseven, WeaponType.RIFLE, DLCType.APEX));
        rifles.add(new WeaponItem("CAR-95", R.drawable.carninetyfive, WeaponType.RIFLE, DLCType.APEX));
        rifles.add(new WeaponItem("MX", R.drawable.mx, WeaponType.RIFLE));
        rifles.add(new WeaponItem("MX 3GL", R.drawable.mxgl, WeaponType.RIFLE));
        rifles.add(new WeaponItem("MXC", R.drawable.mxc, WeaponType.RIFLE));
        rifles.add(new WeaponItem("Katiba", R.drawable.katiba, WeaponType.RIFLE));
        rifles.add(new WeaponItem("Katiba Carbine", R.drawable.katibacarbine, WeaponType.RIFLE));
        rifles.add(new WeaponItem("Katiba GL", R.drawable.katibagl, WeaponType.RIFLE));
        rifles.add(new WeaponItem("Mk20", R.drawable.mktwenty, WeaponType.RIFLE));
        rifles.add(new WeaponItem("Mk20C", R.drawable.mktwentyc, WeaponType.RIFLE));
        rifles.add(new WeaponItem("Mk20 EGLM", R.drawable.mktwentygl, WeaponType.RIFLE));
        rifles.add(new WeaponItem("SDAR", R.drawable.sdar, WeaponType.RIFLE));
        rifles.add(new WeaponItem("SPAR-16", R.drawable.sparsixteen, WeaponType.RIFLE, DLCType.APEX));
        rifles.add(new WeaponItem("TRG 20", R.drawable.trgtwenty, WeaponType.RIFLE));
        rifles.add(new WeaponItem("TRG 21", R.drawable.trgtwentyone, WeaponType.RIFLE));
        rifles.add(new WeaponItem("Type 115", R.drawable.typeoneonefive, WeaponType.RIFLE, DLCType.APEX));
        return rifles;
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

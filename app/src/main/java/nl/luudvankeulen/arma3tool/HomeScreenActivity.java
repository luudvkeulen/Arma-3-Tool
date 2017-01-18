package nl.luudvankeulen.arma3tool;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity {

    private AdView mAdView;
    private IInAppBillingService mService;
    private ServiceConnection mServiceConn;
    private ArrayList<String> skuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //Ads
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mAdView.bringToFront();
            }
        });
        //Billing
        mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name,
                                           IBinder service) {
                mService = IInAppBillingService.Stub.asInterface(service);
                try {
                    Bundle ownedItems = mService.getPurchases(3, getPackageName(), "inapp", "bGoa+V7g/yqDXvKRqq+JTFn4uQZbPiQJo4pf9RzJ");
                    int response = ownedItems.getInt("RESPONSE_CODE");
                    if (response == 0) {
                        ArrayList<String> ownedSkus = ownedItems.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> purchaseDataList = ownedItems.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> signatureList = ownedItems.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        String continuationToken = ownedItems.getString("INAPP_CONTINUATION_TOKEN");
                        System.out.println("Owned items2 " + ownedSkus.size());
                        /*for (String purchaseData : purchaseDataList) {
                            System.out.println("item: " + purchaseData);
                            JSONObject o = new JSONObject(purchaseData);
                            String token = o.optString("token", o.optString("purchaseToken"));
                            mService.consumePurchase(3, getPackageName(), token);
                        }*/

                        if(ownedSkus.size() > 0) {
                            RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_home_screen);
                            layout.removeView(mAdView);
                            Button btnRemoveAds = (Button) findViewById(R.id.removeads);
                            btnRemoveAds.setVisibility(View.GONE);
                        }
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };

        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);

        skuList.add("remove_ads");
        Bundle querySkus = new Bundle();
        querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
    }

    public void onButtonMapsClick(View view) {
        Intent intent = new Intent(this, MapScreenActivity.class);
        startActivity(intent);
    }

    public void onButtonWeaponsClick(View view) {
        Intent intent = new Intent(this, WeaponScreenActivity.class);
        startActivity(intent);
    }

    public void onButtonRemoveAdsClick(View view) {
        try {
            Bundle buyIntentBundle = mService.getBuyIntent(3, getPackageName(), "remove_ads", "inapp", "bGoa+V7g/yqDXvKRqq+JTFn4uQZbPiQJo4pf9RzJ");
            PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");
            startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mAdView != null) {
            mAdView.destroy();
        }
        if (mService != null) {
            unbindService(mServiceConn);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("Result");
    }
}

package promo.kit.testapp.data.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetUtils {
    public static boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager
                = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo()
                != null && connectivityManager.getActiveNetworkInfo()
                .isConnected();
    }
}

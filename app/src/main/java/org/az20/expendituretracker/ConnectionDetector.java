package org.az20.expendituretracker;


import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {

    Context context;

    public ConnectionDetector(Context context) {

        this.context = context;
    }

    public boolean isConnected(){

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {

            NetworkInfo info = connectivityManager.getActiveNetworkInfo();

            if (info != null)
                if (info.getState() == NetworkInfo.State.CONNECTED)
                    return true;
        }

        return false;
    }

    public void alertDialog(Context context, String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}

package com.example.Utlis;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.retrofitdemopro.R;


public class DialogPopup {


    public static ProgressDialog progressDialog;
    Dialog dialog;
    private static DialogPopup instance;
    AlertDialog googlePlayAlertDialog;
    AlertDialog locationAlertDialog;
    static Context context;

    public synchronized static DialogPopup getInstance() {

        if (instance == null) {
            instance = new DialogPopup(context);
        }
        return instance;
    }

    public DialogPopup(Context context) {
        this.context = context;
    }

   /* public Dialog showAppSettingsDialog(final Activity mContext, final String message) {
        final Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
        dialog.getWindow().getAttributes().windowAnimations = R.style.Animations_LoadingDialogFade;
        dialog.setContentView(R.layout.dialog_custom_two_btn);
        dialog.setCancelable(false);
        dialog.show();
        TextView tvMessage = ((TextView) dialog.findViewById(R.id.textMessage));
        tvMessage.setText(message);
        dialog.findViewById(R.id.ok_btn).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setData(Uri.parse("package:" + mContext.getPackageName()));
            mContext.startActivity(intent);
            dialog.dismiss();
        });

        dialog.findViewById(R.id.btnCancel).setOnClickListener(v -> dialog.dismiss());
        dialog.findViewById(R.id.crossbtn_RL).setOnClickListener(v -> dialog.dismiss());

        return dialog;
    }*/

    /**
     * Displays custom loading dialog
     *
     * @param context application context
     * @param message string message to show in dialog
     */
    public void showLoadingDialog(Context context, String message) {
        try {
            if (isDialogShowing()) {
                dismissLoadingDialog();
            }

            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    return;
                }
            }

            progressDialog = new ProgressDialog(context, R.style.AppTheme);
            progressDialog.show();
            WindowManager.LayoutParams layoutParams = progressDialog.getWindow().getAttributes();
            layoutParams.dimAmount = 0.5f;
            progressDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            progressDialog.setCancelable(false);
            //progressDialog.setContentView(R.layout.dialog_loading_box);

           // RelativeLayout frameLayout = (RelativeLayout) progressDialog.findViewById(R.id.dlgProgress);

          //  ((ProgressBar) progressDialog.findViewById(R.id.progress_wheel)).setProgress(10);
          //  TextView messageText = (TextView) progressDialog.findViewById(R.id.tvProgress);
          //  messageText.setText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean isDialogShowing() {
        try {
            if (progressDialog == null) {
                return false;
            } else {
                return progressDialog.isShowing();
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Dismisses above loading dialog
     */
    public void dismissLoadingDialog() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
            Log.e("e", "=" + e);
        }

    }

   /* public void alertPopup(Activity activity, String title, String message) {
        try {
            try {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Exception e) {
            }
            if ("".equalsIgnoreCase(title)) {
                title = activity.getResources().getString(R.string.alert);
            }

            dialog = new Dialog(activity, R.style.DialogTheme);
            dialog.getWindow().getAttributes().windowAnimations = R.style.Animations_LoadingDialogFade;
            dialog.setContentView(R.layout.dialog_custom_message);

            WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
            layoutParams.dimAmount = DataUtil.dialogDimAmount;
            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);


            TextView textHead = (TextView) dialog.findViewById(R.id.textHead);
            textHead.setTypeface(DataUtil.getFont(activity), Typeface.BOLD);
            TextView textMessage = (TextView) dialog.findViewById(R.id.textMessage);
            textMessage.setTypeface(DataUtil.getFont(activity), Typeface.BOLD);
            ImageView textImg = (ImageView) dialog.findViewById(R.id.textImg);

            textMessage.setMovementMethod(new ScrollingMovementMethod());
            textHead.setText(title);
            textMessage.setText(message);

            textHead.setVisibility(View.GONE);
            textImg.setVisibility(View.GONE);

            TextView btnOk = (TextView) dialog.findViewById(R.id.ok_btn);
            btnOk.setTypeface(DataUtil.getFont(activity), Typeface.BOLD);

            btnOk.setOnClickListener(view -> dialog.dismiss());

            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

   /* public void alertPopupWithListener(Activity activity, String title, String message, final View.OnClickListener onClickListener) {
        try {
            try {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Exception e) {
            }
            if ("".equalsIgnoreCase(title)) {
                title = activity.getResources().getString(R.string.alert);
            }

            dialog = new Dialog(activity, R.style.DialogTheme);
            dialog.getWindow().getAttributes().windowAnimations = R.style.Animations_LoadingDialogFade;
            dialog.setContentView(R.layout.dialog_custom_message);

            WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
            layoutParams.dimAmount = DataUtil.dialogDimAmount;
            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);

            TextView textHead = (TextView) dialog.findViewById(R.id.textHead);
            textHead.setTypeface(DataUtil.getFont(activity), Typeface.BOLD);
            TextView textMessage = (TextView) dialog.findViewById(R.id.textMessage);
            textMessage.setTypeface(DataUtil.getFont(activity));
            ImageView textImg = (ImageView) dialog.findViewById(R.id.textImg);

            textMessage.setMovementMethod(new ScrollingMovementMethod());
            textHead.setText(title);
            textMessage.setText(message);

            textHead.setVisibility(View.GONE);
            textImg.setVisibility(View.GONE);

            TextView btnOk = (TextView) dialog.findViewById(R.id.ok_btn);
            btnOk.setTypeface(DataUtil.getFont(activity), Typeface.BOLD);

            btnOk.setOnClickListener(view -> {
                dialog.dismiss();
                onClickListener.onClick(view);
            });

            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Function to show settings alert dialog
     * On pressing Settings button will lauch Settings Options
     */
    public void showGooglePlayErrorAlert(final Activity mContext) {
        try {
            if (googlePlayAlertDialog != null && googlePlayAlertDialog.isShowing()) {
                googlePlayAlertDialog.dismiss();
            }
            AlertDialog.Builder alertDialogPrepare = new AlertDialog.Builder(mContext);

            // Setting Dialog Title
            alertDialogPrepare.setTitle("Google Play Services Error");
            alertDialogPrepare.setCancelable(false);

            // Setting Dialog Message
            alertDialogPrepare.setMessage("Google Play services not found or outdated. Please install Google Play Services?");

            // On pressing Settings button
            alertDialogPrepare.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=com.google.android.gms"));
                        mContext.startActivity(intent);
                    } catch (android.content.ActivityNotFoundException anfe) {
                        mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.gms")));
                    }
                }
            });

            // on pressing cancel button
            alertDialogPrepare.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    mContext.finish();
                }
            });

            googlePlayAlertDialog = alertDialogPrepare.create();

            // Showing Alert Message
            googlePlayAlertDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to show settings alert dialog
     * On pressing Settings button will lauch Settings Options
     */
   /* public void showLocationSettingsAlert(final Context mContext) {
        try {
            if (!((LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE)).isProviderEnabled(LocationManager.NETWORK_PROVIDER)
                    &&
                    !((LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE)).isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                if (locationAlertDialog != null && locationAlertDialog.isShowing()) {
                    locationAlertDialog.dismiss();
                }
                AlertDialog.Builder alertDialogPrepare = new AlertDialog.Builder(mContext);

                // Setting Dialog Title
                alertDialogPrepare.setTitle("Location Settings");
                alertDialogPrepare.setCancelable(false);

                // Setting Dialog Message
                alertDialogPrepare.setMessage("Location is not enabled. Do you want to enable it from settings menu?");

                // On pressing Settings button
                alertDialogPrepare.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        UserDataUtils.is_gps_enabled = true;
                        UserDataUtils.is_network_enabled = true;
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        mContext.startActivity(intent);
                        dialog.dismiss();
                    }
                });

                alertDialogPrepare.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        UserDataUtils.is_gps_enabled = false;
                        UserDataUtils.is_network_enabled = false;
                        dialog.dismiss();
                    }
                });

                locationAlertDialog = alertDialogPrepare.create();

                // Showing Alert Message
                locationAlertDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


}

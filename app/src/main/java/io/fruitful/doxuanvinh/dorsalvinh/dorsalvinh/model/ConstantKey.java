package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by admin on 9/4/2016.
 */
public class ConstantKey {
    public static int PAGE_SIZE = 10;
    public static int TIME_START = 0;
    public static int PAGE_INDEX_START = 0;

    public static String BASE_URL = "http://api.dorsal.jmango.vn";
    public static String CONTENT_TYPE = "application/json";

    //login
    public static String MESSAGE_INCORRECT = "Email or password is incorrect.";
    public static String MESSAGE_BLANK_INPUT = "Email and password can not be blank!";

    //register
    public static int ERROR_ACCOUNT_NOT_ACTIVATED = 1035;
    public static String MESSAGE_PASS_NOT_MATCH = "Password not matched. Please retype.";

    //verify
    public static int ERROR_CODE_VERIFICATION = 1036;

    //dialog
    public static void alertDialog(Activity mActivity, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("Oops");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setNeutralButton("OKE", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}

package com.clinicconnection.clinicconnection.Tools;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.view.WindowManager;

//import com.unit.ideaits.convertunit.R;


public class BasicTools {

    public static int setError(Context context, TextInputLayout layout, int string_id) {
        layout.setErrorEnabled(true);
        layout.setError(context.getString(string_id));
        return Constants.INVALID;
    }

    public static int removeError(TextInputLayout layout) {
        layout.setErrorEnabled(false);
        layout.setError(null);
        return Constants.VALID;
    }

    public static int getScreenHeight(Context context) {
        int first_dimentsion = context.getResources().getDisplayMetrics().widthPixels;
        int second_dimentsion = context.getResources().getDisplayMetrics().heightPixels;
        int height = Math.max(first_dimentsion, second_dimentsion);
        return height;
    }

    public static void hideSoftKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }



    /*public static int getRandomColor(){
        int[] colors = {R.color.material1, R.color.material1, R.color.material2, R.color.material3, R.color.material4,
                R.color.material5, R.color.material6, R.color.material7, R.color.material8, R.color.material9,
                R.color.material10, R.color.material11, R.color.material12, R.color.material13,
                R.color.transparent_black_percent_15, R.color.blue_10, R.color.material1, R.color.material2,
                R.color.material6, R.color.material5, R.color.material3, R.color.material4,
                R.color.material17, R.color.material18,};
        Random random = new Random();
        int selected = random.nextInt(colors.length);
        return colors[selected];
    }*/


   /* public static int getRandomColor(){
        int[] colors = {R.color.transparent_black_percent_50, R.color.transparent_black_percent_30,
                R.color.transparent_black_percent_15, R.color.blue_10,
                R.color.blue_20, R.color.blue_40, R.color.blue_50, R.color.transparent_black_percent_20,
                R.color.transparent_black_percent_45};
        Random random = new Random();
        int selected = random.nextInt(colors.length);
        return colors[selected];}
    */

    public static String format_time(int hour, int minute){
        String time = "";
        if (hour < 10)
            time = "0";
        time = time + hour + ":";
        if (minute < 10)
            time = time + "0";
        time = time + minute;
        return time;
    }

    public static void setStateNow(Context context, String state){
        SharedPreferences preferences = context.getSharedPreferences("State_Now", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("State", state);
        editor.commit();
    }

    public static String getStateNow(Context context){
        SharedPreferences preferences = context.getSharedPreferences("State_Now", Context.MODE_PRIVATE);
        String state = preferences.getString("State","");
        return state;
    }
    //--------------------------------------------------------------------------------------------------

    public static void setSecretCodeSy(Context context, long code){
        SharedPreferences preferences = context.getSharedPreferences("Secret_Codes", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("Secret_Code_SY", code);
        editor.commit();
    }

    public static void setSecretCodeMtn(Context context, long code){
        SharedPreferences preferences = context.getSharedPreferences("Secret_Codes", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("Secret_Code_MTN", code);
        editor.commit();
    }

    public static void setDistributorCodeSy(Context context, long code){
        SharedPreferences preferences = context.getSharedPreferences("Secret_Codes", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("Distributor_Code_SY", code);
        editor.commit();
    }
//-------------------------------------------------------------------------------------------------------------------
    public static long getSecretCodeSy(Context context){
        SharedPreferences preferences = context.getSharedPreferences("Secret_Codes", Context.MODE_PRIVATE);
        long device_id = preferences.getLong("Secret_Code_SY", 0);
        return device_id;
    }

    public static long getDistributorCodeSy(Context context){
        SharedPreferences preferences = context.getSharedPreferences("Secret_Codes", Context.MODE_PRIVATE);
        long device_id = preferences.getLong("Distributor_Code_SY", 0);
        return device_id;
    }

    public static long getSecretCodeMtn(Context context){
        SharedPreferences preferences = context.getSharedPreferences("Secret_Codes", Context.MODE_PRIVATE);
        long device_id = preferences.getLong("Secret_Code_MTN", 0);
        return device_id;
    }
}

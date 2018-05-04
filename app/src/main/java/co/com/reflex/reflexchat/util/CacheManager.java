package co.com.reflex.reflexchat.util;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheManager {

    private static String PREFERENCE_NAME = "USER_DATA";

    public static void writeString(Context context, final String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String readString(Context context, final String key) {
        return context.getSharedPreferences(PREFERENCE_NAME, context.MODE_PRIVATE).getString(key, null);
    }
}

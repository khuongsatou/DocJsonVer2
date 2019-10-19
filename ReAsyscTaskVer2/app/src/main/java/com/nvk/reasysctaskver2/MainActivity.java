package com.nvk.reasysctaskver2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = null;
        try {

            InputStream inputStream = getAssets().open("fileJSON.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            JSONObject objLaravel = new JSONObject(json);
            String name = objLaravel.getString("name");
            Log.d("AAAAA","Name:"+name);//laravel/laravel
            JSONArray arrKeywords = objLaravel.getJSONArray("keywords");
            for (int i = 0; i < arrKeywords.length(); i++) {
                Log.d("AAAAA","KeyWords: "+ arrKeywords.getString(i));//frameword , laravel
            }

            JSONObject objRequire= objLaravel.getJSONObject("require");
            Log.d("AAAAA","Require:"+objRequire.getString("php"));
            Log.d("AAAAA","Require:"+objRequire.getString("fideloper/proxy"));
            Log.d("AAAAA","Require:"+objRequire.getString("laravel/framework"));
            Log.d("AAAAA","Require:"+objRequire.getString("laravel/tinker"));

            JSONObject objScripts = objLaravel.getJSONObject("scripts");
            JSONArray  arr_Post_AutoLoad_dump = objScripts.getJSONArray("post-autoload-dump");

            for (int i = 0; i <arr_Post_AutoLoad_dump.length() ; i++) {
                Log.d("AAAAA","Post_Auto_Load_Dump:"+arr_Post_AutoLoad_dump.getString(i));
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}

package com.example.colon.formulaxy;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class FxyApi {
    String token = new String();
    public String login(String user, String password){
        String msg = new String();
        Authenticate auth = new Authenticate(user, password);

        try {
            auth.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg = token = auth.getToken();
        return msg;
    }

    public JSONArray getPostByTopic(String Grupo, String topic){
        JSONArray RespJsons = new JSONArray();
        FetchJSON fetch = new FetchJSON(token, "posts/"+Grupo+"/"+topic);

        try {
            fetch.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Log.d("results", fetch.getJson());

        JSONObject raw = new JSONObject();
        try {
            raw = new JSONObject(fetch.response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            RespJsons = new JSONArray(raw.getString("posts"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RespJsons;
    }
}

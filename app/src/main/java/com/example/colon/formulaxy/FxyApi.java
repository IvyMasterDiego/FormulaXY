package com.example.colon.formulaxy;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class FxyApi {

    String token = "";
    public String login(String user, String password){
        String msg = new String();
        Authenticate auth = new Authenticate(user, password);

        try {
            auth.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "Bad";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Bad";
        }
        token = MainActivity.token = auth.getToken();
        return "Ok";
    }

    public JSONArray getPostByTopic(String Grupo, String topic){
        JSONArray RespJsons = new JSONArray();
        FetchJSON fetch = new FetchJSON(MainActivity.token, "posts/"+Grupo+"/"+topic);

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

    public String createGroup(String name, String code){
        JSONObject paquete = new JSONObject();
        try {
            paquete.put("name", name);
            paquete.put("code", code);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SendJSON send = new SendJSON(MainActivity.token, "/groups", paquete);
        try {
            send.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "Error";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Error";
        }
        return "Ok";
    }

    public String createUser(String user, String password){
        JSONObject paquete = new JSONObject();
        try {
            paquete.put("name", user);
            paquete.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SendJSON send = new SendJSON(MainActivity.token, "/user", paquete);
        try {
            send.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return "Error";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Error";
        }
        return "Ok";
    }

}

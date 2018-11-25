package com.example.colon.formulaxy;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class FetchJSON extends AsyncTask<Void, Void, Void> {
    String route;
    String end;
    String token ="";
    JSONObject result = new JSONObject();
    public JSONObject getJson(){
        if(result == null){
            try {
                return (new JSONObject("{err:"+end+"}"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else{
            return result;
        }
        return result;
    }
    public FetchJSON(String tkn, String rout){
        route = rout;
        token = tkn;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        String ip = "http://13.58.197.240:5000/";
        URL url = null; //Enter URL here
        try {
            url = new URL(ip + route);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("x-access-token", token);

            int status = httpURLConnection.getResponseCode();
            Log.d("Return code", "Code: " + status);
            if (status == 401) {
                end = "Permission denied";
                //token[0] = new JSONObject("err" + ":" + "Access denied");
            }

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String response = "";
            while (line != null) {
                Log.d("received", line);
                response += line;
                line = bufferedReader.readLine();
            }
            Log.d("response", "response");
            result = new JSONObject(response + "}");
            inputStream.close();
            //wr.close();
        } catch (MalformedURLException e) {
            Log.d("url","exep");
            end = "Connection error";
            e.printStackTrace();
        } catch (ProtocolException e) {
            Log.d("url","prot");
            end = "Connection error";
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("url","io");
            end = "Connection error";
            e.printStackTrace();
        } catch (JSONException e) {
            Log.d("json","exep");
            end = "Connection error";
            e.printStackTrace();
        }
        end = "Connection error";
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

        super.onPostExecute(aVoid);
    }
}

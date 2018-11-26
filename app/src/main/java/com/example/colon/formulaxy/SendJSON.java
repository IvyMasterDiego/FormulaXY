package com.example.colon.formulaxy;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SendJSON extends AsyncTask<Void, Void, Void> {
    String route;
    JSONObject pkg;
    String end;
    String token ="";
    String response = "";
    public String getResp(){
        return end;
    }
    public SendJSON(String tkn, String rout, JSONObject pk){
        pkg = pk;
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
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Accept","application/json");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("x-access-token", token);

            Log.d("PAQUETE ", pkg.toString());

            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
            wr.writeBytes(pkg.toString());
            wr.flush();
            wr.close();

            int status = httpURLConnection.getResponseCode();
            Log.d("Return code", "Code: " + status);
            if (status == 401) {
                end = "Permission denied";
                //token[0] = new JSONObject("err" + ":" + "Access denied");
            }

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                Log.d("received", line);
                response += line;
                line = bufferedReader.readLine();
            }
            Log.d("response", "response");
            end = (String) new JSONObject(response + "}").get("msg");
            inputStream.close();
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
            try{
                end = (String) new JSONObject(response + "}").get("err");
            }catch (JSONException es){
                end = "Connection error";
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

        super.onPostExecute(aVoid);
    }
}

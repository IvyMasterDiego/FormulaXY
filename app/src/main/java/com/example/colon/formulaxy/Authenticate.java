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

public class Authenticate extends AsyncTask<Void, Void, Void> {
    String user;
    String password;
    String end;
    JSONObject token = new JSONObject();
    public String getToken(){
        return end;
    }
    public Authenticate(String usr, String passd){
        user = usr;
        password = passd;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        String ip = "http://13.58.197.240:5000/";
        URL url = null; //Enter URL here
        try {
            url = new URL(ip + "login");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("GET"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
            String usrpsswd = user + ":" + password;
            httpURLConnection.setRequestProperty("Authorization", "Basic " + new String(Base64.encode(usrpsswd.getBytes(), Base64.DEFAULT))); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                    /*Log.d("token", "Basic " +
                            Base64.encode(usrpsswd.getBytes(), Base64.NO_WRAP));*/
            //httpURLConnection.connect();

                    /*JSONObject jsonObject = new JSONObject();
                    jsonObject.put("username", user);
                    jsonObject.put("password", password);

                    DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                    wr.writeBytes(jsonObject.toString());*/

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
                //Log.d("received", line);
                response += line;
                line = bufferedReader.readLine();
            }
            token = new JSONObject(response + "}");
            //Log.d("raw",token[0].getString("token"));
            end = token.getString("token");
            inputStream.close();
            //wr.close();
        } catch (MalformedURLException e) {
            end = "Connection error";
            e.printStackTrace();
        } catch (ProtocolException e) {
            end = "Connection error";
            e.printStackTrace();
        } catch (IOException e) {
            end = "Connection error";
            e.printStackTrace();
        } catch (JSONException e) {
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

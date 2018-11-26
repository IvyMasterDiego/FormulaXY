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
import java.util.ArrayList;


public class FetcherAPI {
    String ip;

    public FetcherAPI(String s) {
        ip = s;
    }

    public String Authenticate(final String user, final String password) {
        final JSONObject[] token = new JSONObject[1];
        final String[] end = new String[1];
        end[0]="none";
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
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
                    token[0] = new JSONObject(response + "}");
                    //Log.d("raw",token[0].getString("token"));
                    end[0] = token[0].getString("token");
                    inputStream.close();
                    //wr.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        Log.d("token", end[0]);
        return end[0];
    }

    public ArrayList<String> GetDataRaw(final String node, final String token) {
        final ArrayList<String> data = new ArrayList<String>();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(ip + node);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestProperty("x-access-token", token);
                    int status = httpURLConnection.getResponseCode();
                    Log.d("Return code", "Code: " + status);
                    if (status == 401) {
                        data.add("Access denied");
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while (line != null) {
                        line = bufferedReader.readLine();
                        data.add(line);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return data;
    }
}


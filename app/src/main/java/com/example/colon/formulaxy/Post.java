package com.example.colon.formulaxy;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class Post {
    public String title;
    public String content;
    public String author;
    public String topic;
    public boolean good = true;

    public Post JsonToPost(JSONObject data){
        Post pst = new Post();
        Log.d("STARTED WITH:", data.toString());
        try{
            Log.d("PASS", "2");
            pst.title = data.getString("title");
            Log.d("PASS", pst.title);
            pst.content = data.getString("content");
            Log.d("PASS", pst.content);
            pst.author = data.getString("author");
            Log.d("PASS", pst.author);
            pst.topic = data.getString("topic");
            Log.d("PASS", pst.topic);
        }catch (JSONException e){
            pst.good = false;
            return pst;
        } catch(Exception e){
            e.printStackTrace();
        }
        return pst;
    }
}

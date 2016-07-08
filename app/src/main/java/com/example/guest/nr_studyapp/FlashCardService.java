package com.example.guest.nr_studyapp;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;


public class FlashCardService {
    public static void findFlashCard(Callback callback) {
//        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.QUIZLET_CONSUMER_KEY, Constants.QUIZLET_CLIENT_ID);

        OkHttpClient client = new OkHttpClient.Builder()
                .build();


          HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.QUIZLET_BASE_URL).newBuilder();
          urlBuilder.addQueryParameter(Constants.CLIENT_ID_PARAMETER, Constants.QUIZLET_CLIENT_ID)
                  .addQueryParameter(Constants.WHITESPACE_PARAMETER, Constants.WHITESPACE_PARAMETER_ANS);
          String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Term> processResults(Response response) {
        ArrayList<Term> terms = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject quizletJSON = new JSONObject(jsonData);
                JSONArray termsJSON = quizletJSON.getJSONArray("terms");
                for (int i = 0; i < termsJSON.length(); i++) {
                    JSONObject termJSON = termsJSON.getJSONObject(i);
                    String term = termJSON.getString("term");
                    String definition = termJSON.getString("defintion");
                    String rank = termJSON.getString("rank");

                    Term term = new Term(term, definition, rank);
                    terms.add(term);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return terms;
    }
}

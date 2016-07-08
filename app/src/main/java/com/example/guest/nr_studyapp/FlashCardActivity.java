package com.example.guest.nr_studyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;
import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;

//
//public class FlashCardActivity extends AppCompatActivity implements View.OnClickListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_flash_card);
//        ButterKnife.bind(this);
//
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//}

public class FlashCardActivity extends AppCompatActivity {
    private ListView mFlashCards;
    public static final String TAG = FlashCardActivity.class.getSimpleName();

//    private String[] flashcards = new String[] {"Acidosis", "Acute stress reaction", "Adjuncts", "Aggravation", "Agitation", "Algorithm", "Alkalosis", "Anoxia", "Antecubital", "Antibiotic", "Antibodies", "Antigen", "Antipyretic", "Arthritis", "Aseptic", "Blunt Trauma", "BSIP", "Copius", "Decontamination", "Delayed Stress Reaction", "Dermatology", "Disinfection", "Edema", "Electrodes", "Embolus", "Emphysema", "Epidemiology", "Epistaxis", "Etiology", "Expedite", "Febrile", "Gait", "Geriatrics", "Hemothorax", "Hepatitis", "Hernia", "Infiltration", "Inflammation", "Infusion", "Ischemia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);
        mFlashCards = (ListView) findViewById(R.id.flashCards);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, flashcards);
//        mFlashCards.setAdapter(adapter);

            getTerms();


        mFlashCards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String flashcard = ((TextView) view).getText().toString();
                Toast.makeText(FlashCardActivity.this, flashcard, Toast.LENGTH_LONG).show();
            }
        });
        }

    private void getTerms() {
        final FlashCardService flashCardService = new FlashCardService();
        flashCardService.findFlashCard(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    }
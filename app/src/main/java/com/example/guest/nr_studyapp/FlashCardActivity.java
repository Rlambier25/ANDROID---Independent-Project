package com.example.guest.nr_studyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FlashCardActivity extends AppCompatActivity {
    private ListView mFlashCards;
    private String[] flashcards = new String[] {"Acidosis", "Acute stress reaction", "Adjuncts", "Aggravation", "Agitation", "Algorithm", "Alkalosis", "Anoxia", "Antecubital", "Antibiotic", "Antibodies", "Antigen", "Antipyretic", "Arthritis", "Aseptic", "Blunt Trauma", "BSIP", "Copius", "Decontamination", "Delayed Stress Reaction", "Dermatology", "Disinfection", "Edema", "Electrodes", "Embolus", "Emphysema", "Epidemiology", "Epistaxis", "Etiology", "Expedite", "Febrile", "Gait", "Geriatrics", "Hemothorax", "Hepatitis", "Hernia", "Infiltration", "Inflammation", "Infusion", "Ischemia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        mFlashCards = (ListView) findViewById(R.id.flashCards);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, flashcards);
        mFlashCards.setAdapter(adapter);

        mFlashCards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String flashcard = ((TextView)view).getText().toString();
                Toast.makeText(FlashCardActivity.this, flashcard, Toast.LENGTH_LONG).show();
            }
        });

    }
}

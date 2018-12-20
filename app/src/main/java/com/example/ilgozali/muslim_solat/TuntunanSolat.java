package com.example.ilgozali.muslim_solat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class TuntunanSolat extends AppCompatActivity {
PDFView pdfviews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuntunan_solat);

        pdfviews = (PDFView) findViewById(R.id.viewpdf);
        pdfviews.fromAsset("tuntunan-shalat.pdf").load();
    }


    }


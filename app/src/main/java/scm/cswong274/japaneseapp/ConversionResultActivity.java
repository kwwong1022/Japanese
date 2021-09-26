package scm.cswong274.japaneseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConversionResultActivity extends AppCompatActivity implements View.OnClickListener {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    TextView txtFinalScore;
    Button Retry, Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_result);
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //getWindow().setLayout((int)(displayMetrics.widthPixels * 0.7), (int)(displayMetrics.heightPixels * 0.7));

        Bundle extras = getIntent().getExtras();
        Retry = findViewById(R.id.btnRetry);
        Home = findViewById(R.id.btnHome);
        Retry.setOnClickListener(this);
        Home.setOnClickListener(this);
        txtFinalScore = findViewById(R.id.txtFinalScore);
        txtFinalScore.setText(extras.getString("Score"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btnRetry):
                    startActivity(new Intent(ConversionResultActivity.this, ConvertionActivity.class));
                break;
            case (R.id.btnHome):
                    startActivity(new Intent(ConversionResultActivity.this, TitleActivity.class));
                break;
        }
    }
}
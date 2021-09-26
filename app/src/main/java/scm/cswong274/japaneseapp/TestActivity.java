package scm.cswong274.japaneseapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    private static final int REQUEST_SPEECH = 1520;
    public String[] hiraganaWord = new  String[71];
    public String[] kataganaWord = new  String[71];
    public Button btnListen;
    int COUNT;
    SpeechRecognizer s;
    TextView Question;
    TextView DetectedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Question = findViewById(R.id.Question);
        btnListen = findViewById(R.id.btn_Start);
        btnListen.setOnClickListener(this);
        DetectedText = findViewById(R.id.DetectedText);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},1 );
        }

        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ja");
        intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS,true);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"SpeakUp");
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS , 100);
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS , 1);
        intent.putExtra(RecognizerIntent.EXTRA_CONFIDENCE_SCORES , 0);

        s = SpeechRecognizer.createSpeechRecognizer(this);
        s.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {
                Log.e("STT","Start Listening");
            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> text = bundle.getStringArrayList(RecognizerIntent.EXTRA_RESULTS);
                Question.setText(text.get(0));
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });
        hiraganaWord[0] = "あ";
        hiraganaWord[1] = "い";
        hiraganaWord[2] = "う";
        hiraganaWord[3] = "え";
        hiraganaWord[4] = "お";
        hiraganaWord[5] = "か";
        hiraganaWord[6] = "き";
        hiraganaWord[7] = "く";
        hiraganaWord[8] = "け";
        hiraganaWord[9] = "こ";
        hiraganaWord[10] = "さ";
        hiraganaWord[11] = "し";
        hiraganaWord[12] = "す";
        hiraganaWord[13] = "せ";
        hiraganaWord[14] = "そ";
        hiraganaWord[15] = "た";
        hiraganaWord[16] = "ち";
        hiraganaWord[17] = "つ";
        hiraganaWord[18] = "て";
        hiraganaWord[19] = "と";
        hiraganaWord[20] = "な";
        hiraganaWord[21] = "に";
        hiraganaWord[22] = "ぬ";
        hiraganaWord[23] = "ね";
        hiraganaWord[24] = "の";
        hiraganaWord[25] = "は";
        hiraganaWord[26] = "ひ";
        hiraganaWord[27] = "ふ";
        hiraganaWord[28] = "へ";
        hiraganaWord[29] = "ほ";
        hiraganaWord[30] = "ま";
        hiraganaWord[31] = "み";
        hiraganaWord[32] = "む";
        hiraganaWord[33] = "め";
        hiraganaWord[34] = "も";
        hiraganaWord[35] = "や";
        hiraganaWord[36] = "ゆ";
        hiraganaWord[37] = "よ";
        hiraganaWord[38] = "ら";
        hiraganaWord[39] = "り";
        hiraganaWord[40] = "る";
        hiraganaWord[41] = "れ";
        hiraganaWord[42] = "ろ";
        hiraganaWord[43] = "わ";
        hiraganaWord[44] = "を";
        hiraganaWord[45] = "ん";
        hiraganaWord[46] = "が";
        hiraganaWord[47] = "ぎ";
        hiraganaWord[48] = "ぐ";
        hiraganaWord[49] = "げ";
        hiraganaWord[50] = "ご";
        hiraganaWord[51] = "ざ";
        hiraganaWord[52] = "じ";
        hiraganaWord[53] = "ず";
        hiraganaWord[54] = "ぜ";
        hiraganaWord[55] = "ぞ";
        hiraganaWord[56] = "だ";
        hiraganaWord[57] = "ぢ";
        hiraganaWord[58] = "づ";
        hiraganaWord[59] = "で";
        hiraganaWord[60] = "ど";
        hiraganaWord[61] = "ば";
        hiraganaWord[62] = "び";
        hiraganaWord[63] = "ぶ";
        hiraganaWord[64] = "べ";
        hiraganaWord[65] = "ぼ";
        hiraganaWord[66] = "ぱ";
        hiraganaWord[67] = "ぴ";
        hiraganaWord[68] = "ぷ";
        hiraganaWord[69] = "ぺ";
        hiraganaWord[70] = "ぽ";

        kataganaWord[0] = "ア";
        kataganaWord[1] = "イ";
        kataganaWord[2] = "ウ";
        kataganaWord[3] = "エ";
        kataganaWord[4] = "オ";
        kataganaWord[5] = "カ";
        kataganaWord[6] = "キ";
        kataganaWord[7] = "ク";
        kataganaWord[8] = "ケ";
        kataganaWord[9] = "コ";
        kataganaWord[10] = "サ";
        kataganaWord[11] = "シ";
        kataganaWord[12] = "ス";
        kataganaWord[13] = "セ";
        kataganaWord[14] = "ソ";
        kataganaWord[15] = "タ";
        kataganaWord[16] = "チ";
        kataganaWord[17] = "ツ";
        kataganaWord[18] = "テ";
        kataganaWord[19] = "ト";
        kataganaWord[20] = "ナ";
        kataganaWord[21] = "ニ";
        kataganaWord[22] = "ヌ";
        kataganaWord[23] = "ネ";
        kataganaWord[24] = "ノ";
        kataganaWord[25] = "ハ";
        kataganaWord[26] = "ヒ";
        kataganaWord[27] = "フ";
        kataganaWord[28] = "ヘ";
        kataganaWord[29] = "ホ";
        kataganaWord[30] = "マ";
        kataganaWord[31] = "ミ";
        kataganaWord[32] = "ム";
        kataganaWord[33] = "メ";
        kataganaWord[34] = "モ";
        kataganaWord[35] = "ヤ";
        kataganaWord[36] = "ユ";
        kataganaWord[37] = "ヨ";
        kataganaWord[38] = "ラ";
        kataganaWord[39] = "リ";
        kataganaWord[40] = "ル";
        kataganaWord[41] = "レ";
        kataganaWord[42] = "ロ";
        kataganaWord[43] = "ワ";
        kataganaWord[44] = "ヲ";
        kataganaWord[45] = "ン";
        kataganaWord[46] = "ガ";
        kataganaWord[47] = "ギ";
        kataganaWord[48] = "グ";
        kataganaWord[49] = "ゲ";
        kataganaWord[50] = "ゴ";
        kataganaWord[51] = "ザ";
        kataganaWord[52] = "ジ";
        kataganaWord[53] = "ズ";
        kataganaWord[54] = "ゼ";
        kataganaWord[55] = "ゾ";
        kataganaWord[56] = "ダ";
        kataganaWord[57] = "ヂ";
        kataganaWord[58] = "ヅ";
        kataganaWord[59] = "デ";
        kataganaWord[60] = "ド";
        kataganaWord[61] = "バ";
        kataganaWord[62] = "ビ";
        kataganaWord[63] = "ブ";
        kataganaWord[64] = "ベ";
        kataganaWord[65] = "ボ";
        kataganaWord[66] = "パ";
        kataganaWord[67] = "ピ";
        kataganaWord[68] = "プ";
        kataganaWord[69] = "ペ";
        kataganaWord[70] = "ポ";

        generateText();

    }

    public void generateText(){
        float rand = new Random().nextFloat();
        int randInt = new Random().nextInt(70);

        boolean KATA = false;
        if (rand > 0.5f){
            KATA = true;
        }
        if (KATA){
            Question.setText(kataganaWord[randInt]);
        }
        else {
            Question.setText(hiraganaWord[randInt]);
        }
    }

    public void Listen(){
        /*if (COUNT == 0){
            COUNT = 1;
            Log.e("STT","Listening");
            s.startListening(intent);
        }
        else if (COUNT == 1){
            COUNT = 0;
            Log.e("STT","Stop Listening");
            s.stopListening();

        }*/

        startActivityForResult(intent, REQUEST_SPEECH);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SPEECH){
            ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            DetectedText.setText(text.get(0));
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_Start) {
            Listen();
        }
    }


}
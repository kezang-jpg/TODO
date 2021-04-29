package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {
    public static final String LOG=MainActivity.class.getName();
    EditText location,share,website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        location=findViewById(R.id.loct);
        share=findViewById(R.id.shart);
        website=findViewById(R.id.webt);

    }
    public void website(View view) {

        String message=website.getText().toString();
        Uri url = Uri.parse(message);
        Intent send = new Intent(Intent.ACTION_VIEW,url);
        if(send.resolveActivity(getPackageManager()) != null){
            startActivity(send);
        }
        else{
            Log.d(LOG,"Implicit Message Error");
        }
    }

    public void location(View view) {
        String message=website.getText().toString();
        Uri url = Uri.parse("geo:0,0?q="+message);
        Intent send = new Intent(Intent.ACTION_VIEW,url);
        if(send.resolveActivity(getPackageManager()) != null){
            startActivity(send);
        }
        else{
            Log.d(LOG,"Implicit Message Error");
        }
    }
    public void share(View view) {
        String message = share.getText().toString();
        String Type = "Text/pain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(Type)
                .setChooserTitle("Share this text with :")
                .setText(message)
                .startChooser();
    }
}
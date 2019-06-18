package com.example.twtprojectpart2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView image_details;
    TextView title_details, subtitle_details;
    EditText user_input;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        image_details = (ImageView)findViewById(R.id.imageDetails);
        title_details = (TextView) findViewById(R.id.titleDetails);
        subtitle_details = (TextView) findViewById(R.id.subtitleDetails);
        user_input = (EditText) findViewById(R.id.editText);
        button = (Button)findViewById(R.id.buttonBack);

        // create an object of the class ObjectClass
//        String object = getIntent().getParcelableExtra("myCustomObject");
//        String object = getIntent().getStringExtra("myCustomObject");
        int object = getIntent().getIntExtra("myCustomObject",1);
        int titleObject = getIntent().getIntExtra("myTitleObject", 99);
        int subtitleObject = getIntent().getIntExtra("mySubtitleObject", 999);
//        Log.e("Test",object.toString());
        // using the object just created, we now can access the icons and textviews from Parcelable class ObjectClass

//        Log.e("Print",Integer.toString(object) );
//        Integer test = android.R.drawable.ic_btn_speak_now;

        image_details.setImageResource(object);
        title_details.setText("Row Title " + titleObject);
        subtitle_details.setText("Row Subtitle " + subtitleObject);

        // after user input is given, the button is clicked that takes back to the home screen
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userInput = user_input.getText().toString();

                // sending intent to go back
//                Intent intent = new Intent();
//                intent.setAction("sendingBack");
//                intent.putExtra("key", userInput);
//                sendBroadcast(intent);

                Intent intent = new Intent(DetailsActivity.this, FirstFragment.class);
                startActivity(intent);

            }
        });
    }
}

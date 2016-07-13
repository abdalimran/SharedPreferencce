package com.github.abdalimran.sharedpreferencce;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView showText;
    private EditText editText;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText= (TextView) findViewById(R.id.showText);
        editText= (EditText) findViewById(R.id.editText);

        sharedPreferences = getSharedPreferences("MyPreference", MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void save(View view) {
        String saveText=editText.getText().toString();
        editor.putString("Message",saveText);
        editor.commit();

        Toast.makeText(getApplicationContext(),"Saved into Shared Preference!",Toast.LENGTH_SHORT).show();
    }

    public void retrieve(View view) {
        String showMessage=sharedPreferences.getString("Message","No data found!");
        showText.setText(showMessage);
        Toast.makeText(getApplicationContext(),"Retrieved Shared Preference!",Toast.LENGTH_SHORT).show();
    }
}

package com.androiddev.dmitr.dmytroweusthemdevtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class NewMessage extends AppCompatActivity {
    Toolbar toolbar;
    EditText to_editText;
    Intent intent = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.new_message);
        to_editText = findViewById(R.id.to_editText);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
//            case R.id.addItem:
//                Toast.makeText(this, "New message clicked", Toast.LENGTH_SHORT).show();
//                intent = new Intent(this, NewMessage.class);
//                startActivity(intent);
//                break;
//            case R.id.search:
//                Toast.makeText(this, "Search clicked ", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.inbox:
                Toast.makeText(this, "Search clicked ", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.sent:
                Toast.makeText(this, "Sent clicked ", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, SentActivity.class);
                startActivity(intent);
                break;
            case R.id.archive:
                Toast.makeText(this, "Archive clicked ", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, ArchiveActivity.class);
                startActivity(intent);
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnSendNewMsgclicked(View view) {
        String email = to_editText.getText().toString();
        if (isValidEmail(email)) {

            // send data to database section must be here

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Button send clicked", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show();
        }
    }



    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}

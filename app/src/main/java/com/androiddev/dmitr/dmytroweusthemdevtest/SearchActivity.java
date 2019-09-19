package com.androiddev.dmitr.dmytroweusthemdevtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText searchText_editText;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.search);
        searchText_editText = findViewById(R.id.search_editText);
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

    public void btnSearchclicked(View view) {
        String searchText = searchText_editText.getText().toString();
        if (!searchText.isEmpty()) {

            // send data to database section must be here

            Toast.makeText(this, "Button search clicked", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Enter some text to search", Toast.LENGTH_SHORT).show();
        }
    }

}

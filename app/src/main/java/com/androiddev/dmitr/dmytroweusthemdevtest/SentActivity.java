package com.androiddev.dmitr.dmytroweusthemdevtest;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SentActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> listViewData;
    ArrayAdapter<String> arrayAdapter;
    Toolbar toolbar;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent);
        listView = findViewById(R.id.listviewSent);
        loadSentMailList();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.sent);

    }

    private void loadSentMailList() {

        // load data from database section must be here

        listViewData = new ArrayList<String>();
        listViewData.add("Sent_Item1");
        listViewData.add("Sent_Item2");
        listViewData.add("Sent_Item3");
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listViewData){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                TextView item = (TextView) super.getView(position,convertView,parent);
                //item.setTextColor(Color.parseColor("black"));
                item.setTypeface(item.getTypeface(), Typeface.NORMAL);
                item.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
                return item;
            }
        };
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addItem:
                Toast.makeText(this, "New message clicked", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, NewMessage.class);
                startActivity(intent);
                break;
            case R.id.inbox:
                Toast.makeText(this, "Search clicked ", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.search:
                Toast.makeText(this, "Search clicked ", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, SearchActivity.class);
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

    // Context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose action");
        getMenuInflater().inflate(R.menu.operations_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String mailItem = listViewData.get(info.position);

        switch (item.getItemId()){
            case R.id.itemArchive:
                Toast.makeText(this,"Archived: "+ mailItem,Toast.LENGTH_SHORT).show();
                return true;

            case R.id.itemDelete:
                Toast.makeText(this,"Deleted: "+ mailItem,Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }


    }
}

package net.apkkothon.localdb6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        listView=(ListView)findViewById(R.id.listView);

        listView.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.lview,R.id.textView,new MyDBFunctions(ShowActivity.this).my_data()));



    }
}

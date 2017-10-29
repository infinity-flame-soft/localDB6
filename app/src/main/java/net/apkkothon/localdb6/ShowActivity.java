package net.apkkothon.localdb6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        listView=(ListView)findViewById(R.id.listView);

        listView.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.lview,R.id.textView,new MyDBFunctions(ShowActivity.this).my_data()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(ShowActivity.this,UpdateActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);

            }
        });

    }
}

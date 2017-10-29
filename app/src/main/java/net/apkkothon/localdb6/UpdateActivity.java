package net.apkkothon.localdb6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText editText;
    Button btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editText=(EditText)findViewById(R.id.editText);
        btnUpdate=(Button)findViewById(R.id.btn_update);
        btnDelete=(Button)findViewById(R.id.btn_delete);

        final int position=getIntent().getIntExtra("position",0);

        editText.setText(new MyDBFunctions(UpdateActivity.this).fetch_name(position+1));


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyDBFunctions(UpdateActivity.this).name_update(position+1,editText.getText().toString());
                Toast.makeText(UpdateActivity.this,"update successfully",Toast.LENGTH_SHORT).show();
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyDBFunctions(UpdateActivity.this).delete(position+1);
                Toast.makeText(UpdateActivity.this,"delete successfully",Toast.LENGTH_SHORT).show();

            }
        });

    }
}

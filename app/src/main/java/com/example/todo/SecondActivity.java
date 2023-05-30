package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {

    private EditText  editText1;
    private EditText  editText2;
    private Button btn ;
    private RespositorioOficio repo;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        editText1 = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonName2);
        btn = findViewById(R.id.btnback2);
        spinner = findViewById(R.id.spinner);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = editText2.getText().toString();


                int aux2  = Integer.parseInt(aux);
                Intent i = new Intent(SecondActivity.this,MainActivity.class);
                Oficio oficio = new Oficio(editText1.getText().toString(),aux2);
                i.putExtra("uno",oficio);
                setResult(RESULT_OK,i);
                finish();;


            }
        });



        Bundle bundle = getIntent().getExtras();
        repo = (RespositorioOficio) bundle.getSerializable("espin");

        ArrayAdapter<Oficio> adap = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,repo.getAll());


        spinner.setAdapter(adap);



    }

}

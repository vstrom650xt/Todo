package com.example.todo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcv);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        MyAdapter adapter = new MyAdapter(this);

        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));


        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
            Intent i  = result.getData();
            Bundle bundle = i.getExtras();
            RespositorioOficio.getInstance().addOficio((Oficio) bundle.getSerializable("uno"));

            System.out.println( RespositorioOficio.getInstance().getAll());
            adapter.notifyDataSetChanged();

        });



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                RespositorioOficio repo2 = new RespositorioOficio();
                repo2 = RespositorioOficio.getInstance();

                i.putExtra("espin",  repo2);
                activityResultLauncher.launch(i);

            }
        });




    }
}
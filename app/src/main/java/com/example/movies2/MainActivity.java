package com.example.movies2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //app components
    ArrayList<Movie> movies = new ArrayList<>();
    TextView viewTitle;
    private final String JSON_FILE = "movies.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewTitle = findViewById(R.id.textView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //read and parseOnlyAllDetails json file
        String json = JSONUtility.readJSONFromAssets(this, JSON_FILE);
        movies = JSONUtility.parseWithMissingDetails(json);


        //turn it into displayable list through the CustomAdapter
        CustomAdapter adapter = new CustomAdapter(this, movies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
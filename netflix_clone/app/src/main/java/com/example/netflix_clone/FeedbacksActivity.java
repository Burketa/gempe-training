package com.example.netflix_clone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class FeedbacksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Feedback> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbacks);

        this.createFeedbacklist();

        //Referencias
        recyclerView = findViewById(R.id.recycler_view);

        //Adapter
        AdapterFeedbacks adapter = new AdapterFeedbacks(list);

        //Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void createFeedbacklist() {
        list = new ArrayList<>();
        list.add(new Feedback("GOSTEI", "Upper", false));
        list.add(new Feedback("nao gostei", "Lower", true));
        list.add(new Feedback("testes1", "Lower", false));
        list.add(new Feedback("Feedback", "Lower", true));
        list.add(new Feedback("ENGRAÇADO !", "Upper", false));
    }
}

package com.example.netflix_clone.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.netflix_clone.R;
import com.example.netflix_clone.adapters.AdapterFeedbacks;
import com.example.netflix_clone.model.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbacksRecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbacks_recycle);

        //Inicializa a lista
        List<Feedback> list = new ArrayList<>();

        //Pega o bundle da Main Activity
        Bundle bundle = getIntent().getExtras();
        list = (List<Feedback>) bundle.getSerializable("list");

        //Se n;ao tiver nenhum item, gera uma lista generica
        if(list.size() == 0) {
            list = createFeedbacklist(list);
        }

        //Referencias
        RecyclerView recyclerView;
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

    public List<Feedback> createFeedbacklist(List<Feedback> list) {

        list.add(new Feedback("GOSTEI", "Upper", false));
        list.add(new Feedback("nao gostei", "Lower", true));
        list.add(new Feedback("testes1", "Lower", false));
        list.add(new Feedback("Feedback", "Lower", true));
        list.add(new Feedback("ENGRAÇADO !", "Upper", false));

        return list;
    }
}

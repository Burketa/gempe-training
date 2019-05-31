package com.example.netflix_clone.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.netflix_clone.R;
import com.example.netflix_clone.adapters.AdapterFeedbacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class APIActivity extends AppCompatActivity {

    private StringBuffer api_raw_result;

    private List<AdapterFeedbacks> api_result;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        api_result = new ArrayList<>();
        api_raw_result = new StringBuffer();

        //Referencias
        recyclerView = findViewById(R.id.recycler_view);

        //Task
        startTask();
    }

    public void startTask() {
        //Cria um objeto da task para fazer as tearefas assincronas
        GetCurrencyTask task = new GetCurrencyTask();

        //Seta a url da api
        String url_api = "https://blockchain.info/ticker";

        //Executa a tarefa assincrona
        task.execute(url_api);
    }

    class GetCurrencyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String string = strings[0];
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            InputStreamReader streamReader = null;
            BufferedReader bufferedReader = null;

            try {
                //Seta a url
                URL url = new URL(string);

                //Faz a conexao
                connection = (HttpURLConnection) url.openConnection();

                //Poe a resposta em bytes no input stream
                inputStream = connection.getInputStream();

                //Faz a leitura dos bytes para caracteres
                streamReader = new InputStreamReader(inputStream);

                //Transforma em string
                bufferedReader = new BufferedReader(streamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    api_raw_result.append(line);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return api_raw_result.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(APIActivity.this, result, Toast.LENGTH_SHORT).show();
            /*
            //Adapter
            AdapterFeedbacks adapter = new AdapterFeedbacks(list);

            //Layout Manager
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
            recyclerView.setAdapter(adapter);
        }*/
        }
    }
}

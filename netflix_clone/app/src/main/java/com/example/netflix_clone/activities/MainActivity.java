package com.example.netflix_clone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.netflix_clone.R;
import com.example.netflix_clone.model.Feedback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tv_feedback;
    private CheckBox cb_toast;
    private RadioGroup radio_group;

    private List<Feedback> feedbacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(getBaseContext(), RetrofitActivity.class);
        Intent intent = new Intent(getBaseContext(), WhatsappActivity.class);
        startActivity(intent);

        feedbacks = new ArrayList<>();

        //Referencias
        tv_feedback = findViewById(R.id.tv_feedback);
        cb_toast = findViewById(R.id.cb_toast);
        radio_group = findViewById(R.id.rg_case);

    }

    /*  Ao clicar no botao:
        - Checa qual botao do radio group esta ativo
        - Checa se o checkbox para exibir toast esta ativo ou nao
        - Adiciona o feedback na lista
    */
    public void buttonSend(View view) {
        String user_feedback = tv_feedback.getText().toString();

        Feedback current_feedback = new Feedback();

        switch(radio_group.getCheckedRadioButtonId())
        {
            case R.id.rb_upper:
                current_feedback.setFeedback(user_feedback.toUpperCase());
                current_feedback.setString_case("UPPER");
                break;
            default:
            case R.id.rb_lower:
                current_feedback.setFeedback(user_feedback.toLowerCase());
                current_feedback.setString_case("lower");
                break;
        }

        if (isToastChecked(current_feedback)) {
            Toast.makeText(getApplicationContext(), current_feedback.getFeedback(), Toast.LENGTH_SHORT).show();
        }

        feedbacks.add(current_feedback);
    }

    //Checa se o checkbox para exibir toast esta ativo ou nao
    public boolean isToastChecked(Feedback feedback) {
        boolean isChecked = cb_toast.isChecked();

        feedback.setToast_checked(isChecked);

        return isChecked;
    }

    //Passa os dados para as novas activities
    public void loadFeedbacksRecycleActivity(View view) {
        Intent intent = new Intent(getBaseContext(), FeedbacksRecyclerViewActivity.class);
        intent.putExtra("list", (Serializable) feedbacks);
        startActivity(intent);
    }

    public void loadAPIActivity(View view) {
        Intent intent = new Intent(getBaseContext(), APIActivity.class);
        startActivity(intent);
    }
}

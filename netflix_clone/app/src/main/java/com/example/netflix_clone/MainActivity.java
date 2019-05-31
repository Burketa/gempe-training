package com.example.netflix_clone;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tv_feedback;
    private CheckBox cb_toast;
    private RadioGroup radio_group;

    private List<Feedback> feedbacks;

    private Feedback current_feedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feedbacks = new ArrayList<>();
        current_feedback = new Feedback();

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
        current_feedback.reset();

        String user_feedback = tv_feedback.getText().toString();

        current_feedback.setFeedback(user_feedback);
        checkRadioGroupSelected();

        switch(current_feedback.getString_case())
        {
            case "Upper":
                current_feedback.setFeedback(user_feedback.toUpperCase());
                break;
            case "Lower":
                current_feedback.setFeedback(user_feedback.toLowerCase());
                break;
        }

        if (isToastChecked(current_feedback)) {
            Toast.makeText(getApplicationContext(), current_feedback.getFeedback(), Toast.LENGTH_SHORT).show();
        }

        feedbacks.add(current_feedback);
    }

    //Checa qual botao do radio group esta ativo
    public void checkRadioGroupSelected() {
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_upper:
                        current_feedback.setString_case("Upper");
                        break;
                    case R.id.rb_lower:
                        current_feedback.setString_case("Lower");
                        break;
                }
            }
        });
    }

    //Checa se o checkbox para exibir toast esta ativo ou nao
    public boolean isToastChecked(Feedback feedback) {
        boolean isChecked = cb_toast.isChecked();

        feedback.setToast_checked(isChecked);

        return isChecked;
    }

    //Passa os dados para a nova activity
    public void loadFeedbacksActivity(View view) {
        Intent i = new Intent(getBaseContext(), FeedbacksActivity.class);
        //i.putExtra("PersonID", personID);
        startActivity(i);
    }
}

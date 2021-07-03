package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "Under our Constitution, some powers belong to the states. What is one power of the states?",
                            "If both the President and the Vice President can no longer serve, who becomes President?",
                            "Who vetoes bills?",
                            "What does the President’s Cabinet do?",
                            "Why do some states have more Representatives than other states?",
                            "What is an amendment?",
                            "The beginning of the Declaration of Independence?",
                            "What is the capital of the United States?",
                            "What are two Cabinet-level positions?",
                            "What is the economic system in the United States?",
                            "How many US senators does Utah have?"
                         };
    String answers[] = {"Provide schooling and education","The President","Speaker of the House","The President","Advises the President","Because of the state's population","An addition (to the Constitution)","Washington, DC","Secretary of Defense and Secretary of State","Capitalist economy","2"};
    String opt[] = {
                    "Make treaties","Provide schooling and education","Create an army","Coin or print money",
                    "The President","The Vice-President","The Secretary of Defense","The Attorney General",
                    "President of the State","Speaker of the House","Governor of the most populous state","Chief Justice of the Supreme Court",
                    "The President","The Vice President","The Senate","The House of Representatives",
                    "Advises the President","Selects the Vice President","Runs the government when the President travels","Negotiates treaties with foreign nations",
                    "Because the state's Representatives have seniority in the House of Representatives","Because of the state's population","Because of the geographical size of the state","Because of the state's location",
                    "An addition (to the Constitution)","The Preamble to the Constitution","An introduction","The beginning of the Declaration of Independence",
                    "St. Louis, MO","Olympia, WA","New York, NY","Washington, DC",
                    "Secretary of Defense and Secretary of State","Governor of New York and Governor of California","First Lady and White House Spokesperson","President of the Senate and Speaker of the House",
                    "Communist economy","Capitalist economy","Socialist economy","None of these answers",
                    "1","2","3","4",

                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
        textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}
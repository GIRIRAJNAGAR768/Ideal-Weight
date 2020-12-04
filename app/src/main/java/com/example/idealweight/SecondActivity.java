package com.example.idealweight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton maleRadioButton,femaleRadioButton,selectedGender;
    EditText input_height,input_weight;
    Button btn_result;
    TextView result_text;
    String gender = null;
    int height,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        radioGroup=findViewById(R.id.radioGroup);
        maleRadioButton=findViewById(R.id.maleRadioButton);
        femaleRadioButton=findViewById(R.id.femaleRadioButton);

        input_height=findViewById(R.id.input_height);
        input_weight=findViewById(R.id.input_weight);

        btn_result=findViewById(R.id.btn_result);
        result_text=findViewById(R.id.result_text);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedGender = (RadioButton) findViewById(checkedId);
                if(checkedId==-1){
                    Toast.makeText(SecondActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    gender = selectedGender.getText().toString();
                    Toast.makeText(SecondActivity.this,selectedGender.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String heightStr = input_height.getText().toString();
               String weightStr = input_weight.getText().toString();

               if(gender==null)
               {
                   Toast.makeText(SecondActivity.this,"Select Gender", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   if(heightStr.length()==0 || weightStr.length()==0)
                   {
                       Toast.makeText(SecondActivity.this,"Enter valid height or weight", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       height = Integer.parseInt(heightStr);
                       weight = Integer.parseInt(weightStr);
                       int idealWeight;

                       if(gender.equals("Male"))
                       {
                           idealWeight = height-100;
                       }
                       else
                       {
                           idealWeight = height-110;
                       }

                       if(idealWeight==weight)
                           result_text.setText("normal");
                       else if(idealWeight>weight)
                            result_text.setText("OverWeight");
                       else
                           result_text.setText("UnderWeight");

                       result_text.setVisibility(View.VISIBLE);

                   }
               }
            }
        });

    }
}
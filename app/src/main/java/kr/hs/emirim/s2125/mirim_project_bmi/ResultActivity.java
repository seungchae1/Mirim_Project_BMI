package kr.hs.emirim.s2125.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textName = findViewById(R.id.text_name);
        TextView textBMi = findViewById(R.id.text_bmi);
        TextView textWeight = findViewById(R.id.text_weight);
        ImageView imgV = findViewById(R.id.bmi_img);

        Intent  intent= getIntent();
        String name =intent.getStringExtra("name");
        double weight = Integer.parseInt(intent.getStringExtra("weight"));
        double tall = Integer.parseInt(intent.getStringExtra("tall"));

        double Bmi= weight / Math.pow(tall/100, 2);
        String wResult="";

        if(Bmi>35){
            wResult="고도비만";
            imgV.setImageResource(R.drawable.bmi5);
        }
        else if(Bmi>30) {
            wResult="비만";
            imgV.setImageResource(R.drawable.bmi4);
        }
        else if(Bmi>25) {
            wResult="과체중";
            imgV.setImageResource(R.drawable.bmi3);
        }
        else if(Bmi>18.5){
            wResult="표준체중";
            imgV.setImageResource(R.drawable.bmi2);
        }
        else {
            wResult="저체중";
            imgV.setImageResource(R.drawable.bmi1);
        }

        textName.setText(name+"님의 BMI지수는 ");
        textBMi.setText(String.format("%.2f",Bmi)+"입니다");
        textWeight.setText(wResult);

        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
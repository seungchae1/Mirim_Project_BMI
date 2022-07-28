package kr.hs.emirim.s2125.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Editname, Editweight, Edittall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnResult= findViewById(R.id.btn_result);
        Editname= findViewById(R.id.edit_name);
        Editweight= findViewById(R.id.edit_weight);
        Edittall= findViewById(R.id.edit_tall);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("name",Editname.getText().toString());
                intent.putExtra("weight",Editweight.getText().toString());
                intent.putExtra("tall",Edittall.getText().toString());
                startActivity(intent);
            }
        });
    }
}
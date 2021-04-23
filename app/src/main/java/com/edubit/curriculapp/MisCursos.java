package com.edubit.curriculapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MisCursos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_cursos);
    }

    /*
    txt = (TextView)findViewById(R.id.txt);
SpannableString content = new SpannableString(txt.getText());
content.setSpan(new UnderlineSpan(), 0, txt.length(), 0);
txt.setText(content);
txt.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent i = new Intent(Intent.ACTION_VIEW);
i.setData(Uri.parse("http://www.bedelias.edu.uy"));
startActivity(i);
}
});
    */

}
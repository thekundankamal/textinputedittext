package com.thekundankamal.textinputedittext;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.thekundankamal.textinputlibrary.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText edInputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        edInputText=findViewById(R.id.input_data);
        //edInputText.setTitleText("Header");
        //edInputText.setText("Welcome ");
    }
}

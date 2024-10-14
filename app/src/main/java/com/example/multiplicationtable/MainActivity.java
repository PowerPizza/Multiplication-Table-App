package com.example.multiplicationtable;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText num1_entry;
    TextView output_area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1_entry = findViewById(R.id.number_entry);
        output_area = findViewById(R.id.output);

        num1_entry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                int number_;
                try {
                    number_ = Integer.parseInt(editable.toString());
                }
                catch (Exception e){
                    output_area.setText(R.string.output_default_text);
                    return;
                }
                String table_str = "";
                for (int i = 0; i < 10; i++){
                    table_str = table_str.concat(String.format(Locale.ENGLISH, "%d x %d = %d\n", number_, i+1, number_*(i+1)));
                }
                output_area.setText(table_str);
            }
        });
    }
}
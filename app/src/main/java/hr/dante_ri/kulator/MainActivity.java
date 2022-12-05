package hr.dante_ri.kulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String number = button.getText().toString();
                TextView textView = (TextView) findViewById(R.id.txtResult);
                String currentText = textView.getText().toString();
                currentText = currentText + number;
                textView.setText(currentText);
            }
        };

        int buttons[] = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        for(int i = 0; i < buttons.length; i++) {
            Button b = findViewById(buttons[i]);
            b.setOnClickListener(onClickListener);
        }

    }
}
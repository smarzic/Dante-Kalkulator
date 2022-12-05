package hr.dante_ri.kulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int br1;
    String operator;

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

        View.OnClickListener opOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pročitati što je kliknuto
                Button button = (Button) view;
                operator = button.getText().toString();
                // pročitati upisani broj, spremiti ga i isprazniti polje
                TextView textView = findViewById(R.id.txtResult);
                String currNumber = textView.getText().toString();
                br1 = Integer.parseInt(currNumber);
                textView.setText("");
            }
        };
        int buttonsOp[] = {R.id.btnDivide, R.id.btnMinus, R.id.btnMultiply, R.id.btnPlus};
        for(int i=0; i < buttonsOp.length; i++) {
            Button b = findViewById(buttonsOp[i]);
            b.setOnClickListener(opOnClickListener);
        }

        Button btnEquals = findViewById(R.id.btnEqual);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pročitati drugi broj
                TextView textView = findViewById(R.id.txtResult);
                String currText = textView.getText().toString();
                int br2 = Integer.parseInt(currText);
                // izračunati
                int result = 0;
                if(operator.equals("+")) {
                    result = br1 + br2;
                } else if(operator.equals("-")) {
                    result = br1 - br2;
                } else if(operator.equals("*")) {
                    result = br1 * br2;
                } else if(operator.equals("/")) {
                    result = br1 / br2;
                }
                textView.setText(result + "");
            }
        });

    }
}
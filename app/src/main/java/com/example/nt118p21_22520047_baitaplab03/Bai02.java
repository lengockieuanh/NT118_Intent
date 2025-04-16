package com.example.nt118p21_22520047_baitaplab03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import net.sourceforge.jeval.Evaluator;

public class Bai02 extends AppCompatActivity {
    private TextView txtExpression, txtResult;
    private StringBuilder expression = new StringBuilder();
    private Evaluator evaluator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai02);

        txtExpression = findViewById(R.id.txtExpression);
        txtResult = findViewById(R.id.txtResult);
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        evaluator = new Evaluator();

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View v = gridLayout.getChildAt(i);
            if (v instanceof Button) {
                Button btn = (Button) v;
                btn.setOnClickListener(view -> onButtonClick(btn.getText().toString()));
            }
        }
    }

    private void onButtonClick(String value) {
        switch (value) {
            case "AC":
                expression.setLength(0);
                txtResult.setText("0");
                break;
            case "del":
                if (expression.length() > 0) {
                    expression.deleteCharAt(expression.length() - 1);
                }
                break;
            case "=":
                evaluateExpression();
                return;
            case "±":
                toggleSign();
                return;
            default:
                expression.append(mapInput(value));
        }
        txtExpression.setText(expression.toString());
    }

    private String mapInput(String value) {
        switch (value) {
            case "÷": return "/";
            case "×": return "*";
            case "−": return "-";
            case ",": return ".";
            default: return value;
        }
    }

    private void toggleSign() {
        if (expression.length() > 0 && Character.isDigit(expression.charAt(expression.length() - 1))) {
            try {
                double currentVal = Double.parseDouble(expression.toString());
                currentVal *= -1;
                expression = new StringBuilder(String.valueOf(currentVal));
                txtExpression.setText(expression.toString());
            } catch (Exception e) {}
        }
    }

    private void evaluateExpression() {
        try {
            String result = evaluator.evaluate(expression.toString());
            txtResult.setText(result.replace('.', ','));
        } catch (Exception e) {
            txtResult.setText("Lỗi");
        }
    }
}




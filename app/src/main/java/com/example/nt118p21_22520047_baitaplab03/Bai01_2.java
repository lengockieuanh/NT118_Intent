package com.example.nt118p21_22520047_baitaplab03;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bai01_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai012);

        // Lấy Bundle từ Intent
        Bundle bundle = getIntent().getExtras();

        String hoTen = "", cmnd = "", bangCap = "", soThich = "", extra = "";

        // Lấy dữ liệu từ Bundle
        if (bundle != null) {
            hoTen = bundle.getString("HOTEN", "");
            cmnd = bundle.getString("CMND", "");
            bangCap = bundle.getString("BANGCAP", "");
            soThich = bundle.getString("SOTHICH", "");
            extra = bundle.getString("EXTRA", "");
        }

        TextView tvInfo = findViewById(R.id.txtInfo);
        StringBuilder message = new StringBuilder();
        message.append("Họ tên: ").append(hoTen).append("\n")
                .append("CMND: ").append(cmnd).append("\n")
                .append("Bằng cấp: ").append(bangCap).append("\n")
                .append("Sở thích: ").append(soThich).append("\n")
                .append("--------------------------\n")
                .append("Thông tin bổ sung:\n")
                .append(extra);
        tvInfo.setText(message.toString());

        findViewById(R.id.btnClose).setOnClickListener(v -> finish());
    }
}


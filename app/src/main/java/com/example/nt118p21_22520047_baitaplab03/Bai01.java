package com.example.nt118p21_22520047_baitaplab03;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bai01 extends AppCompatActivity {

    EditText edtName, edtCmnd, edtExtraInfo;
    RadioGroup radioGroupDegree;
    RadioButton rbTrungCap, rbCaoDang, rbDaiHoc;
    CheckBox cbDocBao, cbDocSach, cbDocCode;
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai01);

        edtName = findViewById(R.id.edtName);
        edtCmnd = findViewById(R.id.edtCmnd);
        edtExtraInfo = findViewById(R.id.edtExtraInfo);
        radioGroupDegree = findViewById(R.id.radioGroupDegree);
        rbTrungCap = findViewById(R.id.rbTrungCap);
        rbCaoDang = findViewById(R.id.rbCaoDang);
        rbDaiHoc = findViewById(R.id.rbDaiHoc);
        cbDocBao = findViewById(R.id.cbDocBao);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbDocCode = findViewById(R.id.cbDocCode);
        btnGui = findViewById(R.id.btnGui);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtName.getText().toString().trim();
                String cmnd = edtCmnd.getText().toString().trim();
                String extra = edtExtraInfo.getText().toString();

                if (hoTen.length() < 3) {
                    Toast.makeText(Bai01.this, "Tên người dùng phải có ít nhất 3 ký tự", Toast.LENGTH_SHORT).show();
                    return;}

                if (!cmnd.matches("\\d{9}")) {
                    Toast.makeText(Bai01.this, "CMND phải gồm đúng 9 chữ số", Toast.LENGTH_SHORT).show();
                    return;}

                if (!cbDocBao.isChecked() && !cbDocSach.isChecked() && !cbDocCode.isChecked()) {
                    Toast.makeText(Bai01.this, "Chọn ít nhất một sở thích", Toast.LENGTH_SHORT).show();
                    return;}

                String bangCap = "";
                if (rbTrungCap.isChecked()) bangCap = "Trung cấp";
                else if (rbCaoDang.isChecked()) bangCap = "Cao đẳng";
                else bangCap = "Đại học";

                String soThich = "";
                if (cbDocBao.isChecked()) soThich += "Đọc báo - ";
                if (cbDocSach.isChecked()) soThich += "Đọc sách - ";
                if (cbDocCode.isChecked()) soThich += "Đọc coding - ";
                if (!soThich.isEmpty()) soThich = soThich.substring(0, soThich.length() - 3);

                // Tạo intent để gọi Activity 2 (Bai01_2)
                Intent intent = new Intent(Bai01.this, Bai01_2.class);

                // Tạo Bundle để truyền dữ liệu
                Bundle bundle = new Bundle();

                // Thêm <key, value> vào bundle
                bundle.putString("HOTEN", hoTen);
                bundle.putString("CMND", cmnd);
                bundle.putString("BANGCAP", bangCap);
                bundle.putString("SOTHICH", soThich);
                bundle.putString("EXTRA", extra);

                // Đưa Bundle vào intent
                intent.putExtras(bundle);
                // Gọi Activity 2 (Bai01_2)
                startActivity(intent);
            }
        });
    }
}

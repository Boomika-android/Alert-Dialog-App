package com.example.alertdialogapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_show_alertDialog;
    Button btn_yes, btn_no;

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

        btn_show_alertDialog = findViewById(R.id.txt_btn);
        Dialog dialog = new Dialog(MainActivity.this);

        btn_show_alertDialog.setOnClickListener(v -> {
                dialog.setContentView(R.layout.dialog_layout);
                dialog.setCancelable(true);
                dialog.show();
                btn_no = dialog.findViewById(R.id.btn_no);
                btn_yes = dialog.findViewById(R.id.btn_yes);

                btn_yes.setOnClickListener( v1 -> Toast.makeText(MainActivity.this, "Yes is Clicked", Toast.LENGTH_SHORT).show());

                btn_no.setOnClickListener( v2 -> Toast.makeText(MainActivity.this, "No is Clicked", Toast.LENGTH_SHORT).show());
        });
    }
}
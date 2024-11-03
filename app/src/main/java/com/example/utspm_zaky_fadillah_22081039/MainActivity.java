package com.example.utspm_zaky_fadillah_22081039;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextnomor;
    private EditText editTextalamat;
    private RadioButton radio1, radio2;
    private CheckBox checkBox;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        editTextName = findViewById(R.id.editTextName);
        editTextnomor = findViewById(R.id.editTextnomor);
        editTextalamat = findViewById(R.id.editTextalamat);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        checkBox = findViewById(R.id.checkBox1);
        checkBox = findViewById(R.id.checkBox2);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set listener untuk tombol submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        // Ambil data dari input pengguna
        String name = editTextName.getText().toString();
        String keterangan = radio1.isChecked() ? "cukup mampu" : "tidak mampu";
        String gaji = checkBox.isChecked() ? "0-1.000.000" : "1.000.000-2.000.000";

        // Buat dialog untuk menampilkan informasi
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Informasi Pengguna");
        builder.setMessage("Nama: " + name + "\nketerangan: " + keterangan + "\ngaji: " + gaji);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Data Terkirim", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Menutup dialog
            }
        });

        // Tampilkan dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
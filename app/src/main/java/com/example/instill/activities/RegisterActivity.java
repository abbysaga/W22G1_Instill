package com.example.instill.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.instill.R;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private SwitchCompat genderSwitch;
    private EditText regName, regEmail, regPhone, regBday, regPassword, regConfPwd;
    private Button registerBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        genderSwitch = findViewById(R.id.genderSwitch);
        regName = findViewById(R.id.newNameInput);
        regEmail = findViewById(R.id.newEmailInput);
        regPhone = findViewById(R.id.newPhoneInput);
        regBday = findViewById(R.id.newBdayInput);
        regPassword = findViewById(R.id.newPwdInput);
        regConfPwd = findViewById(R.id.newConfirmPwdInput);


    }
}
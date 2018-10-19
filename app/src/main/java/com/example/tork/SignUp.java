package com.example.tork;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import static com.basgeekball.awesomevalidation.ValidationStyle.UNDERLABEL;

public class SignUp extends AppCompatActivity {

    private Button button2, sign_up_btn;
    private TextInputEditText textInputName;
    private TextInputEditText textInputMail;
    private TextInputEditText textInputNumber;
    private TextInputEditText textInputPassword;
    private TextInputEditText textInputConpassword;
    private  String passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        textInputName =  findViewById(R.id.text_input_name);
        textInputMail =  findViewById(R.id.text_input_mail);
        textInputNumber = findViewById(R.id.text_input_number);
        textInputPassword = findViewById(R.id.text_input_password);
        textInputConpassword =  findViewById(R.id.text_input_conpassword);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

    }

    private boolean validateName() {
        String nameInput = textInputName.getText().toString().trim();

        if (nameInput.isEmpty()) {
            textInputName.setError("Enter your full name");
            return false;
        } else {
            textInputName.setError(null);
            return true;
        }
    }

    private boolean validateMail() {
        String mailInput = textInputMail.getText().toString().trim();

        if (mailInput.isEmpty()) {
            textInputMail.setError("Enter valid email address");
            return false;
        } else {
            textInputMail.setError(null);
            return true;
        }
    }

    private boolean validateNumber() {
        String numberInput = textInputNumber.getText().toString().trim();

        if (numberInput.isEmpty()) {
            textInputNumber.setError("Enter phone number");
            return false;
        } else {
            textInputNumber.setError(null);
            return true;
        }

    }


    private boolean validatePassword() {
         passwordInput = textInputPassword.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Confirm Password");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }


    private boolean validateConfirmPassword() {
        String confirmPasswordInput = textInputConpassword.getText().toString().trim();

        if (confirmPasswordInput.isEmpty()){
            textInputConpassword.setError("Please fill both Passwords");
            return false;
        }else if (!confirmPasswordInput.isEmpty()){
            textInputConpassword.setError(null);
            return true;
        }

        if (confirmPasswordInput != passwordInput){
            textInputConpassword.setError("Passwords do not match!");
            return false;
        }else {
            textInputConpassword.setError(null);
            return true;
        }
    }
//
    public void confirmInput(View v) {

        if (!validateName() | !validateMail() | !validateNumber() | !validatePassword() | !validateConfirmPassword()){
            return;

        }

    }

}

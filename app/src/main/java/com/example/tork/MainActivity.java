package com.example.tork;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText edPassword;
    CheckBox myBox;
    private Button signInBtn,signUpBtn1;
    private TextView forgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPassword = findViewById(R.id.edPassword);
        myBox = findViewById(R.id.myBox);
        signInBtn = findViewById(R.id.signInbtn);
        signInBtn.setOnClickListener(this);
        signUpBtn1 = findViewById(R.id.signUpBtn1);
        signUpBtn1.setOnClickListener(this);
        forgotPass = findViewById(R.id.forgotPass);
        forgotPass.setOnClickListener(this);
        myBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else{
                    edPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
       // Intent intent = new Intent();
        switch (v.getId()){
            case R.id.forgotPass:
                openWebPage( "https://kolopay.com/forgot-password");
                break;
            case R.id.signUpBtn1:
                Intent intent = new Intent(this, SignUp.class);
                startActivity(intent);
                break;


                default:
                    break;
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else{
            //Page not found
        }
    }
}

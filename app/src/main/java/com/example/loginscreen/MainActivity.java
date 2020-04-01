package com.example.loginscreen;
//Project 1 Login Screen,---AmelioMarku,Izmir Beqiri, Nehat Vataksi, Mensur Pervizi. Informatike Viti2, 30/03/2020.
//Ky projekt konsiston ne krijimin e nje Login Screen. Eshte bere krijimi i layout i faqes login dhe me pas eshte shkruar kodi qe ben te mundur te jepen te dhenat e sakta.
//per te bere login, gjithashtu ka disa attempts dhe nje counter neqoftese inputet jane te gabuara. pasi nje logimi te sukseshem shohim nje mesash pershendetes Welcome Back ^_^
//username: Admin     Password:Admin1
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etusername);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Info.setText("Number of attempts remaining: 3");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    validate(username.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate(String userusername, String userPassword){
        if ((userusername.equals ("Admin")) && (userPassword.equals ("Admin1"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("Number of attempts remaining : "+ String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }

        }
    }
}

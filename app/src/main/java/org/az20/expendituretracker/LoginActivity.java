package org.az20.expendituretracker;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.az20.expendituretracker.database.User;
import org.az20.expendituretracker.database.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameText, passwordText;
    private String userName, userPassword;
    public UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        usernameText = findViewById(R.id.usr_input);
        passwordText = findViewById(R.id.pass_input);
        TextView register = findViewById(R.id.textView);
        Button loginBtn = findViewById(R.id.btnlogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = usernameText.getText().toString().trim();
                userPassword = passwordText.getText().toString().trim();


                if (userPassword.isEmpty() || userName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter username and password",
                            Toast.LENGTH_SHORT).show();
                }else{

                    userRepository = new UserRepository(getApplication());
                    User user = userRepository.findUser(userName, userPassword);
                    if(user != null && user.getUsername().equalsIgnoreCase(userName)){
                        Toast.makeText(LoginActivity.this, "Successful login",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else{
                        Toast.makeText(LoginActivity.this, "Incorrect login credentials",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

}



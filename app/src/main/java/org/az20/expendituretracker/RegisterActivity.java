package org.az20.expendituretracker;


import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.az20.expendituretracker.database.User;
import org.az20.expendituretracker.database.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameText, passwordText, emailText, fullnameText;
    private String userName, userEmail, userPassword, userFullName;
    public UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        fullnameText = findViewById(R.id.usr_fname);
        usernameText = findViewById(R.id.usr_name);
        emailText = findViewById(R.id.usr_email);
        passwordText = findViewById(R.id.usr_pass);
        Button registerBtn = findViewById(R.id.btn_register);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFullName = fullnameText.getText().toString();
                userName = usernameText.getText().toString();
                userEmail = emailText.getText().toString();
                userPassword = passwordText.getText().toString();


                if (userName.isEmpty() || userFullName.isEmpty() ||
                        userEmail.isEmpty() || userPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Fill out all fields!",
                            Toast.LENGTH_LONG).show();
                }else{

                    userRepository = new UserRepository(getApplication());
                    User user = new User(userFullName, userName, userEmail, userPassword);
                    userRepository.addUser(user);
                    Toast.makeText(RegisterActivity.this,
                                "Registered Successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
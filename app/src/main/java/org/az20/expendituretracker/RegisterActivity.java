package org.az20.expendituretracker;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.az20.expendituretracker.database.User;
import org.az20.expendituretracker.helpers.PasswordHash;
import org.az20.expendituretracker.helpers.Validation;
import org.az20.expendituretracker.viewmodels.UserViewModel;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameText, passwordText, emailText, fullnameText;
    private String userName, userEmail, userPassword, userFullName;
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mUserViewModel = new UserViewModel(getApplication());

        fullnameText = findViewById(R.id.usr_fname);
        usernameText = findViewById(R.id.usr_name);
        emailText = findViewById(R.id.usr_email);
        passwordText = findViewById(R.id.usr_pass);
        Button registerBtn = findViewById(R.id.btn_register);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userFullName = fullnameText.getText().toString();
                userName = usernameText.getText().toString().toLowerCase();
                userEmail = emailText.getText().toString();
                userPassword = passwordText.getText().toString();

                if (userName.isEmpty() || userFullName.isEmpty() ||
                        userEmail.isEmpty() || userPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Fill out all fields!",
                            Toast.LENGTH_SHORT).show();
                } else {

                    if (!Validation.nameValidation(userFullName)){
                        fullnameText.setError(getString(R.string.error_name));
                        return;
                    }

                    if (!Validation.userValidation(userName)){
                        usernameText.setError(getString(R.string.error_username));
                        return;
                    }
                    if (!Validation.emailValidation((userEmail))){
                        emailText.setError(getString(R.string.error_email));
                        return;
                    }
                    if (!Validation.passwordValidation(userPassword)){
                        showAlert(getString(R.string.error_password));
                    }

                    userPassword = PasswordHash.hashPassword(userPassword);
                    User user = new User(userFullName, userName, userEmail, userPassword);
                    mUserViewModel.addUser(user);
                    Toast.makeText(RegisterActivity.this,
                            "Registered Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                }
            }
        });
    }

    protected void showAlert(String msg) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
        dialog.setMessage(msg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                });
        dialog.create().show();
    }
}
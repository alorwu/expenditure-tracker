package org.az20.expendituretracker;


import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText username, password, email, fullname;
    private String usr_name, usr_email, usr_pass, usr_fname;
    public static UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        fullname = findViewById(R.id.usr_fname);
        username = findViewById(R.id.usr_name);
        email = findViewById(R.id.usr_email);
        password = findViewById(R.id.usr_pass);
        Button btn_register = findViewById(R.id.btn_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usr_fname = fullname.getText().toString();
                usr_name = username.getText().toString();
                usr_email = email.getText().toString();
                usr_pass = password.getText().toString();

                userRepository = new UserRepository(getApplication(), usr_fname, usr_pass);

                if (usr_name.isEmpty() || usr_fname.isEmpty() ||
                        usr_email.isEmpty() || usr_pass.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Fill out all fields!",
                            Toast.LENGTH_LONG).show();
                }else{

                        User user = new User(usr_fname, usr_name, usr_email, usr_pass);
                        userRepository.addUser(user);
                        Toast.makeText(RegisterActivity.this,
                                    "Registered Successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
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

public class login_activity extends AppCompatActivity {

    private EditText username, password;
    private String usr_name, usr_pass;
    public static UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        username = findViewById(R.id.usr_input);
        password = findViewById(R.id.pass_input);
        TextView tv_register = findViewById(R.id.textView);
        Button btn_login = findViewById(R.id.btnlogin);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_activity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usr_name = username.getText().toString().trim();
                usr_pass = password.getText().toString().trim();

                userRepository = new UserRepository(getApplication(), usr_name, usr_pass);

                if (usr_pass.isEmpty() || usr_name.isEmpty()) {
                    Toast.makeText(login_activity.this, "Enter username and password",
                            Toast.LENGTH_SHORT).show();
                }else{

                    int count = userRepository.findUser(usr_name, usr_pass);
                    if(count > 0){
                        Toast.makeText(login_activity.this, "Successful login",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(login_activity.this, "Incorrect login credentials",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

}



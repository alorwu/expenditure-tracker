package org.az20.expendituretracker;


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
    private TextView tv_register;
    private Button btn_login;
    private String usr_name, usr_pass;
    ConnectionDetector connectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        username = findViewById(R.id.usr_input);
        password = findViewById(R.id.pass_input);
        tv_register = findViewById(R.id.textView);
        btn_login = findViewById(R.id.btnlogin);
        connectionDetector = new ConnectionDetector(this);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Insert Event
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usr_name = username.getText().toString().trim();
                usr_pass = password.getText().toString().trim();

                if (usr_pass.isEmpty() || usr_name.isEmpty()) {
                    Toast.makeText(login_activity.this, "Enter username and password",
                            Toast.LENGTH_SHORT).show();
                }else{

                    if (connectionDetector.isConnected()){

                        // Check If user Exist

                    }else{
                        String title = "No Internet Connection";
                        String msg = "Turn on mobile data or wifi to continue.";
                        connectionDetector.alertDialog(login_activity.this, title, msg);
                    }
                }
            }
        });
    }

}



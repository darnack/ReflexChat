package co.com.reflex.reflexchat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.com.reflex.reflexchat.util.CacheManager;

public class ConfirmActivity extends AppCompatActivity {

    private TextView txtNickName, txtAge, txtCity, txtGender;
    private Button btnConfirm, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        txtNickName = (TextView)findViewById(R.id.txtNickName);
        txtAge = (TextView)findViewById(R.id.txtAge);
        txtCity = (TextView)findViewById(R.id.txtCity);
        txtGender = (TextView)findViewById(R.id.txtGender);
        btnConfirm = (Button)findViewById(R.id.btnConfirm);
        btnExit = (Button)findViewById(R.id.btnExit);

        txtNickName.setText(CacheManager.readString(getApplicationContext(), "NickName"));
        txtAge.setText(CacheManager.readString(getApplicationContext(), "Age"));
        txtCity.setText(CacheManager.readString(getApplicationContext(), "City"));
        txtGender.setText(CacheManager.readString(getApplicationContext(), "Gender"));

        btnConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent activity = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(activity);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                 //Ask the user if they want to quit
                new AlertDialog.Builder(ConfirmActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(R.string.exit_title)
                        .setMessage(R.string.exit_confirm)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // Kill application
                                //android.os.Process.killProcess(android.os.Process.myPid());
                                finishAffinity();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton(R.string.no, null)
                        .show();
            }
        });
    }
}

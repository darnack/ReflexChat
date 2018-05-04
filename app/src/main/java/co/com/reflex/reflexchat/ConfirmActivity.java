package co.com.reflex.reflexchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.com.reflex.reflexchat.util.CacheManager;

public class ConfirmActivity extends AppCompatActivity {

    private TextView txtNickName, txtAge, txtCity, txtGender;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        txtNickName = (TextView)findViewById(R.id.txtNickName);
        txtAge = (TextView)findViewById(R.id.txtAge);
        txtCity = (TextView)findViewById(R.id.txtCity);
        txtGender = (TextView)findViewById(R.id.txtGender);
        btnConfirm = (Button)findViewById(R.id.btnConfirm);

        txtNickName.setText(CacheManager.readString(getApplicationContext(), "NickName"));
        txtAge.setText(CacheManager.readString(getApplicationContext(), "Age"));
        txtCity.setText(CacheManager.readString(getApplicationContext(), "City"));
        //txtGender.setText(CacheManager.readString(getApplicationContext(), "Gender"));

        btnConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //TODO:
            }
        });
    }
}

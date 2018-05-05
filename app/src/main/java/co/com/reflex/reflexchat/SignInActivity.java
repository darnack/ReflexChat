package co.com.reflex.reflexchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import co.com.reflex.reflexchat.util.Alert;
import co.com.reflex.reflexchat.util.CacheManager;

public class SignInActivity extends AppCompatActivity {

    private EditText txtNickName, txtAge, txtCity;
    private RadioGroup rdGender;
    //private RadioButton
    private TextView txtGender;
    private Button btnSigIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtNickName = (EditText)findViewById(R.id.txtNickName);
        txtAge = (EditText)findViewById(R.id.txtAge);
        txtCity = (EditText)findViewById(R.id.txtCity);
        rdGender = (RadioGroup)findViewById(R.id.rdGender);
        txtGender = (TextView)findViewById(R.id.txtGender);
        btnSigIn = (Button)findViewById(R.id.btnSignIn);

        txtNickName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        txtAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        txtCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        rdGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        btnSigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(attemptLogin()) {

                    CacheManager.writeString(SignInActivity.this, "NickName", txtNickName.getText().toString());
                    CacheManager.writeString(SignInActivity.this, "Age", txtAge.getText().toString());
                    CacheManager.writeString(SignInActivity.this, "City", txtCity.getText().toString());
                    String gender = ((RadioButton)findViewById(rdGender.getCheckedRadioButtonId())).getText().toString();
                    CacheManager.writeString(SignInActivity.this, "Gender", gender);

                    Intent i=new Intent(getApplicationContext(),ConfirmActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private boolean attemptLogin() {

        // Reset errors.
        txtNickName.setError(null);
        txtAge.setError(null);
        txtCity.setError(null);
        txtGender.setError(null);

        // Store values at the time of the login attempt.
        String nickname = txtNickName.getText().toString();
        String age = txtAge.getText().toString();
        String city = txtCity.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if(rdGender.getCheckedRadioButtonId() == -1) {
            txtGender.setError(getString(R.string.error_field_required));
            focusView = rdGender;
            cancel = true;
        }

        if (TextUtils.isEmpty(city)) {
            txtCity.setError(getString(R.string.error_field_required));
            focusView = txtCity;
            cancel = true;
        }

        if (TextUtils.isEmpty(age)) {
            txtAge.setError(getString(R.string.error_field_required));
            focusView = txtAge;
            cancel = true;
        }

        if (TextUtils.isEmpty(nickname)) {
            txtNickName.setError(getString(R.string.error_field_required));
            focusView = txtNickName;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        }

        return !cancel;
    }

}

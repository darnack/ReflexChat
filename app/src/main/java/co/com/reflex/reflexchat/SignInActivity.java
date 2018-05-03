package co.com.reflex.reflexchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private EditText txtNickName, txtAge;
    private RadioGroup rdGender;
    private TextView txtGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtNickName = (EditText)findViewById(R.id.txtNickName);
        txtAge = (EditText)findViewById(R.id.txtAge);
        rdGender = (RadioGroup)findViewById(R.id.rdGender);
        txtGender = (TextView)findViewById(R.id.txtGender);

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
        rdGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {

        // Reset errors.
        txtNickName.setError(null);
        txtAge.setError(null);
        txtGender.setError(null);

        // Store values at the time of the login attempt.
        String nickname = txtNickName.getText().toString();
        String age = txtAge.getText().toString();

        boolean cancel = false;
        View focusView = null;

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

        if(rdGender.getCheckedRadioButtonId() == 0) {
            txtGender.setError(getString(R.string.error_field_required));
        }

        if (cancel) {
            focusView.requestFocus();
        }
    }

}

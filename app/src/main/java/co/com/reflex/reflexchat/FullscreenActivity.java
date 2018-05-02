package co.com.reflex.reflexchat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class FullscreenActivity extends AppCompatActivity {

    private View mControlsView;
    private Button btnComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mControlsView = findViewById(R.id.fullscreen_content_controls);
        btnComenzar = (Button)findViewById(R.id.btnComenzar);

        btnComenzar.setOnClickListener( new View.OnClickListener() {
            public void onClick(View element) {
                Intent i=new Intent(getApplicationContext(),SignOnActivity.class);
                startActivity(i);
            }
        });
    }
}

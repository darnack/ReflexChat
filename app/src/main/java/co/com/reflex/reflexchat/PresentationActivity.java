package co.com.reflex.reflexchat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class PresentationActivity extends AppCompatActivity {

    private View mControlsView;
    private Button btnComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mControlsView = findViewById(R.id.fullscreen_content_controls);
        btnComenzar = (Button)findViewById(R.id.btnComenzar);

        btnComenzar.setOnClickListener( new View.OnClickListener() {
            public void onClick(View element) {
                Intent i=new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(i);
            }
        });
    }

    // Despliega ventana de confirmación para cerrar la aplicación
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.exit_title)
                    .setMessage(R.string.exit_confirm)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                         public void onClick(DialogInterface dialog, int which) {

                            //Stop the activity
                             PresentationActivity.this.finish();
                        }
                    })
                    .setNegativeButton(R.string.no, null)
                    .show();

            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }
    }
}

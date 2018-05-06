package co.com.reflex.reflexchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import co.com.reflex.reflexchat.util.CacheManager;

public class ChatActivity extends AppCompatActivity {

    private TextView txtChatBot, txtChatMe;
    private EditText txtEdit;
    private Button btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        txtChatBot = (TextView)findViewById(R.id.txtChatBot);
        txtChatMe = (TextView)findViewById(R.id.txtChatMe);
        txtEdit = (EditText)findViewById(R.id.txtEdit);
        btnChat = (Button)findViewById(R.id.btnChat);

        txtChatBot.setText("Hola " + CacheManager.readString(getApplicationContext(), "NickName") );

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtChatMe.setText(txtEdit.getText());
            }
        });
    }
}

package rahulpahuja.com.toastnotificationl;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ToastNotificationActivity extends AppCompatActivity {
    private Button mNotify;
    private EditText mName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Fetching the controls from the layout*/
        mNotify= (Button) findViewById(R.id.btn_notify);
        mName= (EditText) findViewById(R.id.et_name);

        /*Setting the OnClick Event of the Button*/
        mNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Fetching the Text from Control and Converting it to Uppercase*/
                String name=mName.getEditableText().toString().toUpperCase();

                if(name==""||name==null){//NULL or EMPTY CHECK
                    showToast(ToastNotificationActivity.this,"Hello There");
                }
                else
                {
                    showToast(ToastNotificationActivity.this,name);
                }
            }
        });


    }
    public void showToast(Context context, String message)
    {
        //This method is inbuilt and takes a context object and a string message to show
        //with the time length of the notification
        Toast.makeText(context,"HELLO , "+message,Toast.LENGTH_LONG).show();
    }

}

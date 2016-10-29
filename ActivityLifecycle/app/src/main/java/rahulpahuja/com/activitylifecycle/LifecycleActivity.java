package rahulpahuja.com.activitylifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class LifecycleActivity extends AppCompatActivity {
    private Context context;//Declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        context = LifecycleActivity.this;//Passing the Context to a Context Object
        Toast.makeText(context, "Called onCreate", Toast.LENGTH_SHORT).show(); //Shows a Toast Message
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(context, "Called onStart", Toast.LENGTH_SHORT).show(); //Shows a Toast Message
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(context, "Called onResume", Toast.LENGTH_SHORT).show(); //Shows a Toast Message
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(context, "Called onPause", Toast.LENGTH_SHORT).show(); //Shows a Toast Message
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(context, "Called onStop", Toast.LENGTH_SHORT).show(); //Shows a Toast Message
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(context, "Called onRestart", Toast.LENGTH_SHORT).show(); //Shows a Toast Message
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(context, "Called onDestroy", Toast.LENGTH_SHORT).show(); //Shows a Toast Message
    }
}

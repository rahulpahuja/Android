package rahulpahuja.com.viewpagerandfragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import rahulpahuja.com.viewpagerandfragment.R;

public class MainActivity extends AppCompatActivity {
    /*Creating an intent to start the activity with desired selection*/
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*Fetching the Buttons*/
        Button pagerSimple = (Button) findViewById(R.id.btn_simple_pager);
        Button pagerTab = (Button) findViewById(R.id.btn_stripped_pager_tab);
        Button pagerTitle = (Button) findViewById(R.id.btn_stripped_pager_title);

        /*Setting the Click Listener*/
        pagerSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        /*Setting the Click Listener*/
        pagerTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, ViewPagerTabStripActivity.class);
                startActivity(intent);
            }
        });

        /*Setting the Click Listener*/
        pagerTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, ViewPagerTitleStripActivity.class);
                startActivity(intent);
            }
        });
    }
}

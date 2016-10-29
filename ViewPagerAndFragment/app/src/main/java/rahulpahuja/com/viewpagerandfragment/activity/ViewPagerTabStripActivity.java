package rahulpahuja.com.viewpagerandfragment.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import rahulpahuja.com.viewpagerandfragment.R;
import rahulpahuja.com.viewpagerandfragment.adpater.ViewPagerAdapter;

public class ViewPagerTabStripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_tab_strip);

           /*Fetching the View Pager from the View*/
        ViewPager mViewPager = (ViewPager) findViewById(R.id.tab_strip_view_pager);

        /*Initiating the adpater*/
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());



        /*Setting the Adpater on the View Pager Control*/
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

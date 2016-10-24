package rahulpahuja.com.fragmentlifecycle.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import rahulpahuja.com.fragmentlifecycle.R;
import rahulpahuja.com.fragmentlifecycle.fragments.BlueFragment;
import rahulpahuja.com.fragmentlifecycle.fragments.GreenFragment;
import rahulpahuja.com.fragmentlifecycle.fragments.RedFragment;

public class MainActivity extends AppCompatActivity {
    private android.support.v4.app.FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Initializing the Fragment Manager*/
        final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        /*Finding the Spinner for attaching the adapter to it*/
        Spinner fragmentTransactionSpinner = (Spinner) findViewById(R.id.sp_color_selector);

        if (fragmentTransactionSpinner != null) {//NULL CHECK
            /*Adding the Adapter to the Spinner*/
            fragmentTransactionSpinner.setAdapter(getSpinnerAdapter());
        }

        if (fragmentTransactionSpinner != null) {
            fragmentTransactionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            replaceFragment(R.id.fl_fragment_container, fragmentManager, new RedFragment());
                            break;
                        case 1:
                            replaceFragment(R.id.fl_fragment_container, fragmentManager, new GreenFragment());
                            break;
                        case 2:
                            replaceFragment(R.id.fl_fragment_container, fragmentManager, new BlueFragment());
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    /*Created Method for Doing Fragment Transaction*/
    private void replaceFragment(@IdRes int layoutId, android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(layoutId, fragment);
        fragmentTransaction.commit();

    }

    private ArrayAdapter<String> getSpinnerAdapter() {
        /*Initializing the List of Strings*/
        List<String> colorList = new ArrayList<>();
        colorList.add(0, "RED");//Adding Red item to the 0th index
        colorList.add(1, "GREEN");//Adding Green item to the 1st index
        colorList.add(2, "BLUE");//Adding Blue item to the 2nd index
        /*Creating an ArrayAdapter for Spinner Using Context, Layout and List of Strings*/
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, colorList);
        return colorAdapter;
    }
}

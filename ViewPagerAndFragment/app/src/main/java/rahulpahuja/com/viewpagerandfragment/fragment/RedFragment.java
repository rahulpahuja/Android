package rahulpahuja.com.viewpagerandfragment.fragment;

/**
 * Created by Rahul on 10/29/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rahulpahuja.com.viewpagerandfragment.R;

public class RedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflating the view inside of the fragment
        View redFragment = inflater.inflate(R.layout.fragment_red, null);

        return redFragment;
    }
}

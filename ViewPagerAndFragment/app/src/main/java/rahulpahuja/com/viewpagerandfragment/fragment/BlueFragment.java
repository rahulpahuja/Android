package rahulpahuja.com.viewpagerandfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rahulpahuja.com.viewpagerandfragment.R;

public class BlueFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflating the view inside of the fragment
        View blueFragment = inflater.inflate(R.layout.fragment_blue, null);

        return blueFragment;
    }
}

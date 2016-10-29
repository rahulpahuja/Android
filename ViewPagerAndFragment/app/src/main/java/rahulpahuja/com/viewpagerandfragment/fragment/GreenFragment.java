package rahulpahuja.com.viewpagerandfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rahulpahuja.com.viewpagerandfragment.R;

public class GreenFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflating the view inside of the fragment
        View greenFragment = inflater.inflate(R.layout.fragment_green, null);
        return greenFragment;
    }
}

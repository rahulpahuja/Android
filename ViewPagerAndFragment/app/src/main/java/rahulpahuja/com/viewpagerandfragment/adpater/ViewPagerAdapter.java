package rahulpahuja.com.viewpagerandfragment.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import rahulpahuja.com.viewpagerandfragment.fragment.BlueFragment;
import rahulpahuja.com.viewpagerandfragment.fragment.GreenFragment;
import rahulpahuja.com.viewpagerandfragment.fragment.RedFragment;

/**
 * Created by Rahul on 10/29/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment fragment = null;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        //3 is the Number of Fragments we have in here
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "RED";
                break;
            case 1:
                title = "GREEN";
                break;
            case 2:
                title = "BLUE";
                break;
        }
        return title;
    }

    @Override
    public Fragment getItem(int position) {
        //Switching the Current Position of the View Pager
        switch (position) {
            case 0:
                fragment = new RedFragment();
                break;
            case 1:
                fragment = new GreenFragment();
                break;
            case 2:
                fragment = new BlueFragment();
                break;
        }
        return fragment;
    }

}

package com.rahul.mvvmjavaexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rahul.mvvmjavaexample.adapters.RecyclerViewAdapter;
import com.rahul.mvvmjavaexample.models.NicePlace;
import com.rahul.mvvmjavaexample.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    private ArrayList<String>  mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ProgressBar mProgressBar;
    private List<NicePlace> placeList = new ArrayList<>();
    private int mProgressBarVisibility = -1;
    private NicePlace nicePlace;
    RecyclerViewAdapter adapter;
    private FloatingActionButton mFab=null;
    private RecyclerView recyclerView;
    private MainActivityViewModel   mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        recyclerView = findViewById(R.id.rv_container);
        mProgressBar = findViewById(R.id.progress_bar);
        mFab = findViewById(R.id.fab);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.init();

        mainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                //Changes on the List are Seen here

                adapter.notifyDataSetChanged();
            }
        });

        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    changeProgressBarVisibility();
                }else{
                    changeProgressBarVisibility();
                    recyclerView.smoothScrollToPosition(mainActivityViewModel.getNicePlaces().getValue().size()-1);
                }
            }
        });


        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.addNewValue(new NicePlace("New Jersey","data:image/jpeg;base64,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"));
            }
        });

        //initImageBitmaps();
        renderListofNicePlaces();
        setupRecyclerView();
    }

    private  void changeProgressBarVisibility(){
        if(mProgressBar.getVisibility()==View.VISIBLE){
            mProgressBar.setVisibility(View.GONE);
        }else if(mProgressBar.getVisibility()==View.INVISIBLE||mProgressBar.getVisibility()==View.GONE){
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    private void renderListofNicePlaces() {
        initImageBitmaps();
        for (int i = 0; i < mImageUrls.size(); i++) {
            placeList.add(new NicePlace(mNames.get(i),mImageUrls.get(i)));
        }
    }

    private void setupRecyclerView() {
        Log.d(TAG, "setupRecyclerView: init");
        //adapter = new RecyclerViewAdapter(mNames,mImageUrls,this);
        adapter = new RecyclerViewAdapter(mainActivityViewModel.getNicePlaces().getValue(),this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: ");
        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Australia_Day.jpg/1024px-Australia_Day.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/02/a0002487/img/basic/a0002487_main.jpg?20200929151728&q=80&rw=750&rh=536");
        mNames.add("Japan");

        mImageUrls.add("https://i2.wp.com/www.traveloffpath.com/wp-content/uploads/2020/09/Morocco-Reopening-Borders-For-Tourism-Everything-You-Need-To-Know.jpg?resize=759%2C500&ssl=1");
        mNames.add("Morocco");

        mImageUrls.add("https://static01.nyt.com/images/2020/10/20/world/20china-india/merlin_178747155_b40897a8-b921-42a6-ad55-27fd790c5648-articleLarge.jpg?quality=75&auto=webp&disable=upscale");
        mNames.add("India");


        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Australia_Day.jpg/1024px-Australia_Day.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/02/a0002487/img/basic/a0002487_main.jpg?20200929151728&q=80&rw=750&rh=536");
        mNames.add("Japan");

        mImageUrls.add("https://i2.wp.com/www.traveloffpath.com/wp-content/uploads/2020/09/Morocco-Reopening-Borders-For-Tourism-Everything-You-Need-To-Know.jpg?resize=759%2C500&ssl=1");
        mNames.add("Morocco");

        mImageUrls.add("https://static01.nyt.com/images/2020/10/20/world/20china-india/merlin_178747155_b40897a8-b921-42a6-ad55-27fd790c5648-articleLarge.jpg?quality=75&auto=webp&disable=upscale");
        mNames.add("India");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Australia_Day.jpg/1024px-Australia_Day.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/02/a0002487/img/basic/a0002487_main.jpg?20200929151728&q=80&rw=750&rh=536");
        mNames.add("Japan");

        mImageUrls.add("https://i2.wp.com/www.traveloffpath.com/wp-content/uploads/2020/09/Morocco-Reopening-Borders-For-Tourism-Everything-You-Need-To-Know.jpg?resize=759%2C500&ssl=1");
        mNames.add("Morocco");

        mImageUrls.add("https://static01.nyt.com/images/2020/10/20/world/20china-india/merlin_178747155_b40897a8-b921-42a6-ad55-27fd790c5648-articleLarge.jpg?quality=75&auto=webp&disable=upscale");
        mNames.add("India");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Australia_Day.jpg/1024px-Australia_Day.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/02/a0002487/img/basic/a0002487_main.jpg?20200929151728&q=80&rw=750&rh=536");
        mNames.add("Japan");

        mImageUrls.add("https://i2.wp.com/www.traveloffpath.com/wp-content/uploads/2020/09/Morocco-Reopening-Borders-For-Tourism-Everything-You-Need-To-Know.jpg?resize=759%2C500&ssl=1");
        mNames.add("Morocco");

        mImageUrls.add("https://static01.nyt.com/images/2020/10/20/world/20china-india/merlin_178747155_b40897a8-b921-42a6-ad55-27fd790c5648-articleLarge.jpg?quality=75&auto=webp&disable=upscale");
        mNames.add("India");


    }


}
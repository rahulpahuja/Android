package com.rahulandroid.tinderswipeableviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardStackView cardStackView = findViewById(R.id.card_stack_view);
        cardStackView.setLayoutManager(new CardStackLayoutManager(this,this));
        List<ExamData> list = new ArrayList<ExamData>();
        list = getData();
        ClickListener listiner = new ClickListener() {
            @Override
            public void click(int index){
                //Toast.makeText(this,"clicked item index is "+index, Toast.LENGTH_LONG).show();
            }
        };
        CardStackAdapter adapter = new CardStackAdapter(
                list, getApplication(),listiner);
        cardStackView.setAdapter(adapter);

    }

    private List<ExamData> getData()
    {
        List<ExamData> list = new ArrayList<>();
        list.add(new ExamData("First Exam", "May 23, 2015", "Best Of Luck"));
        list.add(new ExamData("Second Exam", "June 09, 2015", "b of l"));
        list.add(new ExamData("My Test Exam", "April 27, 2017", "This is testing exam .."));
        return list;
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {

    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }
}
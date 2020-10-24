package com.rahul.mvvmjavaexample.repositories;

import androidx.lifecycle.MutableLiveData;

import com.rahul.mvvmjavaexample.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository  {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance(){
        if(instance ==null){
            instance = new NicePlaceRepository();
        }
        return instance;
    }

    //Pretends to get data from WebService or an Online Source or Cache
    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        //DB and Rest Service Methods for settingdata
        setNicePlaces();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setNicePlaces(){
        dataSet.add(new NicePlace("Savanna","https://www.arcgis.com/sharing/rest/content/items/c415572a86f244b795ec0f486a140a6d/resources/1571179525790.jpeg?w=3117"));


        dataSet.add(new NicePlace("Austrailia","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Australia_Day.jpg/1024px-Australia_Day.jpg"));


        dataSet.add(new NicePlace("Japan","https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/02/a0002487/img/basic/a0002487_main.jpg?20200929151728&q=80&rw=750&rh=536"));

        dataSet.add(new NicePlace("Morocco","https://i2.wp.com/www.traveloffpath.com/wp-content/uploads/2020/09/Morocco-Reopening-Borders-For-Tourism-Everything-You-Need-To-Know.jpg?resize=759%2C500&ssl=1"));

        dataSet.add(new NicePlace("India","https://static01.nyt.com/images/2020/10/20/world/20china-india/merlin_178747155_b40897a8-b921-42a6-ad55-27fd790c5648-articleLarge.jpg?quality=75&auto=webp&disable=upscale"));



        dataSet.add(new NicePlace("Austrailia","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Australia_Day.jpg/1024px-Australia_Day.jpg"));


        dataSet.add(new NicePlace("Japan","https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/02/a0002487/img/basic/a0002487_main.jpg?20200929151728&q=80&rw=750&rh=536"));

        dataSet.add(new NicePlace("Morocco","https://i2.wp.com/www.traveloffpath.com/wp-content/uploads/2020/09/Morocco-Reopening-Borders-For-Tourism-Everything-You-Need-To-Know.jpg?resize=759%2C500&ssl=1"));

        dataSet.add(new NicePlace("India","https://static01.nyt.com/images/2020/10/20/world/20china-india/merlin_178747155_b40897a8-b921-42a6-ad55-27fd790c5648-articleLarge.jpg?quality=75&auto=webp&disable=upscale"));





    }

}

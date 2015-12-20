package com.yenitsrm.androidsekmeliarayuz.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.GridLayoutManager;
import android.widget.TextView;

import com.com.javakaian.models.User;
import com.yenitsrm.androidsekmeliarayuz.Factory;
import com.yenitsrm.androidsekmeliarayuz.R;
import com.yenitsrm.androidsekmeliarayuz.gallery.GalleryAdapter;
import com.yenitsrm.androidsekmeliarayuz.gallery.ImageModel;

public class TabFragment1 extends Fragment {

    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;

    ArrayList<ImageModel> data = new ArrayList<>();

    private TextView userNameTxt;


    //galeride gösterilecek rerimlerin url dizisi
    public static String IMGS[] = {

            "https://images.unsplash.com/photo-1444090542259-0af8fa96557e?q=80&fm=jpg&w=1080&fit=max&s=4b703b77b42e067f949d14581f35019b",
            "https://images.unsplash.com/photo-1439546743462-802cabef8e97?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300",
            "https://images.unsplash.com/photo-1441155472722-d17942a2b76a?q=80&fm=jpg&w=1080&fit=max&s=80cb5dbcf01265bb81c5e8380e4f5cc1",
            "https://images.unsplash.com/photo-1437651025703-2858c944e3eb?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300",
            "https://images.unsplash.com/photo-1431538510849-b719825bf08b?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300",
            "https://images.unsplash.com/photo-1434873740857-1bc5653afda8?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300",
            "https://images.unsplash.com/photo-1439396087961-98bc12c21176?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300",
            "https://images.unsplash.com/photo-1433616174899-f847df236857?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300",
            "https://images.unsplash.com/photo-1438480478735-3234e63615bb?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300",
            "https://images.unsplash.com/photo-1438027316524-6078d503224b?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        //login olan kullanıcıyı alıp
        //bilgilerini ilgili textviewlere yazdırıyoruz
        User user = Factory.getUser();
        userNameTxt = (TextView) view.findViewById(R.id.textViewKullaniciAdi);
        userNameTxt.setText(user.getUserName());

        //url'lerden resimlerimizi üretiyoruz
        for (int i = 0; i < IMGS.length; i++) {

            ImageModel imageModel = new ImageModel();
            imageModel.setName("Image " + i);
            imageModel.setUrl(IMGS[i]);
            data.add(imageModel);

        }

        //resimler galeri şeklinde görüntüleniyor
        mRecyclerView = (RecyclerView) view.findViewById(R.id.image_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(), 3));
        mRecyclerView.setHasFixedSize(true); // Helps improve performance
        mAdapter = new GalleryAdapter(getActivity().getBaseContext(), data);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
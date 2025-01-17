package com.example.bottombarfragment.fragmet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottombarfragment.Item;
import com.example.bottombarfragment.MyAdapter;
import com.example.bottombarfragment.R;
import com.example.bottombarfragment.calculator1;
import com.example.bottombarfragment.calculator2;

import java.util.ArrayList;
import java.util.List;

public class BangunDatarFragment extends Fragment implements MyAdapter.ItemClickListener {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MyAdapter myAdapter;
    List<Item> listData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bangundatar, container, false);

        recyclerView = view.findViewById(R.id.rv2dMenu);
        listData = new ArrayList<>();

        listData.add(new Item("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/shape_square.png", "Persegi"));
        listData.add(new Item("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/shape_circle.png", "Lingkaran"));
        listData.add(new Item("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/shape_triangle.png", "Segitiga"));
        listData.add(new Item("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/shape_rectangle.png", "Persegi panjang"));



        linearLayoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        myAdapter = new MyAdapter(requireContext(), listData);
        myAdapter.setItemClickListener(this);
        recyclerView.setAdapter(myAdapter);

        return view;
    }

    @Override
    public void onItemClick(View view, Item item) {

        Toast.makeText(requireContext(), "You clicked " + item.getName(), Toast.LENGTH_SHORT).show();
        Intent intent;
        switch (item.getName()) {
            case "Persegi":
                intent = new Intent(requireContext(), calculator1.class);
                break;
            case "Lingkaran":
                intent = new Intent(requireContext(), calculator1.class);
                break;
            case "Segitiga":
                intent =new Intent(requireContext(), calculator2.class);
                intent.putExtra("shape2", item.getName());
                startActivity(intent);
                break;
            case "Persegi panjang":
                intent = new Intent(requireContext(), calculator2.class);
                intent.putExtra("shape2", item.getName());
                startActivity(intent);
                break;

            default:

                return;
        }

        // Optionally, you can pass additional data to the activity using intent.putExtra()
        intent.putExtra("shape1", item.getName());
        startActivity(intent);


    }
}

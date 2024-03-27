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

public class RuangFragment extends Fragment implements MyAdapter.ItemClickListener {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MyAdapter myAdapter;
    List<Item> listData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bangunruang, container, false);

        recyclerView = view.findViewById(R.id.rv3dMenu);
        listData = new ArrayList<>();

        listData.add(new Item("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/object_cube.png", "Kubus"));
        listData.add(new Item("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/object_cylinder.png", "Tabung"));
        listData.add(new Item("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/object_ball.png", "Bola"));
        listData.add(new Item("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/object_cone.png", "Kerucut"));

        linearLayoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        myAdapter = new MyAdapter(requireContext(), listData);

        myAdapter.setItemClickListener(this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onItemClick(View view, Item item) {
        // Handle the item click here
        Toast.makeText(requireContext(), "You clicked " + item.getName(), Toast.LENGTH_SHORT).show();
        Intent intent;
        switch (item.getName()) {
            case "Kubus":
                intent = new Intent(requireContext(), calculator1.class);
                break;
            case "Tabung":
                intent = new Intent(requireContext(), calculator2.class);
                intent.putExtra("shape2", item.getName());
                startActivity(intent);
                break;
            case "Bola":
                intent =new Intent(requireContext(), calculator1.class);
                break;
            case "Kerucut":
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


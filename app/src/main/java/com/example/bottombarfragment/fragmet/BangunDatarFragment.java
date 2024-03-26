package com.example.bottombarfragment.fragmet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottombarfragment.Item;
import com.example.bottombarfragment.MyAdapter;
import com.example.bottombarfragment.R;

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

        listData.add(new Item("https://media.tenor.com/clTeB86HM-oAAAAM/nahida-genshin.gif"));
        listData.add(new Item("https://media.tenor.com/clTeB86HM-oAAAAM/nahida-genshin.gif"));




        linearLayoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        myAdapter = new MyAdapter(requireContext(), listData);
        myAdapter.setItemClickListener(this);
        recyclerView.setAdapter(myAdapter);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        // Handle item click here
    }
}

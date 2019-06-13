package com.example.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.Map;


public class TodayList extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today_list, container, false);
        //Список дел на сегодня
        ListView listView = view.findViewById(R.id.todoToday);
        getActivity().setTitle("Today List");

        //Петя, тут нужно то, откуда пойдет список

        ArrayAdapter<Map> adapter = new ArrayAdapter<Map>(getActivity(), R.layout.list_item);
        listView.setAdapter(adapter);
        return view;
    }
}



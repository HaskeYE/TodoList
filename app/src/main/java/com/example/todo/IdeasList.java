package com.example.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


public class IdeasList extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ideas_list, container, false);
        //Список дел на сегодня
        ListView listView = view.findViewById(R.id.ideasList);
        getActivity().setTitle("Ideas List");

        //Петя, тут нужно то, откуда пойдет список
        String[] ideas = new String[/*к-во идей на данный момент в int (четверка там просто так)*/4];
        //Нужна в итоге мапа с названием todoMap, в которой ключ - дело, а
        //значение - это время выполнения. emptylist на мапу меняй

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, ideas);
        listView.setAdapter(adapter);
        return view;
    }
}

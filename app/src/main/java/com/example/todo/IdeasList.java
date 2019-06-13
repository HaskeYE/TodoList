package com.example.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class IdeasList extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ideas_list, container, false);
        //Список дел на сегодня
        ListView listView = view.findViewById(R.id.ideasList);
        getActivity().setTitle("Ideas List");

        //То, откуда пойдет список
        DataHelper db = App.getInstance().getDatabase();
        IdeasDao ideaDao = db.ideasDao();

        List<Ideas> ideas = ideaDao.getAll();
        List<String> ideasHeads = new ArrayList<>();

        for (Ideas x: ideas) {
            ideasHeads.add(x.getHead());
        }



                //String[] ideas = new String[/*к-во идей на данный момент в int (четверка там просто так)*/4];
        //Нужна в итоге мапа с названием todoMap, в которой ключ - дело, а
        //значение - это время выполнения. emptylist на мапу меняй

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, ideasHeads);
        listView.setAdapter(adapter);
        return view;
    }
}

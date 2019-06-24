package com.example.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        final ListView listView = view.findViewById(R.id.ideasList);
        getActivity().setTitle("Ideas List");

        //То, откуда пойдет список
        DataHelper db = App.getInstance().getDatabase();
        IdeasDao ideaDao = db.ideasDao();

        List<Ideas> ideas = ideaDao.getAll();
        List<String> ideasHeads = new ArrayList<>();

        for (Ideas x: ideas) {
            ideasHeads.add(x.getHead());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, ideasHeads);
        listView.setAdapter(adapter);
        //Deleting Idea
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = view.findViewById(R.id.ideasList);
                String text = textView.getText().toString();
                //Удалить text из sql твоей


                Toast toast = Toast.makeText(getContext(),
                        "Идея удалена", Toast.LENGTH_SHORT);
                toast.show();
            }});
        return view;
    }
}

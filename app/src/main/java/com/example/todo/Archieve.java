package com.example.todo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Archieve extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.new_fr, container, false);
            //Список дел на сегодня
            final ListView listView = view.findViewById(R.id.archieve);
            getActivity().setTitle("Ideas List");

            //То, откуда пойдет список
            DataHelper db = App.getInstance().getDatabase();
            final IdeasDao ideaDao = db.ideasDao();


            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            HashMap<String, String> map;
            for (Ideas x: ideaDao.getAllTasks()) {
                map = new HashMap<>();
                map.put("Time", x.getTime());
                map.put("Head", x.getHead());
                map.put("Date", x.getData());
                arrayList.add(map);
            }
            if (arrayList.size() < 1) {
                Toast toast = Toast.makeText(getActivity(),
                        "Задач на сегодня нет", Toast.LENGTH_LONG);
                toast.show();
            }

            SimpleAdapter adapter = new SimpleAdapter(getActivity(), arrayList,
                    R.layout.new_fr,
                    new String[]{"Time", "Head", "Date"},
                    new int[]{R.id.text_view_member_id, R.id.text_view_name,
                            R.id.text_view_phone});
            listView.setAdapter(adapter);
        return view;
        }
    }


package com.example.todo;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TodayList extends Fragment {
    private DataHelper db = App.getInstance().getDatabase();
    private IdeasDao ideaDao = db.ideasDao();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today_list, container, false);
        //Список дел на сегодня
        ListView listView = view.findViewById(R.id.todoToday);
        getActivity().setTitle("Today List");

        //Getting today date
        String date = " ";

        //Tasks for today by today date
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        HashMap<String, String> map;
        for (Ideas x: ideaDao.getByData(date)) {
            map = new HashMap<>();
            map.put("Time", x.getTime());
            map.put("Head", x.getHead());
            arrayList.add(map);
        }
        if (arrayList.size() < 1) {
            Toast toast = Toast.makeText(getActivity(),
                    "Задач на сегодня нет", Toast.LENGTH_LONG);
            toast.show();
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), arrayList, android.R.layout.simple_list_item_2,
                new String[]{"Time", "Head"},
                new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);
        return view;
    }
}



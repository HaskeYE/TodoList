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
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Archieve extends Fragment{

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
            final IdeasDao ideaDao = db.ideasDao();

        }
    }


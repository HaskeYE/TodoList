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


public class IdeasList extends Fragment {
    AlertDialog.Builder ad;
    Context context;
    int pos;

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

        List<Ideas> ideas = ideaDao.getAll();
        final List<String> ideasHeads = new ArrayList<>();

        for (Ideas x: ideas) {
            ideasHeads.add(x.getHead());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, ideasHeads);
        listView.setAdapter(adapter);


        //Deleting idea
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                pos = position;
                ad.show();
            }});

        String title = "Удаление";
        String message = "Хотите ли вы удалить данную идею?";
        String button1String = "Да";
        String button2String = "Нет";

        context = getActivity();
        ad = new AlertDialog.Builder(context);
        ad.setTitle(title);  // заголовок
        ad.setMessage(message); // сообщение
        ad.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                // по позиции получаем выбранный элемент
                String selectedItem = ideasHeads.get(pos);
                ideaDao.deletByHead(selectedItem);
                Toast toast = Toast.makeText(getContext(),
                        "Идея удалена", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        ad.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "Удаление отменено",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ad.setCancelable(true);
        ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
            }
        });


        return view;
    }
}


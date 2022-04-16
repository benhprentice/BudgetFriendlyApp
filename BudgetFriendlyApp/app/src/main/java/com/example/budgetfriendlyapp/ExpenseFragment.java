package com.example.budgetfriendlyapp;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Vector;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class ExpenseFragment extends Fragment {

    static private Data data;

    NumberFormat nf = new DecimalFormat("##.##");

    EditText addExpenseBox;
    Float expenseValue;

    EditText addNoteBox;
    String noteValue;
    String expenseString;

    Vector<String> listItems = new Vector<>();

    ArrayAdapter<String> listViewAdapter;

    public ExpenseFragment(Data data) {
        this.data = data;
    }

    public static ExpenseFragment newInstance(String param1, String param2) {
        ExpenseFragment fragment = new ExpenseFragment(data);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_expense,container, false);

        ListView listView = (ListView) view.findViewById(R.id.expenseCards);

        listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                listItems
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int idView = getResources().getIdentifier("saveExpense", "id", getContext().getPackageName());
        View eventView = view.findViewById(idView);
        eventView.setOnClickListener(new OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             saveExpenseMethod(view);
                                         }
                                     }
        );

        int idView2 = getResources().getIdentifier("cancelExpense", "id", getContext().getPackageName());
        View eventView2 = view.findViewById(idView2);
        eventView2.setOnClickListener(new OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              cancelExpenseMethod(view);
                                          }
                                      }
        );

        int idView3 = getResources().getIdentifier("expenseAmount", "id", getContext().getPackageName());
        addExpenseBox = view.findViewById(idView3);

        int idView4 = getResources().getIdentifier("expenseNote", "id", getContext().getPackageName());
        addNoteBox = view.findViewById(idView4);

    }

    public void saveExpenseMethod(View view) {

        expenseString = addExpenseBox.getText().toString();

        data.subAmount( Float.parseFloat(expenseString));
        expenseValue = data.getAmount();

        noteValue = addNoteBox.getText().toString();

        listItems.add(0, "- $ " + expenseString + "    " + noteValue);
        listViewAdapter.notifyDataSetChanged();

        addExpenseBox.setText("");
        addNoteBox.setText("");

        Log.d("Message:", "Success!");
    }

    public void cancelExpenseMethod(View view) {

        addExpenseBox.setText("");
        addNoteBox.setText("");

        Log.d("Message:", "Success!");
    }

}
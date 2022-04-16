package com.example.budgetfriendlyapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IncomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IncomeFragment extends Fragment {

    static private Data data;

    NumberFormat nf = new DecimalFormat("##.##");

    float parseFloat;

    EditText addIncomeBox;

    EditText addCategoryBox;
    String categoryValue;
    String incomeString;

    Vector<String> listItems = new Vector<>();

    ArrayAdapter<String> listViewAdapter;

    public IncomeFragment(Data data) {
        this.data = data;
    }

    public static IncomeFragment newInstance(String param1, String param2) {
        IncomeFragment fragment = new IncomeFragment(data);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_income,container, false);

        ListView listView = (ListView) view.findViewById(R.id.expenseCards2);

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

        int idView4 = getResources().getIdentifier("amount", "id", getContext().getPackageName());
        addIncomeBox = view.findViewById(idView4);

        int idView6 = getResources().getIdentifier("note", "id", getContext().getPackageName());
        addCategoryBox = view.findViewById(idView6);

        int idView = getResources().getIdentifier("addIncomeButton", "id", getContext().getPackageName());
        View eventView = view.findViewById(idView);
        eventView.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             saveIncomeMethod(view);
                                         }
                                     }
        );

        int idView2 = getResources().getIdentifier("cancelIncome", "id", getContext().getPackageName());
        View eventView2 = view.findViewById(idView2);
        eventView2.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              cancelIncomeMethod(view);
                                          }
                                      }
        );

    }

    public void saveIncomeMethod (View view) {

        incomeString = addIncomeBox.getText().toString();

        parseFloat = Float.parseFloat(incomeString);

        data.addAmount( parseFloat );


// add new list item
        listItems.add(0, "+ $ " + incomeString);
        listViewAdapter.notifyDataSetChanged();


// add category data
        Log.d("Message", incomeString);
        categoryValue = addCategoryBox.getText().toString();

        // clear form
        addIncomeBox.setText("");
        addCategoryBox.setText("");
    }

    private void cancelIncomeMethod(View view) {
        addIncomeBox.setText("");
        addCategoryBox.setText("");
    }

}
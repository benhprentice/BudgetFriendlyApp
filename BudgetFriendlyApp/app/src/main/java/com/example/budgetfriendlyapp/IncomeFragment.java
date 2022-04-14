package com.example.budgetfriendlyapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IncomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IncomeFragment extends Fragment {

    TextView eventView3;
    EditText addIncomeBox;
    String incomeValue;

    TextView eventView4;
    EditText addCategoryBox;
    String categoryValue;

    public IncomeFragment() {
    }

    public static IncomeFragment newInstance(String param1, String param2) {
        IncomeFragment fragment = new IncomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_income, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int idView3 = getResources().getIdentifier("listOfIncomeAmounts", "id", getContext().getPackageName());
        eventView3 = view.findViewById(idView3);

        int idView4 = getResources().getIdentifier("amount", "id", getContext().getPackageName());
        addIncomeBox = view.findViewById(idView4);

        int idView5 = getResources().getIdentifier("listOfIncomeNames", "id", getContext().getPackageName());
        eventView4 = view.findViewById(idView5);

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

    }

    public void saveIncomeMethod (View view) {
        Log.d( "Message:", "Success!");
        incomeValue = addIncomeBox.getText().toString();
        eventView3.setText(incomeValue);

        categoryValue = addCategoryBox.getText().toString();
        eventView4.setText(categoryValue);
    }

}
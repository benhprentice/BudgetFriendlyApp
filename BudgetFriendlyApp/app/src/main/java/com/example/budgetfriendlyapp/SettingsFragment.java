package com.example.budgetfriendlyapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    static private Data data;

    EditText addBudgetBox;

    public SettingsFragment(Data data) { this.data = data;
    }

    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment(data);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int idView = getResources().getIdentifier("saveBudget", "id", getContext().getPackageName());
        View eventView = view.findViewById(idView);
        eventView.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             saveBudgetMethod(view);
                                         }
                                     }
        );

        int idView2 = getResources().getIdentifier("cancelBudget", "id", getContext().getPackageName());
        View eventView2 = view.findViewById(idView2);
        eventView2.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              cancelBudgetMethod(view);
                                          }
                                      }
        );

        int idView3 = getResources().getIdentifier("budgetAmount", "id", getContext().getPackageName());
        addBudgetBox = view.findViewById(idView3);

    }


    public void saveBudgetMethod(View view) {

        data.setBudget( Double.parseDouble(addBudgetBox.getText().toString()));
        addBudgetBox.setText("");

        Log.d("Message:", "Success!");
    }

    public void cancelBudgetMethod(View view) {

        addBudgetBox.setText("");

        Log.d("Message:", "Success!");
    }
}
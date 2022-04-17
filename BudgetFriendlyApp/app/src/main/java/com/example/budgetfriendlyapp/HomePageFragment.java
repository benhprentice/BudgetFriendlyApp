package com.example.budgetfriendlyapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageFragment extends Fragment {

    static private Data data;

    TextView currentBalanceBox;
    TextView monthlyBalanceBox;

    Double currentBalance;
    Double monthlyBalance;

    DecimalFormat currency = new DecimalFormat("###,###,##0.00");

    public HomePageFragment(Data data) {
        this.data = data;
    }

    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment(data);
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

        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int idView4 = getResources().getIdentifier("currentBalance", "id", getContext().getPackageName());
        currentBalanceBox = view.findViewById(idView4);

        int idView5 = getResources().getIdentifier("monthlyBalance", "id", getContext().getPackageName());
        monthlyBalanceBox = view.findViewById(idView5);

        currentBalance = data.getAmount();

        currentBalanceBox.setText("$ " + currency.format(currentBalance));

        monthlyBalance = data.getBudget();

        monthlyBalanceBox.setText("$ " + currency.format(monthlyBalance));

    }

}
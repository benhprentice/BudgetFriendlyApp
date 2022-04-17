package com.example.budgetfriendlyapp;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {

        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);

        View view=layoutInflater.inflate(R.layout.slidescreen,container,false);

        ImageView logo=view.findViewById(R.id.logo);
        ImageView ind1=view.findViewById(R.id.ind1);
        ImageView ind2=view.findViewById(R.id.ind2);
        ImageView ind3=view.findViewById(R.id.ind3);

        TextView guidelines=view.findViewById(R.id.guidelines);
        TextView description=view.findViewById(R.id.description);

        ImageView forward=view.findViewById(R.id.forward);
        ImageView back=view.findViewById(R.id.back);
        Button btnGetStarted=view.findViewById(R.id.btn);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ctx,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);

            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlideActivity.viewPager.setCurrentItem(position+1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlideActivity.viewPager.setCurrentItem(position-1);
            }
        });


        switch(position)
        {
            case 0:
                logo.setImageResource(R.drawable.logo1);
                ind1.setImageResource(R.drawable.selected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);

                guidelines.setText("Congrats!");
                description.setText("You're one step closer to financial stability!");
                back.setVisibility(View.GONE);
                forward.setVisibility(View.VISIBLE);
                break;
            case 1:
                logo.setImageResource(R.drawable.inandex);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.selected);
                ind3.setImageResource(R.drawable.unselected);

                guidelines.setText("Income and Expense!");
                description.setText("You'll be putting in your source(s) of income in the (+) and your expenses in the (-) section. To delete an item simply hold down the chosen item!");
                back.setVisibility(View.VISIBLE);
                forward.setVisibility(View.VISIBLE);
                break;
            case 2:
                logo.setImageResource(R.drawable.inandex);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.selected);

                guidelines.setText("Almost Done!");
                description.setText("When you click the settings icon, you can input your desired monthly budget amount!");
                forward.setVisibility(View.GONE);
                back.setVisibility(View.VISIBLE);
                break;
        }

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
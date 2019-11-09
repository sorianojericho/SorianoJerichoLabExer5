package com.example.sorianojericholabexer4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.Nullable;

public class AndroidAdapter extends ArrayAdapter<com.example.sorianojericholabexer4.AndroidVersion> {
    private Context context;
    private int resource;

    public AndroidAdapter(Context context, int resource, List<com.example.sorianojericholabexer4.AndroidVersion> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int i, @Nullable View convertView, ViewGroup parent) {
        int logo = getItem(i).getLogo();
        String name = getItem(i).getName();
        String country1 = getItem(i).getCountry();
        String industry1 = getItem(i).getIndustry();
        String ceo1 = getItem(i).getCeo();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView img = convertView.findViewById(R.id.logoL);
        TextView comName = convertView.findViewById(R.id.comName);
        TextView country = convertView.findViewById(R.id.country);
        TextView industry= convertView.findViewById(R.id.industry);
        TextView ceo = convertView.findViewById(R.id.ceo);

        img.setImageResource(logo);
        comName.setText(name);
        country.setText(country1);
        industry.setText(industry1);
        ceo.setText(ceo1);
        return convertView;
        }
    }



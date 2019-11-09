package com.example.sorianojericholabexer5;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sorianojericholabexer5.AndroidAdapter;
import com.example.sorianojericholabexer5.AndroidVersion;
import com.example.sorianojericholabexer5.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] comName, country, industry, ceo, info;
    int[] logo = {R.drawable.icbc, R.drawable.samsung, R.drawable.wellsfargo,
            R.drawable.royaldutchshell, R.drawable.pinganinsurance, R.drawable.jpmorgan,
            R.drawable.apple, R.drawable.att, R.drawable.agriculturalbankofchina,
            R.drawable.bankofamerica, R.drawable.bankofchina, R.drawable.chinaconstrucbank,
            R.drawable.citibank, R.drawable.exxonmobil};
    ListView lstVersions;
    ArrayList<AndroidVersion> versions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comName = getResources().getStringArray(R.array.comName);
        country = getResources().getStringArray(R.array.country);
        industry = getResources().getStringArray(R.array.industry);
        ceo = getResources().getStringArray(R.array.ceo);
        for (int i = 0; i < comName.length; i++) {
            versions.add(new com.example.sorianojericholabexer5.AndroidVersion(logo[i], comName[i], industry[i], country[i], ceo[i]));
        }
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.newlayout, versions);
        lstVersions = findViewById(R.id.lvCompanies);
        lstVersions.setAdapter(adapter);
        lstVersions.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "company.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            String choice = info[i];
            fos.write(choice.getBytes());
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setIcon(logo[i]);
            dialog.setTitle(comName[i]);
            dialog.setMessage(info[i]);
            dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, comName[i] + country[i] + ceo[i] + industry[i], Toast.LENGTH_LONG).show();

                }

            });


            dialog.create().show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package edu.temple.colorchange;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private ArrayList<ColorItem> colorList;
    private ColorAdapter colorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        final View layoutView = findViewById(R.id.b_color);
        initList();

        Spinner spinnerColors = findViewById(R.id.color_spinner);

        colorAdapter = new ColorAdapter(this, colorList);
        spinnerColors.setAdapter(colorAdapter);

        spinnerColors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ColorItem clickedItem = (ColorItem) parent.getItemAtPosition(position);
                String clickedColorName = clickedItem.getColorName();

                if (clickedColorName.equals("Red")) {
                    layoutView.setBackgroundColor(Color.RED);
                } else if (clickedColorName.equals("Black")) {
                    layoutView.setBackgroundColor(Color.BLACK);
                } else if (clickedColorName.equals("Blue")) {
                    layoutView.setBackgroundColor(Color.BLUE);
                } else if (clickedColorName.equals("Yellow")) {
                    layoutView.setBackgroundColor(Color.YELLOW);
                }
                Toast.makeText(ColorActivity.this, clickedColorName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                layoutView.setBackgroundColor(Color.WHITE);
            }
        });
    }

    private void initList() {
        colorList = new ArrayList<>();
        colorList.add(new ColorItem("Red", Color.RED));
        colorList.add(new ColorItem("Black", Color.BLACK));
        colorList.add(new ColorItem("Blue", Color.BLUE));
        colorList.add(new ColorItem("Yellow", Color.YELLOW));
    }
}

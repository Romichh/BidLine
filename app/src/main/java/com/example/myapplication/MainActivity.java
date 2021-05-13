package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle [] = {"Поламався автомобіль?", "Закінчилось пальне?","Потрібні автозапчастини?","Потрібна автомийка?","Потрапив у ДТП?", "Захотілось поспати?","Зголоднів??"};
    int images[] = {R.drawable.car_repair, R.drawable.gas, R.drawable.car_shop, R.drawable.car_wash, R.drawable.crash, R.drawable.lodging, R.drawable.restaurant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(MainActivity.this, AutoServiceActivity.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(MainActivity.this, GoogleMapsGas.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(MainActivity.this, GoogleMapsCarWash.class);
                    startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(MainActivity.this, EmergencyActivity.class);
                    startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent(MainActivity.this, GoogleMapsLodging.class);
                    startActivity(intent);
                }
                if(position == 6){
                    Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        int rImgs[];

        MyAdapter (Context c, String title[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            return row;
        }
    }

}
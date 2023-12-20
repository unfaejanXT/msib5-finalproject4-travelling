package com.hacktiv8.travelling3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScheduleBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_bus);

        ImageButton boarding = findViewById(R.id.boarding);
        ImageButton dropping = findViewById(R.id.dropping);
        ImageButton back = findViewById(R.id.back_bt);
        TextView next = findViewById(R.id.next);
        TextView ptNameTv = findViewById(R.id.pt_name_tv);
        TextView facilityTv = findViewById(R.id.facility_tv);

        Bundle dataEt = getIntent().getExtras();
        String ptName = dataEt.getString("ptNameFromIntent");
        String facility = dataEt.getString("facilityFromIntent");
        String keyBus = dataEt.getString("keyFromIntent");

        ptNameTv.setText(ptName);
        facilityTv.setText(facility);


        FrameLayout contentDefault = findViewById(R.id.content_frame);
        BoardingFragment boardingFragment = BoardingFragment.newInstance(keyBus);
        getSupportFragmentManager().beginTransaction().add(R.id.content_frame, boardingFragment).commit();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleBusActivity.this, BusSeatsActivity.class);

                // Mendapatkan data dari getIntent()
                Bundle data = getIntent().getExtras();
                assert data != null;
                String key = data.getString("keyFromIntent");
                String date = data.getString("dateFromIntent");
                String pt_name = data.getString("ptNameFromIntent");
                String price = data.getString("priceFromIntent");
                String fasilityEt = data.getString("facilityFromIntent");
                String departure = data.getString("departureFromIntent");
                String date1 = data.getString("mHomeTextInputDateGo");
                String inputFrom = data.getString("mInputFrom");
                String inputTo = data.getString("mInputTo");

                // Menambahkan data ke Intent
                intent.putExtra("key", key);
                intent.putExtra("date", date);
                intent.putExtra("pt_name", pt_name);
                intent.putExtra("price", price);
                intent.putExtra("fasility", fasilityEt);
                intent.putExtra("departure", departure);

                intent.putExtra("mHomeTextInputDateGo", date1);
                intent.putExtra("mInputFrom", inputFrom);
                intent.putExtra("mInputTo", inputTo);

                startActivity(intent);
                finish();
            }
        });
        boarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boarding.setBackgroundResource(R.color.gray);
                dropping.setBackgroundResource(R.color.white);
                BoardingFragment boardingFragment = BoardingFragment.newInstance(keyBus);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, boardingFragment).commit();
            }
        });

        dropping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boarding.setBackgroundResource(R.color.white);
                dropping.setBackgroundResource(R.color.gray);
                DroppingFragment droppingFragment = DroppingFragment.newInstance(keyBus);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, droppingFragment).commit();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleBusActivity.this, OrderActivity.class);

                // Mendapatkan data dari getIntent()
                Bundle data = getIntent().getExtras();
                assert data != null;
                String key = data.getString("keyFromIntent");
                String date = data.getString("dateFromIntent");
                String pt_name = data.getString("ptNameFromIntent");
                String price = data.getString("priceFromIntent");
                String fasilityEt = data.getString("facilityFromIntent");
                String departure = data.getString("departureFromIntent");
                String date1 = data.getString("mHomeTextInputDateGo");
                String inputFrom = data.getString("mInputFrom");
                String inputTo = data.getString("mInputTo");

                // Menambahkan data ke Intent
                intent.putExtra("key", key);
                intent.putExtra("date", date);
                intent.putExtra("pt_name", pt_name);
                intent.putExtra("price", price);
                intent.putExtra("fasility", fasilityEt);
                intent.putExtra("departure", departure);

                intent.putExtra("mHomeTextInputDateGo", date1);
                intent.putExtra("mInputFrom", inputFrom);
                intent.putExtra("mInputTo", inputTo);

                startActivity(intent);
            }
        });
    }
    
}
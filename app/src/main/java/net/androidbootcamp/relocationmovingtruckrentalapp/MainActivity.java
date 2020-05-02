package net.androidbootcamp.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    float intFootMiles;
    int intTrucks;
    float intFees;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText trucksAll = (EditText)findViewById(R.id.txtFoot);
        final EditText milesFoot = (EditText)findViewById(R.id.txtPaymentMiles);
        final EditText fees = (EditText)findViewById(R.id.txtFee);
        Button rental = (Button)findViewById(R.id.btnRental);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        rental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intTrucks = Integer.parseInt(trucksAll.getText().toString());
                intFootMiles = Float.parseFloat(milesFoot.getText().toString());
                intFees = Float.parseFloat(fees.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intTrucks);
                editor.putFloat("key2", intFootMiles);
                editor.putFloat("key3", intFees);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Rental.class));
            }
        });
    }
}

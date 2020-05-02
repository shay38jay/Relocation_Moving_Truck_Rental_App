package net.androidbootcamp.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Rental extends AppCompatActivity {

    double milesA = 0.99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);

        TextView rentalPayment = (TextView) findViewById(R.id.txtPaymentMiles);
        ImageView image = (ImageView) findViewById(R.id.imgTruck);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intTrucks = sharedPref.getInt("key1", 0);
        float intFootMiles = sharedPref.getFloat("key2", 0);
        float intFees = sharedPref.getFloat("key3", 0);
        float milesOfTotal;

        milesOfTotal = (float) ((intFootMiles * milesA) + intFees);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        rentalPayment.setText("One Day Rental Plus 0.99 cent per Mile is " + currency.format(milesOfTotal));

        if (intTrucks == 10 || intFees == 19.99) {
            image.setImageResource(R.drawable.tenfoot);
        } else if (intTrucks == 17 || intFees == 29.95){
            image.setImageResource(R.drawable.seventeenfoot);
        } else if (intTrucks == 26 || intFees == 39.95) {
            image.setImageResource(R.drawable.twentysixfoot);
        } else {
            rentalPayment.setText("Enter 10ft Truck($19.99), 17ft Truck($29.95), or 26ft Truck" +
                    "($39.95)");
        }

    }
}


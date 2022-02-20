package com.example.a5180_mad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class TicketPriceMainActivity extends AppCompatActivity {

    final String TAG = "checkpoint";

    EditText ticketPriceInput;
    RadioGroup radioGroup;
    TextView discountedPriceOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_price);

        ticketPriceInput = findViewById(R.id.ticket_price_input);
        radioGroup = findViewById(R.id.radioGroup);
        discountedPriceOutput = findViewById(R.id.discounted_price_output);
        setTitle("Ticket Discount Calculator");


        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);


        //OnClick listener for constraintLayou to close keyboard once tapping outisde of editText field.
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: tapped");
                closeKeyboard();
            }
        });


        //Calculate button
        findViewById(R.id.calculate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputPrice = ticketPriceInput.getText().toString();
                double inputAsDouble;
                NumberFormat Newtotal = NumberFormat.getCurrencyInstance();


                Log.d(TAG, "onClick: " + inputPrice);

                try {
                    inputAsDouble = Double.parseDouble(inputPrice);
                } catch(NumberFormatException e){
                    Log.d(TAG, "onClick: NOT DOUBLE");
                    inputAsDouble = 0.001;
                }


                Log.d(TAG, "onClick: " + inputPrice);
                double percentage = 0.0;

                double discountedTotal = 0.00;

                //Set percentage chosen
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_5: percentage = 0.05;
                        break;
                    case R.id.radio_10: percentage = 0.1;
                        break;
                    case R.id.radio_15: percentage = 0.15;
                        break;
                    case R.id.radio_20: percentage = 0.2;
                        break;
                    case R.id.radio_50: percentage = 0.5;
                        break;
                }
                //Validation
                if(inputPrice.isEmpty()){
                    Toast.makeText(getBaseContext(), R.string.user_add_number, Toast.LENGTH_SHORT ).show();
                } else if(inputAsDouble <0.1){
                    clearCalculator();
                    Toast.makeText(getBaseContext(), R.string.user_add_number_greater_than_zero , Toast.LENGTH_SHORT ).show();
                }else if(radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getBaseContext(), R.string.user_choose_radio_button , Toast.LENGTH_SHORT ).show();
                } else {
                    //if all is valid then calculate
                    discountedTotal = (inputAsDouble - (inputAsDouble* percentage));
                }

                //Set the output to the calculated value
                discountedPriceOutput.setText(Newtotal.format(discountedTotal));

            }
        });

        findViewById(R.id.clear_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearCalculator();
            }
        });




    }

    private void closeKeyboard() {
        // this will give us the view
        // which is currently focus
        // in this layout
        View view = this.getCurrentFocus();

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
            InputMethodManager manager
                    = (InputMethodManager)
                    getSystemService(
                            Context.INPUT_METHOD_SERVICE);
            manager
                    .hideSoftInputFromWindow(
                            view.getWindowToken(), 0);
        }
    }

    private void clearCalculator() {
        ticketPriceInput.setText("");
        discountedPriceOutput.setText("$0.00");
    }


}
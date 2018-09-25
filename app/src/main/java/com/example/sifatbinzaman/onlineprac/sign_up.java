package com.example.sifatbinzaman.onlineprac;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class sign_up extends AppCompatActivity {

    EditText etName, etId, etLevel, etCredit, etBirthday;
    Button btnSave, btnShowAll;
    RadioGroup radioGroup;
    CheckBox chk1, chk2,chk3,chk4;


    // needed for datepicker
    Calendar myCalendar = Calendar.getInstance();

    //needed for dropdown menu
    Spinner dropdown;

    String semail, spassword, sname,sid,slevel,scredit,chklevel,sgender, spinner, sbirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etCredit = findViewById(R.id.etCredit);
        etLevel = findViewById(R.id.etLevel);
        btnShowAll = findViewById(R.id.btnShowAll);
        btnSave = findViewById(R.id.btnSave);
        radioGroup = findViewById(R.id.radioGender);
        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        chk4 = findViewById(R.id.chk4);



       //FOR DROPDOWN MENU

        dropdown = findViewById(R.id.spinner1);

        //create a list of items for the spinner.
        String[] items = new String[]{"1", "2", "three"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);




        //

        // For Datepicker

        etBirthday = findViewById(R.id.birthday);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        etBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(sign_up.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    //Datepicker ends

        //FOR Checkbox


        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chk1.isChecked())
                {
                    chklevel = "1";
                }
                else if(chk2.isChecked())
                {
                    chklevel = "2";
                }
                else if(chk3.isChecked())
                {
                    chklevel = "3";
                }
                else if(chk4.isChecked())
                {
                    chklevel = "4";
                }
                else
                {
                    chklevel="";
                }


                //FOR RadioButton

                int i = radioGroup.getCheckedRadioButtonId();
                if (i == findViewById(R.id.radioMale).getId()) {
                    sgender = "Male";
                } else if (i == findViewById(R.id.radioFemale).getId()) {
                    sgender = "Female";
                }


                //passed data from mainActivity

                semail = getIntent().getStringExtra("email");
                spassword = getIntent().getStringExtra("password");

                //etName.setText(semail);
                //

                sname = etName.getText().toString().trim();
                sid = etId.getText().toString().trim();
                slevel = etLevel.getText().toString().trim();
                scredit = etCredit.getText().toString().trim();

                spinner = dropdown.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(), semail + "\n" + spassword + "\n" + sname + "\n" + sid + "\n" + slevel + "\n" +scredit + "\n" +chklevel + "\n" +spinner + "\n" +sbirthday + "\n"+sgender + "\n", Toast.LENGTH_LONG  ).show();
               // System.out.println(semail + "\n" + spassword + "\n" + sname + "\n" + sid + "\n" + slevel + "\n" +scredit + "\n" +chklevel + "\n" +spinner + "\n" +sbirthday + "\n"+sgender + "\n"  );

            }
        });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);


        etBirthday.setText(sdf.format(myCalendar.getTime()));
        sbirthday = etBirthday.getText().toString().trim();
    }

}

package com.example.chuyenform;

import androidx.appcompat.app.AppCompatActivity;

/*import android.content.Context;*/
import android.content.Intent;
import android.os.Bundle;
/*import android.view.View;*/
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNa, edNu;
    TextView lbAg2;
    Switch swGe;
    SeekBar sbAg;
    Spinner spDe;
    CheckBox cbSp;
    RadioButton rdMu, rdRo, rdPo, rdCl;
    Button btRe;
    RadioGroup rdgMu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*edusername.findViewById(R.id.edusername);
        btlogin.findViewById(R.id.btlogin);*/

        edNa = (EditText) findViewById(R.id.edNa);
        edNu = (EditText) findViewById(R.id.edNu);
        swGe = (Switch) findViewById(R.id.swGe);
        swGe.setTextOn("Female");
        swGe.setTextOff("Male");
        lbAg2 = (TextView) findViewById(R.id.lbAg2);
        sbAg = (SeekBar) findViewById(R.id.sbAg);
        sbAg.setMax(130);
        sbAg.setProgress(30);
        spDe = (Spinner) findViewById(R.id.spDe);
        cbSp = (CheckBox) findViewById(R.id.cbSp);
        rdgMu = (RadioGroup) findViewById(R.id.rdgMu);
        /*rdCl =(RadioButton) findViewById(R.id.rdCl);
        rdPo = (RadioButton) findViewById(R.id.rdPo);
        rdRo = (RadioButton) findViewById(R.id.rdRo);*/
        btRe = (Button) findViewById(R.id.btRe);
//spiner:
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.Degree_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDe.setAdapter(adapter);
//seekbar:
        sbAg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                lbAg2.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//Button click:
        btRe.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //set tung thu nhu the nay co ve ton ram
                User user = new User(edNu.getText().toString());
                user.setName(edNa.getText().toString());
                user.setAge((byte)sbAg.getProgress());
                user.setGender(swGe.isChecked());//isChecked == true thi la nu;
                user.setPhoneNumber(edNu.getText().toString());
                user.setLikeSport(cbSp.isChecked());
                rdMu = (RadioButton) findViewById(rdgMu.getCheckedRadioButtonId());
                user.setKindOfMusic(rdMu.getText().toString());
                user.setDegree(spDe.getSelectedItem().toString());

                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user);
                Intent intent = new Intent(getApplicationContext(), Message.class);
                intent.putExtras(bundle);//hoac dung truc tiep putExtra("t",user); khi nao put danh sach lon thi dung bundle
                startActivity(intent);
            }


        });

    }

}
/*<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string-array name="planets_array">
        <item>Mercury</item>
        <item>Venus</item>
        <item>Earth</item>
        <item>Mars</item>
        <item>Jupiter</item>
        <item>Saturn</item>
        <item>Uranus</item>
        <item>Neptune</item>
    </string-array>
</resources>


Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
spinner.setAdapter(adapter);

public class SpinnerActivity extends Activity implements OnItemSelectedListener {
    ...

    public void onItemSelected(AdapterView<?> parent, View view,
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}


Spinner spinner = (Spinner) findViewById(R.id.spinner);
spinner.setOnItemSelectedListener(this);


CHECKBOX
public void onCheckboxClicked(View view) {
    // Is the view now checked?
    boolean checked = ((CheckBox) view).isChecked();

    // Check which checkbox was clicked
    switch(view.getId()) {
        case R.id.checkbox_meat:
            if (checked)
                // Put some meat on the sandwich
            else
                // Remove the meat
            break;
        case R.id.checkbox_cheese:
            if (checked)
                // Cheese me
            else
                // I'm lactose intolerant
            break;
        // TODO: Veggie sandwich
    }
}


*/
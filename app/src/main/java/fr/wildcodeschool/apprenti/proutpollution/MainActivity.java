package fr.wildcodeschool.apprenti.proutpollution;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btn_send_data;
    private EditText lat_edit, lon_edit;



    private String temp_key, lat, lon, strength;
    private DatabaseReference rootCoords = FirebaseDatabase.getInstance().getReference().child("coords");
    private DatabaseReference rootCoord;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView date_text = (TextView) findViewById(R.id.date_text);
        btn_send_data = (Button) findViewById(R.id.btn_send_data);
        lat_edit = (EditText) findViewById(R.id.lat_edit);
        lon_edit = (EditText) findViewById(R.id.lon_edit);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.strength);

        final TextView strengthValue = (TextView) findViewById(R.id.strengthValue);



        btn_send_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = lat_edit.getText().toString();
                lon = lon_edit.getText().toString();
                strength = strengthValue.getText().toString();
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                date_text.setText(date);




                Map<String, Object> map = new HashMap<String, Object>();
                temp_key = rootCoords.push().getKey().toString();
                rootCoords.updateChildren(map);

                Coord mesCoords = new Coord(lat, lon, strength, date);
                rootCoord = rootCoords.child(temp_key);
                rootCoord.setValue(mesCoords);

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar strength, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                strengthValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar strength) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar strength) {
                // TODO Auto-generated method stub
            }
        });
    }


}
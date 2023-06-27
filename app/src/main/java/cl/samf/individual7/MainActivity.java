package cl.samf.individual7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View saludo = findViewById(android.R.id.content);
        saludoinicial(saludo);


        CalendarView calendar = findViewById(R.id.calendarView);
        EditText actividad = findViewById(R.id.editText);
        Button registrar = findViewById(R.id.Registrar);
        TextView textview = findViewById(R.id.textView2);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                textview.setText(selectedDate);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String message = actividad.getText().toString();
                String selectedDate = textview.getText().toString();
                String result = "Fecha: " + selectedDate + "\nMensaje: " + message;
                textview.setText(result);

            }
        });


    }

    private void saludoinicial(View saludo) {
        String mensaje = "Bienvenido a la aplicación de SAMF";
        Snackbar snackbar = Snackbar.make(saludo, mensaje, Snackbar.LENGTH_LONG);
        snackbar.show();

    }
}
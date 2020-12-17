package mx.edu.tesoem.isc.aed.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    TextView dlbmatricula,dlbnombre,dlbpromedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        dlbmatricula = findViewById(R.id.dlblmatricula);
        dlbnombre = findViewById(R.id.dlblnombre);
        dlbpromedio = findViewById(R.id.dlblpromedio);

        String nombre = getIntent().getExtras().get("Nombre").toString();


        getSupportActionBar().setTitle(nombre);
    }
}

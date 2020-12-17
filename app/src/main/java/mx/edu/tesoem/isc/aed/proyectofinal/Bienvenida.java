package mx.edu.tesoem.isc.aed.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Bienvenida extends AppCompatActivity {

    GridView gvDatos;
    EditText matricula,nombre,correo,promedio;
    List<Datos> datos = new ArrayList<>();
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        gvDatos = findViewById(R.id.gvDatos);
        matricula = findViewById(R.id.matricula);
        nombre = findViewById(R.id.nombre);
        correo = findViewById(R.id.correo);
        promedio = findViewById(R.id.promedio);

        Verificar();

    }

    private void Verificar(){
        Control conexion = new Control();
        if (conexion.Existencia(this)){
            if (conexion.Lectura(this)){
                datos = conexion.getDatos();
                adaptador = new Adaptador(datos,this);
                gvDatos.setAdapter(adaptador);
            }else {
                Toast.makeText(this,"Error al leer el archivo", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"No se encontro el archivo, cree uno nuevo", Toast.LENGTH_SHORT).show();
        }
    }

    public void Graba(View v){
        Datos dato = new Datos();
        Control conexion = new Control();

        dato.setMatricula(matricula.getText().toString());
        dato.setNombre(nombre.getText().toString());
        dato.setCorreo(correo.getText().toString());
        dato.setPromedio(promedio.getText().toString());

        datos.add(dato);
        if (conexion.Escritura(this,datos)){
            Toast.makeText(this,"Ingreso correcto",Toast.LENGTH_SHORT).show();
            Verificar();
        }else{
            Toast.makeText(this,"Error al ingresar",Toast.LENGTH_SHORT).show();
        }
    }
}
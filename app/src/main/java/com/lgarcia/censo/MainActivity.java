package com.lgarcia.censo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtDocumento, edtNombre, edtEdad;
    RadioGroup rgSexo, rgDiabetico, rgHipertenso, rgAntecedentes;
    Button btnGuardar;
    ListView listRegistro;

    ArrayList<Censo> listaCenso;
    CensoAdapter adapter;
    long id = 1;
    String documento, nombre, edad, sexo;
    boolean diabetico, hipertenso, antecedente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDocumento = findViewById(R.id.edtDocumento);
        edtNombre = findViewById(R.id.edtNombre);
        edtEdad = findViewById(R.id.edtEdad);
        rgSexo = findViewById(R.id.rgSexo);
        rgDiabetico = findViewById(R.id.rgDiabetico);
        rgHipertenso = findViewById(R.id.rgHipertenso);
        rgAntecedentes = findViewById(R.id.rgAntecedentes);
        btnGuardar = findViewById(R.id.btnGuardar);
        listRegistro = findViewById(R.id.listRegistro);

        listaCenso = new ArrayList();
        adapter = new CensoAdapter(this, listaCenso);
        listRegistro.setAdapter(adapter);

    }

    public void validarYGuardar(View v) {
        int pos = -1;
        documento = edtDocumento.getText().toString();
        if(listaCenso.isEmpty()){
            guardarEnObjeto();
        }else{
            for(int i = 0; i<listaCenso.size(); i++){
                if(listaCenso.get(i).getDocumento().equals(documento)){
                    pos = i;
                    break;
                }
            }
            if(pos == -1){
                guardarEnObjeto();
            }else{
                Toast.makeText(this,
                        "El usuario ha sido censado",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    public void guardarEnObjeto() {

        nombre = edtNombre.getText().toString();
        edad = edtEdad.getText().toString();
        if (rgSexo.getCheckedRadioButtonId() == R.id.rbMasculino) {
            sexo = "Masculino";
        } else if (rgSexo.getCheckedRadioButtonId() == R.id.rbFemenino) {
            sexo = "Femenino";
        } else if (rgSexo.getCheckedRadioButtonId() == R.id.rbOtro) {
            sexo = "Otro";
        }
        if(rgDiabetico.getCheckedRadioButtonId() == R.id.rbDiabeticoSi){
            diabetico = true;
        }else{
            diabetico = false;
        }
        if(rgHipertenso.getCheckedRadioButtonId() == R.id.rbHipertensoSi){
            hipertenso = true;
        }else{
            hipertenso = false;
        }
        if(rgAntecedentes.getCheckedRadioButtonId() == R.id.rbAntecedentesSi){
            antecedente = true;
        }else{
            antecedente = false;
        }
        listaCenso.add(new Censo(id,documento,
                nombre,edad,sexo,diabetico,
                hipertenso,antecedente));
        adapter.notifyDataSetChanged();
        Toast.makeText(this,
                "Datos Guardados",
                Toast.LENGTH_LONG).show();

    }
}


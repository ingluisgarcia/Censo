package com.lgarcia.censo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CensoAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<Censo> listado;

    public CensoAdapter(Activity activity,
                        ArrayList<Censo> listado){
        this.activity = activity;
        this.listado = listado;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public Object getItem(int position) {
        return listado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listado.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView ==null){
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE);
            v= inflater.inflate(R.layout.listado,null);
        }

        TextView txtNombre = v.findViewById(R.id.txtNombre);
        TextView txtDocumento = v.findViewById(R.id.txtDocumento);
        TextView txtEdad = v.findViewById(R.id.txtEdad);
        TextView txtSexo = v.findViewById(R.id.txtSexo);
        TextView txtDiabetico = v.findViewById(R.id.txtDiabetico);
        TextView txtHipertenso = v.findViewById(R.id.txtHipertenso);
        TextView txtAntecedentes = v.findViewById(R.id.txtAntecedentes);

        txtDocumento.setText("Documento: "+listado.get(position).getDocumento());
        txtNombre.setText("Nombre: "+listado.get(position).getNombre());
        txtEdad.setText("Edad: "+listado.get(position).getEdad());
        txtSexo.setText("Sexo: "+listado.get(position).getSexo());
        txtDiabetico.setText(listado.get(position).isDiabetes());
        txtHipertenso.setText(listado.get(position).isHipertenso());
        txtAntecedentes.setText(listado.get(position).isAntecedentes());
        return v;
    }
}

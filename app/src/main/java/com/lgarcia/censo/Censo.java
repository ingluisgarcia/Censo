package com.lgarcia.censo;

public class Censo {
    private long id;
    private String documento;
    private String nombre;
    private String edad;
    private String sexo;
    private boolean diabetes;
    private boolean hipertenso;
    private boolean antecedentes;

    public Censo(long id, String documento, String nombre,
                 String edad, String sexo, boolean diabetes,
                 boolean hipertenso, boolean antecedentes){
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.diabetes = diabetes;
        this.hipertenso = hipertenso;
        this.antecedentes = antecedentes;
    }

    public long getId(){
        return id;
    }

    public String getDocumento(){
        return documento;
    }
    public String getNombre(){
        return nombre;
    }
    public String getEdad(){
        return edad;
    }
    public String getSexo(){
        return sexo;
    }
    public String isDiabetes(){
        if(diabetes){
            return "Si";
        }else{
            return "No";
        }
    }
    public String isHipertenso(){
        if(hipertenso){
            return "Si";
        }else{
            return "No";
        }
    }
    public String isAntecedentes(){
        if(antecedentes){
            return "Si";
        }else{
            return "No";
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoGym;

import java.time.LocalDate;
import modelo.Cliente;
import retoGym.Reto;

/**
 *
 * @author Yiam Rodriguez - Karina Ortega 
 */
public class Ficha {
    //Atributos de la clase ficha
    private float i_MasaCorporal;
    private float i_MasaMuscular;
    private float i_GrasaCorporal;
    private float medidasAntro;
    private String testBurpee;
    private int maxSentadilla;
    private float flexibilidad;
    private float frecuenciaCardiaca;
    private float presionArterial;
    private float perfilLipidico;
    private int trote;
    private LocalDate fechaIngreso;
    
    //Cosntructores de la clase Ficha
    public Ficha(){  
    }

    public Ficha(float i_MasaCorporal, float i_MasaMuscular, float i_GrasaCorporal, float medidasAntro, String testBurpee, int maxSentadilla, float flexibilidad, float frecuenciaCardiaca) {
        this.i_MasaCorporal = i_MasaCorporal;
        this.i_MasaMuscular = i_MasaMuscular;
        this.i_GrasaCorporal = i_GrasaCorporal;
        this.medidasAntro = medidasAntro;
        this.testBurpee = testBurpee;
        this.maxSentadilla = maxSentadilla;
        this.flexibilidad = flexibilidad;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.fechaIngreso = LocalDate.now();
    }
    public Ficha(float i_MasaCorporal, float i_MasaMuscular, float i_GrasaCorporal, float medidasAntro, int maxSentadilla, float flexibilidad, float frecuenciaCardiaca, float presionArterial, float perfilLipidico, int trote) {
        this.i_MasaCorporal = i_MasaCorporal;
        this.i_MasaMuscular = i_MasaMuscular;
        this.i_GrasaCorporal = i_GrasaCorporal;
        this.medidasAntro = medidasAntro;
        this.maxSentadilla = maxSentadilla;
        this.flexibilidad = flexibilidad;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.presionArterial = presionArterial;
        this.perfilLipidico = perfilLipidico;
        this.trote = trote;
        this.fechaIngreso = LocalDate.now();
    }
    
    //Metodos Getters&Setters
    public float getI_MasaCorporal() {
        return i_MasaCorporal;
    }

    public void setI_MasaCorporal(float i_MasaCorporal) {
        this.i_MasaCorporal = i_MasaCorporal;
    }

    public float getI_MasaMuscular() {
        return i_MasaMuscular;
    }

    public void setI_MasaMuscular(float i_MasaMuscular) {
        this.i_MasaMuscular = i_MasaMuscular;
    }

    public float getI_GrasaCorporal() {
        return i_GrasaCorporal;
    }

    public void setI_GrasaCorporal(float i_GrasaCorporal) {
        this.i_GrasaCorporal = i_GrasaCorporal;
    }

    public float getMedidasAntro() {
        return medidasAntro;
    }

    public void setMedidasAntro(float medidasAntro) {
        this.medidasAntro = medidasAntro;
    }

    public String getTestBurpee() {
        return testBurpee;
    }

    public void setTestBurpee(String testBurpee) {
        this.testBurpee = testBurpee;
    }

    public int getMaxSentadilla() {
        return maxSentadilla;
    }

    public void setMaxSentadilla(int maxSentadilla) {
        this.maxSentadilla = maxSentadilla;
    }

    public float getFlexibilidad() {
        return flexibilidad;
    }

    public void setFlexibilidad(float flexibilidad) {
        this.flexibilidad = flexibilidad;
    }

    public float getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(float frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public float getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(float presionArterial) {
        this.presionArterial = presionArterial;
    }

    public float getPerfilLipidico() {
        return perfilLipidico;
    }

    public void setPerfilLipidico(float perfilLipidico) {
        this.perfilLipidico = perfilLipidico;
    }

    public int getTrote() {
        return trote;
    }

    public void setTrote(int trote) {
        this.trote = trote;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    //Metodos toString que nos ayudará a imprimir las carcateristicas que se desean
    public String toString2() {
        return "Ficha{" + "Indice de Masa corporal=" + i_MasaCorporal + ", indice de masa muscular=" + i_MasaMuscular + ", indice de GrasaCorporal=" + i_GrasaCorporal + ", Medidas Antropometricas=" + medidasAntro +  ", maxSentadilla 1 min=" + maxSentadilla + ", flexibilidad=" + flexibilidad + ", frecuenciaCardiaca=" + frecuenciaCardiaca +", presionArterial=" + presionArterial + ", perfilLipidico=" + perfilLipidico + ", trote=" + trote + ", fechaIngreso=" + fechaIngreso + '}';
    }
    
    public String toString1() {
        return "Ficha{" + "Indice de Masa corporal=" + i_MasaCorporal + ", indice de masa muscular=" + i_MasaMuscular + ", indice de GrasaCorporal=" + i_GrasaCorporal + ", Medidas Antropometricas=" + medidasAntro + ", maxSentadilla 1 min=" + maxSentadilla + ", flexibilidad=" + flexibilidad + ", frecuenciaCardiaca=" + frecuenciaCardiaca +'}';
    }

    public Ficha consultarFicha(String idReto,String idUsuario){
        Categoria c= new Categoria();
        if(c.buscarInscritoReto(idReto, idUsuario)!=null){
            Cliente c1=c.buscarInscritoReto(idReto, idUsuario);
            return c1.getFicha();
        }
        return null;
    }
    public Ficha ingresarFicha1(){
        Ficha f= new Ficha(0f, 0f, 0f, 0f, "no ha ingresado datos", 0, 0, 0);
        return  f;
    }
    
    public Ficha ingresarFicha2(){
        Ficha f= new Ficha(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        return  f;
    }
    
}

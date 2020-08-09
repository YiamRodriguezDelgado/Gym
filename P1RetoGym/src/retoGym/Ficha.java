/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoGym;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import modelo.Cliente;
import retoGym.Reto;

/**
 *
 * @author Yiam Rodriguez - Karina Ortega 
 */
public class Ficha {
    //Atributos de la clase ficha
    private String i_MasaCorporal;
    private String i_MasaMuscular;
    private String i_GrasaCorporal;
    private String medidasAntro;
    private String testBurpee;
    private String maxSentadilla;
    private String flexibilidad;
    private String frecuenciaCardiaca;
    private String presionArterial;
    private String perfilLipidico;
    private String trote;
    private LocalDate fechaIngreso;
    
    //Cosntructores de la clase Ficha
    public Ficha(){  
    }
     public Ficha(String i_MasaCorporal, String i_MasaMuscular, String i_GrasaCorporal, String medidasAntro, String testBurpee, String maxSentadilla, String flexibilidad, String frecuenciaCardiaca, LocalDate fechaIngreso) {
        this.i_MasaCorporal = i_MasaCorporal;
        this.i_MasaMuscular = i_MasaMuscular;
        this.i_GrasaCorporal = i_GrasaCorporal;
        this.medidasAntro = medidasAntro;
        this.testBurpee = testBurpee;
        this.maxSentadilla = maxSentadilla;
        this.flexibilidad = flexibilidad;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
//        LocalDate localDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedDate = localDate.format(formatter);
//        LocalDate f = LocalDate.parse(formattedDate.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.fechaIngreso=fechaIngreso;
         
   }
    public Ficha(String i_MasaCorporal, String i_MasaMuscular, String i_GrasaCorporal, String medidasAntro, String testBurpee, String maxSentadilla, String flexibilidad, String frecuenciaCardiaca) {
        this.i_MasaCorporal = i_MasaCorporal;
        this.i_MasaMuscular = i_MasaMuscular;
        this.i_GrasaCorporal = i_GrasaCorporal;
        this.medidasAntro = medidasAntro;
        this.testBurpee = testBurpee;
        this.maxSentadilla = maxSentadilla;
        this.flexibilidad = flexibilidad;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
//        LocalDate localDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedDate = localDate.format(formatter);
//        LocalDate f = LocalDate.parse(formattedDate.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.fechaIngreso=LocalDate.now();
         
   }
    public Ficha(String i_MasaCorporal, String i_MasaMuscular, String i_GrasaCorporal, String medidasAntro, String maxSentadilla, String flexibilidad, String frecuenciaCardiaca, String presionArterial, String perfilLipidico, String trote) {
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
        
//        LocalDate localDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedDate = localDate.format(formatter);
//        
//        LocalDate f = LocalDate.parse(formattedDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.fechaIngreso=LocalDate.now();
        
       
        
    }

    public String getI_MasaCorporal() {
        return i_MasaCorporal;
    }

    public void setI_MasaCorporal(String i_MasaCorporal) {
        this.i_MasaCorporal = i_MasaCorporal;
    }

    public String getI_MasaMuscular() {
        return i_MasaMuscular;
    }

    public void setI_MasaMuscular(String i_MasaMuscular) {
        this.i_MasaMuscular = i_MasaMuscular;
    }

    public String getI_GrasaCorporal() {
        return i_GrasaCorporal;
    }

    public void setI_GrasaCorporal(String i_GrasaCorporal) {
        this.i_GrasaCorporal = i_GrasaCorporal;
    }

    public String getMedidasAntro() {
        return medidasAntro;
    }

    public void setMedidasAntro(String medidasAntro) {
        this.medidasAntro = medidasAntro;
    }

    public String getTestBurpee() {
        return testBurpee;
    }

    public void setTestBurpee(String testBurpee) {
        this.testBurpee = testBurpee;
    }

    public String getMaxSentadilla() {
        return maxSentadilla;
    }

    public void setMaxSentadilla(String maxSentadilla) {
        this.maxSentadilla = maxSentadilla;
    }

    public String getFlexibilidad() {
        return flexibilidad;
    }

    public void setFlexibilidad(String flexibilidad) {
        this.flexibilidad = flexibilidad;
    }

    public String getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public String getPerfilLipidico() {
        return perfilLipidico;
    }

    public void setPerfilLipidico(String perfilLipidico) {
        this.perfilLipidico = perfilLipidico;
    }

    public String getTrote() {
        return trote;
    }

    public void setTrote(String trote) {
        this.trote = trote;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
 
  
    
    


//    @Override
//    public String toString() {
//        return 
//                "\n" +
//                "Indice de Masa Corporal: " + i_MasaCorporal+"\n" + 
//                "Indice de masa muscular: " + i_MasaMuscular+"\n" + 
//                "Indice de grasa corporal: " + i_GrasaCorporal+"\n" +
//                "Medidas antropometricas: " + medidasAntro+"\n" + 
//                "Test Burpee=" + testBurpee + 
//                "Max Sentadilla 1 min: " + maxSentadilla+"\n" + 
//                "Flexibilidad=" + flexibilidad + "\n" +
//                "FrecuenciaCardiaca: " + frecuenciaCardiaca+"\n" + 
//                "PresioncArterial: " + presionArterial+"\n" + 
//                "Perfil Lipidico: " + perfilLipidico+"\n" + 
//                "Trote: " + trote+"\n" + 
//                "FechaIngreso: " + fechaIngreso+"\n";
//    }

     public String toString1() {
        return 
                "\n" +
                "Indice de Masa Corporal: " + i_MasaCorporal+"\n" + 
                "Indice de masa muscular: " + i_MasaMuscular+"\n" + 
                "Indice de grasa corporal: " + i_GrasaCorporal+"\n" +
                "Medidas antropometricas: " + medidasAntro+"\n" + 
                "Test Burpee: " + testBurpee+"\n" + 
                "Max Sentadilla 1 min: " + maxSentadilla+"\n" + 
                "Flexibilidad=" + flexibilidad + "\n" +
                "FrecuenciaCardiaca: " + frecuenciaCardiaca+"\n" + 
                "FechaIngreso: " + fechaIngreso+"\n";
    }
     public String toString2() {
        return 
                "\n"+
                "Indice de Masa Corporal: " + i_MasaCorporal+"\n" + 
                "Indice de masa muscular: " + i_MasaMuscular+"\n" + 
                "Indice de grasa corporal: " + i_GrasaCorporal+"\n" +
                "Medidas antropometricas: " + medidasAntro+"\n" + 
                
                "Max Sentadilla 1 min: " + maxSentadilla+"\n" + 
                "Flexibilidad: " + flexibilidad + "\n" +
                "FrecuenciaCardiaca: " + frecuenciaCardiaca+"\n" + 
                "PresioncArterial: " + presionArterial+"\n" + 
                "Perfil Lipidico: " + perfilLipidico+"\n" + 
                "Trote: " + trote+"\n" + 
                "FechaIngreso: " + fechaIngreso+"\n";
    }
   Reto reto= new Reto(); 
   public boolean dispFichaInicial(Reto r){
      
       LocalDate inicioReto= r.getFechaInicio_Reto().plusDays(7);
       LocalDate fecha= LocalDate.now();
      int valor=fecha.compareTo(inicioReto);
      if(valor<0){
          return true;
      }
      return false;       
   }
   public boolean dispFichaFinal(Reto r){
       
       LocalDate cierreReto= r.getFechaCierre_Reto().plusDays(7);
       LocalDate fecha= LocalDate.now();
      int valor=fecha.compareTo(cierreReto);
      if(valor<0){
          return true;
      }
    return false;
   }
}

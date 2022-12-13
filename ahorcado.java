/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Locale;
import java.util.*;

/**
 *
 * @author oscarloha
 */
public class ahorcado {
    /*
    6. Juego Ahorcado: Crear una clase Ahorcado (como el juego), la cual deberá contener como
atributos, un vector con la palabra a buscar, la cantidad de letras encontradas y la cantidad
jugadas máximas que puede realizar el usuario. Definir los siguientes métodos con los
parámetros que sean necesarios:
• Constructores, tanto el vacío como el parametrizado.
• Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima. Con
la palabra del usuario, pone la longitud de la palabra, como la longitud del vector.
Después ingresa la palabra en el vector, letra por letra, quedando cada letra de la
palabra en un índice del vector. Y también, guarda en cantidad de jugadas máximas, el
valor que ingresó el usuario y encontradas en 0.
• Método longitud(): muestra la longitud de la palabra que se debe encontrar. Nota:
buscar como se usa el vector.length.
• Método buscar(letra): este método recibe una letra dada por el usuario y busca sila
letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.
• Método encontradas(letra): que reciba una letra ingresada por el usuario y muestre
cuantas letras han sido encontradas y cuantas le faltan. Este método además deberá
devolver true si la letra estaba y false si la letra no estaba, ya que, cada vez que se
busque una letra que no esté, se le restará uno a sus oportunidades.
• Método intentos(): para mostrar cuantas oportunidades le queda al jugador.
• Método juego(): el método juego se encargará de llamar todos los métodos
previamente mencionados e informará cuando el usuario descubra toda la palabra o
se quede sin intentos. Este método se llamará en el main.
    */
    
    private String[] Palabra;
    private String[] PalabraAux;
    private int cantEncontradas;
    private int intentos;

    public ahorcado() {
    }

    public ahorcado(String[] Palabra, int cantEncontradas, int intentos) {
        this.Palabra = Palabra;
        this.cantEncontradas = cantEncontradas;
        this.intentos = intentos;
    }

    public String[] getPalabra() {
        return Palabra;
    }

    public void setPalabra(String[] Palabra) {
        this.Palabra = Palabra;
    }

    public int getCantEncontradas() {
        return cantEncontradas;
    }

    public void setCantEncontradas(int cantEncontradas) {
        this.cantEncontradas = cantEncontradas;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

   public void crearJuego(){
      Scanner leer = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
      
       System.out.println("Ingrese la palabra del ahorcado: ");
      String frase = leer.next();
      
       System.out.println("Cuantas oportunidades quieres tener? ");
       this.intentos = leer.nextInt();
       
      this.Palabra=new String[frase.length()];
      this.PalabraAux=new String[frase.length()];
      
       for (int i = 0; i < frase.length(); i++) {
           
           this.Palabra[i]=frase.substring(i, i+1);
           this.PalabraAux[i]="-";
           
       }
      
   }
    
    public void longitud(){
        System.out.println("La longitud de la palabra es: " + this.Palabra.length);
    }
    
    public boolean buscarLetra(String Letra){
        int cont = 0;
        boolean band = false;
        for (int i = 0; i < this.Palabra.length; i++) {
            if(this.Palabra[i].equals(Letra)){
                cont++;
            }
        }
        
        if (cont == 0){
            System.out.println("La letra " + Letra + " No se encuentra en la palabra");
        }else{
            System.out.println("La letra " + Letra + "  se encuentra en la palabra, un total de: " + cont + " veces");
        }
        return band;
    }
    
    public boolean encontradas(String Letra){
        boolean band = false;
        for (int i = 0; i < this.Palabra.length; i++) {
            if(this.Palabra[i].equals(Letra)){
                if(this.PalabraAux.equals("-")){
                    this.Palabra[i] = Letra;
                    this.cantEncontradas++;
                }
                band = true;
            }
        }
        if (!band){
           this.cantEncontradas--; 
        }
        return buscarLetra(Letra);
    }
    
    public void intentos(){
        System.out.println("le quedan  intentos " + this.intentos);
    }
    public void mostrar(){
        for (int i = 0; i < this.Palabra.length; i++) {
            System.out.print(this.PalabraAux[i]);
        }
        System.out.println("");
    }
    public void juego(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        String letra;
        crearJuego();
        do{
            mostrar();
            intentos();
            longitud();
            System.out.println("Ingrese la letra que desea buscar");
            letra = leer.next();
            encontradas(letra);
            
        }while (this.intentos != 0 || this.cantEncontradas == this.Palabra.length);
        
        if(this.cantEncontradas == this.Palabra.length){
            System.out.println("Palabra encontrada");
            mostrar();
        }else{
            System.out.println("Palabra no encontrada");
        }
        
    }
    
}

package Proyecto;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


/**
 *
 * @author Jeiel
 */
public class DExponencial {
    
    public int nClientes;
    public double tiempoExp;
    public int estandarCalidad;
    public LinkedList <Integer> arrClientes;
    public LinkedList <Double> arrRi;
    public LinkedList <String> arrVi;
    public LinkedList <Double> arrTi;
    public LinkedList <Double> arrTr;
    public LinkedList <String> arrEstandar;
    public LinkedList <Double> arrTif;
    
    public DExponencial()
    {
        
        this.arrClientes=new LinkedList<Integer>();
        this.arrRi=new LinkedList<Double>();
        this.arrVi=new LinkedList<String>();
        this.arrTi=new LinkedList<Double>();
        this.arrTr=new LinkedList<Double>();
        this.arrEstandar=new LinkedList<String>();
        this.arrTif=new LinkedList<Double>();
    }
    
    public void genArrClientes() {
        
        for (int cliente=0;cliente<this.nClientes;cliente++)
            this.arrClientes.add(cliente+1);
        
    }
    
    public void genArrRi(){
        this.genArrClientes();
        
        for (int ri=0;ri<this.nClientes;ri++)
            this.arrRi.add(Double.parseDouble(String.format("%.4f", Math.random())));
    }
    
    public void genArrVi(){
    this.genArrRi();
    for(int vi=0;vi<this.nClientes;vi++)
        this.arrVi.add(-this.tiempoExp + "ln(1-"+this.arrRi.get(vi)+")");
    }
    
    public void genArrTi(){
    this.genArrVi();
    for (int ti=0; ti<this.nClientes;ti++){
        
        this.arrTi.add(Double.parseDouble(String.format("%.4f", (-this.tiempoExp*Math.log(1-this.arrRi.get(ti))))));
        this.arrTr.add(Double.parseDouble(String.format("%.2f",this.genArrTr(this.arrTi.get(ti)))));
        }
    
    }
    
    public double genArrTr(double tiempo){
        int entero=(int)tiempo;
        double decimales=tiempo-entero;
        
        decimales=Double.parseDouble(String.format("%.2f", decimales*60/100));
        
        tiempo=entero+decimales;
        
        return tiempo;
    
    }
    
    public void genArrTif()
    {
        this.genArrTi();
        this.arrTif.add(0.0);
        double suma;
        int entero;
        double decimal;
        for (int i=0;i<this.nClientes;i++)
        {
            suma= Double.parseDouble(String.format("%.2f", this.arrTif.get(i) + this.arrTr.get(i)));
            
            entero=(int) suma;
            decimal=suma - entero;
            
            if(decimal > 0.60)
            {
                decimal = decimal-0.60;
                entero+=1;
                
                decimal= entero+decimal;
                this.arrTif.add(Double.parseDouble(String.format("%.2f", decimal)));
            }
            else
                this.arrTif.add(suma);
        }
    
    }
    public void generarDistribucion(){
        Scanner leer= new Scanner(System.in);
        
        System.out.println("Cuantos clientes: ");
        nClientes=leer.nextInt();
        System.out.println("Tiempo exponencial: ");
        tiempoExp=leer.nextDouble();
        
        this.genArrTif();
    }
    
    public void verResultadosDE(){
        System.out.println("\n **RESULTADOS DISTRIBUCION ** \n");
        
        Scanner leer= new Scanner(System.in);
        String r;        
            System.out.println("¿Deseas ver los resultados de la\ndistribucion exponencial?\n s/si n/no 3/salir");
            
            r=leer.nextLine();                    
            switch(r)
            {
            
                case "s":
                    this.mostrarArreglos("Numeros Aleatorios:  ", this.arrRi);
                    this.mostrarArreglos("Tiempo Ti: ", this.arrTi);
                    this.mostrarArreglos("Tiempo Real: ", this.arrTr);
                    this.mostrarArreglos("Tiempo de espera en la finla\npara cada uno de los clientes:  ", this.arrTif);
                    break;
                   
                default:
                    break;
    }
    }
    
    public void mostrarArreglos(String etiqueta, LinkedList arr)
    {
        
        String caja="";
        caja+= etiqueta;
        for(int dato=0;dato<arr.size();dato++)
        {
            caja+="\n"+(dato+1)+".- "+arr.get(dato);
        }
        System.out.println(caja);
        System.out.println("**************************");
    
    }
    
    
}

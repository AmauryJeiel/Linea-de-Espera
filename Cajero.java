package Proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Jeiel
 */
public class Cajero extends DExponencial{
    
    final private int LIMCAJAS=10;
    public int cajasAbiertas;
    
    public LinkedList <Integer> clientes;
    public LinkedList <Double> tiempoXCliente;
    public LinkedList <Double> tiempoXCliente2=arrTr;
    
    public ArrayList <LinkedList <Double>> matriz;
    public ArrayList <LinkedList <String>> matrizE;
    Scanner leer=new Scanner(System.in);
    boolean bandera=true;
    
    public Cajero(int cajas)
    {
        this.cajasAbiertas=cajas;
        this.clientes=new LinkedList<Integer>();
        this.tiempoXCliente=new LinkedList<Double>();
        
        this.clientes=this.arrClientes;
        this.tiempoXCliente=this.arrTr; 
        
        
        matriz=new ArrayList<LinkedList<Double>>();
        matrizE=new ArrayList<LinkedList<String>>();
        
        while (bandera=true){
            
            if(cajas>this.LIMCAJAS){
                System.out.println("El limite de las cajas es 10\nIngresa el numero de cajas a abrir");
                cajas=leer.nextInt();  
                this.cajasAbiertas=cajas;
                bandera=true;
                }
                else{
                    for(int i=0;i<cajas;i++){
                        this.matriz.add(new LinkedList<Double>());
                        this.matrizE.add(new LinkedList<String>());
                    }
                    break;
                    }          
        }
                generarDistribucion();
    }
    
    public void antenderC()
    {       
        verResultadosDE();
        
            System.out.println("\n\n**COMIENZA LINEA DE ESPERA**\n\n");
            System.out.println(this.tiempoXCliente);
            System.out.println("*****************");

            if(this.cajasAbiertas> this.nClientes)
            {
                int cont=1;
                double dato;
                for (int caja=0;caja<this.cajasAbiertas;caja++)
                {
                    if(this.tiempoXCliente.peek() == null)
                    {
                        break;
                    }
                    else{
                        dato=this.tiempoXCliente.pop();
                        this.matriz.get(caja).add(dato);
                        this.matrizE.get(caja).add(((cont++)+" cliente."));
                        
                    }
                }
                System.out.println(this.matriz);
            }    
            
            else{
            double dato;
            int cont=1;
            for (int caja=0;caja<this.cajasAbiertas;caja++)
            {
                dato=this.tiempoXCliente.pop();
                this.matriz.get(caja).add(dato);
                this.matrizE.get(caja).add(((cont++)+" cliente."));
            }
            System.out.println(this.matriz);
            System.out.println("*********************");
            }

        
        removeMin();
    }
    
    private void removeMin(){
        
        int tamanio=this.tiempoXCliente.size();
        for(int c=0;c<tamanio;c++)
        {
        
            LinkedList <Double> arrMenores=new LinkedList<Double>();
            int posicion=0;
            double menor;
            
            for (int i=0;i<this.cajasAbiertas;i++)
            {
                arrMenores.add(Collections.min(this.matriz.get(i)));
                
            }
            System.out.println(arrMenores);
            

            menor=Collections.min(arrMenores);
            System.out.println(menor);

            for(int i=0;i<this.cajasAbiertas;i++)
            {
                if(menor == arrMenores.get(i)){
                    posicion=i;
                    double resta;
                    System.out.println("Posicion donde se encuentra el menor: "+posicion);
                    for(int j=0;j<this.cajasAbiertas;j++)
                    {
                        resta= Double.parseDouble(String.format("%.2f", this.matriz.get(j).peek() - menor));
                        this.matriz.get(j).pop();
                        this.matriz.get(j).add(resta);
                    }
                    System.out.println(this.matriz);
                    break;
                }
            }

            this.matriz.get(posicion).pop();

            this.matriz.get(posicion).add(this.tiempoXCliente.pop());
            this.matrizE.get(posicion).add(((c+1)+this.cajasAbiertas)+" cliente.");
            
            System.out.println("***********************************************");
     
        }
        System.out.println(this.matriz);
        System.out.println(this.matrizE);
        
        this.mostrarResultados();
        
    }
    
    private void mostrarResultados()
    {
        String caja="";
        for(int columna=0;columna<this.cajasAbiertas;columna++)
        {
            caja+="\nCAJA: "+ (columna+1);
            for(int fila=0;fila<this.matrizE.get(columna).size();fila++)
            {
                caja+="\n"+matrizE.get(columna).get(fila);
            }
            
         caja +="\n***************************\n";
        }
        System.out.println(caja);
        
        
        
    
        
    }
    
    
    
    
    
}

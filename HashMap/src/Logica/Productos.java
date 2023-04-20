/**
 * 
 */
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Productos {
	public static void main(String[] args) {

	    HashMap<String,Integer> listaProductos = new HashMap<String,Integer>();
	    //Scanner sc = new Scanner(System.in);
	    int opcionElegida = 0;
	    int precio;
	    String codigo;

	    while (opcionElegida != 5) {
	               opcionElegida = Integer.parseInt(
	                JOptionPane.showInputDialog(
	                        null,"MENÚ PRINCIPAL"+"\n"+
	                             "1. Ingresar Producuto"+"\n"+
	                             "2. Modificar Precio"+"\n"+
	                             "3. Consultar Producutos"+"\n"+
	                             "4. Eliminar Producuto"+"\n"+
	                             "5. Salir"+"\n"+
	                             "Digite la Opción:"));
	        switch (opcionElegida) {
	            case 1:
	                
	                //System.out.println("Introduce el códido del producto:");
	                codigo = JOptionPane.showInputDialog(null,"Digite el código:");
	                precio = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el precio:"));
	                guardarProducto(codigo, precio, listaProductos);
	                break;
	            case 2:
	                //System.out.println("Introduce el códido del producto del que quieres cambiar el precio:");
	                codigo = JOptionPane.showInputDialog(null,"Digite el código:");
	                modificaPrecio(codigo, listaProductos);
	                break;
	            case 3:
	                mostrarProductos(listaProductos);
	                break;
	            case 4:
	                //System.out.println("Introduce el códido del producto que quieres eliminar:");
	                codigo = JOptionPane.showInputDialog(null,"Digite el código:");
	                eliminaProducto(codigo, listaProductos);
	                break;
	                case 5:
	                break;   // Si la opcion es 5 no se hace nada 
	            default:
	                System.out.println("opción no valida");
	        }

	    }
	    
	    }
	    
	    public static void guardarProducto(String codigo, int precio, HashMap <String,Integer> listaProductos){
	    if (listaProductos.containsKey(codigo)) {
	        System.out.println("No se puede introducir el producto. El código esta repetido.");
	    } else {
	        listaProductos.put(codigo, precio);               
	    }
	   }
	    		
	    public static void modificaPrecio(String codigo, HashMap<String,Integer> listaProductos){
	    Scanner sc = new Scanner(System.in);
	    int precio;
	    if (listaProductos.containsKey(codigo)) {
	        System.out.println("Introduce el precio del producto:");
	        precio = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el precio:"));
	        listaProductos.put(codigo, precio);            
	    } else {
	        System.out.println("No hay ningun producto con ese código.");
	    }
	   }
	    public static void mostrarProductos(HashMap<String, Integer> listaProductos) {
	    String clave;
	    Iterator<String> productos = listaProductos.keySet().iterator();
	    System.out.println("Hay los siguientes productos:");
	    while(productos.hasNext()){
	        clave = productos.next();
	        System.out.println(clave + " - " + listaProductos.get(clave));
	    }        
	}

	public static void eliminaProducto(String codigo, HashMap<String,Integer> listaProductos) {
	    if (listaProductos.containsKey(codigo)) {
	        listaProductos.remove(codigo);
	    } else {
	        System.out.println("No hay ningun producto con ese código.");  
	    }       
	} 

}

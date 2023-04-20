/**
 * 
 */
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.sun.jdi.request.ModificationWatchpointRequest;

/**
 * @author GonzalezHDanielaA
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		HashMap<String, Float> listaProductos = new HashMap<String,Float>();
		Scanner datos = new Scanner(System.in);
		int opcionElegida = 0;
		float precio;
		String codigo;
		
		while(opcionElegida != 5)
		{
			System.out.println("Introduce el numero de la opción que quieras");
			System.out.println("1.-Introducir producto");
			System.out.println("2.-Modificar precio");
			System.out.println("3.-Mostrar todos los productos");
			System.out.println("4.-Eliminar producto");
			System.out.println("5.-Salir");
			opcionElegida = datos.nextInt();
			
			switch(opcionElegida)
			{
			case 1:
				System.out.println("Introduce el código del producto");
				codigo = datos.next();
				System.out.println("Introduce el precio del producto");
				precio = datos.nextFloat();
				guardarProducto(codigo, precio, listaProductos);
				break;
			case 2:
				System.out.println("introduce el código del produto del que quieres cambiar el precio");
				codigo = datos.next();
				modificarPrecio(codigo, listaProductos);
				break;
			case 3:
				mostrarProductos(listaProductos);
				break;
				
			case 4:
				System.out.println("Introduce el código del producto que quieres eliminar: ");
				codigo = datos.next();
				eliminarProducto(codigo, listaProductos);
				break;
			case 5:
				break;
			default:
				System.out.println("Tienes que introducir una opción válida");
			}	
		}
	}
	
	
	public static void guardarProducto(String codigo,float precio, HashMap <String,Float> listaProductos)
	{
		if(listaProductos.containsKey(codigo))
		{
			System.out.println("No se puede introducir el producto. El código esta repetido");	
		}else {
			listaProductos.put(codigo, precio);
		}
	}
	
	public static void modificarPrecio(String codigo, HashMap<String,Float> listaProductos)
	{
		Scanner dato = new Scanner(System.in);
		
		if(listaProductos.containsKey(codigo)) {
			System.out.println("Introduce el precio dewl producto");
			listaProductos.put(codigo, dato.nextFloat());
		}else {
			System.out.println("No hay ningún producto con ese código");
		}
	}

	public static void mostrarProductos(HashMap<String,Float> listaProductos)
	{
		String clave;
		Iterator<String> productos = listaProductos.keySet().iterator();
		System.out.println("Hay los siguientes productos");
		while(productos.hasNext())
		{
			clave = productos.next();
			System.out.println(clave + "- "+ listaProductos.get(clave));
		}
		
	}

	public static void mostrarProductos2(HashMap<String,Float> listaProductos)
	{
		Iterator iterator = listaProductos.entrySet().iterator();
		
		Map.Entry producto;
		while(iterator.hasNext())
		{
			producto = (Map.Entry) iterator.next();
			System.out.println(producto.getKey() + " -"+producto.getValue());
		}
	}
	
	public static void eliminarProducto(String codigo, HashMap<String,Float> listaProductos)
	{
		if(listaProductos.containsKey(codigo)) 
		{
			listaProductos.remove(codigo);
		}
		else {
			System.out.println("No hay ningún producto con ese código");
		}
	}
	
	
	
}


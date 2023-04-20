/**
 * 
 */
package Logica;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * @author GonzalezHDanielaA
 *
 */
public class TareaClase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<String, String> listaPersonas=new HashMap<String,String>();
		
		int opcionElegida =0;
		String identificacion;
		String nombre;
		
		while(opcionElegida!=5)
		{
				opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(null,
								 "1. Ingresar persona"+"\n"+
	                             "2. Modificar Persona"+"\n"+
	                             "3. Consultar Personas"+"\n"+
	                             "4. Eliminar Personas"+"\n"+
	                             "5. Salir"+"\n"+
	                             "Digite la Opción:"));
				
				switch(opcionElegida)
				{
					case 1:
					
						identificacion= JOptionPane.showInputDialog(null,"Digite la identificacion");
						nombre = JOptionPane.showInputDialog(null,"Digite el nombre");
						guardarUsuario(identificacion, nombre, listaPersonas);
						break;
					
					case 2:
						identificacion = JOptionPane.showInputDialog(null,"Digite la identificacion");
						modificarUsuario(identificacion, listaPersonas);
						break;
					case 3:
						mostrarPersonas(listaPersonas);
						break;
					case 4:
						identificacion = JOptionPane.showInputDialog(null,"Digite la identificacion");
						eliminarPersonas(identificacion, listaPersonas);
						break;
					case 5:
						break;
					default:
						System.out.println("Opción ingresada no es válida");
				}
		}
		
		
		
		

	}
	
	
	
	public static void guardarUsuario(String identificacion, String nombre, HashMap<String, String> listaPersonas)
	{
		if(listaPersonas.containsKey(identificacion))
		{
			System.out.println("No se puede agregar la persona");
		}else {
			listaPersonas.put(identificacion, nombre);
		}	
	}
	
	public static void modificarUsuario(String identificacion,HashMap<String, String> listaPersonas)
	{
		String nombre;
		if(listaPersonas.containsKey(identificacion))
		{
			System.out.println("Ingrese el nombre del usuario");
			nombre=JOptionPane.showInputDialog(null,"Digite el nombre");
			listaPersonas.put(identificacion, nombre);	
		}else {
			System.out.println("No hay personas con esa identificacion");
		}
	}

	
	public static void mostrarPersonas(HashMap<String, String> listaPersonas)
	{
		String clave;
		Iterator<String> personas = listaPersonas.keySet().iterator();
		System.out.println("Lista de personas");
		
		while(personas.hasNext())
		{
			clave = personas.next();
			System.out.println(clave + "-" +listaPersonas.get(clave));
			
		}
		
	}
	
	public static void eliminarPersonas(String identificacion, HashMap<String, String> listaPersonas)
	{
		if(listaPersonas.containsKey(identificacion))
		{
			listaPersonas.remove(identificacion);
		}else {
			System.out.println("No existe ninguna persona con esa identificacion");
		}
		
	}
}

import javax.swing.*;

public class Principal {
	public static void main(String[] args) {
		while(true) {
			try{
				ingresar();
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra Operación?");
				if(JOptionPane.OK_OPTION == respuesta) {
					ingresar();
				} else {
					JOptionPane.showMessageDialog(null, "Estamos para Servirte");
					break;
				}
			} catch (Exception e){
				System.out.println(e.getMessage());
				System.out.println("Fin.");
			}
		}
	}
	private static void ingresar() {
		Conversion conversion = new Conversion();
		String input = JOptionPane.showInputDialog(null, "Ingrese el valor a convertir");
		double valor = Double.parseDouble(input);
		conversion.convertir(valor);
	}
}

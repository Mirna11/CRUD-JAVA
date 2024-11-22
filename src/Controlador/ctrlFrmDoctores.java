package Controlador;

import Modelo.Doctores;
import Vista.FrmDoctores;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlFrmDoctores implements MouseListener{
     //1-Mandar a llamar a las otras capas
    private Doctores Modelo;
    private FrmDoctores Vista;
    
    
    //2-Constructor de la clase
    public ctrlFrmDoctores(Doctores modelo,FrmDoctores vista){
        this.Modelo = modelo;
        this.Vista = vista;
      
        
        Vista.btnGuardar.addMouseListener(this);
        Modelo.Mostrar(Vista.jTable);
    }
    
    
    
    //3- Programas el boton

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== Vista.btnGuardar){
            System.out.println("se dio click al btn");
            Modelo.setNombre(Vista.txtNombre.getText());
            Modelo.setEspecialidad(Vista.txtEspecialidad.getText());
            Modelo.setEdad(Integer.parseInt(Vista.txtEdad.getText()));
            
            Modelo.Guardar();
            Modelo.Mostrar(Vista.jTable);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
   
}

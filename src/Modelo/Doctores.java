
package Modelo;

import java.sql.*; 
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Doctores {
    //Parametros
    private String uuid_doctores;
    private String Nombre;
    private String Especialidad;
    private int edad;
    
    //GET y SET
    
    public String getUuid_doctores() {
        return uuid_doctores;
    }

    public void setUuid_doctores(String uuid_doctores) {
        this.uuid_doctores = uuid_doctores;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
   //Metodos
    
    public void Guardar(){
    //Creamos una variable igual a ejecutar el método de la clase conexion
    
    Connection conexion= ClaseConexion.getConexion();
    try{
        PreparedStatement addDoctor = conexion.prepareStatement("INSERT INTO tDoctores(uuid_doctores, nombre, especialidad,edad)values(?,?,?,?)");
        addDoctor.setString(1, UUID.randomUUID().toString());
        addDoctor.setString(2,getNombre());
        addDoctor.setString(3,getEspecialidad());
        addDoctor.setInt(4,getEdad());
        
        addDoctor.executeUpdate();
        
    }catch (SQLException ex){
        System.out.println("Este es un error del modelo:metodo guardar " + ex);
    }
    }
    
    public void Mostrar(JTable tabla1){
    //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modelitoDoctores = new DefaultTableModel();
        modelitoDoctores.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Especialidad", "Edad"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tDoctores");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelitoDoctores.addRow(new Object[]{rs.getString("UUID_doctores"), 
                    rs.getString("nombre"), 
                    rs.getString("especialidad"), 
                    rs.getInt("edad")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla1.setModel(modelitoDoctores);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    
    }
    
    public void Eliminar(){
    }
    public void Actualizar(){
    }


}

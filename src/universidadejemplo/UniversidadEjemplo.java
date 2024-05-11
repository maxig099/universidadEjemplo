/*
 * To change this license header, choose License Headers in Project Properties.
 * select * from productos  ORDER BY id asc limit 1
 * and open the template in the editor.
 */
package universidadejemplo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UniversidadEjemplo {

    public static void main(String[] args) {
         
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/universidadejemplo", "root" , "");
            
            //Agregar alumnos
       /*   String alum = "INSERT INTO alumno(idAlumno, dni, apellido, nombre, fechaNacimiento, estado) "
                    + "VALUES(1, 132456, 'gomez', 'maximo', '2004-05-13', 1),"
                    + "(2,2324256, 'villegas', 'guillermo','2000-06-11', 1),"
                    + "(3, 1324346, 'diaz', 'gonzalo', '2001-07-08', 0)";
            
            PreparedStatement ps = con.prepareStatement(alum);
            
            ps.executeUpdate();
           */ 
         
       //Agregar materias
        /* String mat = "INSERT INTO materia(nombre, año, estado) "
                 + "VALUES ('Programacion Web', 1, 1 ), ('Ingenieria de Software', 3, 0 ), ('Matematica II', 2, 1 ), ('Laboratorio de Programacion', 1, 0 )";
         
         PreparedStatement ps = con.prepareStatement(mat);
         
         ps.executeUpdate();
         */
        
        
        
        
        //Inscribir alumnos a materias
       /* String ins = "INSERT INTO inscripcion (nota, idAlumno, idMateria) "
                + "VALUES (9, 1, 1), (5, 1, 3), (10, 2, 2), (7, 2, 4), (8, 3, 4), (6, 3, 1)";
        
        PreparedStatement ps = con.prepareStatement(ins);
        
        ps.executeUpdate();
        */
       
       
       
       
       //Listar alumnos con nota mayor a 8
     /* String sql ="SELECT a.*, i.nota, i.idMateria "
              + "FROM alumno a "
              + "JOIN inscripcion i ON (i.idAlumno = a.idAlumno) WHERE i.nota > 8";
       
       PreparedStatement ps = con.prepareStatement(sql);
     ResultSet datos = ps.executeQuery();
       
      while(datos.next()) {
           int idAlumno = datos.getInt("idAlumno");
           int dni = datos.getInt("dni");
           String apellido = datos.getString("apellido");
           String nombre = datos.getString("nombre");
           Date fechaN = datos.getDate("fechaNacimiento");
           boolean estado = datos.getBoolean("estado");
           int nota = datos.getInt("nota");
           int idMateria = datos.getInt("idMateria");
           
           System.out.println("ID alumno: " + idAlumno);
           System.out.println("DNI: " + dni);
           System.out.println("Nombre: " + nombre);
           System.out.println("Apellido: " + apellido);
           System.out.println("Fecha Nacimiento: " + fechaN);
           System.out.println("Estado: " + estado);
           System.out.println("Nota: " + nota);
           System.out.println("ID Materia: " + idMateria);
           System.out.println("------------------------------");
       }*/
      
      int idAlumno = 1;
      int idMateria = 3;
      String sql= "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idAlumno);
      ps.setInt(2, idMateria);
      int filasAfec = ps.executeUpdate();
           
      if(filasAfec > 0) {
          System.out.println("Desinscripto Correctamente");
      }
      else {
          System.out.println("No se encontro la inscripcion");
      }
       
       
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UniversidadEjemplo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de conexion " + ex);
        }
        
            
        
            
    } 
    
}

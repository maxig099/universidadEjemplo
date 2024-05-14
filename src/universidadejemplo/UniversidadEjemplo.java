package universidadejemplo;

import java.sql.*;

public class UniversidadEjemplo {

    public static void main(String[] args) {
         
        try {
//  1. Cargar el driver MariaDB.

            Class.forName("org.mariadb.jdbc.Driver");
            
//  2. Establecer la conexión a la base de datos previamente creada.

            String url = "jdbc:mariadb://localhost/universidad_ulp";
            String usuario = "root";
            String password = "";
            
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion Establecida");
            
////  3. Insertar 3 alumnos
//
//            String cargaAlumnoSQL = "INSERT INTO alumno(idAlumno, dni, apellido, nombre, fechaNacimiento, estado) "
//                                    + "VALUES (1, 132456, 'gomez', 'maximo', '2004-05-13', 1),"
//                                    + "(2,2324256, 'villegas', 'guillermo','2000-06-11', 1),"
//                                    + "(3, 1324346, 'diaz', 'gonzalo', '2001-07-08', 0)";
//
//            PreparedStatement ps = conexion.prepareStatement(cargaAlumnoSQL);
//            ps.executeUpdate();
//            
//            System.out.println("Alumnos Cargados");

////  4. Insertar 4 materias
//
//            String materiasSQL = "INSERT INTO materia(nombre, anio, estado) "
//                                + "VALUES ('Programacion Web', 1, 1 ),"
//                                + "('Ingenieria de Software', 3, 0 ),"
//                                + "('Matematica II', 2, 1 ),"
//                                + "('Laboratorio de Programacion', 1, 0 )";
//
//            PreparedStatement ps = conexion.prepareStatement(materiasSQL);
//            ps.executeUpdate();
//            
//            System.out.println("Materias Agregadas");

////  5. Inscribir a los 3 alumnos en 2 materias cada uno.
//
//            String inscripcionMateriaSQL = "INSERT INTO inscripcion (nota, idAlumno, idMateria) "
//                                        + "VALUES (9, 1, 1), (5, 1, 3), (10, 2, 2),"
//                                        + "(7, 2, 4), (8, 3, 4), (6, 3, 1)";
//
//            PreparedStatement ps = conexion.prepareStatement(inscripcionMateriaSQL);
//            ps.executeUpdate();
//            
//            System.out.println("Alumnos Inscriptos");

////  6. Listar los datos de los alumnos con calificaciones superiores a 8.
//
//            String listarAlumnosSQL = "SELECT a.*, i.nota, i.idMateria "
//                                    + "FROM alumno a "
//                                    + "JOIN inscripcion i ON (i.idAlumno = a.idAlumno) WHERE i.nota > 8";
//
//            PreparedStatement ps = conexion.prepareStatement(listarAlumnosSQL);
//            ResultSet datos = ps.executeQuery();
//
//            while (datos.next()) {
//                int idAlumno = datos.getInt("idAlumno");
//                int dni = datos.getInt("dni");
//                String apellido = datos.getString("apellido");
//                String nombre = datos.getString("nombre");
//                Date fechaN = datos.getDate("fechaNacimiento");
//                boolean estado = datos.getBoolean("estado");
//                int nota = datos.getInt("nota");
//                int idMateria = datos.getInt("idMateria");
//
//                System.out.println("ID alumno: " + idAlumno);
//                System.out.println("DNI: " + dni);
//                System.out.println("Nombre: " + nombre);
//                System.out.println("Apellido: " + apellido);
//                System.out.println("Fecha Nacimiento: " + fechaN);
//                System.out.println("Estado: " + estado);
//                System.out.println("Nota: " + nota);
//                System.out.println("ID Materia: " + idMateria);
//                System.out.println("------------------------------");
//            }

//  7. Desinscribir un alumno de una de la materias.

            int idAlumno = 1;
            int idMateria = 3;
            String desinscribirAlumnoSQL = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
            PreparedStatement ps = conexion.prepareStatement(desinscribirAlumnoSQL);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            int filasAfec = ps.executeUpdate();

            if (filasAfec > 0) {
                System.out.println("Desinscrito Correctamente");
            } else {
                System.out.println("No se encontro la inscripcion");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver");
            
        }catch(SQLSyntaxErrorException ex){
            System.out.println("Error de Sintaxis en sentencia");            
            
        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {    //Codigo de tipo de error
                case 1062:
                    System.out.println("Entrada duplicada");
                    break;
                case 1049:
                    System.out.println("Base de datos desconocida");
                    break;
                default:
                    System.out.println("Error de conexión");
                    break;
            }
            ex.printStackTrace();   //Imprimo el error lanzado
        }            
    }    
}

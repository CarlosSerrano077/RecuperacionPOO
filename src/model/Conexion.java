package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //Conexion  a la base de datos
    /** Credenciales para la conexión a la base de datos. */
    private final String usuario= "usyijmttc8yx7jxp";
    private final String url= "jdbc:mysql://usyijmttc8yx7jxp:iIJqMfJ13pTdsgOHsnlQ@b6pl6zmmlwf8z3okn24x-mysql.services.clever-cloud.com:3306/b6pl6zmmlwf8z3okn24x";
    private final String password="iIJqMfJ13pTdsgOHsnlQ";

    /**
     * Constructor de la clase. Intenta establecer una conexión para verificar su éxito.
     */
    public Conexion(){
        try{
            Connection conn = DriverManager.getConnection(url,usuario,password);
            System.out.println("Conexion exitosa a Clever Cloud");
            conn.close();
        }catch (SQLException e){
            System.out.println("Error al conectar: "+ e.getMessage());
        }
    }

    /**
     * Obtiene y retorna una nueva conexión a la base de datos.
     * @return Un objeto Connection que representa la conexión a la base de datos.
     * @throws SQLException Si ocurre un error de conexión.
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, password);
    }
}

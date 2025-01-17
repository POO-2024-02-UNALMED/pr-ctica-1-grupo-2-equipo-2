package baseDatos;

import modelo.Domicilio;
import modelo.EstadoPedido;
import java.io.*;

public class Persistencia {
    private static final String RUTA_TEMP = "temp/";

    static {
        File tempDir = new File(RUTA_TEMP);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
    }

    public static void guardarDatos(DataManager dataManager) {
        try (FileOutputStream fileOut = new FileOutputStream(RUTA_TEMP + "datos.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(dataManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataManager cargarDatos() {
        try (FileInputStream fileIn = new FileInputStream(RUTA_TEMP + "datos.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            DataManager dataManager = (DataManager) in.readObject();

            return dataManager;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

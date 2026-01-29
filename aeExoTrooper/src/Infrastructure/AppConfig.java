//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package Infrastructure;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import Infrastructure.Tools.CMD;

public abstract class AppConfig {
    private static final Properties props = new Properties();
   
    // Ruta principal (cuando se ejecuta dentro de aeExoTrooper/)
    private static final String APP_PROPERTIES      = "src/app.properties";
    // Rutas alternativas (cuando se ejecuta desde el directorio padre)
    private static final String[] APP_PROPERTIES_PATHS = new String[] {
        "src/app.properties",
        "aeExoTrooper/src/app.properties",
        "../aeExoTrooper/src/app.properties",
        "../src/app.properties"
    };
    private static String appPropertiesPathUsed = APP_PROPERTIES;
    private static final String KEY_DB_NAME         = "db.File"     ;
    private static final String KEY_FILE_LOG        = "df.logFile"  ;
    private static final String KEY_FILE_EXOMUNISION= "df.ExoMunision"  ;
    private static final String KEY_FILE_EXOTRACER  = "df.ExoTracer"  ;

    
    

    private static final String KEY_RES_IMG_MAIN    = "res.img.Main";
    private static final String KEY_RES_IMG_LOGO    = "res.img.logo";
    private static final String KEY_RES_IMG_SPLASH  = "res.img.Splash";
    
    // Configuración dinámica  (Sin recompilar)
    public static final String getDATABASE   (){ return getProperty( KEY_DB_NAME      ); }
    public static final String getLOGFILE    (){ return getProperty( KEY_FILE_LOG     ); }
    public static String       getEXOTRACER  (){ return getProperty(KEY_FILE_EXOTRACER);}
    public static String       getEXOMUNISION(){ return getProperty(KEY_FILE_EXOMUNISION); }

    // Resources .  Recurso estático empaquetado
    public static final URL getImgMain      (){ return getAppResource( KEY_RES_IMG_MAIN   ); }
    public static final URL getImglogo      (){ return getAppResource( KEY_RES_IMG_LOGO   ); }
    public static final URL getImgSplash    (){ return getAppResource( KEY_RES_IMG_SPLASH ); }
    
    // AppMSGs
    public static final String MSG_DEFAULT_ERROR    = "Ups! Error inesperado. Por favor, contacte al administrador del sistema.";
    public static final String MSG_DEFAULT_CLASS    = "undefined";
    public static final String MSG_DEFAULT_METHOD   = "undefined";

    static {
        boolean loaded = false;
        for (String path : APP_PROPERTIES_PATHS) {
            try (InputStream appProperties = new FileInputStream(path)) {
                props.load(appProperties);
                appPropertiesPathUsed = path;
                CMD.println("AppConfig ❱❱ cargado: " + path);
                loaded = true;
                break;
            } catch (IOException _) {
                // Intentar siguiente ruta
            }
        }
        if (!loaded) {
            CMD.printlnError("ERROR al cargar ❱❱ app.properties (no se encontró en rutas conocidas)");
        }
    }

    private AppConfig(){}

    static String getProperty(String key) {
        String path = props.getProperty(key);
        CMD.println("AppConfig ❱❱ "+ appPropertiesPathUsed +"." + key + " : "+ path);
        if(path != null)
            return  path;
        else
            CMD.printlnError("ERROR ❱❱ " + appPropertiesPathUsed +"." + key + " : "+ path);
        return null;
    }

    static URL getAppResource(String key) {
        String path = getProperty(key);
        if(path != null)
            return  AppConfig.class.getResource(path);
        else
            CMD.printlnError("ERROR ❱❱ getAppResource : " + APP_PROPERTIES +"." + key + " : "+ path);
        return null;
    }
    
}
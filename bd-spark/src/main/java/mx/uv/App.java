package mx.uv;

import static spark.Spark.*;

import java.util.UUID;

import com.google.gson.*;

import mx.uv.db.DAO;
import mx.uv.db.Usuario;


/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson = new Gson();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/", (req, res) -> {
            return null;
        });

        post("/usuario", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Usuario u = gson.fromJson(json, Usuario.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);
            //usuarios.put(id, u);

            DAO dao = new DAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarUsuario(u));
            respuesta.addProperty("id", id);
            return respuesta;
        });
        
        get("/usuarios", (req, res) -> {
            before((req2, res2) -> res.type("application/json"));
            DAO dao = new DAO();
            return gson.toJson(dao.listadoUsuario());
        });

    }
}

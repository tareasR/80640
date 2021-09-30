package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
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
        // before((request, response) -> {
        // response.header("Access-Control-Allow-Origin", origin);
        // response.header("Access-Control-Request-Method", methods);
        // response.header("Access-Control-Allow-Headers", headers);
        // // Note: this may or may not be necessary in your particular application
        // response.type("application/json");
        // });

        System.out.println("Hello World!");
        get("/hola", (rq, rs) -> {
            System.out.println("Request: " + rq.queryParams("nombre") + " " + rq.queryParams("pass"));
            String msj;
            if (rq.queryParams("nombre").equals("root"))
                msj = "Bienvenido!";
            else
                msj = "Usuario equivocado";
            return "Hola get " + msj + " " + "<a href='//127.0.0.1:5500/formulario.html'>regresar</a>";
        });

        get("/Luis", (rq, rs) -> "Luis");
        get("/Ariana", (rq, rs) -> "Ariana");

        post("/hola", (rq, rs) -> {
            System.out.println("Request: " + rq.queryParams("nombre") + " " + rq.queryParams("pass"));
            String msj;
            if (rq.queryParams("nombre").equals("root"))
                msj = "Bienvenido!";
            else
                msj = "Usuario equivocado";
            return "Hola post " + msj + " " + "<a href='//127.0.0.1:5500/formulario.html'>regresar</a>";
        });

        post("/holaJson", (rq, rs) -> {
            // System.out.println("Request: " + rq.queryParams("nombre") + " " +
            // rq.queryParams("pass"));
            String request = rq.body();
            System.out.println("Request: " + request );
            String msj = null;
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse( request );
            JsonObject peticion = arbol.getAsJsonObject();

            Object nombre =  peticion.get("nombre") ;
            // if (rq.queryParams("nombre").equals("root"))
            // msj = "Bienvenido!";
            // else
            // msj = "Usuario equivocado";
            return "Hola post " + nombre + " " + "<a href='//127.0.0.1:5500/formulario.html'>regresar</a>";
        });

        get("/holaJson", (rq,rs)->{
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("user", rq.queryParams("nombre"));
            respuesta.addProperty("access", "granted");
            respuesta.addProperty("time", 31312321);
            return respuesta;
        });
    }
}

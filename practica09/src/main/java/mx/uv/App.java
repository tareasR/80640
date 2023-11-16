package mx.uv;

import static spark.Spark.*;

import com.google.gson.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hola Mundo!" );

    //fuente:https://gist.github.com/saeidzebardast/e375b7d17be3e0f4dddf
    options("/*",(request,response)->{
    String accessControlRequestHeaders=request.headers("Access-Control-Request-Headers");
    if(accessControlRequestHeaders!=null){
    response.header("Access-Control-Allow-Headers",accessControlRequestHeaders);
    }
    String accessControlRequestMethod=request.headers("Access-Control-Request-Method");
    if(accessControlRequestMethod!=null){
    response.header("Access-Control-Allow-Methods",accessControlRequestMethod);
    }
    return "OK";
    });
    
    before((request,response)->response.header("Access-Control-Allow-Origin","*"));
    

        get("/index.html",
            (request, response)-> "<h1>Hola mundo!</h1>"
        );

        post("/", (request, response) -> "soy el post");

        get("/ruta1",   
            (request, response)-> {
                String parametro = request.queryParams("apellido");
                System.out.println("tipo de contenido ruta1: "+ request.contentType());

                System.out.println(parametro);
                System.out.println("esto es el request " + request.contentType());
                return "<h1>Adios mundo "+ parametro + "!</h1>";
            }
        );

        post("/ruta1",   
            (request, response)-> {
                String parametro = request.queryParams("apellido");
                System.out.println("tipo de contenido ruta1: "+ request.contentType());

                System.out.println(parametro);
                System.out.println("esto es el request " + request.contentType());
                return "<h1>Adios mundo "+ parametro + "!</h1>";
            }
        );


        get("/ruta2",
            (request, response)-> {
                String parametro = request.queryParams("nombre");
                System.out.println("tipo de contenido: "+ request.contentType());
                JsonObject respuesta = new JsonObject();
                respuesta.addProperty("msj", "hola");
                respuesta.addProperty("apellido", parametro);
                response.type("application/json");
                return respuesta;
            }
        );

        post("/ruta2",
            (request, response)-> {
                //String parametro = request.queryParams("nombre");
                String parametro = request.body();
                System.out.println("tipo de contenido: "+ request.contentType());
                System.out.println("el body tiene: "+ parametro);

                JsonParser parser = new JsonParser();
                // este objeto sirve para acceder a los elementos de la petición en json
                JsonElement arbol = parser.parse(parametro);

                // este objeto sirve para construir la respuesta en json
                JsonObject respuesta = new JsonObject();
                respuesta.addProperty("msj", "hola");
                respuesta.addProperty("apellido", arbol.getAsJsonObject().get("nombre").getAsString());
                response.type("application/json");
                return respuesta;
            }
        );
        
        get("/ruta3",
            (request, response)-> {
                System.out.println("esto es el request " + request.contentType());
                response.type("application/json");
               return "{\"alumno\":\"john\",\"matricula\":\"s0001\",\"carrera\":\"tc\"}";
            }
        );
    }
}

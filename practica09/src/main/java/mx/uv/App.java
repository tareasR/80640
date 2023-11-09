package mx.uv;

import static spark.Spark.*;

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
    

        get("/",
            (request, response)-> "<h1>Hola mundo!</h1>"
        );
        get("/ruta1",
            (request, response)-> "<h1>Adios mundo!</h1>"
        );
        get("/ruta2",
            (request, response)-> "<h1>Que tal mundo!</h1>"
        );
        get("/ruta3",
            (request, response)-> "{\"alumno\":\"john\",\"matricula\":\"s0001\",\"carrera\":\"tc\"}"
        );
    }
}

package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;

import mx.uv.datos.Usuario;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App {
    private static Gson gson = new Gson();
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Hello World!");

        staticFiles.location("/");

        // tiene prevalencia el mapeo estático de forma que
        // si tenemos un index.html, este se va a cargar primero que
        // el mapeo a la raíz "/"
        get("/", (req, res) -> {
            return "respuesta";
        });

        get("/hola", (req, res) -> {
            res.redirect("/hola.html");
            return null;
        });

        post("/enviar", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Usuario u = gson.fromJson(json, Usuario.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);
            usuarios.put(id, u);

            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", "creado");
            respuesta.addProperty("id", id);
            return respuesta;
        });

        // do this
        get("/pagina", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(new ModelAndView(model, "pagina.html"));
        });

        // do this
        get("/velocity", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "Que se yo!");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/hola.vm"));
        });


        // do this
        get("/usuario", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", usuarios.values());
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/hola.vm"));
        });
    }
}

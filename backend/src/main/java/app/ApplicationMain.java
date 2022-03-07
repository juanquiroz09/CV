package app;

import static spark.Spark.before;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApplicationMain {

  static Logger logger = Logger.getLogger(ApplicationMain.class);

  public static void main(String[] args) {
    BasicConfigurator.configure();
    Group group = createGroup();
    Group group_two = createGroup_two();
    Group group_three = createGroup_three();

    //Enable CORS
    enableCors();

    // Experiencia
    get("/experiencia",(req, res) -> {
        res.type("application/json");
        JSONObject jo = new JSONObject(group);
        return jo;
      }
    );
    post("/experiencia",(req, res) -> {
        res.type("application/json");
        JSONObject body = new JSONObject(req.body());
        Experiencia exp = new Experiencia();
        if (!body.has("habilidades")) {
          return "Invalid request";
        }
        exp.setHabilidades(body.getString("habilidades"));
        group.addExperiencia(exp);
        JSONObject jo = new JSONObject(group);
        return jo;
      }
    );
   /*delete("/experiencia/habilidades", (req, res) -> {
      res.type("application/json");
      JSONObject body = new JSONObject(req.body());
      Experiencia exp = new Experiencia();
      if (!body.has("habilidades")) {
        return "Invalid request";
      }
      exp.setHabilidades(body.getString("habilidades"));
      group.deleteExperiencia(exp);
      JSONObject jo = new JSONObject(group);
      return jo;
  });
*/
    // Conocimiento
    get("/conocimiento",(req, res) -> {
        res.type("application/json");
        JSONObject jo = new JSONObject(group_two);
        return jo;
      }
    );
    post("/conocimiento",(req, res) -> {
        res.type("application/json");
        JSONObject body = new JSONObject(req.body());
        Experiencia cono = new Experiencia();
        if (!body.has("conocimientos")) {
          return "Invalid request";
        }
        cono.setConocimientos(body.getString("conocimientos"));
        group_two.addConocimiento(cono);
        JSONObject jo = new JSONObject(group_two);
        return jo;
      }
    );
        // Referencia
        get("/referencia",(req, res) -> {
          res.type("application/json");
          JSONObject jo = new JSONObject(group_three);
          return jo;
        }
      );
      post("/referencia",(req, res) -> {
          res.type("application/json");
          JSONObject body = new JSONObject(req.body());
          Experiencia refe = new Experiencia();
          if (!body.has("referencias")) {
            return "Invalid request";
          }
          refe.setReferencias(body.getString("referencias"));
          group_three.addReferencia(refe);
          JSONObject jo = new JSONObject(group_three);
          return jo;
        }
      );
  }

  public static void enableCors() {
    options(
      "/*",
      (request, response) -> {
        String accessControlRequestHeaders = request.headers(
          "Access-Control-Request-Headers"
        );
        if (accessControlRequestHeaders != null) {
          response.header(
            "Access-Control-Allow-Headers",
            accessControlRequestHeaders
          );
        }

        String accessControlRequestMethod = request.headers(
          "Access-Control-Request-Method"
        );
        if (accessControlRequestMethod != null) {
          response.header(
            "Access-Control-Allow-Methods",
            accessControlRequestMethod
          );
        }

        return "OK";
      }
    );

    before(
      (request, response) -> response.header("Access-Control-Allow-Origin", "*")
    );
  }

//Experiencias
  public static Group createGroup() {
    Group group = new Group();
    group.addExperiencia(createExperiencia("Diseñador Web"));
    return group;
  }

  public static Experiencia createExperiencia(String _habilidades) {
    Experiencia exp = new Experiencia();
    exp.setHabilidades(_habilidades);
    return exp;
  }

  //Conocimientos
  public static Group createGroup_two() {
    Group group_two = new Group();
    group_two.addConocimiento(createConocimiento("HTML"));
    return group_two;
  }

  public static Experiencia createConocimiento(String _conocimientos) {
    Experiencia cono = new Experiencia();
    cono.setConocimientos(_conocimientos);
    return cono;
  }

    //Referencia
    public static Group createGroup_three() {
      Group group_three = new Group();
      group_three.addReferencia(createReferencia("Edgarm12@gmail.com"));
      return group_three;
    }
  
    public static Experiencia createReferencia(String _referencias) {
      Experiencia refe = new Experiencia();
      refe.setReferencias(_referencias);
      return refe;
    }

}

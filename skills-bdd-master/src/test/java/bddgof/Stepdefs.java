package bddgof;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import cucumber.api.java.pt.Entao;

import bddgof.SkillsTeste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

import org.json.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Stepdefs {

    private static String id_skill;

    /*************************************************************************/

    @Dado("Que Gerente cadastra uma skill")
    public void que_Gerente_cadastra_uma_skill() {

    }

    @Quando("Escolhe a opcao de consultar: {string}")
    public void escolhe_a_opcao_de_consultar(String string) {
        Stepdefs.id_skill = string;
    }

    @Quando("clica em consultar skill:")
    public void clica_em_consultar_skill() {

    }

    @Entao("A consulta deve retornar a skill cadastrada: {string}")
    public void a_consulta_deve_retornar_a_skill_cadastrada(String string) {

       RestTemplate restTemplate = new RestTemplate();
       String url = "https://immense-island-96291.herokuapp.com/sprintly/skills/" + id_skill;

       String s = restTemplate.getForObject(url, String.class);

       JsonObject obj = new JsonParser().parse(s).getAsJsonObject();

        System.out.print(obj);

        assertEquals(obj.get("name").toString() , "\"" + string + "\"") ;

    }

}

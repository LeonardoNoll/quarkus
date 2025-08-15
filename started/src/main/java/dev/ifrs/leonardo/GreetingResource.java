package dev.ifrs.leonardo;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import io.quarkus.vertx.http.runtime.devmode.Json;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    ArrayList<Tarefa> tarefas = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloName(@PathParam("name") String name) {
        return "Hello, " + name + "!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String kilometersToMiles(@FormParam("km") String km) {
        Double miles = Double.parseDouble(km) * 0.621371;
        return Double.toString(miles);
    }

    @GET
    @Path("/query")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloQuery(@QueryParam("name") String name) {
        return "Hello" + name;
    }

    @POST
    @Path("/tarefa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tarefa retornaTarefa(Tarefa postTarefa) {
        Tarefa newTarefa = new Tarefa(postTarefa.getName(), postTarefa.getDescription());
        tarefas.add(newTarefa);
        return newTarefa;
    }

    @GET
    @Path("/tarefa")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tarefa> retornaTarefas() {
        return tarefas;
    }

    @DELETE
    @Path("/tarefa/{id}")
    @Consumes(MediaType.)
}

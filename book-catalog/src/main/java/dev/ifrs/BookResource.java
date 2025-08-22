package dev.ifrs;

import java.util.List;

import dev.ifrs.data.DataBase;
import dev.ifrs.model.Book;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/books")
public class BookResource {

    @Inject
    DataBase dataBase;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> listBooks() {
        return dataBase.getBooks();
    }

    @POST
    @Path("/book")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String book(String isbn) {
        try {
            for (Book currBook : dataBase.getBooks()) {
                if (currBook.getIsbn().equals(isbn)) {
                    if (currBook.isBooked())
                        return "Já esta alugado";
                    else {
                        currBook.setBooked(false);
                        return "Livro alugado com sucesso";
                    }
                }
            }
            return "ISBN não corresponde a nenhum livro do sistema";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}

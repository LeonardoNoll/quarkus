package dev.ifrs;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.ifrs.client.BookClient;
import dev.ifrs.model.Book;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/manager")
public class ManagerResource {

    @Inject
    @RestClient
    BookClient bookClient;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return bookClient.listBooks();
    }

    @POST
    @Path("/book")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String book(String isbn) {
        return bookClient.book(isbn);
    }
}

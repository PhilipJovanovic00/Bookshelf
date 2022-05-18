package ch.bzz.bookshelf.service;

import ch.bzz.bookshelf.data.DataHandler;
import ch.bzz.bookshelf.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("book")
public class BookService {

    //@GET
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBooks(){
        List<Book> bookList = DataHandler.getInstance().readAllBooks();
        Response response = Response
                .status(200)
                .entity(bookList)
                .build();
        return response;
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readBook(
            @QueryParam("uuid") String bookUUID
    ) {
        Book book = DataHandler.getInstance().readBookByUUID(bookUUID);
        Response response = Response
                .status(200)
                .entity(book)
                .build();
        return response;


    }

}

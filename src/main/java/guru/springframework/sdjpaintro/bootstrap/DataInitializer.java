package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;


    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driver Design","123","RandomHouse");
        Book savedDDD = bookRepository.save(bookDDD);
        System.out.println("ID: " + bookDDD.getId());

        Book bookSIA = new Book("Spring in action", "1231231", "Oreily");
        Book savedSIA = bookRepository.save(bookSIA);
        System.out.println("ID: " + bookSIA.getId());

        bookRepository.findAll().forEach(book -> System.out.println("Book title " + book.getId() + " and title" +
                book.getTitle()));
    }
}

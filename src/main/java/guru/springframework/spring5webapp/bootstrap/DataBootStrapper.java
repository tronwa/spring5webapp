package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repos.AuthorRepository;
import guru.springframework.spring5webapp.repos.BookRepository;
import guru.springframework.spring5webapp.repos.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBootStrapper implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DataBootStrapper(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book =  new Book("Domain driven design", "1234321");
        String wiley = "Wiley & Sons";
        Publisher pub = new Publisher(wiley, new Address("1 Highway", "Duckburg", "4711", "Calisota"));
        publisherRepository.save(pub);

        book.getAuthors().add(eric);
        book.setPublisher(pub);
        eric.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developent without EJB", "089873424");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Books in book repo: " + bookRepository.count());
        System.out.println("Publishers in the world: " + publisherRepository.count());
        Publisher p = publisherRepository.findByName(wiley);
        //System.out.println(p.getName() + " has released " + p.getBooks().size() + " books. ");


    }
}

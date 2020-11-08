package com.ayan.spring.webapp.bootstrap;

import com.ayan.spring.webapp.domain.Address;
import com.ayan.spring.webapp.domain.Author;
import com.ayan.spring.webapp.domain.Book;
import com.ayan.spring.webapp.domain.Publisher;
import com.ayan.spring.webapp.repository.AddressRepository;
import com.ayan.spring.webapp.repository.AuthorRepository;
import com.ayan.spring.webapp.repository.BookRepository;
import com.ayan.spring.webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in author book Bootstrap");

        bootstarpauthorbook();

        System.out.println("Started in publisher address Bootstrap");

        bootstrapaddrpublisher();

        System.out.println("Started in Book and Publisher");

        bootstrapbookpublisher();
    }

    Publisher publisher = new Publisher("Better Publisher");
    Address address = new Address("Hno2", "palwal", "haryana", 121102L);
    Publisher publisher2 = new Publisher("Good Publisher");
    Address address2 = new Address("Hno2", "Bhopal", "madhyapradesh", 460135L);

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "3939459459");


    private void bootstrapbookpublisher() {

        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);

        ddd.setPublisher(publisher);
        noEJB.setPublisher(publisher);

        publisherRepository.save(publisher);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);

    }

    private void bootstrapaddrpublisher() {

        publisher.setAddress(address);
        address.setPublisher(publisher);

        addressRepository.save(address);
        publisherRepository.save(publisher);

        publisher2.setAddress(address2);
        address2.setPublisher(publisher2);

        addressRepository.save(address2);
        publisherRepository.save(publisher2);

        System.out.println("Number of publisher : " + publisherRepository.count());
    }

    private void bootstarpauthorbook() {

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Books: " + bookRepository.count());

    }
}

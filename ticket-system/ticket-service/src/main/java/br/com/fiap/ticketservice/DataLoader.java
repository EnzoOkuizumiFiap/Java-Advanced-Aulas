package br.com.fiap.ticketservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TicketRepository ticketRepository;

    public DataLoader(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var ticket = new Ticket();
        ticket.setEventName("Rock in Rio");
        ticket.setAvailable(5);
        ticketRepository.save(ticket);
    }
}

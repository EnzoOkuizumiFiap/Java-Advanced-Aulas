package br.com.fiap.ticketservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    public record PurchaseResponse(String status) {}

    @PostMapping("purchase/{id}")
    public ResponseEntity<PurchaseResponse> purchase(@PathVariable UUID id){
        try {
            ticketService.purchase(id);
            return ResponseEntity.ok(new PurchaseResponse("Ticket purchased successfully for id: " + id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new PurchaseResponse("ERRO: " + ex.getMessage()));
        }
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

}

package br.com.fiap.weatherplanner.planner;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planner")
@RequiredArgsConstructor
public class PlannerController {
    private final PlannerService plannerService;

    public record PlannerRequest(String activity){}
    public record PlannerResponse(String result){}

    @GetMapping
    public PlannerResponse getPlannerFromActivity(PlannerRequest request) {
        return new PlannerResponse(
                plannerService.getPlannerFromActivity(request.activity)
        );
    }
}

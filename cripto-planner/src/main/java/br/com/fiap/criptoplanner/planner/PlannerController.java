package br.com.fiap.criptoplanner.planner;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planner")
@RequiredArgsConstructor
public class PlannerController {
    private final PlannerService plannerService;

    @GetMapping
    public PlannerResponse getPlannerFromActivity(@RequestParam("activity") String activity) {
        return new PlannerResponse(plannerService.getPlannerFromActivity(activity));
    }
}

package br.com.fiap.spy.mission;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {
    private final MissionRepository missionRepository;
    public MissionController(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @GetMapping
    List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mission createMission(@RequestBody Mission mission) {
        return missionRepository.save(mission);
    }

}

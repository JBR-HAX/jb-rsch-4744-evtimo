package org.jetbrains.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RobotController {
    @Autowired
    RobotService robotService;

    @PostMapping("/locations")
    public List<Location> getLocations(@RequestBody List<Movement> movements) {
        return robotService.calculateLocations(movements);
    }

    @PostMapping("/moves")
    public List<Movement> getMoves(@RequestBody List<Location> locations) {
        return robotService.calculateMovements(locations);
    }
}
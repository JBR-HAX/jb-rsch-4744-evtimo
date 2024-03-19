package org.jetbrains.assignment;

import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

@Service
public class RobotService {

    public List<Location> calculateLocations(List<Movement> movements) {
        int x = 0;
        int y = 0;

        List<Location> locations = new ArrayList<>();

        // Always starting from (0,0)
        locations.add(new Location(x, y));

        for (Movement movement : movements) {
            switch (movement.getDirection()) {
                case "NORTH":
                    y += movement.getSteps();
                    break;
                case "SOUTH":
                    y -= movement.getSteps();
                    break;
                case "EAST":
                    x += movement.getSteps();
                    break;
                case "WEST":
                    x -= movement.getSteps();
                    break;
            }
            locations.add(new Location(x, y));
        }

        return locations;
    }

    public List<Movement> calculateMovements(List<Location> locations) {
        List<Movement> movements = new ArrayList<>();
        for (int i = 0; i < locations.size() - 1; i++) {
            Location start = locations.get(i);
            Location end = locations.get(i + 1);

            if (start.getX() != end.getX()) {
                // determine direction
                Direction direction = start.getX() < end.getX() ? Direction.EAST : Direction.WEST;
                // determine distance
                int distance = Math.abs(start.getX() - end.getX());
                movements.add(new Movement(direction, distance));
            }

            if (start.getY() != end.getY()) {
                // determine direction
                Direction direction = start.getY() < end.getY() ? Direction.NORTH : Direction.SOUTH;
                // determine distance
                int distance = Math.abs(start.getY() - end.getY());
                movements.add(new Movement(direction, distance));
            }
        }
        return movements;
    }
}
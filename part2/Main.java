AirportSimulatorimport java.util.*;
import java.util.concurrent.*;

public class AirportSimulator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        List<Aircraft> aircrafts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String id = "A" + (100 + i);
            Aircraft a = switch (new Random().nextInt(3)) {
                case 0 -> new PassengerPlane(id, tower);
                case 1 -> new CargoPlane(id, tower);
                default -> new Helicopter(id, tower);
            };
            aircrafts.add(a);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() -> {
            Aircraft random = aircrafts.get(new Random().nextInt(aircrafts.size()));
            boolean emergency = new Random().nextInt(10) == 0;

            if (emergency) {
                System.out.println(random + " declaring emergency!");
                random.declareEmergency();
            } else {
                System.out.println(random + " requesting runway...");
                boolean cleared = tower.requestRunway(random);
                if (cleared) {
                    System.out.println(random + " cleared for takeoff/landing");
                    tower.releaseRunway();
                } else {
                    System.out.println(random + " added to queue");
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}

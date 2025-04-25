import java.util.*;

class ControlTower implements TowerMediator {
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean runwayBusy = false;

    public void broadcast(String msg, Aircraft sender) {
        System.out.println("[Tower] " + sender + " says: " + msg);

        if (msg.equalsIgnoreCase("MAYDAY")) {
            System.out.println("Emergency from " + sender);
            landingQueue.remove(sender);
            landingQueue.addFirst(sender);
            notifyAllToHold(sender);
            clearRunway(sender);
        }
    }

    private void notifyAllToHold(Aircraft except) {
        for (Aircraft a : landingQueue) {
            if (!a.equals(except)) {
                a.receive("Hold position – Emergency in progress");
            }
        }
        for (Aircraft a : takeoffQueue) {
            a.receive("Hold takeoff – Emergency in progress");
        }
    }

    private void clearRunway(Aircraft emergencyAircraft) {
        if (!runwayBusy) {
            System.out.println("[Tower] Emergency landing granted for " + emergencyAircraft);
            runwayBusy = true;
        }
    }

    public boolean requestRunway(Aircraft a) {
        if (a.isEmergency()) {
            clearRunway(a);
            return true;
        }

        if (!runwayBusy) {
            runwayBusy = true;
            return true;
        }

        if (a instanceof PassengerPlane || a instanceof CargoPlane) {
            landingQueue.add(a);
        } else {
            takeoffQueue.add(a);
        }
        return false;
    }

    public void releaseRunway() {
        runwayBusy = false;
    }
}

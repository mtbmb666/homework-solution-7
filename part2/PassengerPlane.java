class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, TowerMediator tower) {
        super(id, tower);
    }

    public void receive(String msg) {
        System.out.println("[PassengerPlane " + id + "] received: " + msg);
    }
}

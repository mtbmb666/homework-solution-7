class CargoPlane extends Aircraft {
    public CargoPlane(String id, TowerMediator tower) {
        super(id, tower);
    }

    public void receive(String msg) {
        System.out.println("[CargoPlane " + id + "] received: " + msg);
    }
}

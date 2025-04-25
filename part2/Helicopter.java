class Helicopter extends Aircraft {
    public Helicopter(String id, TowerMediator tower) {
        super(id, tower);
    }

    public void receive(String msg) {
        System.out.println("[Helicopter " + id + "] received: " + msg);
    }
}

abstract class Aircraft {
    protected final String id;
    protected TowerMediator tower;
    protected boolean emergency;

    public Aircraft(String id, TowerMediator tower) {
        this.id = id;
        this.tower = tower;
    }

    public abstract void receive(String msg);

    public void send(String msg) {
        tower.broadcast(msg, this);
    }

    public String getId() {
        return id;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void declareEmergency() {
        emergency = true;
        send("MAYDAY");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Series {
    private final List<Season> seasons = new ArrayList<>();

    public void addSeason(Season s) {
        seasons.add(s);
    }

    public EpisodeIterator createBingeIterator() {
        return new BingeIterator(seasons);
    }
}

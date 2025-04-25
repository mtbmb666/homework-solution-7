class BingeIterator implements EpisodeIterator {
    private final List<Season> seasons;
    private int currentSeasonIndex = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentIterator = new SeasonIterator(seasons.get(0));
        }
    }

    public boolean hasNext() {
        while (currentIterator != null && !currentIterator.hasNext()) {
            currentSeasonIndex++;
            if (currentSeasonIndex >= seasons.size()) {
                return false;
            }
            currentIterator = new SeasonIterator(seasons.get(currentSeasonIndex));
        }
        return currentIterator != null && currentIterator.hasNext();
    }

    public Episode next() {
        return currentIterator.next();
    }
}

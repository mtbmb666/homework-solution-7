class SeasonIterator implements EpisodeIterator {
    private final List<Episode> episodes;
    private int currentIndex = 0;

    public SeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
    }

    public boolean hasNext() {
        return currentIndex < episodes.size();
    }

    public Episode next() {
        return episodes.get(currentIndex++);
    }
}

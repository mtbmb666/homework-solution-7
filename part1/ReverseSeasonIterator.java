class ReverseSeasonIterator implements EpisodeIterator {
    private final List<Episode> episodes;
    private int currentIndex;

    public ReverseSeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
        this.currentIndex = episodes.size() - 1;
    }

    public boolean hasNext() {
        return currentIndex >= 0;
    }

    public Episode next() {
        return episodes.get(currentIndex--);
    }
}

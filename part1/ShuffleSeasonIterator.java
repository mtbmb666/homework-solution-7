class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffledEpisodes;
    private int currentIndex = 0;

    public ShuffleSeasonIterator(Season season, long seed) {
        this.shuffledEpisodes = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(shuffledEpisodes, new Random(seed));
    }

    public boolean hasNext() {
        return currentIndex < shuffledEpisodes.size();
    }

    public Episode next() {
        return shuffledEpisodes.get(currentIndex++);
    }
}

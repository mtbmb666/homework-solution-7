import java.util.*;

class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public EpisodeIterator createIterator() {
        return new SeasonIterator(this);
    }

    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(this);
    }

    public EpisodeIterator createShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(this, seed);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator();
    }
}

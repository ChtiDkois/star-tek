package fr.vlaamsdk.startek.persistence;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author ymartel (martel@codelutin.com)
 */
public class ComicBook {

    public ComicBook() {
        this.identifier = UUID.randomUUID();
    }

    protected UUID identifier;
    protected String title;
    protected Integer pages;
    protected String language;

    protected String editor;
    protected String publisher;
    protected String collection;

    protected String summary;

    protected Set<Person> writers;

    protected Integer volume;
    protected Integer number;

    protected String country;

    protected Set<Person> artists;
    protected Set<Person> colorsArtists;
    protected Set<Person> coverArtists;
    protected Set<Person> letterers;

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Set<Person> getWriters() {
        return writers;
    }

    public void setWriters(Set<Person> writers) {
        this.writers = writers;
    }

    public void addWriter(Person writer) {
        if (this.writers == null) {
            this.writers = new HashSet<>();
        }
        this.writers.add(writer);
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Person> getArtists() {
        return artists;
    }

    public void setArtists(Set<Person> artists) {
        this.artists = artists;
    }

    public void addArtist(Person artist) {
        if (this.artists == null) {
            this.artists = new HashSet<>();
        }
        this.artists.add(artist);
    }

    public Set<Person> getColorsArtists() {
        return colorsArtists;
    }

    public void setColorsArtists(Set<Person> colorsArtists) {
        this.colorsArtists = colorsArtists;
    }

    public void addColorsArtist(Person colorsArtist) {
        if (this.colorsArtists == null) {
            this.colorsArtists = new HashSet<>();
        }
        this.colorsArtists.add(colorsArtist);
    }

    public Set<Person> getCoverArtists() {
        return coverArtists;
    }

    public void setCoverArtists(Set<Person> coverArtists) {
        this.coverArtists = coverArtists;
    }

    public void addCoverArtist(Person coverArtist) {
        if (this.coverArtists == null) {
            this.coverArtists = new HashSet<>();
        }
        this.coverArtists.add(coverArtist);
    }

    public Set<Person> getLetterers() {
        return letterers;
    }

    public void setLetterers(Set<Person> letterers) {
        this.letterers = letterers;
    }

    public void addLetterer(Person letterer) {
        if (this.letterers == null) {
            this.letterers = new HashSet<>();
        }
        this.letterers.add(letterer);
    }
}

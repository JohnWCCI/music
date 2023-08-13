package org.webapi.music.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String duration;
    private int rating;
    private String videoLink;

    @ManyToOne
    private Album album;

    @ElementCollection
    private List<Comment> comments;

    public Song() {
    }

    public Song(String title, String duration, int rating, Album album, String videoLink) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
        this.videoLink = videoLink;
        this.album = album;
    }

    public void addAlbum(Album album){
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public Album getAlbum() {
        return album;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        result = prime * result + rating;
        result = prime * result + ((videoLink == null) ? 0 : videoLink.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (duration == null) {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (rating != other.rating)
            return false;
        if (videoLink == null) {
            if (other.videoLink != null)
                return false;
        } else if (!videoLink.equals(other.videoLink))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Song [title=" + title + ", duration=" + duration + ", rating=" + rating + ", videoLink=" + videoLink
                + "]";
    }

}

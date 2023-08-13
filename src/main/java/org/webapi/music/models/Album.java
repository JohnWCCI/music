package org.webapi.music.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String artistName;
    private String recordLable;
    private String description;
    private String imageUrl;

    @ElementCollection
    private List<Comment> comments;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;

    public Album() {
    }

    public Album(String title, String artistName, String recordLable, String description, String imageUrl) {
        this.title = title;
        this.artistName = artistName;
        this.recordLable = recordLable;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getRecordLable() {
        return recordLable;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public long getId() {
        return id;
    }

    public List<Song> getSongs(){
        return songs;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((artistName == null) ? 0 : artistName.hashCode());
        result = prime * result + ((recordLable == null) ? 0 : recordLable.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
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
        Album other = (Album) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (artistName == null) {
            if (other.artistName != null)
                return false;
        } else if (!artistName.equals(other.artistName))
            return false;
        if (recordLable == null) {
            if (other.recordLable != null)
                return false;
        } else if (!recordLable.equals(other.recordLable))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        } else if (!imageUrl.equals(other.imageUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Album [title=" + title + ", artistName=" + artistName + ", recordLable=" + recordLable + "]";
    }

    

    
    
}


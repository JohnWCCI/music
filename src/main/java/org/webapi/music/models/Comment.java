package org.webapi.music.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Comment {
    
    private String body;
    private String author;
   
    public Comment() {
    }

    public Comment(String body, String author) {
        this.body = body;
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
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
        Comment other = (Comment) obj;
        if (body == null) {
            if (other.body != null)
                return false;
        } else if (!body.equals(other.body))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Comments [body=" + body + ", author=" + author + "]";
    }

    
    
}

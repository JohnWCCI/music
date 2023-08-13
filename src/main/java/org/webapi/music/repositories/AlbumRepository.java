package org.webapi.music.repositories;

import org.springframework.data.repository.CrudRepository;
import org.webapi.music.models.Album;

public interface AlbumRepository extends CrudRepository<Album,Long> {
    
}

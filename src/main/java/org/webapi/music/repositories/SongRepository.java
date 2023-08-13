package org.webapi.music.repositories;

import org.springframework.data.repository.CrudRepository;
import org.webapi.music.models.Song;

public interface SongRepository extends CrudRepository<Song,Long>{
    
}

package org.webapi.music.Services;

import org.springframework.stereotype.Service;
import org.webapi.music.models.Album;
import org.webapi.music.models.Song;
import org.webapi.music.repositories.AlbumRepository;
import org.webapi.music.repositories.SongRepository;

import jakarta.el.ELException;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    public AlbumService(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    public Album save(Album album) throws Exception {
        return albumRepository.save(album);
    }

    public Iterable<Album> retrieveAllAlbums() {
        return albumRepository.findAll();
    }

    public void delete(Long id) throws Exception {
        if (!albumRepository.existsById(id)) {
            throw new Exception("Album not found");
        }
        albumRepository.deleteById(id);
    }

    public Album retrieveAlbumById(Long id) throws Exception {
        try {
            return albumRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception("Album not found");
        }

    }

    public Album addSongToAlbum(Song song, Long albumId) throws Exception {
        Album album = retrieveAlbumById(albumId);
        song.addAlbum(album);
        songRepository.save(song);
        return retrieveAlbumById(albumId);
    }

    public Iterable<Song> retrieveAlbumSongs(Long albumId) throws Exception {
        return retrieveAlbumById(albumId).getSongs();
    }

}

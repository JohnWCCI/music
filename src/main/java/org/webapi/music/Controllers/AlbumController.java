package org.webapi.music.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webapi.music.Services.AlbumService;
import org.webapi.music.models.Album;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("")
    public Iterable<Album> retrieveAllAlbums() {
        return albumService.retrieveAllAlbums();
    }

    @GetMapping("/{id}")
    public Album retrieveAlbumById(@PathVariable Long id) throws Exception {
        return albumService.retrieveAlbumById(id);
    }

    @PostMapping("")
    public Album createNewAlbum(@RequestBody Album album) throws Exception{
        return albumService.save(album);
    }

}

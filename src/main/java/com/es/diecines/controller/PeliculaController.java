package com.es.diecines.controller;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/")
    public PeliculaDTO insert (
            @RequestBody PeliculaDTO pDTO
    ){
        if (pDTO == null) return null;
        pDTO = peliculaService.insert(pDTO);
        return pDTO;
    }

    @GetMapping("/")
    public List<PeliculaDTO> getAll(){
        return peliculaService.getAll();
    }

    @GetMapping("/{id}")
    public PeliculaDTO getById(
            @PathVariable String id
    ){
        if(id == null || id.isEmpty()) return null;

        return peliculaService.getById(id);
    }

    @DeleteMapping("/{id}")
    public PeliculaDTO deleteById(
            @PathVariable String id
    ){
        if(id == null || id.isEmpty()) return null;

        return peliculaService.deleteById(id);
    }

    @PutMapping("/{id}")
    public PeliculaDTO editPelicula(
            @PathVariable String id,
            @RequestBody PeliculaDTO pDTO
    ){
        if (id == null || id.isEmpty() || pDTO == null) return null;
        return peliculaService.editPelicula(id,pDTO);
    }

    @GetMapping("/rating/{minRating}")
    public List<PeliculaDTO> rating(
            @PathVariable String minRating
    ){
        if(minRating == null || minRating.isEmpty()) return null;

        return peliculaService.rating(minRating);
    }
}

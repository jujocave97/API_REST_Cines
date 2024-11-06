package com.es.diecines.mapper;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.model.Pelicula;

public class Mapper {
    public static PeliculaDTO getPeliculaDTO(Pelicula p) {
        PeliculaDTO pDTO = new PeliculaDTO();
        pDTO.setDirector(p.getDirector());
        pDTO.setId(p.getId());
        pDTO.setRating(p.getRating());
        pDTO.setScreenshot(p.getScreenshot());
        pDTO.setSynopsis(p.getSynopsis());
        pDTO.setPosterImage(p.getPosterImage());
        pDTO.setTime(p.getTime());
        pDTO.setTitle(p.getTitle());
        pDTO.setTrailer(p.getTrailer());
        return pDTO;
    }

    public static Pelicula getPelicula(PeliculaDTO pDTO){
        Pelicula p = new Pelicula();
        p.setDirector(pDTO.getDirector());
        p.setRating(pDTO.getRating());
        p.setSynopsis(pDTO.getSynopsis());
        p.setTime(pDTO.getTime());
        p.setScreenshot(pDTO.getScreenshot());
        p.setTitle(pDTO.getTitle());
        p.setPosterImage(pDTO.getPosterImage());
        p.setTrailer(pDTO.getTrailer());
        return p;
    }

    public static Pelicula actualizarPelicula(PeliculaDTO pDTO, Pelicula p){
        p.setDirector(pDTO.getDirector());
        p.setRating(pDTO.getRating());
        p.setSynopsis(pDTO.getSynopsis());
        p.setTime(pDTO.getTime());
        p.setScreenshot(pDTO.getScreenshot());
        p.setTitle(pDTO.getTitle());
        p.setPosterImage(pDTO.getPosterImage());
        p.setTrailer(pDTO.getTrailer());
        return p;
    }
}

package com.es.diecines.service;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.model.Pelicula;
import com.es.diecines.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaDTO getById(String id){

        long idL = 0L;

        try{
            idL = Long.parseLong(id);
        }catch (NumberFormatException n){
            n.printStackTrace();
            return null;
        }

        Pelicula p = peliculaRepository.findById(idL).orElse(null);

        if (p == null) return null;
        else {
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
            return  pDTO;
        }
    }
}

package com.es.diecines.service;

import com.es.diecines.dto.PeliculaDTO;
import com.es.diecines.mapper.Mapper;
import com.es.diecines.model.Pelicula;
import com.es.diecines.model.Sesion;
import com.es.diecines.repository.PeliculaRepository;
import com.es.diecines.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private SesionRepository sesionRepository;

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
            return Mapper.getPeliculaDTO(p);
        }
    }

    public PeliculaDTO insert(PeliculaDTO pDTO){
        Pelicula p = Mapper.getPelicula(pDTO);
        peliculaRepository.save(p);
        pDTO.setId(p.getId());
        return pDTO;
    }

    public List<PeliculaDTO> getAll(){
        List<PeliculaDTO> peliculasDTO = new ArrayList<>();
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas = peliculaRepository.findAll();

        for ( Pelicula p : peliculas){
            peliculasDTO.add(Mapper.getPeliculaDTO(p));
        }

        return peliculasDTO;
    }

    public PeliculaDTO deleteById ( String id ){
        long idL = 0L;
        try{
            idL = Long.parseLong(id);
        }catch (NumberFormatException n){
            n.printStackTrace();
            return null;
        }

        List<Sesion> sesions = sesionRepository.findAll();
        for (Sesion s : sesions){
            if (s.getPelicula().getId() == idL)
                sesionRepository.delete(s);
        }

        Pelicula p = peliculaRepository.findById(idL).orElse(null);
        if ( p == null) return null;
        else {
            peliculaRepository.deleteById(idL);
            return Mapper.getPeliculaDTO(p);
        }
    }

    public PeliculaDTO editPelicula ( String id, PeliculaDTO pDTO){
        long idL = 0L;
        try{
            idL = Long.parseLong(id);
        }catch (NumberFormatException n){
            n.printStackTrace();
            return null;
        }

        Pelicula p = peliculaRepository.findById(idL).orElse(null);
        if ( p == null) return null;
        else {
            peliculaRepository.save(Mapper.actualizarPelicula(pDTO, p));
            return pDTO;
        }
    }


    public List<PeliculaDTO> rating(String rate){
        double rateD = 0.0;
        try{
            rateD = Double.parseDouble(rate);
        }catch (NumberFormatException n){
            n.printStackTrace();
            return null;
        }

        List<Pelicula> peliculas = peliculaRepository.findAll();
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();

        for ( Pelicula p : peliculas){
            if (p.getRating()>=rateD){
                peliculaDTOS.add(Mapper.getPeliculaDTO(p));
            }
        }

        return peliculaDTOS;
    }
}

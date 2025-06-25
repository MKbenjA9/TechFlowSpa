package com.example.TechFlowspa.service;



import com.example.TechFlowspa.model.Geolocalizacion;
import com.example.TechFlowspa.repository.GeolocalizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeolocalizacionService {

    private final GeolocalizacionRepository repository;

    @Autowired
    public GeolocalizacionService(GeolocalizacionRepository repository) {
        this.repository = repository;
    }

    public List<Geolocalizacion> listarTodas() {
        return repository.findAll();
    }

    public Optional<Geolocalizacion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Geolocalizacion> buscarPorUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

    public Geolocalizacion guardar(Geolocalizacion geo) {
        return repository.save(geo);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

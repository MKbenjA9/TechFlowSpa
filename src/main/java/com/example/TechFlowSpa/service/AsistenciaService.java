package com.example.TechFlowSpa.service;

import com.example.TechFlowSpa.model.Asistencia;
import com.example.TechFlowSpa.repository.AsistenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;

    public AsistenciaService(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }

    public List<Asistencia> obtenerAsistencias(){
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> obtenerAsistenciaPorId(Long id){
        return asistenciaRepository.findById(id);
    }

    public Asistencia guardarAsistencia(Asistencia asistencia){
        return asistenciaRepository.save(asistencia);
    }

    public void deleteAsistenciaPorId(Long id){
        asistenciaRepository.deleteById(id);
    }
}

package com.example.TechFlowspa.repository;

import com.example.TechFlowspa.model.Geolocalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeolocalizacionRepository extends JpaRepository<Geolocalizacion, Long> {
    List<Geolocalizacion> findByUsuario(String usuario);
}

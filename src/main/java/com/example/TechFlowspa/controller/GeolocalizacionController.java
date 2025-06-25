package com.example.TechFlowspa.controller;

import com.example.TechFlowspa.model.Geolocalizacion;
import com.example.TechFlowspa.service.GeolocalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/geolocalizaciones")

public class GeolocalizacionController {

    private final GeolocalizacionService service;

    @Autowired
    public GeolocalizacionController(GeolocalizacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Geolocalizacion> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Geolocalizacion> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/usuario/{usuario}")
    public List<Geolocalizacion> obtenerPorUsuario(@PathVariable String usuario) {
        return service.buscarPorUsuario(usuario);
    }

    @PostMapping
    public ResponseEntity<Geolocalizacion> crear(@RequestBody Geolocalizacion geo) {
        Geolocalizacion guardado = service.guardar(geo);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Geolocalizacion> actualizar(@PathVariable Long id, @RequestBody Geolocalizacion geo) {
        return service.buscarPorId(id)
                .map(g -> {
                    g.setLatitud(geo.getLatitud());
                    g.setLongitud(geo.getLongitud());
                    g.setUsuario(geo.getUsuario());
                    return ResponseEntity.ok(service.guardar(g));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

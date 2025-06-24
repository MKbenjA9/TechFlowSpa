package com.example.TechFlowSpa.controller;

import com.example.TechFlowSpa.model.Asistencia;
import com.example.TechFlowSpa.service.AsistenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    private AsistenciaService asistenciaService;

    public AsistenciaController (AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @GetMapping
    public List<Asistencia> obtenerAsistencias() {
        return asistenciaService.obtenerAsistencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> obtenerAsistenciaPorId(@PathVariable Long id){
        return asistenciaService.obtenerAsistenciaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{od}")
    public Asistencia crear(@RequestBody Asistencia asistencia) {
        return asistenciaService.guardarAsistencia(asistencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> actualizarAsistencia(@PathVariable Long id, @RequestBody Asistencia asistenciaActualizada){
        return asistenciaService.obtenerAsistenciaPorId(id)
                .map(asistencia -> {
                    asistencia.setFecha(asistenciaActualizada.getFecha());
                    asistencia.setPresente(asistenciaActualizada.getPresente());
                    return ResponseEntity.ok(asistenciaService.guardarAsistencia(asistencia));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (asistenciaService.obtenerAsistenciaPorId(id).isPresent()) {
            asistenciaService.deleteAsistenciaPorId(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}


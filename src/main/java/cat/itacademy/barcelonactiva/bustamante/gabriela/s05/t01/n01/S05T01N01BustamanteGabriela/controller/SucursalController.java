package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.controller;

import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.services.SucursalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sucursal") // Ruta base para todos los endpoints del controlador
public class SucursalController {
    @Autowired
    private SucursalServicio sucursalServicio;

    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> createSucursal(@RequestBody Sucursal sucursal) {
        Sucursal nuevaSucursal = sucursalServicio.crearSucursal(sucursal);
        SucursalDTO nuevaSucursalDTO = sucursalServicio.convertToDto(nuevaSucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSucursalDTO);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSucursal(@PathVariable int id, @RequestBody Sucursal sucursalActualizada) {
        try {
            sucursalServicio.updateSucursal(id, sucursalActualizada.getNombreSucursal(), sucursalActualizada.getPaisSucursal());
            return ResponseEntity.ok("Sucursal actualizada exitosamente");
        } catch (SucursalNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAllSucursal() {
        List<SucursalDTO> sucursales = sucursalServicio.getAllSucursal();
        return ResponseEntity.ok(sucursales);

    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Sucursal> searchSucursalById(@PathVariable int id) {
        Optional<Sucursal> sucursalOptional = sucursalServicio.getSucursalById(id);

        return sucursalOptional
                .map(sucursal -> ResponseEntity.ok().body(sucursal))  // si la sucursal existe
                .orElseGet(() -> ResponseEntity.notFound().build());  //si la sucursal no existe

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSucursalById(@PathVariable int id) {
        sucursalServicio.deleteSucursalById(id);
        return ResponseEntity.noContent().build();

    }

}


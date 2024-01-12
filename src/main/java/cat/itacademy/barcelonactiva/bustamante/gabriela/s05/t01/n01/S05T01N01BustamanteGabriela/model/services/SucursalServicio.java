package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.services;

import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.dto.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface SucursalServicio {
    Sucursal crearSucursal(Sucursal sucursal);
    //Sucursal addSucursal(Sucursal sucursal);
    List<SucursalDTO> getAllSucursal();
    Sucursal updateSucursal(Integer pk_SucursalID, String nombreSucursal, String paisSucursal);
    Optional<Sucursal> getSucursalById(int id);
    void deleteSucursalById(int id);
    List<SucursalDTO> convertToDtoList(List<Sucursal> sucursales);
    SucursalDTO convertToDto(Sucursal nuevaSucursal);

}


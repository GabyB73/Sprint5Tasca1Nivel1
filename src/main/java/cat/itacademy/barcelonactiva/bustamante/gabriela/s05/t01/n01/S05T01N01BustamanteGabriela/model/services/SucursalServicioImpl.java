package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.services;

import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.repository.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SucursalServicioImpl implements SucursalServicio{
    @Autowired
    private final SucursalRepositorio sucursalRepositorio;

    public SucursalServicioImpl(SucursalRepositorio sucursalRepositorio) {
        this.sucursalRepositorio = sucursalRepositorio;
    }
    //Métodos CRUD

    @Override
    public Sucursal crearSucursal(Sucursal sucursal) {

        return sucursalRepositorio.save(sucursal);
    }

    @Override
    public List<SucursalDTO> getAllSucursal() {
        List<Sucursal> sucursales = sucursalRepositorio.findAll();
        return convertToDtoList(sucursales);

    }

    @Override
    public Sucursal updateSucursal(Integer pk_SucursalID, String nuevoNombreSucursal, String nuevoPaisSucursal) {
        Optional<Sucursal> sucursalOptional = sucursalRepositorio.findById(pk_SucursalID);

        if (sucursalOptional.isPresent()) {
            Sucursal sucursal = sucursalOptional.get();
            sucursal.setNombreSucursal(nuevoNombreSucursal);
            sucursal.setPaisSucursal(nuevoPaisSucursal);
            return sucursalRepositorio.save(sucursal);
        } else {
            throw new SucursalNotFoundException("Sucursal no encontrada con el ID: " + pk_SucursalID);
        }

    }

    @Override
    public Optional<Sucursal> getSucursalById(int id) {
        return sucursalRepositorio.findById(id);

    }

    @Override
    public void deleteSucursalById(int id) {
        sucursalRepositorio.deleteById(id);

    }

    //Métodos de conversión
    //Método para convertir la Entidad en DTO
    public SucursalDTO convertToDto(Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNombreSucursal(sucursal.getNombreSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());

        // Lógica para determinar el tipo de sucursal basado en la lista de países de la UE
        if (SucursalDTO.getPaisesUE().contains(sucursal.getPaisSucursal())) {
            sucursalDTO.setTipoSucursal("UE");
        } else {
            sucursalDTO.setTipoSucursal("Fuera UE");
        }

        return sucursalDTO;
    }
//Método para convertir el DTO en la Entidad
@Override
    public List<SucursalDTO> convertToDtoList(List<Sucursal> sucursales) {
        return sucursales.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());


    }
}





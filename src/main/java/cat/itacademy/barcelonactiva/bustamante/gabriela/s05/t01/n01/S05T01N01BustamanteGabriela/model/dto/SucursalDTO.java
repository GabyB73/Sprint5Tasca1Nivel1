package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.dto;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO {
    private Integer pk_SucursalID;
    private String nombreSucursal;
    private String paisSucursal;
    private String tipoSucursal;
    private static final List<String> PAISES_UE_LIST = Arrays.asList("Alemania","Austria", "Bélgica", "Bulgaria", "Chequia",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia","Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "Rumania", "Suecia");


    public SucursalDTO() {
    }

    public SucursalDTO(Integer pk_SucursalID, String nombreSucursal, String paisSucursal, String tipoSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
        this.tipoSucursal = tipoSucursal;
    }
    public static List<String> getPaisesUE() {   //Para poder acceder a la lista de países

        return PAISES_UE_LIST;
    }
    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(String tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

}

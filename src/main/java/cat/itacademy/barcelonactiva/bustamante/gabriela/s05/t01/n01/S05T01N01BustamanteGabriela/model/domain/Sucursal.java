package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.domain;

import jakarta.persistence.*;

@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_SucursalID;
    @Column(name = "nombre de la sucursal")
    private String nombreSucursal;
    @Column(name = "país de la sucursal")
    private String paisSucursal;

    public Sucursal() {
    }

    public Sucursal(String nombreSucursal, String paisSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Sucursal(Integer pk_SucursalID, String nombreSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    /*public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }*/

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

    @Override
    public String toString() {
        return "Sucursal{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                '}';
    }
}
/* return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s']",
        id, firstName, lastName);*/
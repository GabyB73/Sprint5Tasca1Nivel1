package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.controller;

import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n01.S05T01N01BustamanteGabriela.model.services.SucursalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web/sucursales")
public class WebController {
    @Autowired
    private SucursalServicio sucursalServicio;

    @GetMapping("/list")
    public String listSucursales(Model model) {
        List<SucursalDTO> sucursales = sucursalServicio.getAllSucursal();
        model.addAttribute("sucursales", sucursales);
        return "list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("sucursal", new Sucursal());
        return "form";
    }

    @PostMapping("/save")
    public String saveSucursal(@ModelAttribute Sucursal sucursal) {
        sucursalServicio.crearSucursal(sucursal);
        return "redirect:/web/sucursales/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Sucursal> sucursalOptional = sucursalServicio.getSucursalById(id);
        if (sucursalOptional.isPresent()) {
            model.addAttribute("sucursal", sucursalOptional.get());
            return "editForm";
        } else {
            return "redirect:/web/sucursales/list";
        }
    }

    @PostMapping("/update/{id}")
    public String updateSucursal(@PathVariable int id, @ModelAttribute Sucursal sucursal, Model model) {
        try {
            sucursalServicio.updateSucursal(id, sucursal.getNombreSucursal(), sucursal.getPaisSucursal());
            return "redirect:/web/sucursales/list";
        } catch (SucursalNotFoundException e) {

            model.addAttribute("error", e.getMessage());
            return "editForm";

        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable int id) {
        sucursalServicio.deleteSucursalById(id);
        return "redirect:/web/sucursales/list";
    }

}

package cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.controller;

import cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.dto.SucursalDto;
import cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.services.SucursalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sucursals")
public class SucursalController {

    private SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        super();
        this.sucursalService = sucursalService;
    }

    // retornem String pq es arxiu html
    @GetMapping(value = {"/getAll", ""})
    public String viewHomePage(Model model){

        model.addAttribute("listSucursal", sucursalService.getAllSucursal());
        return "/sucursals"; // retornem a arxiu principal

    }

    @GetMapping("/getOne/{id}")
    public String getSucursalById(@PathVariable(name = "id") Integer id, Model model){

        model.addAttribute("sucursal", sucursalService.getSucursalById(id));
        return "oneSucursal";

    }

    @GetMapping("/newSucursal")
    public String sucursalForm(Model model){
        SucursalDto sucursalDto = new SucursalDto();
        model.addAttribute("sucursal", sucursalDto);
        return "createNewSucursal";

    }

    @PostMapping("/create")
    public String createSucursal(@ModelAttribute("sucursal") SucursalDto sucursalDto){
        sucursalService.createSucursal(sucursalDto);
        return "redirect:/sucursals";
    }

    @GetMapping("/updateOne/{id}")
    public String editSucursal(@PathVariable Integer id, Model model){
        model.addAttribute("modifiedSucursal", sucursalService.getSucursalById(id));
        return ("editSucursal");
    }

    @PostMapping("/update")
    public String updateSucursal(@ModelAttribute("modifiedSucursal") SucursalDto sucursalDto){
        sucursalService.updateSucursal(sucursalDto, sucursalDto.getId());
        return "redirect:/sucursals";
    }

    @GetMapping("/deleteOne/{id}")
    public String deleteSucursal(@PathVariable Integer id){
        sucursalService.deleteSucursal(id);
        return "redirect:/sucursals";
    }
}


















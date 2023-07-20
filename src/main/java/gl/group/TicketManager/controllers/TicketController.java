package gl.group.TicketManager.controllers;

import gl.group.TicketManager.entities.Ticket;
import gl.group.TicketManager.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TicketController {

    @Autowired
    TicketService service;

    @GetMapping({ "", "/", "/index" })
    public String home(Model model){
//        service.addTicket(new Ticket());
//        System.out.println(service.getAllTickets().get(0).getCreatedDate());
        model.addAttribute("tickets", service.getAllTickets());
        return "index";
    }

    @GetMapping("/search")
    public String searchTickets(@RequestParam("s") String text, Model model){
        model.addAttribute("tickets", service.searchTickets(text.toLowerCase()));
        return "index";
    }

    @GetMapping({"/page/add"})
    public String addTicketPage(Model model){
        model.addAttribute("ticket", new Ticket());
        return "add";
    }

    @PostMapping({"/post/add"})
    public RedirectView handleAddTicket(Model model, @ModelAttribute("ticket") Ticket ticket){
        service.addTicket(ticket);
        return new RedirectView("/");
    }

    @GetMapping({"/page/edit/{id}"})
    public String editTicketPage(Model model, @PathVariable("id") Long id){
        model.addAttribute("ticket", service.getTicket(id));
        return "edit";
    }

    @PostMapping({"/post/edit/{id}"})
    public RedirectView handleEditTicket(Model model, @ModelAttribute("ticket") Ticket ticket, @PathVariable("id") Long id){
        service.editTicket(ticket, id);
        return new RedirectView("/");
    }

    @GetMapping({"/page/view/{id}"})
    public String viewTicketPage(Model model, @PathVariable("id") Long id){
        model.addAttribute("ticket", service.getTicket(id));
        return "view";
    }

    @GetMapping({"/page/delete/{id}"})
    public RedirectView handleDeleteTicket(Model model, @PathVariable("id") Long id){
        service.deleteTicket(id);
        return new RedirectView("/");
    }
}

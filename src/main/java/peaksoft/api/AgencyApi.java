//package peaksoft.api;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import peaksoft.entity.Agency;
//import peaksoft.service.AgencyService;
//
//@Controller
//@RequestMapping("agencies")
//@RequiredArgsConstructor
//public class AgencyApi {
//    private final AgencyService agencyService;
//    @GetMapping()
//    public String getAllAgencies(Model model) {
//        model.addAttribute("agencies", agencyService.getAllAgencies());
//        return "agencies";
//    }
//    @GetMapping("/new")
//    public String createAgency(Model model) {
//        model.addAttribute("newAgency", new Agency());
//        return "agencies";
//    }
//    @PostMapping("/save")
//    public String saveCompany(@ModelAttribute("newAgency") Agency agency) {
//        agencyService.saveAgency(agency);
//        return "redirect:/agencies";
//    }
//}
package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.service.AgencyService;

@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyApi {
    private final AgencyService agencyService;

    @GetMapping()
    public String getAllAgencies(Model model) {
        model.addAttribute("agencies", agencyService.getAllAgencies());
        return "Agency";
    }
    @GetMapping("/{id}")
    public String getAgencyById(@PathVariable ("id")Long id,Model model) {
        model.addAttribute("agencies", agencyService.getAgencyById(id));
        return "AgencyInfo";
    }

    @GetMapping("/new")
    public String createAgency(Model model) {
        model.addAttribute("newAgency", new Agency());
        return "newAgency";
    }

    @PostMapping("/save")
    public String saveAgency(@ModelAttribute("newAgency") Agency agency){
        agencyService.saveAgency(agency);
        return "redirect:/agencies";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteAgency(@PathVariable("id") Long id) {
        agencyService.deleteAgencyById(id);
        return "redirect:/agencies";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") Long id,
                         Model model) {
        model.addAttribute("editAgency", agencyService.getAgencyById(id));
        return "updateAgency";
    }

    @PostMapping("/updateAgency/{id}")
    public String saveUpdate(@ModelAttribute("editAgency") Agency agency,
                             @PathVariable("id") Long id) {
        agencyService.updateAgency(id, agency);
        return "redirect:/agencies";
    }

}
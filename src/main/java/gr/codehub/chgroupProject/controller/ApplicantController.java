package gr.codehub.chgroupProject.controller;

import gr.codehub.chgroupProject.model.Applicant;
import gr.codehub.chgroupProject.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    /**
     *
     * @return list off aplicants
     */
    @GetMapping("applicant")
    public List<Applicant> getListApplicants(){
        return applicantService.getApplicant();
    }

    /**
     *
     * @param applicantId specific applicant
     * @return give us back a specific applicant
     */
    @GetMapping("applicant/{applicantId}")
    public Applicant getApplicantById(@PathVariable int applicantId)
            //TODO throws CustomerNotFoundException
    {
        return applicantService.getApplicant(applicantId);
    }

    /**
     *
     * @param applicant
     * @return add a new applicant
     */
    @PostMapping("applicant")
    public Applicant addApplicant(@RequestBody Applicant applicant)
           //TODO throws CustomerCreationException
    {
        return applicantService.addApplicant(applicant);
    }

}

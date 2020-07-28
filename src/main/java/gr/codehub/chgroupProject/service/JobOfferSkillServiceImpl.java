package gr.codehub.chgroupProject.service;

import gr.codehub.chgroupProject.excheption.JobOfferNotFoundException;
import gr.codehub.chgroupProject.excheption.SkillNotFoundException;
import gr.codehub.chgroupProject.model.ApplicantSkill;
import gr.codehub.chgroupProject.model.JobOffer;
import gr.codehub.chgroupProject.model.JobOfferSkill;
import gr.codehub.chgroupProject.model.Skill;
import gr.codehub.chgroupProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//todo na paroume mia lista me ola ta applicantSkill

@Service
public class JobOfferSkillServiceImpl implements JobOfferSkillService {
    @Autowired
    JobOfferSkillRepository jobOfferSkillRepo;
    @Autowired
    SkillRepository skillRepo;
    @Autowired
    JobOfferRepository jobOfferRepo;


    @Override
    public JobOfferSkill addJobOfferSkill(int jobOfferId, int skillId) throws SkillNotFoundException, JobOfferNotFoundException {
        JobOffer jobOfferInDb = jobOfferRepo.findById(jobOfferId)
                        .orElseThrow(
                        () -> new JobOfferNotFoundException("Job offer not found")
                              );

        Skill skillInDb = skillRepo.findById(skillId)
                .orElseThrow(
                        () -> new SkillNotFoundException("Skill not found")
                );

        JobOfferSkill jobOfferSkill = new JobOfferSkill();
        jobOfferSkill.setJobOffer(jobOfferInDb);
        jobOfferSkill.setSkill(skillInDb);

        jobOfferSkillRepo.save(jobOfferSkill);
        return jobOfferSkill;


    }
}

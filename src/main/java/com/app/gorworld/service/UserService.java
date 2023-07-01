package com.app.gorworld.service;

import com.app.gorworld.dto.UpdatePlanDto;
import com.app.gorworld.dto.VerifyPlanDto;
import com.app.gorworld.exception.UserNotFoundException;
import com.app.gorworld.model.User;
import com.app.gorworld.model.enums.PLAN;
import com.app.gorworld.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    MongoSequenceGeneratorService sequenceGeneratorService;
    public User getUser(String mobileNumber){
      return userRepo.findByMobileNumber(mobileNumber);
    }

    public User getUserData(String mobileNumber) throws UserNotFoundException, ParseException {
        User user = userRepo.findByMobileNumber(mobileNumber);
        if(user == null){
            throw new UserNotFoundException("User with "+mobileNumber+" not found");
        }
        verifyUserPlan(user);
        return user;
    }

    private User verifyUserPlan(User user){
        if(user.getPlan() == null) {
            user.setActive(false);
            return user;
        }
        Date planDate = user.getPlanDate();
        long diff = planDate == null ? 0 : getDateDiffToCurrentDate(planDate);
        if(diff > user.getPlan().getDays()){
            user.setActive(false);
        }
        return user;
    }

    private long getDateDiffToCurrentDate(Date planDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date currentDate = sdf.parse("22/03/2024");
        Date currentDate = new Date();
        long diffInMillies = Math.abs(currentDate.getTime() - planDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public User createUser(User user) {
        user.setId(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME));
        return userRepo.save(user);
    }

    public User updateUserPlan(UpdatePlanDto updatePlanDto, User user) {
        user.setPlan(PLAN.valueOf(updatePlanDto.getPlan()));
        user.setPlanDate(new Date());
        return userRepo.save(user);
    }


    public VerifyPlanDto verifyPlan(User user) throws ParseException {
        VerifyPlanDto result = new VerifyPlanDto();
        result.setMobileNumber(user.getMobileNumber());
        long days=0;
        boolean userActive=false;
        if(user.getPlan() != null){
            userActive = verifyUserPlan(user).getActive();
            long diff = user.getPlanDate()==null?0:getDateDiffToCurrentDate(user.getPlanDate());
            days = user.getPlan().getDays() - diff > 0 ? user.getPlan().getDays() - diff : 0;
        }
        result.setPlanActive(userActive);
        result.setMessage( days + " days remaining");
        return result;
    }
}

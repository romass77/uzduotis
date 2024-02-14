package lt.bit.tasks.controllers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import javax.xml.bind.DatatypeConverter;
import lt.bit.tasks.dao.UserDAO;
import lt.bit.tasks.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("user_list")
    public ModelAndView usersList() {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("list", userDAO.findAll());
        return mav;
    }

    @GetMapping("edit")
    public ModelAndView edit(@RequestParam(value = "iduser", required = false) Integer id) {
        ModelAndView mav;
        if (id == null) {
            mav = new ModelAndView("user");
        } else {
            Optional<User> oUser = userDAO.findById(id);
            if (oUser.isPresent()) {
                mav = new ModelAndView("user");
                mav.addObject("value", oUser.get());
            } else {
                mav = usersList();
            }
        }
        return mav;
    }

    @PostMapping("save")
    @Transactional
    public ModelAndView save(
            @RequestParam(value = "iduser", required = false) Integer id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        String encryptedPassword = encryptPassword(password);
        if (id == null) {
            User u = new User();
            u.setName(name);
            u.setEmail(email);
           // u.setPassword(password);
            u.setPassword(encryptedPassword);
            userDAO.save(u);
        } else {
            Optional<User> oUser = userDAO.findById(id);
            if (oUser.isPresent()) {
                User us = oUser.get();
                us.setName(name);
                us.setEmail(email);
                //us.setPassword(password);
                us.setPassword(encryptedPassword);
                userDAO.save(us);
            }

        }
        return usersList();
    }

  // password encrypting metod
    private String encryptPassword(String password) {
        // Use MD5 or a stronger encryption algorithm to encrypt the password
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printHexBinary(hashedBytes).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password", e);
        }
    }
  @GetMapping("delete")
    @Transactional
    public ModelAndView delete(@RequestParam("iduser") Integer id) {
        userDAO.deleteById(id);
        return usersList();
    }

}

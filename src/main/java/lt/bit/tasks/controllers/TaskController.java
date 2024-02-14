
package lt.bit.tasks.controllers;

import lt.bit.tasks.dao.TaskDAO;
import lt.bit.tasks.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("task")
public class TaskController {
    
    
    @Autowired
    private TaskDAO taskDAO;
      @Autowired
    private UserDAO userDAO;
    
    
    @GetMapping("task_list")
    public ModelAndView sarasas() {
        ModelAndView mav = new ModelAndView("tasks");
        mav.addObject("uzduotis", taskDAO.findAll());
        return mav;
    }
     @GetMapping("task_user")
    public ModelAndView taskSarasas(@RequestParam(value = "userid",required = true)Integer id) {
        ModelAndView mav = new ModelAndView("tasks");
        mav.addObject("uzduotis", taskDAO.findById(id).get());
        return mav;
    }

    
}

package ie.cpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;

@Controller
@RequestMapping("/hello")
public class HelloController {
  private static final Logger LOG = Logger.getLogger(HelloController.class);
  private static final String START = "start ..";
  private static final String END = ".. end";

  @RequestMapping(method = RequestMethod.GET)
  public String printHello(ModelMap model) {
    if(LOG.isDebugEnabled()){
      LOG.debug(START);
    }

    try {
      model.addAttribute("message", "Hello at " + System.currentTimeMillis());
      return "hello";

    } finally{
      if(LOG.isDebugEnabled()){
        LOG.debug(END);
      }

    }
  }

}
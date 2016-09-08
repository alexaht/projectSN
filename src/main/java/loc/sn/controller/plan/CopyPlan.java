package loc.sn.controller.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/copyPlan")
public class CopyPlan {

    @Autowired
    private MessageSource source;

}

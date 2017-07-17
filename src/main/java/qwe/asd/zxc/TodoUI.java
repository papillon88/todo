package qwe.asd.zxc;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * Created by papillon on 7/17/2017.
 */
@SpringUI
public class TodoUI extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Label("I'm the root UI!"));
    }
}

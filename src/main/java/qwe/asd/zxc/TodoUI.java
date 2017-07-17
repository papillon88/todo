package qwe.asd.zxc;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by papillon on 7/17/2017.
 */
@SpringUI
@Theme("valo")
public class TodoUI extends UI {

    private VerticalLayout layout;
    @Autowired
    private TodoList todoList;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        //setContent(new Label("I'm the root UI!"));
        setupLayout();
        addHeader();
        addForm();
        addTodoList();
        addActionButton();
    }

    private void addActionButton() {
        Button delete = new Button("Delete completed");
        layout.addComponent(delete);
    }

    private void addTodoList() {
        todoList.setWidth("80%");
        layout.addComponent(todoList);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setSpacing(true);
        formLayout.setWidth("80%");
        TextField task = new TextField();
        task.setWidth("100%");

        Button add = new Button("");
        add.setIcon(FontAwesome.PLUS);
        add.addStyleName(ValoTheme.BUTTON_PRIMARY);
        formLayout.addComponents(task,add);
        formLayout.setExpandRatio(task,1);
        layout.addComponent(formLayout);
    }

    private void addHeader() {
        Label header = new Label("TODO");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        layout.addComponent(header);
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }
}

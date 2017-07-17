package qwe.asd.zxc;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
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
        layout.addComponent(todoList);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        TextField task = new TextField();
        Button add = new Button("Add");
        formLayout.addComponents(task,add);
        layout.addComponent(formLayout);
    }

    private void addHeader() {
        Label header = new Label("TODO");
        layout.addComponent(header);
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        setContent(layout);
    }
}

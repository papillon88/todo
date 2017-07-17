package qwe.asd.zxc;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Arrays;

/**
 * Created by papillon on 7/17/2017.
 */
public class TodoLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;

    public TodoLayout(Todo todo,TodoChangeListner changeListner) {
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setWidth("100%");
        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bindInstanceFields(this);
        binder.setBean(todo);
        addComponents(done,text);
        setExpandRatio(text,1);

        Arrays.asList(done,text).forEach(field -> {
            field.addValueChangeListener(change -> {
               changeListner.todoChanged(todo);
            });
        });
    }
}

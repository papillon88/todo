package qwe.asd.zxc;

import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by papillon on 7/17/2017.
 */
@Component
public class TodoList extends VerticalLayout{

    @Autowired
    TodoRepository todoRepository;

    @PostConstruct
    void init(){
        setSpacing(true);

        setTodos(todoRepository.findAll());
    }

    private void setTodos(List<Todo> todos) {
        removeAllComponents();
        todos.forEach(todo -> {
            addComponent(new TodoLayout(todo));
        });
    }
}

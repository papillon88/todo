package qwe.asd.zxc;

import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by papillon on 7/17/2017.
 */
@Component
public class TodoList extends VerticalLayout implements TodoChangeListner{

    @Autowired
    private TodoRepository todoRepository;
    private List<Todo> todos;

    @PostConstruct
    void init(){
        setSpacing(true);

        update();
    }

    private void update() {
        setTodos(todoRepository.findAll());
    }

    private void setTodos(List<Todo> todos) {
        this.todos = todos;
        removeAllComponents();
        todos.forEach(todo -> {
            addComponent(new TodoLayout(todo,this));
        });
    }

    public void add(Todo todo) {
        todoRepository.save(todo);
        update();
    }

    @Override
    public void todoChanged(Todo todo) {
        add(todo);
    }

    public void deleteCompleted() {
        todoRepository.deleteInBatch(todos.stream().filter(Todo::isDone).collect(Collectors.toList()));
        update();
    }
}

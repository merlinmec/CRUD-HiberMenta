package merlin.mec;



import org.mentawai.ajax.renderer.JsonRenderer;
import org.mentawai.filter.AjaxFilter;
import org.mentawai.filter.ValidationFilter;


public class AppManager extends org.mentawai.core.ApplicationManager {

    public void loadFilters() {
        filter(new ValidationFilter());
        filter(new AjaxFilter(AJAX));
        on(AJAX, ajax(new JsonRenderer()));
    }

    @Override
    public void loadActions() {
        addActionPackage("merlin.mec");
        
        action(ContatoAction.class, "create")
        .on(ERROR, redir("/criarcontato.jsp"))
        .on(SUCCESS, fwd("/ContatoAction.list.mtw"));
        
        action(ContatoAction.class, "update")
        .on(ERROR, fwd("/editarcontato.jsp"))
        .on(EDIT, fwd("/editarcontato.jsp"))
        .on(SUCCESS, fwd("/ContatoAction.list.mtw"));

        
        action(ContatoAction.class, "delete")
        .on(ERROR, redir("/ContatoAction.list.mtw"))
        .on(SUCCESS, redir("/ContatoAction.list.mtw"));
        
        action(ContatoAction.class, "list")
        .on(ERROR, redir("/hello.jsp"))
        .on(SUCCESS, fwd("/contatos.jsp"));
        
        action(ContatoAction.class, "select")
        .on(ERROR, redir("/contatos.jsp"))
        .on(SUCCESS, fwd("/editarcontato.jsp"));
        
        action(ContatoAction.class, "cidadesMapJSON")
        .on(SUCCESS, ajax(new JsonRenderer()));

    }

}

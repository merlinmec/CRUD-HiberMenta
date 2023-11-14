package merlin.mec;

import java.util.List;

import org.mentawai.core.BaseAction;
import org.mentawai.rule.MethodRule;
import org.mentawai.rule.RegexRule;
import org.mentawai.rule.StringRule;
import org.mentawai.validation.Validatable;
import org.mentawai.validation.Validator;

import mec.dao.ContatoDAO;
import mec.util.HibernateUtil;
import mec.model.Contato;

public class ContatoAction extends BaseAction implements Validatable{
	
	private ContatoDAO contatoDAO;

    public ContatoAction() {
        this.contatoDAO = new ContatoDAO(HibernateUtil.getSessionFactory());
    }
    
    public void prepareValidator(Validator val, String method) {
		 
		 String regexAlfanumerico = "[a-zA-Zà-úÀ-Ú0-9\\s]+";
		 String regexEmail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		 String regexTelefone = "\\(\\d{2}\\)9\\d{4}-\\d{4}";		 
		 
		 if (method != null && method.equals("create") && isPost()) {
			 val.requiredFields("Campo Obrigatório!","nome", "telefone","email","rua","numero","bairro","cidade","estado");
			 val.add("nome", StringRule.getInstance(3,25), "Campo Nome com o tamanho errado (mín = 3, máx = 25)");
			 val.add("nome",RegexRule.getInstance(regexAlfanumerico), "O campo Nome não pode ter caracteres especiais!");
			 val.add("email", RegexRule.getInstance(regexEmail), "Email não está no formato correto!");
			 val.add("email", MethodRule.getInstance(this, "checkEmailAdd"), "Email já registrado, insira outro email!");
			 val.add("telefone", RegexRule.getInstance(regexTelefone), "Formato correto do campo Telefone:(XX)9XXXX-XXXX !");
			 val.add("telefone", StringRule.getInstance(0,14), "Campo Telefone com o tamanho errado (máx = 14)");
			 val.add("telefone", MethodRule.getInstance(this, "checkTelefoneAdd"), "Telefone já registrado, insira outro telefone!");
			 val.add("rua",RegexRule.getInstance(regexAlfanumerico), "O campo Rua não pode ter caracteres especiais!!");
			 val.add("rua", StringRule.getInstance(5,40), "Campo Rua com o tamanho errado (mín = 5, máx = 40)");
			 val.add("numero",RegexRule.getInstance(regexAlfanumerico), "O campo Nº da Residência não pode ter caracteres especiais!");
			 val.add("numero", StringRule.getInstance(0,10), "Campo Nº da Residência com o tamanho errado (máx = 10)");
			 val.add("bairro",RegexRule.getInstance(regexAlfanumerico), "O campo Bairro não pode ter caracteres especiais!");
			 val.add("bairro", StringRule.getInstance(5,40), "Campo Bairro com o tamanho errado (mín = 5, máx = 40)");
			 val.add("cidade",RegexRule.getInstance(regexAlfanumerico), "O campo Cidade não pode ter caracteres especiais!!");
			 val.add("cidade", StringRule.getInstance(5,30), "Campo Cidade com o tamanho errado (mín = 5, máx = 30)");
			 val.add("estado",RegexRule.getInstance(regexAlfanumerico), "O campo Estado não pode ter caracteres especiais!");
			 val.add("estado", StringRule.getInstance(2,20), "Campo Estado com o tamanho errado (mín = 2, máx = 20)");
		 }  else if (method != null && method.equals("update") && isPost()) {
			 val.requiredFields("Campo Obrigatório!","nome", "telefone","email","rua","numero","bairro","cidade","estado");
			 val.add("nome", StringRule.getInstance(3,25), "Campo Nome com o tamanho errado (mín = 3, máx = 25)");
			 val.add("nome",RegexRule.getInstance(regexAlfanumerico), "O campo Nome não pode ter caracteres especiais!");
			 val.add("email", RegexRule.getInstance(regexEmail), "Email não está no formato correto!");
			 val.add("email", MethodRule.getInstance(this, "checkEmailEdit"), "Email já registrado, insira outro email!");
			 val.add("telefone", RegexRule.getInstance(regexTelefone), "Formato correto do campo Telefone:(XX)9XXXX-XXXX !");
			 val.add("telefone", StringRule.getInstance(0,14), "Campo Telefone com o tamanho errado (máx = 14)");
			 val.add("telefone", MethodRule.getInstance(this, "checkTelefoneEdit"), "Telefone já registrado, insira outro telefone!");
			 val.add("rua",RegexRule.getInstance(regexAlfanumerico), "O campo Rua não pode ter caracteres especiais!!");
			 val.add("rua", StringRule.getInstance(5,40), "Campo Rua com o tamanho errado (mín = 5, máx = 40)");
			 val.add("numero",RegexRule.getInstance(regexAlfanumerico), "O campo Nº da Residência não pode ter caracteres especiais!");
			 val.add("numero", StringRule.getInstance(0,10), "Campo Nº da Residência com o tamanho errado (máx = 10)");
			 val.add("bairro",RegexRule.getInstance(regexAlfanumerico), "O campo Bairro não pode ter caracteres especiais!");
			 val.add("bairro", StringRule.getInstance(5,40), "Campo Bairro com o tamanho errado (mín = 5, máx = 40)");
			 val.add("cidade",RegexRule.getInstance(regexAlfanumerico), "O campo Cidade não pode ter caracteres especiais!!");
			 val.add("cidade", StringRule.getInstance(5,30), "Campo Cidade com o tamanho errado (mín = 5, máx = 30)");
			 val.add("estado",RegexRule.getInstance(regexAlfanumerico), "O campo Estado não pode ter caracteres especiais!");
			 val.add("estado", StringRule.getInstance(2,20), "Campo Estado com o tamanho errado (mín = 2, máx = 20)");	 
		 }	
	 }
    
    public String create() {
        if (!isPost()) {
            return ERROR;
        }
        Contato contato = createContatoPeloInput();

        try {
            contatoDAO.createContato(contato);
            addMessage("Contato criado!");
        } catch (Exception e) {
            addError("Erro ao criar contato: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;  
    }


    public String update() {
        if (!isPost()) {
            return EDIT;
        }
        
        int idContato = input.getInt("id");
        Contato contato = contatoDAO.selectContato(idContato);
        System.out.println("ID do Contato: " + idContato);
        
        if (contato == null) {
        	return ERROR;
        }

        if (contato != null && contato.getIdcon() == idContato) {
        	

            Contato contatoAtualizado = createContatoPeloInput();

            contato.setNome(contatoAtualizado.getNome());
            contato.setTelefone(contatoAtualizado.getTelefone());
            contato.setEmail(contatoAtualizado.getEmail());
            contato.setRua(contatoAtualizado.getRua());
            contato.setNumero(contatoAtualizado.getNumero());
            contato.setBairro(contatoAtualizado.getBairro());
            contato.setCidade(contatoAtualizado.getCidade());
            contato.setEstado(contatoAtualizado.getEstado());
           
            try {
                contatoDAO.updateContato(contato, idContato);
                addMessage("Contato atualizado com sucesso!");
                return SUCCESS;
            } catch (Exception e) {
            	System.out.println(contato.getNome());
                addError("Erro ao atualizar contato: " + e.getMessage());
                return ERROR;
            }
        } else {
            System.out.println("Contato não encontrado");
            return ERROR;
        }
    }

    
    
    public String delete() {
        int id = input.getInt("id");
        try {
            contatoDAO.deleteContato(id);
            addMessage("Contato deletado!");
        } catch (Exception e) {
            addError("Erro ao deletar contato: " + e.getMessage());
        }

        return SUCCESS;
    }

    public String list() {
        try {
            List<Contato> listaContatos = contatoDAO.listContatos();
            output.setValue("listacontatos", listaContatos);
            return SUCCESS;
        } catch (Exception e) {
            addError("Erro ao listar contatos: " + e.getMessage());
            return ERROR;
        }
    }



    private Contato createContatoPeloInput() {
        Contato contato = new Contato();
        contato.setNome(input.getString("nome"));
        contato.setTelefone(input.getString("telefone"));
        contato.setEmail(input.getString("email"));
        contato.setRua(input.getString("rua"));
        contato.setNumero(input.getString("numero"));
        contato.setBairro(input.getString("bairro"));
        contato.setCidade(input.getString("cidade"));
        contato.setEstado(input.getString("estado"));
        return contato;
    }
    
    public String select() {
        int id = input.getInt("id");
        try {
            Contato contato = contatoDAO.selectContato(id);
            if (contato != null) {
                output.setValue("contato", contato);
                
                return SUCCESS;
            } else {
                addError("Contato não encontrado");
                return ERROR;
            }
        } catch (Exception e) {
            addError("Erro ao obter contato: " + e.getMessage());
            return ERROR;
        }
    }
    
    boolean checkTelefoneAdd(String telefone) {
        return contatoDAO.findByTelefone(telefone) == null;
    }
    
    boolean checkEmailAdd(String email) {
        return contatoDAO.findByEmail(email) == null;
    }
    
    boolean checkTelefoneEdit(String telefone) {
    	int idContato = input.getInt("id");
        Contato contato = contatoDAO.selectContato(idContato);

        if (!contato.getTelefone().equals(telefone)) {
            return contatoDAO.findByTelefone(telefone) == null;
        }
        return true;
    }
    
    boolean checkEmailEdit(String email) {
    	int idContato = input.getInt("id");
        Contato contato = contatoDAO.selectContato(idContato);

        if (!contato.getEmail().equals(email)) {
            return contatoDAO.findByEmail(email) == null;
        }
        return true;
    }
   
}

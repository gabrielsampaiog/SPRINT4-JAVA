package br.com.bikeinsure.model;

import org.mindrot.jbcrypt.BCrypt;

public class Colaborador {
    private int idColaborador;
    private String nome;
    private String senhaHash;
    private String salt;

    // Construtor que inclui o idColaborador
    public Colaborador(int idColaborador, String nome, String senhaHash, String salt) {
        this.idColaborador = idColaborador;
        this.nome = nome;
        this.senhaHash = senhaHash;
        this.salt = salt;
    }


    // Getter e Setter para senhaHash (não permita a definição direta)
    public String getSenhaHash() {
        return senhaHash;
    }

    // Mantenha o método setSenha para alteração de senha
    public void setSenha(String senha) {
        // Adicione uma verificação de política de senha forte
        if (!verificarPoliticaSenhaForte(senha)) {
            throw new IllegalArgumentException("A senha não atende à política de senha forte.");
        }

        this.salt = BCrypt.gensalt(12);
        this.senhaHash = hashSenha(senha, salt);
    }

    // Getter para salt (não permita a definição direta)
    public String getSalt() {
        return salt;
    }

    // Outros getters e setters
    
    public int getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
    

    // Método para verificar a senha
    public boolean verificarSenha(String senha) {
        String senhaCandidata = hashSenha(senha, salt);
        return senhaCandidata.equals(this.senhaHash);
    }

	// Método para gerar o hash da senha
    private String hashSenha(String senha, String salt) {
        return BCrypt.hashpw(senha, salt);
    }

    // Adicione uma verificação de política de senha forte
    private boolean verificarPoliticaSenhaForte(String senha) {
        return senha.length() >= 8 && senha.matches(".*[A-Z].*") && senha.matches(".*[a-z].*") && senha.matches(".*\\d.*");
    }

   

}

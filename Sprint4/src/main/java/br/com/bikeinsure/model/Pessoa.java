package br.com.bikeinsure.model;

import org.mindrot.jbcrypt.BCrypt;

public class Pessoa {

    private int idPessoa;
    private String nome;
    private String cpf;
    private int rg;
    private String dataNascimento;
    private String endereco;
    private String senhaHash;
    private String salt;
    private String email; 
    private String telefone;

    // Construtor sem parâmetros
    public Pessoa() {
        // Este é um construtor vazio necessário quando você também quer ter um construtor com parâmetros.
        // Caso contrário, Java fornecerá automaticamente um construtor padrão vazio.
    }

    public Pessoa(int idPessoa, String nome, String cpf, int rg, String dataNascimento, String endereco, String senhaHash, String salt, String email, String telefone) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        setCpf(cpf);
        setRg(rg);
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        setTelefone(telefone);
        setSenha(senhaHash);
    }


    // Getter e Setter para senhaHash (não permita a definição direta)
    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenha(String senha) {
        if (!verificarPoliticaSenhaForte(senha)) {
            throw new IllegalArgumentException("A senha não atende à política de senha forte.");
        }

        this.salt = BCrypt.gensalt(12);
        this.senhaHash = BCrypt.hashpw(senha, salt);
    }

    // Getter e Setter para salt (não permita a definição direta)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        // Não permita a definição direta do salt
    }

    // Getter e Setter para email
    public String getEmail() {
        return email;
    }

    // Método para verificar o formato do email
    public boolean verificarFormatoEmail(String email) {
        return email != null && email.matches(".+@.+\\..+");
    }
    
    public void setEmail(String email) {
        // Adicione verificação de formato de email
        if (!verificarFormatoEmail(email)) {
            throw new IllegalArgumentException("Formato de email inválido.");
        }
        this.email = email;
    }

    // Outros getters e setters
    public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}
    
  

    // Métodos para verificar senha e política de senha forte
    public boolean verificarSenha(String senha) {
        return BCrypt.checkpw(senha, this.senhaHash);
    }

	private boolean verificarPoliticaSenhaForte(String senha) {
        return senha.length() >= 8 && senha.matches(".*[A-Z].*") && senha.matches(".*[a-z].*") && senha.matches(".*\\d.*");
    }

	// Setter para CPF com verificação
    public void setCpf(String cpf) {
        // Adicione verificação de CPF
        if (!verificarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf;
    }

    // Setter para RG com verificação
    public void setRg(int rg) {
        // Adicione verificação de RG
        if (rg <= 0) {
            throw new IllegalArgumentException("RG inválido.");
        }
        this.rg = rg;
    }

    // Método para verificar CPF utilizando algoritmo específico
    private boolean verificarCpf(String cpf) {
        // Verifica se o CPF tem 11 dígitos numéricos
        return cpf != null && cpf.matches("\\d{11}");
    }

}
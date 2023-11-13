package br.com.bikeinsure.model;

public class Seguros {

    private int cdSeguro;        // Código identificador do seguro
    private String tipoSeguro;   // Tipo do seguro (ex: "Automóvel", "Residencial", etc.)
    private String inicioSeguro; // Data de início do seguro (representada como String)
    private String fimSeguro;    // Data de término do seguro (representada como String)
    private String statusSeguro; // Status do seguro (ex: "Ativo", "Cancelado", etc.)

    // Construtor
    public Seguros(int cdSeguro, String tipoSeguro, String inicioSeguro, String fimSeguro, String statusSeguro) {
        this.cdSeguro = cdSeguro;
        this.tipoSeguro = tipoSeguro;
        setInicioSeguro(inicioSeguro); // Configuração com validação
        setFimSeguro(fimSeguro);       // Configuração com validação
        this.statusSeguro = statusSeguro;
    }

    // Getters e Setters
    public int getCdSeguro() {
		return cdSeguro;
	}

	public void setCdSeguro(int cdSeguro) {
		this.cdSeguro = cdSeguro;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public String getStatusSeguro() {
		return statusSeguro;
	}

	public void setStatusSeguro(String statusSeguro) {
		this.statusSeguro = statusSeguro;
	}

	public String getInicioSeguro() {
		return inicioSeguro;
	}

	public String getFimSeguro() {
		return fimSeguro;
	}
    
    // Método para validar e configurar a data de início do seguro
    public void setInicioSeguro(String inicioSeguro) {
        // Adicione aqui a lógica de validação para garantir que a string seja uma data válida
        // (pode usar bibliotecas como SimpleDateFormat para validar formatos de datas)
        // Exemplo simples: verificando se a string não está vazia
        if (inicioSeguro == null || inicioSeguro.isEmpty()) {
            throw new IllegalArgumentException("Data de início do seguro inválida.");
        }
        this.inicioSeguro = inicioSeguro;
    }


	// Método para validar e configurar a data de término do seguro
    public void setFimSeguro(String fimSeguro) {
        // Adicione aqui a lógica de validação para garantir que a string seja uma data válida
        // (pode usar bibliotecas como SimpleDateFormat para validar formatos de datas)
        // Exemplo simples: verificando se a string não está vazia
        if (fimSeguro == null || fimSeguro.isEmpty()) {
            throw new IllegalArgumentException("Data de término do seguro inválida.");
        }
        this.fimSeguro = fimSeguro;
    }
}

package br.com.bikeinsure.model;

public class Bike {
    private String nomeBike;
    private double preco;
    private String cor;
    private String nomeModelo;
    private String descricaoModelo;
    private String tamanho;
    private String marca;
    private String personalizada;
    private int bikeId;

    // Construtor que inicializa uma instância de Bike
    public Bike(int bikeId, String nomeBike, double preco, String cor, String nomeModelo,
            String descricaoModelo, String tamanho, String marca, String personalizada) {
    this.bikeId = bikeId;
    this.nomeBike = nomeBike;
    this.preco = preco;
    this.cor = cor;
    this.nomeModelo = nomeModelo;
    this.descricaoModelo = descricaoModelo;
    this.tamanho = tamanho;
    this.marca = marca;
    this.personalizada = personalizada;
}

  

    // Retorna o nome da bike
    public String getNomeBike() {
        return nomeBike;
    }

    // Define o nome da bike
    public void setNomeBike(String nomeBike) {
        this.nomeBike = nomeBike;
    }

    // Retorna o preço da bike
    public double getPreco() {
        return preco;
    }

    // Define o preço da bike, validando se não é negativo
    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
    }

    // Retorna a cor da bike
    public String getCor() {
        return cor;
    }

    // Define a cor da bike, validando se não é nula ou vazia
    public void setCor(String cor) {
        if (cor != null && !cor.isEmpty()) {
            this.cor = cor;
        } else {
            throw new IllegalArgumentException("A cor não pode ser nula ou vazia.");
        }
    }

    // Retorna o modelo associado à bike
    public String getNomeModelo() {
        return nomeModelo;
    }

    public String getDescricaoModelo() {
        return descricaoModelo;
    }

    // Define o modelo associado à bike
    public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}
    

    // Retorna o tamanho da bike
    public String getTamanho() {
        return tamanho;
    }

	// Define o tamanho da bike
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    // Retorna a marca da bike
    public String getMarca() {
        return marca;
    }

    // Define a marca da bike
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
 // Retorna o ID da bike
    public int getbikeId() {
        return bikeId;
    }

    // Define o ID da bike
    public void setbikeId(int bikeId) {
        this.bikeId = bikeId;
    }


    // Retorna informações sobre a personalização da bike
    public String getPersonalizada() {
        return personalizada;
    }

    // Define informações sobre a personalização da bike
    public void setPersonalizada(String personalizada) {
        this.personalizada = personalizada;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeId=" + bikeId +
                ", nomeBike='" + nomeBike + '\'' +
                ", preco=" + preco +
                ", cor='" + cor + '\'' +
                ", nomeModelo='" + nomeModelo + '\'' +
                ", descricaoModelo='" + descricaoModelo + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", marca='" + marca + '\'' +
                ", personalizada='" + personalizada + '\'' +
                '}';
    }
}

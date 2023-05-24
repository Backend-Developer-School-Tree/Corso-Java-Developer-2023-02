package classifica_serie_a;

public class Giocatore {

    private static int count = 1;
    private final int id;
    private String nome;
    private String cognome;

    public Giocatore(String nome, String cognome) {
        this.id = count++;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }

    public void setCognome(String cognome) { this.cognome = cognome; }

    @Override
    public String toString() {
        return "Giocatore {" +
                "\n id=" + id +
                ",\n nome='" + nome + '\'' +
                ",\n cognome='" + cognome + '\'' +
                "\n}";
    }
}

// Product
class Sanduiche {
    private String pao;
    private String carne;
    private String queijo;
    private boolean alface;
    private boolean tomate;
    private boolean molhoEspecial;

    public void setPao(String pao) { this.pao = pao; }
    public void setCarne(String carne) { this.carne = carne; }
    public void setQueijo(String queijo) { this.queijo = queijo; }
    public void setAlface(boolean alface) { this.alface = alface; }
    public void setTomate(boolean tomate) { this.tomate = tomate; }
    public void setMolhoEspecial(boolean molhoEspecial) { this.molhoEspecial = molhoEspecial; }

    @Override
    public String toString() {
        return "Sanduíche com: " + pao + ", " + carne + ", " + queijo +
               (alface ? ", alface" : "") +
               (tomate ? ", tomate" : "") +
               (molhoEspecial ? ", molho especial" : "") + ".";
    }
}

// Interface Builder: define as etapas da construção
interface SanduicheBuilder {
    void escolherPao();
    void escolherCarne();
    void escolherQueijo();
    void adicionarComplementos();
    Sanduiche build();
}

// Builder concreto 1: monta um sanduíche simples
class SanduicheSimplesBuilder implements SanduicheBuilder {
    private Sanduiche sanduiche = new Sanduiche();

    public void escolherPao() { sanduiche.setPao("Pão francês"); }
    public void escolherCarne() { sanduiche.setCarne("Frango grelhado"); }
    public void escolherQueijo() { sanduiche.setQueijo("Mussarela"); }
    public void adicionarComplementos() {
        sanduiche.setAlface(true);
        sanduiche.setTomate(true);
        sanduiche.setMolhoEspecial(false);
    }
    public Sanduiche build() { return sanduiche; }
}

// Builder concreto 2: monta um sanduíche especial
class SanduicheEspecialBuilder implements SanduicheBuilder {
    private Sanduiche sanduiche = new Sanduiche();

    public void escolherPao() { sanduiche.setPao("Pão integral"); }
    public void escolherCarne() { sanduiche.setCarne("Carne bovina dupla"); }
    public void escolherQueijo() { sanduiche.setQueijo("Cheddar"); }
    public void adicionarComplementos() {
        sanduiche.setAlface(true);
        sanduiche.setTomate(true);
        sanduiche.setMolhoEspecial(true);
    }
    public Sanduiche build() { return sanduiche; }
}

// Diretor
class Cozinha {
    private SanduicheBuilder builder;

    public void setBuilder(SanduicheBuilder builder) {
        this.builder = builder;
    }

    public Sanduiche montarSanduiche() {
        builder.escolherPao();
        builder.escolherCarne();
        builder.escolherQueijo();
        builder.adicionarComplementos();
        return builder.build();
    }
}

// Programa principal
public class Main {
    public static void main(String[] args) {
        Cozinha cozinha = new Cozinha();

        SanduicheBuilder simples = new SanduicheSimplesBuilder();
        cozinha.setBuilder(simples);
        Sanduiche sanduiche1 = cozinha.montarSanduiche();
        System.out.println(sanduiche1);

        SanduicheBuilder especial = new SanduicheEspecialBuilder();
        cozinha.setBuilder(especial);
        Sanduiche sanduiche2 = cozinha.montarSanduiche();
        System.out.println(sanduiche2);
    }
}



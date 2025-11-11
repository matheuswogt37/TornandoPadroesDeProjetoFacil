// Interface Estado
interface MarioState {
    void pegarCogumelo(MarioContext mario);
    void pegarFlor(MarioContext mario);
    void pegarPena(MarioContext mario);
    void levarDano(MarioContext mario);
    void status();
}

// Contexto
class MarioContext {
    private MarioState state;

    public MarioContext() {
        state = new MarioPequeno(this); // Estado inicial
    }

    public void setState(MarioState state) {
        this.state = state;
    }

    public MarioState getState() {
        return state;
    }

    // Métodos delegados
    public void pegarCogumelo() { state.pegarCogumelo(this); }
    public void pegarFlor() { state.pegarFlor(this); }
    public void pegarPena() { state.pegarPena(this); }
    public void levarDano() { state.levarDano(this); }
}

// --- ESTADOS ---

class MarioPequeno implements MarioState {
    private MarioContext mario;

    public MarioPequeno(MarioContext mario) {
        this.mario = mario;
    }

    public void pegarCogumelo(MarioContext mario) {
        System.out.println("Mario pequeno pegou um cogumelo! Agora é Super Mario!");
        mario.setState(new SuperMario(mario));
    }

    public void pegarFlor(MarioContext mario) {
        System.out.println("Mario pequeno pegou uma flor! Agora é Fire Mario!");
        mario.setState(new FireMario(mario));
    }

    public void pegarPena(MarioContext mario) {
        System.out.println("Mario pequeno pegou uma pena! Agora é Cape Mario!");
        mario.setState(new CapeMario(mario));
    }

    public void levarDano(MarioContext mario) {
        System.out.println("Mario pequeno levou dano! Game Over!");
    }

    public void status() {
        System.out.println("Estado atual: Mario pequeno 🧢");
    }
}

class SuperMario implements MarioState {
    private MarioContext mario;

    public SuperMario(MarioContext mario) {
        this.mario = mario;
    }

    public void pegarCogumelo(MarioContext mario) {
        System.out.println("Super Mario já está com um cogumelo!");
    }

    public void pegarFlor(MarioContext mario) {
        System.out.println("Super Mario pegou uma flor! Agora é Fire Mario!");
        mario.setState(new FireMario(mario));
    }

    public void pegarPena(MarioContext mario) {
        System.out.println("Super Mario pegou uma pena! Agora é Cape Mario!");
        mario.setState(new CapeMario(mario));
    }

    public void levarDano(MarioContext mario) {
        System.out.println("Super Mario levou dano! Voltou a ser Mario pequeno.");
        mario.setState(new MarioPequeno(mario));
    }

    public void status() {
        System.out.println("Estado atual: Super Mario 🍄");
    }
}

class FireMario implements MarioState {
    private MarioContext mario;

    public FireMario(MarioContext mario) {
        this.mario = mario;
    }

    public void pegarCogumelo(MarioContext mario) {
        System.out.println("Fire Mario já é poderoso o bastante!");
    }

    public void pegarFlor(MarioContext mario) {
        System.out.println("Fire Mario já tem poder de fogo!");
    }

    public void pegarPena(MarioContext mario) {
        System.out.println("Fire Mario pegou uma pena! Agora é Cape Mario!");
        mario.setState(new CapeMario(mario));
    }

    public void levarDano(MarioContext mario) {
        System.out.println("Fire Mario levou dano! Voltou a ser Super Mario.");
        mario.setState(new SuperMario(mario));
    }

    public void status() {
        System.out.println("Estado atual: Fire Mario 🔥");
    }
}

class CapeMario implements MarioState {
    private MarioContext mario;

    public CapeMario(MarioContext mario) {
        this.mario = mario;
    }

    public void pegarCogumelo(MarioContext mario) {
        System.out.println("Cape Mario já é poderoso!");
    }

    public void pegarFlor(MarioContext mario) {
        System.out.println("Cape Mario pegou uma flor! Agora é Fire Mario!");
        mario.setState(new FireMario(mario));
    }

    public void pegarPena(MarioContext mario) {
        System.out.println("Cape Mario já tem uma capa!");
    }

    public void levarDano(MarioContext mario) {
        System.out.println("Cape Mario levou dano! Voltou a ser Super Mario.");
        mario.setState(new SuperMario(mario));
    }

    public void status() {
        System.out.println("Estado atual: Cape Mario 🦸‍♂️");
    }
}

public class Main {
    public static void main(String[] args) {

        // Contexto: Mario (o personagem que muda de estado)
        MarioContext mario = new MarioContext();

        // Estado inicial
        mario.getState().status();

        // Mario pega um cogumelo
        mario.pegarCogumelo();
        mario.getState().status();
        mario.pegarCogumelo();
        
        // Mario pega uma flor de fogo
        mario.pegarFlor();
        mario.getState().status();

        // Mario pega uma pena
        mario.pegarPena();
        mario.getState().status();

        // Mario leva dano
        mario.levarDano();
        mario.getState().status();
    }
}
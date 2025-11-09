import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observer {
    void update(String message);
}

// Classe Subject (Observable)
class Channel {
    private List<Observer> subscribers = new ArrayList<>();
    private String name;

    public Channel(String name) {
        this.name = name;
    }

    public void subscribe(Observer o) {
        subscribers.add(o);
    }

    public void unsubscribe(Observer o) {
        subscribers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : subscribers) {
            o.update(name + ": " + message);
        }
    }

    public void uploadVideo(String title) {
        System.out.println("Novo vídeo: " + title);
        notifyObservers("Novo vídeo postado -> " + title);
    }
}

// Observador concreto
class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " recebeu notificação: " + message);
    }
}

// Demonstração
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel("TechZone");

        Subscriber s1 = new Subscriber("Alice");
        Subscriber s2 = new Subscriber("Bob");

        channel.subscribe(s1);
        channel.subscribe(s2);

        channel.uploadVideo("Padrão de Projeto Observer");
    }
}



package model;
import java.util.ArrayList;

public class NeoTunesController{

    private ArrayList<Producer> producers;
    private ArrayList<Consumer> consumers;

    public NeoTunesController(){
        producers = new ArrayList<Producer>();
        consumers = new ArrayList<Consumer>();
    }

    public boolean addProducers(Producer producer){
        return producers.add(producer);
    }

    public boolean addConsumers(Consumer consumer){
        return consumers.add(consumer);
    }
}
package model;

public class AssistingTrainer extends Trainer {

    private boolean proffessional;
    private String /*[]*/ expertise;
  
    public AssistingTrainer(String name, String id, int salary, boolean status, int xpYears, boolean proffessional, int index) {
        super(name,id,salary,status,xpYears);
        this.proffessional = proffessional;
        expertise = Expertise.get(index).getName();
    }
}
